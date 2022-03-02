package admin;

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
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AdminAccessories extends JFrame implements ActionListener {
    Container c;
    JLabel lab_accessories,lab1_uniqueId,lab3_carModel,lab2_carBrand,lab4_accessName,lab5_accessBrand,lab6_accessDesc,lab7_price,lab9_image,label,lb;
    JTextField txt1_uniqueId,txt3_carModel,txt2_carBrand,txt4_accessName,txt5_accessBrand,txt7_price,lbl_image;
    JTextArea accessDesc;
    JComboBox jcb1_carType;
    JPasswordField pass;
    String s;
    JButton submit;
    JButton update;
    JButton delete;
    JButton attach1,attach2,attach3;
    JTextArea screen;
    JTable table;
    PreparedStatement ptmt=null;
    public AdminAccessories()
    {
        BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\admin.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1950, 1035, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
    setTitle("ACCESSORIES SALES");
      setSize(1950,1035);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
      c.setLayout(null);
   
      lab_accessories =new JLabel("ACCESSORIES SALES");
      lab_accessories.setBounds(835,30,460,40);
      lab_accessories.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,35));
      c.add(lab_accessories);
      
      lab1_uniqueId=new JLabel("PRODUCT ID :");
      lab1_uniqueId.setBounds(720,150,200,30);
      lab1_uniqueId.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab1_uniqueId);
      
      txt1_uniqueId =new JTextField();
      txt1_uniqueId.setBounds(1020,150,200,30);
      c.add(txt1_uniqueId);
       
      lab2_carBrand=new JLabel("CAR BRAND :");
       lab2_carBrand.setBounds(720,210,200,30);
       lab2_carBrand.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add( lab2_carBrand);
      
       txt2_carBrand =new JTextField();
       txt2_carBrand.setBounds(1020,210,200,30);
      c.add( txt2_carBrand);
      
      lab3_carModel=new JLabel("CAR MODEL :");
      lab3_carModel.setBounds(720,270,150,30);
      lab3_carModel.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab3_carModel);
      
      txt3_carModel=new JTextField();
      txt3_carModel.setBounds(1020,270,200,30);
      c.add(txt3_carModel);
     
      lab4_accessName=new JLabel("ACCESSORY NAME :");
      lab4_accessName.setBounds(720,330,200,30);
     lab4_accessName.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab4_accessName);
      
      txt4_accessName=new JTextField();
      txt4_accessName.setBounds(1020,330,200,30);
      c.add(txt4_accessName);
      
      lab5_accessBrand=new JLabel("ACCESSORY BRAND :");
      lab5_accessBrand.setBounds(720,390,250,30);
      lab5_accessBrand.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab5_accessBrand);
      
      txt5_accessBrand =new JTextField();
      txt5_accessBrand.setBounds(1020,390,200,30);
      c.add(txt5_accessBrand);
       
      lab6_accessDesc=new JLabel("ACCESSORY DESCRIPTION :");
      lab6_accessDesc.setBounds(720,450,300,30);
      lab6_accessDesc.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab6_accessDesc);
      
      accessDesc=new JTextArea();
      accessDesc.setBounds(1020,450,200,130);
      c.add(accessDesc); 
      
      lab7_price=new JLabel("PRICE :");
      lab7_price.setBounds(720,600,200,30);
      lab7_price.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab7_price);
      
      txt7_price =new JTextField();
      txt7_price.setBounds(1020,600,200,30);
      c.add(txt7_price);
      
      lab9_image=new JLabel(" ");
      lab9_image.setBounds(300,200,360,320);
      lab9_image.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lab9_image);
      
      lb=new JLabel("IMAGE :");
      lb.setBounds(720,660,200,30);
      lb.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,21));
      c.add(lb);
      
      label=new JLabel(" ");
      label.setBounds(300,200,360,320);
      label.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
      c.add(label);
      
      lbl_image =new JTextField();
      lbl_image.setBounds(300,500,180,20);
      //c.add(lbl_image);
     
      submit =new JButton("SUBMIT");
      submit.setBounds(750,750,90,30);
      c.add(submit);
      submit.addActionListener(this);
       
      update =new JButton("UPDATE");
      update.setBounds(900,750,90,30);
      c.add(update);
      update.addActionListener(this);
       
      delete =new JButton("DELETE");
      delete.setBounds(1050,750,90,30);
      c.add(delete);
      delete.addActionListener(this);
      
      attach1 =new JButton("ATTACH");
      attach1.setBounds(1020,660,100,30);
      c.add(attach1);
       attach1.addActionListener(this);
      
      setVisible(true);   
    }

    
    @Override
    public void actionPerformed(ActionEvent evt){
       Object a=evt.getSource();
       
       
       
       if(a==submit){
           
            String rn=txt1_uniqueId.getText();
            String first=txt2_carBrand.getText();
            String brand=txt3_carModel.getText();
            String col=txt4_accessName.getText();
            //String un=jcb1_carType.getSelectedItem().toString();
            String year=txt5_accessBrand.getText();
            String pri=txt7_price.getText();
            String fu=accessDesc.getText();
            String im=lbl_image.getText();
            im=im.replace("\\", "\\\\");
            System.out.println(im);
           
            
            String PATTERN="^[0-9]{0,6}$";
            Pattern patt=Pattern.compile(PATTERN);
            Matcher match=patt.matcher(txt1_uniqueId.getText());
            if(!match.matches()){
               JOptionPane.showMessageDialog(this,"ID is invalid");
            }
                
            String PATTERN2="^[a-zA-Z]{0,30}$";
            Pattern patt2=Pattern.compile(PATTERN2);
            Matcher match2=patt2.matcher(txt2_carBrand.getText());
            if(!match2.matches()){
                JOptionPane.showMessageDialog(this,"Car brand is invalid");
            }
        
        String PATTERN3="^[a-zA-Z]{0,30}$";
        Pattern patt3=Pattern.compile(PATTERN3);
        Matcher match3=patt3.matcher(txt3_carModel.getText());
        if(!match3.matches()){
            JOptionPane.showMessageDialog(this,"Car Model is invalid");
        }
        
        String PATTERN4="^[a-zA-Z]{0,30}$";
        Pattern patt4=Pattern.compile(PATTERN4);
        Matcher match4=patt4.matcher(txt4_accessName.getText());
        if(!match4.matches()){
            JOptionPane.showMessageDialog(this,"Accessory Name is invalid");
        }
        
        String PATTERN5="^[a-zA-Z]{0,30}$";
        Pattern patt5=Pattern.compile(PATTERN5);
        Matcher match5=patt5.matcher(txt5_accessBrand.getText());
        if(!match5.matches()){
            JOptionPane.showMessageDialog(this,"Accessory Brand is incorrect");
        }
        
        String PATTERN6="^[a-zA-Z\\n]{0,500}$";
        Pattern patt6=Pattern.compile(PATTERN5);
        Matcher match6=patt6.matcher(accessDesc.getText());
        if(!match6.matches()){
            JOptionPane.showMessageDialog(this,"Description is incorrect");
        }
        
        String PATTERN7="^[a-zA-Z0-9]{0,16}$";
        Pattern patt7=Pattern.compile(PATTERN7);
        Matcher match7=patt7.matcher(txt7_price.getText());
        if(!match7.matches()){
           JOptionPane.showMessageDialog(this,"price is incorrect");
        }
            
        
            else{
               try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="INSERT into access_list values(?,?,?,?,?,?,?,?)";
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt1_uniqueId.getText());
            if(txt1_uniqueId.getText().trim().isEmpty()){
           }
            ptmt.setString(2,txt2_carBrand.getText());
            ptmt.setString(3,txt3_carModel.getText());
            ptmt.setString(4,txt4_accessName.getText());
            //ptmt.setString(5,jcb1_carType.getSelectedItem().toString());
            ptmt.setString(5,txt5_accessBrand.getText());
            ptmt.setString(7,txt7_price.getText());
            ptmt.setString(6,accessDesc.getText());
            ptmt.setString(8,lbl_image.getText());
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
            
            String query="delete from access_list where product_id=?";
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt1_uniqueId.getText());
             
            
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
            
            String query="update access_list set product_id=?,car_brand=? where product_id=?"; 
            
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt1_uniqueId.getText());
            
            ptmt.setString(3,txt1_uniqueId.getText());
            ptmt.setString(2,txt3_carModel.getText());
            
            
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"UPDATION SUCCESSFULL");
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }    
        if(a==attach1){
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
		new AdminAccessories();
                
		
	}
}
