package car;

import database.Product2;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import service.jdbcconnect;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import database.datas;

public class salesbill {
    Connection connect;
PreparedStatement prepared;
String brand,model,fuel,price,color;
salesbill(final String id,final String name,final String date,final String modelno,final String brand,final String pay, final String phone) throws Exception{
jdbcconnect jdbc =new jdbcconnect();
Product2 b=new Product2();
JLabel mailid = new JLabel();
JTextField txtmailid = new JTextField();
JLabel summary,name1,valuename,id1,valueid,phone1,valuephone,dos,valueedos,car,area,valuearea,valuecar,thanks,car1,valuecar1;
JButton Confirm;
JFrame salesbill = new JFrame("BOOKING SUMMARY");
summary = new JLabel(" BOOKING SUMMARY ");
summary.setBounds(195, 20, 300, 40);
summary.setFont(new Font("Arial",Font.BOLD,19));

id1 = new JLabel("BOOKING ID");
id1.setBounds(100,60,150,35);
id1.setFont(new Font("arial",Font.PLAIN,17));
valueid = new JLabel();
valueid.setText(id);
valueid.setFont(new Font("arial",Font.PLAIN,17));
valueid.setBounds(320,60,200,35);

name1 = new JLabel("REGISTRATION NAME");
name1.setBounds(100, 110, 250, 40);
name1.setFont(new Font("arial",Font.PLAIN,17));
valuename = new JLabel();
valuename.setText(name);
valuename.setBounds(320, 110, 200, 40);
valuename.setFont(new Font("arial",Font.PLAIN,17));

phone1 = new JLabel("PHONE NUMBER");
phone1.setFont(new Font("arial",Font.PLAIN,17));
phone1.setBounds(100,170,170,40);
valuephone = new JLabel();
valuephone.setText(phone);
valuephone.setFont(new Font("arial",Font.PLAIN,17));
valuephone.setBounds(320, 170, 200, 40);

dos = new JLabel("DELIVERY DATE");
dos.setFont(new Font("arial",Font.PLAIN,17));
dos.setBounds(100, 230, 150, 40);
valueedos = new JLabel();
valueedos.setText(date);
valueedos.setFont(new Font("arial",Font.PLAIN,17));
valueedos.setBounds(320,230,200,40);

car = new JLabel("CAR MODELNO");
car.setFont(new Font("arial",Font.PLAIN,17));
car.setBounds(100,290,150,40);
valuecar = new JLabel();
valuecar.setText(modelno);
valuecar.setFont(new Font("arial",Font.PLAIN,17));
valuecar.setBounds(320, 290,200, 40);

car1 = new JLabel("CAR BRAND");
car1.setFont(new Font("arial",Font.PLAIN,17));
car1.setBounds(100,350,150,40);
valuecar1 = new JLabel();
valuecar1.setText(brand);
valuecar1.setFont(new Font("arial",Font.PLAIN,17));
valuecar1.setBounds(320, 350,200, 40);

area = new JLabel("PAYMENT METHOD");
area.setBounds(100, 410, 200, 40);
area.setFont(new Font("arial",Font.PLAIN,17));
valuearea = new JLabel();
valuearea.setText(pay);
valuearea.setBounds(320,410, 350, 40);
valuearea.setFont(new Font("arial",Font.PLAIN,17));

mailid.setBounds(120, 460, 400, 40);
mailid.setText("Enter the mail id to receive the booking details");
mailid.setFont(new Font("Arial",Font.PLAIN,17));

txtmailid.setBounds(170, 510, 250, 35);
txtmailid.setFont(new Font("Arial",Font.PLAIN,17));



Confirm = new JButton("Confirm");
Confirm.setBounds(230, 580, 140, 30);
Confirm.setFont(new Font("Arial",Font.PLAIN,16));

Confirm.addActionListener(new ActionListener() {

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
                message.setSubject("Car Booking");
                String text = "Hai "+name+", Your Dream car "+modelno+" "+brand+" has been booked successfully under the registration name "+name.toUpperCase()+"."+"\r\n"+
                "Your car will be delivered within "+date+"."+"\r\n"+
                "Booking ID: "+id+" (use this ID for future reference)"+"\r\n"+
                       "Payment method :"+pay+"\r\n";
                message.setText(text);
                Transport.send(message);
                JOptionPane.showMessageDialog(null, "Email sent succesfully");

} catch (Exception e1) {
System.out.println(e1);
}
}

    
});
salesbill.setBounds(350, 80, 650, 700);
salesbill.add(summary);
salesbill.add(id1);
salesbill.add(valueid);
salesbill.add(name1);
salesbill.add(valuename);
salesbill.add(phone1);
salesbill.add(valuephone);
salesbill.add(dos);
salesbill.add(valueedos);
salesbill.add(car);
salesbill.add(valuecar);
salesbill.add(car1);
salesbill.add(valuecar1);
salesbill.add(area);
salesbill.add(valuearea);
salesbill.add(mailid);
salesbill.add(txtmailid);
salesbill.add(Confirm);
salesbill.setLayout(null);
salesbill.setVisible(true);

}
}
