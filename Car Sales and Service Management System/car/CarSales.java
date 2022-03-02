package car;
import database.DatabaseOperations;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class CarSales extends JFrame implements ActionListener {
    JLabel lb,lb_carType,lb1_carName,lb2_carBrand,lb3_launchYear,lb4_fuelType,lb5_price,ani;
     JComboBox jcb_carType,jcb1_carName,jcb2_carBrand,jcb3_launchYear,jcb4_fuelType,jcb5_price;
    JButton jbtn1_cancel,jbtn2_summit,print,book,view;
    String cartype="";
    JTextArea screen;
    Connection conn=null;
    PreparedStatement stmt=null;
    
 
    public CarSales(){
         setLayout(null);
         
        lb=new JLabel("CAR SALES");
        ani=new JLabel("A CAR FOR ALL BUDGET");
        ani.setBounds(480, 2, 590, 155);
        jbtn1_cancel=new JButton("CANCEL");
        jbtn2_summit=new JButton("SUBMIT");

        lb_carType=new JLabel("CAR TYPE");
        lb1_carName=new JLabel("CAR NAME");
        lb2_carBrand=new JLabel("CAR BRAND");
        lb3_launchYear=new JLabel("LAUNCH YEAR");
        lb4_fuelType=new JLabel("FUEL TYPE");
        lb5_price=new JLabel("CAR PRICE");
       
        jcb_carType=new JComboBox();
        jcb1_carName=new JComboBox();
        jcb2_carBrand=new JComboBox();
        jcb3_launchYear=new JComboBox();
        jcb4_fuelType=new JComboBox();
        jcb5_price=new JComboBox();
        
        
        lb.setBounds(640, 89, 190, 85);
        ani.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
        lb.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,24));
        lb_carType.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb1_carName.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb2_carBrand.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb3_launchYear.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb4_fuelType.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb5_price.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        lb_carType.setBounds(300, 200, 120, 25);     
        lb1_carName.setBounds(300, 250, 120, 25);
        lb2_carBrand.setBounds(300, 300, 120, 25);
        lb3_launchYear.setBounds(300, 350, 120, 25);
        lb4_fuelType.setBounds(300, 400, 120, 25);
        lb5_price.setBounds(300, 450, 120, 25);
       
        jcb_carType.setBounds(430, 200, 150, 25);     
        jcb1_carName.setBounds(430, 250, 150, 25);
        jcb2_carBrand.setBounds(430, 300, 150, 25);
        jcb3_launchYear.setBounds(430, 350, 150, 25);
        jcb4_fuelType.setBounds(430, 400, 150, 25);
        jcb5_price.setBounds(430, 450, 150, 25);
        
                  
        jbtn1_cancel.setBounds(490, 500, 120, 25);
        jbtn2_summit.setBounds(620, 500, 120, 25); 
        screen=new JTextArea();
        screen .setBounds(800,190,310,300);
        
        
        jcb_carType.addItem("NewCar");
        jcb_carType.addItem("UsedCar");
        
        try{
                   Connection co = DatabaseOperations.getConnection();
                   Statement stmt=co.createStatement();
                   String query="select CAR_CARNAME from Car";
                   PreparedStatement pstmt=co.prepareStatement(query);
                    //pstmt.setString(1,cartype);

                   ResultSet rst=pstmt.executeQuery();

                   while(rst.next()){

                       jcb1_carName.addItem(rst.getString("CAR_CARNAME"));
                   }



            }
                   catch(Exception ex){
                JOptionPane.showMessageDialog(null, " ---------- "+ ex.toString());
            }
        

        
        
         try{
                   //jcb2_carBrand.addItem("NULL");

                   Connection co = DatabaseOperations.getConnection();
                   Statement stmt=co.createStatement();
                   String query="select CAR_CARBRAND from Car";
                   PreparedStatement pstmt=co.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       jcb2_carBrand.addItem(rst.getString("CAR_CARBRAND"));
                   }
            

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
            }
         

         
            try{
                  // jcb3_launchYear.addItem("NULL");

                   Connection co = DatabaseOperations.getConnection();
                   Statement stmt=co.createStatement();
                   String query="select CAR_LAUNCHYEAR from Car";
                   PreparedStatement pstmt=co.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       jcb3_launchYear.addItem(rst.getInt("CAR_LAUNCHYEAR"));
                   }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
            }

         
            try{
                   //jcb4_fuelType.addItem("NULL");

                   Connection co = DatabaseOperations.getConnection();
                   Statement stmt=co.createStatement();
                   String query="select CAR_FUELTYPE from Car";
                   PreparedStatement pstmt=co.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       jcb4_fuelType.addItem(rst.getString("CAR_FUELTYPE"));
                   }
            }

            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
            }

         
            try{
                   //jcb5_price.addItem("NULL");

                   Connection co = DatabaseOperations.getConnection();
                   Statement stmt=co.createStatement();
            
            String query="select CAR_PRICE from Car";
                    
            PreparedStatement pstmt=co.prepareStatement(query);
                   ResultSet rst=pstmt.executeQuery();
                   while(rst.next()){
                       jcb5_price.addItem(rst.getString("CAR_PRICE"));
                   }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, " ---------- "+ ex.toString());
            }

         
         
        jbtn1_cancel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
              
                 System.exit(0);
              
             }
            
        });

       /* c.setLayout(new BorderLayout());
      setContentPane(new JLabel(new ImageIcon("C:\\Users\\KESINI\\Pictures\\bg.jpg")));
      setLayout(new FlowLayout());
      L1=new JLabel();
      add(L1);
*/      add(lb);
        add(ani);
        add(lb1_carName);
        add(lb2_carBrand);
        add(lb3_launchYear);
        add(lb4_fuelType);
        add(lb5_price);
        add(lb_carType);
                  
        add(jcb1_carName);
        add(jcb2_carBrand);
        add(jcb3_launchYear);
        add(jcb4_fuelType);
        add(jcb5_price);
        add(jcb_carType);

        add(jbtn1_cancel);
        add(jbtn2_summit);
        jbtn2_summit.addActionListener(this);
        add(screen);
       book =new JButton("BOOK");
       book.setBounds(750, 500, 120, 25);
       add(book);
       book.addActionListener(this);
       view =new JButton("VIEW ALL CARS");
       view.setBounds(600, 150, 190, 25);
       add(view);
       view.addActionListener(this);

        setVisible(true);
        setSize(1950,1005);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String args[]) throws Exception
    {
        String str="com.jtattoo.plaf.noire.NoireLookAndFeel";
        UIManager.setLookAndFeel(str);
        new CarSales();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
       //To change body of generated methods, choose Tools | Templates.
        Object a=evt.getSource();
       
       
       
       if(a==jbtn2_summit){
          
           String type=jcb1_carName.getSelectedItem()+".";
           String carname=jcb1_carName.getSelectedItem()+".";
          String brand=jcb2_carBrand.getSelectedItem()+".";
                    String yr=jcb3_launchYear.getSelectedItem()+".";
                    String fuel=jcb4_fuelType.getSelectedItem()+".";
                    String price= jcb5_price.getSelectedItem()+".";
                    
                    screen.setText("DESCRIPTION\n\n"+"CAR TYPE : "+type+"\n\n"+ "CAR NAME : "+carname+"\n\n"+"CAR BRAND :"+brand+"\n\n" +"LAUNCH YEAR :"+yr+"\n\n"+"FUEL TYPE :"+fuel+"\n\n"+"CAR PRICE :"+price+"\n\n");
                   
       }
       if(a==view){
          JTableWithImage ob =new JTableWithImage();
          ob.setVisible(true);
       }
       if(a==book)
       {
           new CarBooking();
       }
           
    }
}