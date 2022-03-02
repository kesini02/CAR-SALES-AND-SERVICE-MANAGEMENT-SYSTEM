package Frontpage;

import database.DatabaseOperations;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import service.jdbcconnect;

public class MainPage extends JFrame {
    
    Container c;
    PreparedStatement prepared;
    JLabel Username,password,register,login,label,wel,welcome;
    static Connection connection;
    JTextField txtusername,txtpassword;
    JButton buttlogin,buttregister,buttadmin;
    
    public MainPage(){
        jdbcconnect jdbc = new jdbcconnect();
        connection = jdbc.getconnection();
        BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\main.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1950, 1035, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
       setTitle("CAR SALES AND SERVICE");
      setSize(1950,1035);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
      c.setLayout(null);
      
      wel=new JLabel("Welcome Back!");
      wel.setBounds(250, 100, 300, 30);
      wel.setFont(new Font("Algerian",Font.BOLD,25));
      c.add(wel);
      
      welcome=new JLabel("We are glad to see you again! Get access to your Orders,Wishlist and Recommendations...");
      welcome.setBounds(280, 150, 1200, 30);
      welcome.setFont(new Font("Algerian",Font.PLAIN,20));
      c.add(welcome);
      
      label=new JLabel("Don't have an account?");
      label.setBounds(830, 400, 300, 30);
      label.setFont(new Font("Segoe Script",Font.PLAIN,18));
      c.add(label);
      
      login =new JLabel("LOGIN");
      login.setBounds(975,250,460,40);
      login.setFont(new Font("TIMES NEW ROMAN",Font.HANGING_BASELINE,35));
      
      Username = new JLabel("Username :");
      Username.setBounds(620, 320, 100, 40);
      Username.setFont(new Font("Calibri",Font.BOLD,21));

      password  = new JLabel("Password :");
      password.setBounds(960, 320, 100, 40);
      password.setFont(new Font("Calibri",Font.BOLD,21));
 
      txtusername = new JTextField();
      txtusername.setBounds(735,320, 200, 40);
      txtusername.setFont(new Font("Calibri",Font.BOLD,21));

      txtpassword = new JTextField();
      txtpassword.setBounds(1065, 320, 200, 40);
      txtpassword.setFont(new Font("Calibri",Font.BOLD,21));

      buttlogin = new JButton();
      buttlogin.setText("USER");
      buttlogin.setBounds(1300, 320, 100, 40);
      buttlogin.setFont(new Font("ARIAL",Font.BOLD,21));
      buttlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "Select password from users where user_name=?";
         try {
           String name = txtusername.getText().toString();
           prepared = connection.prepareStatement(query);
           prepared.setString(1,name );
           ResultSet r = prepared.executeQuery();
           if(r.next()) {
            if(txtpassword.getText().equals(r.getString(1))) {
               new MainPage1();

                   }
              else {


                 JOptionPane.showMessageDialog(null, "Please check the password entered");
                 txtpassword.requestFocus();

                 }
                    }
             else {
               JOptionPane.showMessageDialog(null,"User Not present please register");
               }

              } catch (SQLException e1) {

           e1.printStackTrace();
           }    
            }
          
      });
      
      buttregister = new JButton();
      buttregister.setText("REGISTER");
      buttregister.setBounds(1080, 440, 150, 25);
      buttregister.setFont(new Font("ARIAL",Font.BOLD,18));
      c.add(buttregister);
      buttregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
            }
          
      });
      
      buttadmin = new JButton();
      buttadmin.setText("ADMIN");
      buttadmin.setBounds(1430, 320, 100, 40);
      buttadmin.setFont(new Font("ARIAL",Font.BOLD,21));
      buttadmin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String a="admin07";
                String b="password";
                if(txtusername.getText().equals(a) && txtpassword.getText().equals(b))
                {
                    new AdminPage();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter valid username and password");
                }
                
            }
          
      });
    
      c.add(buttadmin);
      c.add(login);
      c.add(Username);
      c.add(password);
      c.add(txtusername);
      c.add(txtpassword);
      c.add(buttlogin);
      setVisible(true);
    }
    

    public static void main(String args[])
    {
        new MainPage();
    }
}
