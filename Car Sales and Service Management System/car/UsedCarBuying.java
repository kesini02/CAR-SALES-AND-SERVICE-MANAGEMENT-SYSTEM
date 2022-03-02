package car;

import database.DatabaseOperations;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.regex.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class UsedCarBuying extends JFrame  implements ActionListener{
    
    Container c;
    JLabel lab_carSales,lab1_modelNo,lab2_carName,lab3_carBrand,lab4_carColor,lab5_carType,lab6_launchYear,lab7_price,lab8_fuelType,lab9_image,label10,label,image,lab;
    JTextField txt1_modelNo,txt2_carName,txt3_carBrand,txt4_carColor,txt5_launchYear,txt6_price,txt7_fuelType,lbl_image;
    JComboBox jcb1_carType,jcb_carBrand,jcb_carName;
    JPasswordField pass;
    String s;
    JButton submit;
    JButton update;
    JButton delete;
    JButton attach;
    JTextArea screen;
    JTable table;
    PreparedStatement ptmt=null;
    
   
    public UsedCarBuying()  {
        /*BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\usedcar.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1950, 1035, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
      
       setLocationRelativeTo(null);  
      pack();*/
      setTitle("SALES");
      setSize(1950,1035);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
      c.setLayout(null);
        // c.add(label3); 
       // JPanel panel = (JPanel)c.getContentPane();  

        JTextArea area=new JTextArea("SCHEDULE AN APPOINTMENT\n" +
"Our representative will meet you at a location and time that \nis convenient to you. Selling a Pre-Owned car was\n never this hassle-free.");  
        area.setBounds(1000,100, 500,120); 
        Font font = new Font("Segoe Script", Font.BOLD, 15);
        area.setFont(font);
        c.add(area);
      lab_carSales=new JLabel("I am looking to sell/exchange my");
      lab_carSales.setBounds(30,100,480,40);
      lab_carSales.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,35));
      lab_carSales.setForeground(Color.BLACK);
      c.add(lab_carSales);
      
      lab=new JLabel("ADD USED CARS");
      lab.setBounds(875,30,260,40);
      lab.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,25));
      lab.setForeground(Color.BLACK);
      c.add(lab);
      
      
      lab1_modelNo=new JLabel("MODEL NO :");
      lab1_modelNo.setBounds(1000,250,100,20);
      lab1_modelNo.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab1_modelNo.setForeground(Color.BLACK);
      c.add(lab1_modelNo);
      
      txt1_modelNo =new JTextField();
      txt1_modelNo.setBounds(1150,250,200,20);
      c.add(txt1_modelNo);
      
      lab2_carName=new JLabel("CAR NAME");
      lab2_carName.setBounds(740,90,100,30); 
      lab2_carName.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab2_carName.setForeground(Color.BLACK);
      c.add(lab2_carName); 
     
      txt2_carName=new JTextField();
      txt2_carName.setBounds(740,120,200,20);
      c.add(txt2_carName);
      
      lab3_carBrand=new JLabel("CAR BRAND");
      lab3_carBrand.setBounds(520,90,100,30); 
      lab3_carBrand.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab3_carBrand.setForeground(Color.BLACK);
      c.add(lab3_carBrand); 
      
      txt3_carBrand=new JTextField();
      txt3_carBrand.setBounds(520,120,200,20);
      c.add(txt3_carBrand);
     
      lab4_carColor=new JLabel("CAR COLOUR :");
      lab4_carColor.setBounds(1000,350,130,20);
      lab4_carColor.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab4_carColor.setForeground(Color.BLACK);
      c.add(lab4_carColor);
      
      txt4_carColor =new JTextField();
      txt4_carColor.setBounds(1150,350,200,20);
      c.add(txt4_carColor);
      
      lab5_carType=new JLabel("CAR TYPE :");
      lab5_carType.setBounds(1000,300,100,20);
      lab5_carType.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab5_carType.setForeground(Color.BLACK);
      c.add(lab5_carType);
      
      jcb1_carType=new JComboBox();
      jcb1_carType.addItem("USED");
      jcb1_carType.setBounds(1150,300,200,20); 
      //jcb1_carType.setForeground(Color.WHITE);
      c.add(jcb1_carType);  
       
      lab6_launchYear=new JLabel("LAUNCH YEAR :");
      lab6_launchYear.setBounds(1000,400,140,20);
      lab6_launchYear.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab6_launchYear.setForeground(Color.BLACK);
      c.add(lab6_launchYear);
      
      txt5_launchYear =new JTextField();
      txt5_launchYear.setBounds(1150,400,200,20);
      c.add(txt5_launchYear);
       
      lab7_price=new JLabel("PRICE :");
      lab7_price.setBounds(1000,450,100,20);
      lab7_price.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab7_price.setForeground(Color.BLACK);
      c.add(lab7_price);
      
      txt6_price =new JTextField();
      txt6_price.setBounds(1150,450,200,20);
      c.add(txt6_price);
       
      lab8_fuelType=new JLabel("FUEL TYPE :");
      lab8_fuelType.setBounds(1000,500,100,20);
      lab8_fuelType.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      lab8_fuelType.setForeground(Color.BLACK);
      c.add(lab8_fuelType); 
      
      txt7_fuelType=new JTextField();
      txt7_fuelType.setBounds(1150,500,200,20);
      c.add(txt7_fuelType); 
      
      label=new JLabel(" ");
      label.setBounds(1450,250,320,290);
      label.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      c.add(label);
      
      image=new JLabel("IMAGE :");
      image.setBounds(1000,550,100,20);
      image.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      image.setForeground(Color.BLACK);
      c.add(image); 
      
      lbl_image =new JTextField();
      lbl_image.setBounds(1150,550,200,20);
      //c.add(lbl_image);
     
      submit =new JButton("SUBMIT");
      submit.setBounds(1080,650,90,20);
      submit.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
      c.add(submit);
      submit.addActionListener(this);
       
      update =new JButton("UPDATE");
      update.setBounds(1180,650,90,20);
      update.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
      c.add(update);
      update.addActionListener(this);
       
      delete =new JButton("DELETE");
      delete.setBounds(1280,650,90,20);
      delete.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
      c.add(delete);
      delete.addActionListener(this);
      
      attach =new JButton("ATTACH");
      attach.setBounds(1150,550,100,20);
      attach.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
      c.add(attach);
      attach.addActionListener(this);
     
    
       
