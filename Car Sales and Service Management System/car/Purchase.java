package car;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Purchase extends JFrame implements ActionListener{
JLabel product_name, product_no, total_field, name, phone, totalvis;
JComboBox q;
public int quan;
JTextField price_text, choosen, product_description, namefield, phonefield;
JLabel retImage;
JTextField no;




public Purchase(String ctool, int toolno, String toolprice, String tooldescrip){

ImageIcon image = new ImageIcon("logo.jpg");
setIconImage(image.getImage());
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ImageIcon img = new ImageIcon("purchasebg.jpg");
JLabel background = new JLabel("", img, JLabel.CENTER);
background.setBounds(0, 0, 1920, 1080);
setSize(1920, 1080);
Container c = getContentPane();

//page name
JLabel page = new JLabel("E-ACCESSORIES SHOP");
page.setBounds(550, 50, 1000, 100);
page.setFont(new Font("null",Font.BOLD, 40));

//Customer details
JLabel cdetails= new JLabel("Customer Details");
cdetails.setBounds(390, 150, 1000, 100);
cdetails.setFont(new Font("null",Font.PLAIN, 25));

JLabel pdetails= new JLabel("Product Details");
pdetails.setBounds(910, 150, 1000, 100);
pdetails.setFont(new Font("null",Font.PLAIN, 25));

//Name
name = new JLabel("Customer Name: ");
name.setBounds(300, 250, 200, 30);
name.setFont(new Font("null", Font.PLAIN, 14));

//Name TextField
namefield  = new JTextField();
namefield.setBounds(450, 250, 200, 30);
namefield.setFont(new Font("null", Font.ITALIC, 14));

//Phone
phone = new JLabel("Phone Number: ");
phone.setBounds(300, 300, 200, 30);
phone.setFont(new Font("null", Font.PLAIN, 14));

//Phone TextField
phonefield  = new JTextField();
phonefield.setBounds(450, 300, 200, 30);
phonefield.setFont(new Font("null", Font.ITALIC, 14));

//Product name
product_name = new JLabel("Product Name: ");
product_name.setBounds(800, 300, 200, 30);
product_name.setFont(new Font("null", Font.PLAIN, 14));

//Product TextField
choosen  = new JTextField();
choosen.setBounds(950, 300, 200, 30);
choosen.setFont(new Font("null", Font.ITALIC, 14));
choosen.setText(String.valueOf(ctool));
choosen.setEditable(false);

//Product No Label
product_no = new JLabel("Product No: ");
product_no.setBounds(800, 350, 200, 30);
product_no.setFont(new Font("null",Font.PLAIN, 14));

//Product No textfield
no = new JTextField();
no.setFont(new Font("null", Font.ITALIC, 14));
no.setBounds(950, 350, 200, 30);
no.setText(Integer.toString(toolno));
no.setEditable(false);

//Price
JLabel price= new JLabel("Price: ");
price.setBounds(300, 350, 200, 30);
price.setFont(new Font("null",Font.PLAIN, 14));

//Price
price_text = new JTextField();
price_text.setBounds(450, 350, 200, 30);
price_text.setFont(new Font("null",Font.ITALIC, 14));
price_text.addActionListener(this);
price_text.setText(String.valueOf(toolprice));
price_text.setEditable(false);



//Quantity Label
JLabel q_label= new JLabel("Quantity: ");
q_label.setBounds(300, 400, 200, 30);
q_label.setFont(new Font("null",Font.PLAIN, 14));

//Quantity Combobox
String[] inside = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
q = new JComboBox(inside);
q.setBounds(450, 400, 200, 30);
q.setFont(new Font("null",Font.ITALIC, 14));
q.addActionListener(this);

//Pro Desc Label
JLabel desc_label= new JLabel("Description: ");
desc_label.setBounds(800, 250, 200, 30);
desc_label.setFont(new Font("null",Font.PLAIN, 14));

//Product Description
product_description = new JTextField();
product_description.setBounds(950, 250, 200, 30);
product_description.setFont(new Font("null",Font.ITALIC, 14));
product_description.setText(String.valueOf(tooldescrip));
product_description.setEditable(false);

//total
JLabel total= new JLabel("Total: ");
total.setBounds(300, 500, 200, 50);
total.setFont(new Font("null",Font.BOLD, 30));

//total field
total_field = new JLabel();
total_field.setBounds(450, 500, 200, 30);
total_field.setFont(new Font("null",Font.BOLD,30));

totalvis = new JLabel();
totalvis.setBounds(510, 500, 200, 50);
totalvis.setFont(new Font("null",Font.BOLD,30));


//JLabel
retImage = new JLabel();
retImage.setBounds(800, 05, 500, 500);


//Button
JButton print = new JButton("Place Order");
print.setBounds(450, 600, 200, 30);
print.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        new AccessoriesBill(namefield.getText(),phonefield.getText(),price_text.getText(),q.getSelectedItem().toString(),total_field.getText(),product_name.getText(),no.getText());
    }
    
});


