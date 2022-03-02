package admin;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class AdminCarSales extends JFrame implements ActionListener{
    Container c;

   JLabel label0,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label,lab;
    JTextField mno,car_name,car_brand,colour,yr,price,lbl_image;
    JComboBox fuel,usedornew;
    JPasswordField pass;
    String s;
    JButton submit;
     JButton update;
      JButton delete;
     
       JButton attach;
       
       byte[] car_image=null;
       JTextArea screen;
       JTable table;
    Connection conn=null;
    PreparedStatement stmt=null;
    
    
   
    public AdminCarSales(){
        super("insert image to database in java");
        BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\admin.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1950, 1035, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
    
    setTitle("ADMIN CAR SALES");
        
      setSize(1950,1035);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
      c.setLayout(null);
   
     label0=new JLabel("ADMIN CAR SALES");
      label0.setBounds(835,30,460,40);
       label0.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,35));
       label0.setForeground(Color.BLACK);
      c.add(label0);
      
      label1=new JLabel("MODEL NO :");
      label1.setBounds(720,150,200,30);
       label1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
       label1.setForeground(Color.BLACK);
      c.add(label1);
      
      mno =new JTextField();
       mno.setBounds(1020,150,200,30);
       c.add(mno);
       //rlab =new JTextField();
       //rlab.setBounds(290,50,100,20);
       //c.add(rlab);
  
       
      label2=new JLabel("CAR NAME :");
      label2.setBounds(720,210,200,30);
       label2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label2.setForeground(Color.BLACK);
      c.add(label2);
      
      car_name =new JTextField();
       car_name.setBounds(1020,210,200,30);
       c.add( car_name);
       
      label3=new JLabel("CAR BRAND :");
      label3.setBounds(720,270,150,30);
       label3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label3.setForeground(Color.BLACK);
      c.add(label3);
      
      car_brand=new JTextField();
      car_brand.setBounds(1020,270,200,30);
       c.add(car_brand);
     
      label4=new JLabel("CAR COLOUR :");
      label4.setBounds(720,330,200,30);
       label4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label4.setForeground(Color.BLACK);
      c.add(label4);
      
      colour =new JTextField();
       colour.setBounds(1020,330,200,30);
       c.add(colour);
       
      label5=new JLabel("CAR TYPE :");
      label5.setBounds(720,390,200,30);
       label5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label5.setForeground(Color.BLACK);
      c.add(label5);
      
     usedornew=new JComboBox();
      usedornew.addItem("USED");
      usedornew.addItem("NEW");
     
      usedornew.setBounds(1020,390,200,30);
       
       c.add(usedornew);  
       
      label6=new JLabel("LAUNCH YEAR :");
      label6.setBounds(720,450,200,30);
      label6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
       label6.setForeground(Color.BLACK);
      c.add(label6);
      
      yr =new JTextField();
      yr.setBounds(1020,450,200,30);
       c.add(yr);
      label7=new JLabel("PRICE :");
      label7.setBounds(720,510,200,30);
       label7.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label7.setForeground(Color.BLACK);
      c.add(label7);
      
      price =new JTextField();
        price.setBounds(1020,510,200,30);
       c.add( price);
       
      label8=new JLabel("FUEL TYPE :");
      label8.setBounds(720,560,200,30);
       label8.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
        label8.setForeground(Color.BLACK);
       c.add(label8); 

       fuel=new JComboBox();
      fuel.addItem("PETROL");
      fuel.addItem("DIESEL");
     
      fuel.setBounds(1020,560,200,30);
       
       c.add(fuel);
       
      lab=new JLabel("IMAGE :");
      lab.setBounds(720,610,100,30);
      lab.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
      c.add(lab);
      

       
      label=new JLabel(" ");
      label.setBounds(300,200,360,320);
      label.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,21));
       label.setForeground(Color.BLACK);
       
      c.add(label);
      lbl_image =new JTextField();
      lbl_image.setBounds(300,500,180,20);
      // c.add(lbl_image);
       
       
    
       submit =new JButton("SUBMIT");
       submit.setBounds(750,710,90,30);
       c.add(submit);
       submit.addActionListener(this);
       
       update =new JButton("UPDATE");
       update.setBounds(900,710,90,30);
       c.add(update);
       update.addActionListener(this);
       
       delete =new JButton("DELETE");
      delete.setBounds(1050,710,90,30);
       c.add(delete);
       delete.addActionListener(this);
      /* view =new JButton("VIEW");
     view.setBounds(400,550,90,20);
       c.add(view);
       view.addActionListener(this);
       search =new JButton("SEARCH");
       search.setBounds(210,600,100,20);
       c.add(search);
       search.addActionListener(this);
       */
      attach =new JButton("ATTACH");
       attach.setBounds(1020,610,100,30);
       c.add(attach);
       attach.addActionListener(this);
      
       
