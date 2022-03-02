package service;
import service.javabean;
import javax.swing.*;
import service.jdbcconnect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

import com.toedter.calendar.JDateChooser;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
public class Service {
static ResultSet ids;
static Connection connecttojdbc;
PreparedStatement pstatement;
static PreparedStatement call;
javabean bean =new javabean();
JFrame service_frame;
JLabel name, phno,dateofservice, car_brand,car_number,Type_of_service,service_area,linterim,lmajor,lfull,ser;
JTextField tname,tcar_number,phone;
JTextArea interim,full,major;
JDateChooser fordate;
JButton submit;
String ser_id;
JComboBox<String> tcar_brand,tTypeofservice,tservicestate,tservicecity;
String brands[]= {" "," Maruthi suzuki"," Hyundai"," Toyota"," Mahindra"," Skoda"," Renault"," Volkswagen"," Nissan"," Ford"," Honda"," Kia", " Chevrolet"," Suzuki"};
String typesofservice[]= {" "," Interim car service"," Full car service"," Major car service"};
String states[]= {" ","Tamilnadu","Kerala","Andhra pradesh","Karnataka","Maharashtra","Haryana","Telangana"};
String tamilnadu[]= {" ","Chennai","Coimbatore","Madurai","Namakkal","Dindugal","Salem","Karur","Tirunelveli","Thanjavur","Vellore"};
String kerala[]= {" ","Thrissur","Kochi","Thiruvananthapuram","Kollam"};
String andhra[]= {" ","Vijayawada","Tirupati","Kakinada","Chittoor"};
String karnataka[]= {" ","Bangalore","Mysore","Mangalore","Udupi"};
String Maharashtra[]= {" ","Mumbai","Pune","Lathor","Nagpur","Nashik","Solapur"};
String Haryana[]= {" ","Faridabad","Gurugram","sonipat","gurgaon"};
String Telangana[]= {" ","Hyderabad","karimnagar","suryapet"};

String query ="insert into service values(?,?,?,?,?,?,?,?)";
 public Service(){
Arrays.sort(brands);
Arrays.sort(states);
Arrays.sort(typesofservice);
service_frame = new JFrame(" S E R V I C E ");

ser=new JLabel("SERVICE BOOKING");
ser.setBounds(730, 30, 250, 60);
ser.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
service_frame.add(ser);



name = new JLabel("Customer Name : ");
name.setBounds(80, 100, 150, 60);
name.setFont(new Font("calibri",Font.PLAIN,20));

dateofservice = new JLabel("Date Of Service : ");
dateofservice.setBounds(80, 200, 150, 60);
dateofservice.setFont(new Font("calibri",Font.PLAIN,20));

car_brand = new JLabel("Car Brand : ");
car_brand.setBounds(80, 250, 150, 60);
car_brand.setFont(new Font("calibri",Font.PLAIN,20));

phno = new JLabel("Phone Number : ");
phno.setBounds(80,150,150,60);
phno.setFont(new Font("calibri",Font.PLAIN,20));

car_number = new JLabel("Car Number : ");
car_number.setBounds(80,300,150,60);
car_number.setFont(new Font("calibri",Font.PLAIN,20));

Type_of_service = new JLabel("Type Of Service : ");
Type_of_service.setBounds(80, 350, 150, 60);
Type_of_service.setFont(new Font("calibri",Font.PLAIN,20));

service_area = new JLabel("Service area : ");
service_area.setBounds(80, 400, 150, 60);
service_area.setFont(new Font("calibri",Font.PLAIN,20));

tname = new JTextField();
tname.setBounds(300, 100, 210, 36);
tname.setFont(new Font("Arial",Font.PLAIN,18));


tcar_number = new JTextField();
tcar_number.setBounds(300, 300, 210, 36);
tcar_number.setFont(new Font("Arial",Font.PLAIN,18));

tcar_brand = new JComboBox<String>(brands);
tcar_brand.setBounds(300,250,210 ,36);
tcar_brand.setFont(new Font("Arial",Font.PLAIN,18));
//tcar_brand.setForeground(Color.red);


tTypeofservice = new JComboBox<String>(typesofservice);
tTypeofservice.setBounds(300, 350, 210, 36);
tTypeofservice.setFont(new Font("Arial",Font.PLAIN,18));

tservicestate = new JComboBox<String>();
tservicestate .setBounds(550,400,210,36);
tservicestate .setFont(new Font("Arial",Font.PLAIN,18));

phone = new JTextField();
phone.setBounds(300,150, 210, 36);
phone.setFont(new Font("Arial",Font.PLAIN,18));

fordate = new JDateChooser();
fordate.setBounds(300, 200,210, 36);
fordate.setForeground(Color.white);


tservicecity = new JComboBox<String>(states);
tservicecity.setFont(new Font("Arial",Font.PLAIN,18));
tservicecity.setBounds(300, 400, 210, 36);

submit = new JButton("SUBMIT");
submit.setBounds(310, 510, 140, 35);
submit.setFont(new Font("seriff",Font.PLAIN,18));

linterim=new JLabel("Interim Service :");
linterim.setBounds(820,610,250,30);
linterim.setFont(new Font("seriff",Font.ITALIC,22));
service_frame.add(linterim); 

interim=new JTextArea("This generally checks levels of the fluids, including \nbrake fluid, screen wash and anti-freeze coolant."
        + "In\n addition to this, it will also check the condition of the \nengine, such as the plugs and filter, as well as testing \nthe batteries, lights and tyres.");
interim.setBounds(820,660,450,130);
interim.setFont(new Font("seriff",Font.PLAIN,19));
service_frame.add(interim); 

lfull=new JLabel("Full Service :");
lfull.setBounds(820,130,250,30);
lfull.setFont(new Font("seriff",Font.ITALIC,22));
service_frame.add(lfull); 

full=new JTextArea("Check level and refill brake fluid/clutch fluid. Check \nBrake pads/Liners, Brake discs/Drums, and replace \nif worn out."
        + "Check level and refill power steering fluid. \nCheck level and refill Automatic/Manual Transmission\n Fluid.");
full.setFont(new Font("seriff",Font.PLAIN,19));
full.setBounds(820,180,450,130);
service_frame.add(full);

lmajor=new JLabel("Major Service :");
lmajor.setBounds(1000,370,250,30);
lmajor.setFont(new Font("seriff",Font.ITALIC,22));
service_frame.add(lmajor); 

major=new JTextArea("This covers all the same checks as the full version, \nbut in much more detail and with additional \nreplacements of wearable parts and"
        + " consumables. \nThese will include air, cabin and fuel filters, spark plugs, \nbrake fluid and coolant wherever required.");
major.setBounds(1000,420,450,130);
major.setFont(new Font("seriff",Font.PLAIN,19));
service_frame.add(major);



fordate.getDateEditor().getUiComponent().addMouseListener(new MouseListener() {

@Override
public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mousePressed(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub

}

@Override
public void mouseClicked(MouseEvent e) {
// TODO Auto-generated method stub
if(tname.getText().matches("[a-zA-Z]+")) {
bean.setService_CustomerName(tname.getText().toString());
}
else {
if(tname.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Customer's name cannot be empty");
tname.requestFocus();
}
else {
JOptionPane.showMessageDialog(null, "Please enter proper customer name");
tname.requestFocus();
}
}
}

});

tcar_brand.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(fordate.getDate()!=null) {
SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
String date = sd.format(fordate.getDate());
bean.setService_DateOfService(date);
}
else{
JOptionPane.showMessageDialog(null, "Date of service cannot be empty");
fordate.requestFocus();

}

}
});
tcar_number.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(tcar_brand.getSelectedIndex()==0) {
JOptionPane.showMessageDialog(null, "Please select the car brand");
tcar_brand.requestFocus();
}
else {
bean.setService_CarBrand(tcar_brand.getItemAt(tcar_brand.getSelectedIndex()).toString());
}
}
});
tTypeofservice.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(tcar_number.getText().toUpperCase().matches("^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$")) {
bean.setService_CarNumber(tcar_number.getText().toString().toUpperCase());
}
else {
if(tcar_number.getText().toUpperCase().equals("")) {
JOptionPane.showMessageDialog(null, "Car number cannot be empty");
tcar_number.requestFocus();
}
else {
JOptionPane.showMessageDialog(null, "Please enter the car number in proper format (ex: MH 08 TY 7667)");
tcar_number.requestFocus();

}

}
}
});
tservicecity.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(tTypeofservice.getSelectedIndex()==0) {
JOptionPane.showMessageDialog(null, "Please select the Type of service from the above list");
tTypeofservice.requestFocus();
}
else {
bean.setService_TypeOfService(tTypeofservice.getItemAt(tTypeofservice.getSelectedIndex()).toString());
}
}
});
tservicecity.addItemListener(new ItemListener() {

@Override
public void itemStateChanged(ItemEvent e) {
if(tservicecity.getSelectedItem().equals("Tamilnadu")) {
Arrays.sort(tamilnadu);
tservicestate.removeAllItems();
for(int i=0;i<tamilnadu.length;i++) {
tservicestate.addItem(tamilnadu[i]);
}
}
else if(tservicecity.getSelectedItem().equals("Kerala")) {
Arrays.sort(kerala);
tservicestate.removeAllItems();
for(int i=0;i<kerala.length;i++) {
tservicestate.addItem(kerala[i]);
}
}
else if (tservicecity.getSelectedItem().equals("Andhra pradesh")) {
Arrays.sort(andhra);
tservicestate.removeAllItems();
for(int i=0;i<andhra.length;i++) {
tservicestate.addItem(andhra[i]);
}
}
       else if(tservicecity.getSelectedItem().equals("Karnataka")) {
        Arrays.sort(karnataka);
        tservicestate.removeAllItems();
        for(int i=0;i<karnataka.length;i++) {
tservicestate.addItem(karnataka[i]);
}
}
       else if(tservicecity.getSelectedItem().equals("Maharashtra")) {
        Arrays.sort(Maharashtra);
        tservicestate.removeAllItems();
        for(int i=0;i<Maharashtra.length;i++) {
tservicestate.addItem(Maharashtra[i]);
}
}
       else if(tservicecity.getSelectedItem().equals("Haryana")) {
        Arrays.sort(Haryana);
        tservicestate.removeAllItems();
        for(int i=0;i<Haryana.length;i++) {
tservicestate.addItem(Haryana[i]);
}
}
       else {
        Arrays.sort(Telangana);
        tservicestate.removeAllItems();
        for(int i=0;i<Telangana.length;i++) {
tservicestate.addItem(Telangana[i]);
}
       
}
}
});
submit.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(tservicecity.getSelectedIndex()==0) {
JOptionPane.showMessageDialog(null, "Please select the proper Service area");
}
else {
String area=tservicestate.getItemAt(tservicestate.getSelectedIndex()).toString()+" , "+tservicecity.getItemAt(tservicecity.getSelectedIndex()).toString();
bean.setService_StoreArea(area);
bean.setService_phone(phone.getText().toString());
}
double id=Math.random()*Math.random()*999;
ser_id=Double.toString(id);
bean.setService_ServiceId(ser_id);
bean.setService_CustomerName(tname.getText().toString());
SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
String date = sd.format(fordate.getDate());
bean.setService_DateOfService(date);
try {
pstatement = connecttojdbc.prepareStatement(query);
pstatement.setString(1, bean.getService_ServiceId());
pstatement.setString(2, bean.getService_CustomerName());
pstatement.setString(3, bean.getService_phone());
pstatement.setString(4, bean.getService_DateOfService());
pstatement.setString(5, bean.getService_CarBrand());
pstatement.setString(6, bean.getService_CarNumber());
pstatement.setString(7, bean.getService_TypeOfService());
pstatement.setString(8, bean.getService_StoreArea());

int i = pstatement.executeUpdate();
connecttojdbc.setAutoCommit(true);
JOptionPane.showMessageDialog(null, "Service Booking successfull ");
ServiceBilling();
} catch (Exception e1) {
// TODO Auto-generated catch block
System.out.println("");
}
}
});