//Container Adding
c.add(page);
c.add(no);
c.add(pdetails);
c.add(print);
c.add(price);
c.add(cdetails);
c.add(price_text);
c.add(q);
c.add(total);
c.add(name);
c.add(namefield);
c.add(phone);
c.add(phonefield);
//c.add(background);
c.add(choosen);
c.add(product_description);
c.add(product_name);
c.add(product_no);
c.add(q_label);
c.add(desc_label);
c.add(total_field);
c.add(totalvis);
c.add(retImage);
setVisible(true);

}

int i;
String path;
@Override
public void actionPerformed(ActionEvent e) {

String qty = q.getSelectedItem().toString();
int quantity = Integer.parseInt(qty);
int price = Integer.parseInt(price_text.getText());
int c = quantity*price;
totalvis.setText(Integer.toString(c));


/*try {
byte[] imageBytes;
Image image;
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CAR", "root", "java24");
String sql = "SELECT * FROM access_list where product_id = 1001";
PreparedStatement st = con.prepareStatement(sql);
//st.setString(1, 1001);

ResultSet rs = st.executeQuery();
while(rs.next()){
imageBytes = rs.getBytes(8);
image = getToolkit().createImage(imageBytes);
ImageIcon icon = new ImageIcon(image);
retImage.setIcon(icon);
}
}*/



}

/* public static void main(String[] args) {
Purchase p = new Purchase();
}*/

}