setVisible(true);    
    
    
      
  
    //button to browse the image into jlabel
   attach.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
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
    });
   delete.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
          try{
            
            String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            String uname="mohana";
            String password="sql";
            
            String query="delete from car where car_modelNo=?";
            conn=DriverManager.getConnection(url,uname,password);
            stmt=conn.prepareStatement(query);
            stmt.setString(1,mno.getText());
             
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");
            
        }
        catch(Exception e2){
             JOptionPane.showMessageDialog(null,e2);
        }
     }
    });
   
  update.addActionListener(new ActionListener(){
        @Override
     public void actionPerformed(ActionEvent e){
          try{
            
            String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            String uname="mohana";
            String password="sql";
            
            String query="update car set car_CarModel=?,car_CarBrand=? where car_modelNo=?"; 
            conn=DriverManager.getConnection(url,uname,password);
            stmt=conn.prepareStatement(query);
            stmt.setString(3,mno.getText());
            
             stmt.setString(2,car_name.getText());
            stmt.setString(1,car_brand.getText());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"UPDATION SUCCESSFULL");
            
        }
        catch(Exception e1){
             JOptionPane.showMessageDialog(null,e1);
        }
     }
    });
   

    //button to insert image and some data into mysql database
    submit.addActionListener(new ActionListener(){
    
       @Override
       public void actionPerformed(ActionEvent e){
            Object a=e.getSource();
       
            String rn=mno.getText();
            String first=car_name.getText();
            String brand=car_brand.getText();
            String col=colour.getText();
            String un=usedornew.getSelectedItem().toString();
            String year=yr.getText();
            String pri=price.getText();
            String fu=fuel.getSelectedItem().toString();
            String im=lbl_image.getText();
            
            im=im.replace("\\", "\\\\");
            System.out.println(im);
            
           
            //String g=select_gender.getSelectedItem().toString();
            
            
                 String PATTERN="^[0-9]{0,6}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(mno.getText());
        if(!match.matches()){
               JOptionPane.showMessageDialog(null,"modelno is invalid");
            }
            
            
        
        String PATTERN3="^[a-zA-Z]{0,30}$";
        Pattern patt3=Pattern.compile(PATTERN3);
        Matcher match3=patt3.matcher(car_brand.getText());
        if(!match3.matches()){
            JOptionPane.showMessageDialog(null,"car brand is invalid");
        }
        String PATTERN4="^[a-zA-Z]{0,30}$";
        Pattern patt4=Pattern.compile(PATTERN4);
        Matcher match4=patt4.matcher(colour.getText());
        if(!match4.matches()){
            JOptionPane.showMessageDialog(null,"colour is invalid");
        }
        String PATTERN5="^[0-9]{0,4}$";
        Pattern patt5=Pattern.compile(PATTERN5);
        Matcher match5=patt5.matcher(yr.getText());
        if(!match5.matches()){
            JOptionPane.showMessageDialog(null,"year is incorrect");
        }
           
        String PATTERN7="^[a-zA-Z0-9]{0,16}$";
        Pattern patt7=Pattern.compile(PATTERN7);
        Matcher match7=patt7.matcher(price.getText());
        if(!match7.matches()){
           JOptionPane.showMessageDialog(null,"price is incorrect");
        }
        else{
           try{
               String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            //ION'&jdbcCompliantTruncation=false";
            String uname="mohana";
            String password="sql";
            
            String query="INSERT into Car values(?,?,?,?,?,?,?,?,?)";
            conn=DriverManager.getConnection(url,uname,password);
            InputStream is = new FileInputStream(new File(s));
            stmt=conn.prepareStatement(query);
           stmt.setString(1,mno.getText());
            if(mno.getText().trim().isEmpty()){
           }
            // JTextField mno,car_name,car_brand,colour,usedornew,yr,price,fuel;
             stmt.setString(2,car_name.getText());
            stmt.setString(3,car_brand.getText());
           // stmt.setString(4,gender.getSelectedItem().toString());
            stmt.setString(4,colour.getText());
            stmt.setString(5,usedornew.getSelectedItem().toString());
            stmt.setString(6,yr.getText());
            stmt.setString(7,price.getText());
            stmt.setString(8,fuel.getSelectedItem().toString());
            
               //InputStream is = new FileInputStream(new File(s));
              
              stmt.setBlob(9,is);
               stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "Data Inserted");
           }catch(Exception ex){
               ex.printStackTrace();
           }}
       }
    });
    

   
    }
    
    //Methode To Resize The ImageIcon
    public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
 
    public static void main(String[] args){
        new AdminCarSales();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   }

