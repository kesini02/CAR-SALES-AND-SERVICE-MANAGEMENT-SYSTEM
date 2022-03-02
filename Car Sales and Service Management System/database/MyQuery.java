package database;
//import com.mysql.cj.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyQuery {
    Connection conn=null;
    PreparedStatement stmt=null;
   public Connection getConnection(){
        Connection con = null;
        try {
            String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            
            String uname="mohana";
            String password="sql";
            
           
            conn=DriverManager.getConnection(url,uname,password);
           
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
        return conn;
    }
    
    public ArrayList<Product2> BindTable(){
        
   ArrayList<Product2> list = new ArrayList<Product2>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("select * from Car ");
   
   Product2 p;
   while(rs.next()){
   p = new Product2(
           
   rs.getString("Car_modelNo"),
   rs.getString("Car_CarName"),
   rs.getString("Car_CarBrand"),
   rs.getString("Car_CarColor"),
   rs.getString("Car_CarType"),
   rs.getString("Car_LaunchYear"),
   rs.getString("Car_Price"),
   rs.getString("Car_FuelType"),
   rs.getBytes("Car_Image")
 
   );
   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   }
}