service_frame.setLayout(null);
service_frame.add(name);
service_frame.add(dateofservice);
service_frame.add(car_brand);
service_frame.add(car_number);
service_frame.add(Type_of_service);
service_frame.add(service_area);
service_frame.add(tname);
service_frame.add(tcar_number);
service_frame.add(tcar_brand);
service_frame.add(tTypeofservice);
service_frame.add(phno);
service_frame.add(phone);
service_frame.add(fordate);
service_frame.add(tservicecity);
service_frame.add(tservicestate );
service_frame.add(submit);
service_frame.setBounds(200, 50, 1700, 935);
service_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


service_frame.setVisible(true);
}
public void ServiceBilling() {
JLabel summary,name,valuename,id,valueid,phone,valuephone,dos,valueedos,type,valuetype,car,valuecar,carnumber,valuecarnumber,area,valuearea,thanks;
JButton Confirm;
JLabel mailid = new JLabel();
JTextField txtmailid = new JTextField();
JFrame servicebill = new JFrame("BOOKING SUMMARY");
summary = new JLabel(" BOOKING SUMMARY ");
summary.setBounds(195, 20, 300, 40);
summary.setFont(new Font("Arial",Font.BOLD,19));

id = new JLabel("SERVICE ID");
id.setBounds(15,60,150,35);
id.setFont(new Font("arial",Font.PLAIN,17));
valueid = new JLabel();
String ids = bean.getService_ServiceId();
String idfinal=(String)ids.subSequence(0, ids.indexOf('.'));
valueid.setText(idfinal);
valueid.setFont(new Font("arial",Font.PLAIN,17));
valueid.setBounds(120,60,200,35);

name = new JLabel("NAME");
name.setBounds(195, 100, 150, 40);
name.setFont(new Font("arial",Font.PLAIN,17));
valuename = new JLabel();
valuename.setText(bean.getService_CustomerName());
valuename.setBounds(270, 100, 200, 40);
valuename.setFont(new Font("arial",Font.PLAIN,17));

phone = new JLabel("PHONE");
phone.setFont(new Font("arial",Font.PLAIN,17));
phone.setBounds(195,150,150,40);
valuephone = new JLabel();
valuephone.setText(bean.getService_phone());
valuephone.setFont(new Font("arial",Font.PLAIN,17));
valuephone.setBounds(270, 150, 200, 40);

dos = new JLabel("DATE OF SERVICE");
dos.setFont(new Font("arial",Font.PLAIN,17));
dos.setBounds(100, 200, 150, 40);
valueedos = new JLabel();
valueedos.setText(bean.getService_DateOfService());
valueedos.setFont(new Font("arial",Font.PLAIN,17));
valueedos.setBounds(270,200,200,40);

car = new JLabel("CAR BRAND");
car.setFont(new Font("arial",Font.PLAIN,17));
car.setBounds(150,250,150,40);
valuecar = new JLabel();
valuecar.setText(bean.getService_CarBrand());
valuecar.setFont(new Font("arial",Font.PLAIN,17));
valuecar.setBounds(270, 250,200, 40);

carnumber = new JLabel("CAR NUMBER");
carnumber.setFont(new Font("arial",Font.PLAIN,17));
carnumber.setBounds(140, 300, 150, 40);
valuecarnumber= new JLabel();
valuecarnumber.setText(bean.getService_CarNumber());
valuecarnumber.setFont(new Font("arial",Font.PLAIN,17));
valuecarnumber.setBounds(270, 300, 200, 40);

type = new JLabel("TYPE OF SERVICE");
type.setFont(new Font("arial",Font.PLAIN,17));
type.setBounds(100, 350, 150,40);
valuetype = new JLabel();
valuetype.setText(bean.getService_TypeOfService());
valuetype.setFont(new Font("arial",Font.PLAIN,17));
valuetype.setBounds(270, 350, 200, 40);

area = new JLabel("SERVICE AREA");
area.setBounds(120, 400, 150, 40);
area.setFont(new Font("arial",Font.PLAIN,17));
valuearea = new JLabel();
valuearea.setText(bean.getService_StoreArea());
valuearea.setBounds(270,400, 350, 40);
valuearea.setFont(new Font("arial",Font.PLAIN,17));

mailid.setBounds(120, 450, 400, 40);
mailid.setText("Enter the mail id to receive the booking details");
mailid.setFont(new Font("Arial",Font.PLAIN,17));

txtmailid.setBounds(170, 500, 250, 35);
txtmailid.setFont(new Font("Arial",Font.PLAIN,17));


Confirm = new JButton("Confirm");
Confirm.setBounds(230, 570, 140, 30);
Confirm.setFont(new Font("Arial",Font.PLAIN,16));

servicebill.setBounds(350, 80, 650, 700);
servicebill.add(summary);
servicebill.add(id);
servicebill.add(valueid);
servicebill.add(name);
servicebill.add(valuename);
servicebill.add(phone);
servicebill.add(valuephone);
servicebill.add(dos);
servicebill.add(valueedos);
servicebill.add(car);
servicebill.add(valuecar);
servicebill.add(carnumber);
servicebill.add(valuecarnumber);
servicebill.add(type);
servicebill.add(valuetype);
servicebill.add(area);
servicebill.add(valuearea);
servicebill.add(Confirm);
servicebill.add(mailid);
servicebill.add(txtmailid);
servicebill.setLayout(null);
servicebill.setVisible(true);

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
                message.setSubject("Car service booking");
                String text="Hai "+bean.getService_CustomerName()+", "+bean.getService_TypeOfService()+" for your"+bean.getService_CarBrand()+" ( "+bean.getService_CarNumber()+" )"+" on "+bean.getService_DateOfService()+" at "+bean.getService_StoreArea()+" has been booked successfully."+"\r\n"+
                " Your service ID is "+idfinal+"."+" Use this ID for Future references.";
                message.setText(text);
                Transport.send(message);
                JOptionPane.showMessageDialog(null, "Email sent succesfully");

} catch (MessagingException e1) {
System.out.println(e1);
}
}
});
}
public static void main(String[] args) throws Exception, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
jdbcconnect jdbc = new jdbcconnect();
connecttojdbc = jdbc.getconnection();
//String lookandfeel="com.jtattoo.plaf.noire.NoireLookAndFeel";
//UIManager.setLookAndFeel(lookandfeel);
Service service = new Service();

}

}