/*
try {
           System.out.print(1);
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1", "root", "");
           System.out.print(2);
           Statement st = con.createStatement();
           System.out.print(3);
           ResultSet rs = st.executeQuery("select * from access_list where product_id = '" + no.getText() + "'");
if (rs.next()) {
                System.out.print(4);
                   path = rs.getString("image");
                   System.out.print(5);
                   rs.absolute(i+1);
                   ImageIcon image = new ImageIcon(rs.getBytes("image"));
                   System.out.print(6);
                   Image im = image.getImage();
                   System.out.print(7);
                   Image myImg = im.getScaledInstance(retImage.getWidth(),  retImage.getHeight(),Image.SCALE_SMOOTH);
                   
                   System.out.print(8);
                    System.out.print(9);
                    retImage.setIcon(image);
                   System.out.print(image);
                   getContentPane().add(retImage);
           }
           else{
                   JOptionPane.showMessageDialog(null, "No Data");
               }
}

catch (Exception e) {
           e.printStackTrace();
       }
*/
 class AccessoriesBill {
     AccessoriesBill(String name,String phone,String price,String q,String total,String productname,String productid)
     {
         JLabel mailid = new JLabel();
JTextField txtmailid = new JTextField();
JLabel summary,name1,valuename,id,valueid,phone1,valuephone,product1,valueproduct,quantity1,valuequantity,price1,valueprice;
JButton Confirm;
JFrame salesbill = new JFrame("PURCHASE SUMMARY");
summary = new JLabel(" PURCHASE SUMMARY ");
summary.setBounds(195, 20, 300, 40);
summary.setFont(new Font("Arial",Font.BOLD,19));

id = new JLabel("PRODUCT ID");
id.setBounds(140,60,150,35);
id.setFont(new Font("arial",Font.PLAIN,17));
valueid = new JLabel();
valueid.setText(productid);
valueid.setFont(new Font("arial",Font.PLAIN,17));
valueid.setBounds(320,60,200,35);

name1 = new JLabel("CUSTOMER NAME");
name1.setBounds(140, 100, 250, 40);
name1.setFont(new Font("arial",Font.PLAIN,17));
valuename = new JLabel();
valuename.setText(name);
valuename.setBounds(320, 100, 200, 40);
valuename.setFont(new Font("arial",Font.PLAIN,17));

phone1 = new JLabel("PHONE NUMBER");
phone1.setFont(new Font("arial",Font.PLAIN,17));
phone1.setBounds(140,150,150,40);
valuephone = new JLabel();
valuephone.setText(phone);
valuephone.setFont(new Font("arial",Font.PLAIN,17));
valuephone.setBounds(320, 150, 200, 40);

product1 = new JLabel("PRODUCT NAME");
product1.setFont(new Font("arial",Font.PLAIN,17));
product1.setBounds(140, 200, 150, 40);
valueproduct = new JLabel();
valueproduct.setText(productname);
valueproduct.setFont(new Font("arial",Font.PLAIN,17));
valueproduct.setBounds(320,200,200,40);

quantity1 = new JLabel("PRODUCT QUANTITY");
quantity1.setFont(new Font("arial",Font.PLAIN,17));
quantity1.setBounds(140,250,200,40);
valuequantity = new JLabel();
valuequantity.setText(q);
valuequantity.setFont(new Font("arial",Font.PLAIN,17));
valuequantity.setBounds(320, 250,200, 40);

price1 = new JLabel("TOTAL PRICE");
price1.setFont(new Font("arial",Font.PLAIN,17));
price1.setBounds(140, 300, 150, 40);
valueprice= new JLabel();
valueprice.setText(price);
valueprice.setFont(new Font("arial",Font.PLAIN,17));
valueprice.setBounds(320, 300, 200, 40);


mailid.setBounds(120, 350, 400, 40);
mailid.setText("Enter the mail ID to receive the purchase details");
mailid.setFont(new Font("Arial",Font.PLAIN,17));

txtmailid.setBounds(170, 400, 250, 35);
txtmailid.setFont(new Font("Arial",Font.PLAIN,17));



Confirm = new JButton("Confirm");
Confirm.setBounds(230, 450, 140, 30);
Confirm.setFont(new Font("Arial",Font.PLAIN,16));

Confirm.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {


final String username = "kaviinjv@gmail.com";
final String password = "devakumari8184";
final String from = "kaviinjv@gmail.com";
       final String to = txtmailid.getText().toString().toLowerCase().replace(" ", "");
       Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "465");
Authenticator a =new Authenticator() {

                   @Override
                   protected PasswordAuthentication getPasswordAuthentication() {
                       
                       return new PasswordAuthentication(username, password);
                       }
                 };
                 Session session = Session.getInstance(props, a);
               try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
                message.setSubject("Accessory purchase");
                String text="Hello "+name+", your "+productname+" purchase of Rs."+price+" done successfully"+"\r\n"+
                "Product ID: "+productid+" (use this for future references)"+"\r\n"+
                "Product Name: "+productname+ " - quantity = "+q;
                message.setText(text);
                Transport.send(message);
                JOptionPane.showMessageDialog(null, "Email sent succesfully");

} catch (Exception e1) {
System.out.println(e1);
}
}
});
salesbill.setBounds(350, 80, 650, 550);
salesbill.add(summary);
salesbill.add(id);
salesbill.add(valueid);
salesbill.add(name1);
salesbill.add(valuename);
salesbill.add(phone1);
salesbill.add(valuephone);
salesbill.add(product1);
salesbill.add(valueproduct);
salesbill.add(quantity1);
salesbill.add(valuequantity);
salesbill.add(price1);
salesbill.add(valueprice);
salesbill.add(mailid);
salesbill.add(txtmailid);
salesbill.add(Confirm);
salesbill.setLayout(null);
salesbill.setVisible(true);

     }
    
}