setVisible(true);    
        
    }
public void actionPerformed(ActionEvent evt){
       Object a=evt.getSource();
       
       
       
       if(a==submit){
           
            String rn=txt1_modelNo.getText();
            String first=txt2_carName.getText();
            String brand=txt3_carBrand.getText();
            String col=txt4_carColor.getText();
            String un=jcb1_carType.getSelectedItem().toString();
            String year=txt5_launchYear.getText();
            String pri=txt6_price.getText();
            String fu=txt7_fuelType.getText();
            String im=lbl_image.getText();
            im=im.replace("\\", "\\\\");
            System.out.println(im);
           
            
            String PATTERN="^[0-9]{0,6}$";
            Pattern patt=Pattern.compile(PATTERN);
            Matcher match=patt.matcher(txt1_modelNo.getText());
            if(!match.matches()){
               JOptionPane.showMessageDialog(this,"modelno is invalid");
            }
                
            String PATTERN2="^[a-zA-Z0-9]{0,30}$";
            Pattern patt2=Pattern.compile(PATTERN2);
            Matcher match2=patt2.matcher(txt2_carName.getText());
            if(!match2.matches()){
                JOptionPane.showMessageDialog(this,"car name is invalid");
            }
        
        String PATTERN3="^[a-zA-Z]{0,30}$";
        Pattern patt3=Pattern.compile(PATTERN3);
        Matcher match3=patt3.matcher(txt3_carBrand.getText());
        if(!match3.matches()){
            JOptionPane.showMessageDialog(this,"car brand is invalid");
        }
        
        String PATTERN4="^[a-zA-Z]{0,30}$";
        Pattern patt4=Pattern.compile(PATTERN4);
        Matcher match4=patt4.matcher(txt4_carColor.getText());
        if(!match4.matches()){
            JOptionPane.showMessageDialog(this,"colour is invalid");
        }
        
        String PATTERN5="^[0-9]{0,4}$";
        Pattern patt5=Pattern.compile(PATTERN5);
        Matcher match5=patt5.matcher(txt5_launchYear.getText());
        if(!match5.matches()){
            JOptionPane.showMessageDialog(this,"year is incorrect");
        }
           
        String PATTERN7="^[a-zA-Z0-9]{0,16}$";
        Pattern patt7=Pattern.compile(PATTERN7);
        Matcher match7=patt7.matcher(txt6_price.getText());
        if(!match7.matches()){
           JOptionPane.showMessageDialog(this,"price is incorrect");
        }
            
        
            else{
               try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="INSERT into Car values(?,?,?,?,?,?,?,?,?)";
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt1_modelNo.getText());
            if(txt1_modelNo.getText().trim().isEmpty()){
           }
            ptmt.setString(2,txt2_carName.getText());
            ptmt.setString(3,txt3_carBrand.getText());
            ptmt.setString(4,txt4_carColor.getText());
            ptmt.setString(5,jcb1_carType.getSelectedItem().toString());
            ptmt.setString(6,txt5_launchYear.getText());
            ptmt.setString(7,txt6_price.getText());
            ptmt.setString(8,txt7_fuelType.getText());
            ptmt.setString(9,lbl_image.getText());
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(this,"ADDED SUCCESSFULLY");
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
        }    } }              
   

        if(a==delete){
        try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="delete from Car where car_modelNo=?";
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt1_modelNo.getText());
             
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(this,"DELETED SUCCESSFULLY");
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
        }

    }     
        if(a==update){
        try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="update Car set Car_ModelNo=?,Car_CarBrand=? where Car_ModelNo=?"; 
            
            ptmt=co.prepareStatement(query);
            ptmt.setString(3,txt1_modelNo.getText());
            
            ptmt.setString(2,txt2_carName.getText());
            ptmt.setString(1,txt3_carBrand.getText());
            
            
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"UPDATION SUCCESSFULL");
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    
    }
        if(a==attach){
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
             fileChooser.addChoosableFileFilter(filter);
             int result = fileChooser.showSaveDialog(null);
             if(result == JFileChooser.APPROVE_OPTION){
             File selectedFile = fileChooser.getSelectedFile();
             String path = selectedFile.getAbsolutePath();
             label.setIcon(ResizeImage(path));
             s = path;
              }
         else if(result == JFileChooser.CANCEL_OPTION){
             System.out.println("No Data");
         }
        }           
}    
public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
 

    public static void main(String[] args) {
		new UsedCarBuying();
                
		
	}
    class MyCanvas extends Canvas{
        @Override
       public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("C:\\icon.jpg");  
        g.drawImage(i, 500,100,this);  
          
    }
    }

   
    
}
