package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseOperations {

    private static Connection connection;

    public static Connection getConnection() {
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","mohana","sql");
          
        }
        catch(Exception ex){
            System.out.println("  "+ex);
        }
        return connection;
    }
}
