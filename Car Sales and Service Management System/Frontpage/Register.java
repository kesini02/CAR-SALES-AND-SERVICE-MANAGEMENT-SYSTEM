package Frontpage;
import database.javabean;
import service.jdbcconnect;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Register {
private JFrame frame;
private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
private JTextField textf1,textf2,textf3,textf4,textf5,textf7,textf9,textf8 ,textf10;
private JRadioButton maleradiobut,femaleradiobut;
javabean jbean = new javabean();
String option[]= {"  ","yes","No"};
private JComboBox<String> dropmenu;
private JButton registerbutt;
Connection connect;
PreparedStatement statement;

Register(){
jdbcconnect cc= new jdbcconnect();
connect = cc.getconnection();
frame = new JFrame(" R E G I S T R A T I O N ");
label1 = new JLabel("Email ID:");
label1.setFont(new Font("calibri", Font.ITALIC, 17));
label2 = new JLabel("Password: ");
label2.setFont(new Font("calibri", Font.ITALIC, 17));
label3 = new JLabel("Name: ");
label3.setFont(new Font("calibri", Font.ITALIC, 17));
label4 = new JLabel("Date Of Birth: ");
label4.setFont(new Font("calibri", Font.ITALIC, 17));
label5=new JLabel("Age: ");
label5.setFont(new Font("calibri", Font.ITALIC, 17));
label6 = new JLabel("Gender: ");
label6.setFont(new Font("calibri", Font.ITALIC, 17));
label7 = new JLabel("Mobile number: ");
label7.setFont(new Font("calibri", Font.ITALIC, 17));
label8=new JLabel("Address: ");
label8.setFont(new Font("calibri", Font.ITALIC, 17));
label9 =new JLabel("License no: ");
label9.setFont(new Font("calibri", Font.ITALIC, 17));
label10=new JLabel("Driving known: ");
label10.setFont(new Font("calibri", Font.ITALIC, 17));



label1.setBounds(40, 40, 110, 47);
label2.setBounds(40, 80, 130, 47);
label3.setBounds(40, 120, 130,47);
label4.setBounds(40, 160, 140, 47);
label5.setBounds(40, 200, 130, 47);
label6.setBounds(40,240,130,47);
label7.setBounds(40,280,130,47);
label8.setBounds(40, 320, 130, 47);
label9.setBounds(40, 360, 130, 47);
label10.setBounds(40, 400, 130, 47);


textf1=new JTextField();
textf1.setFont(new Font("Arial",Font.PLAIN,16));
textf2=new JTextField();
textf2.setFont(new Font("Arial",Font.PLAIN,16));
textf3=new JTextField();
textf3.setFont(new Font("Arial",Font.PLAIN,16));
textf4=new JTextField();
textf4.setFont(new Font("Arial",Font.PLAIN,16));
textf5=new JTextField();
textf5.setFont(new Font("Arial",Font.PLAIN,16));
textf7=new JTextField();
textf7.setFont(new Font("Arial",Font.PLAIN,16));
textf8=new JTextField();
textf8.setFont(new Font("Arial",Font.PLAIN,16));
textf9=new JTextField("Last 6 digits");
textf9.setFont(new Font("Arial",Font.PLAIN,16));
textf10 = new JTextField("Confirm password");
textf10.setFont(new Font("Arial",Font.PLAIN,16));
registerbutt = new JButton("REGISTER");


textf1.setBounds(170,38,200,34);
textf2.setBounds(170, 80, 200, 34);
textf3.setBounds(170, 120, 200, 34);
textf4.setBounds(170, 160, 200, 34);
textf5.setBounds(170,200,200,34);
maleradiobut = new JRadioButton("Male");
femaleradiobut=new JRadioButton("Female");
maleradiobut.setBounds(170, 240, 100, 34);
femaleradiobut.setBounds(280, 240, 100, 34);
maleradiobut.setFont(new Font("Arial",Font.PLAIN,16));
femaleradiobut.setFont(new Font("Arial",Font.PLAIN,16));
ButtonGroup buttgrp = new ButtonGroup();
buttgrp.add(maleradiobut);
buttgrp.add(femaleradiobut);

dropmenu = new JComboBox<String>(option);
dropmenu.setFont(new Font("Arial",Font.BOLD,15));
textf7.setBounds(170,280,200,34);
textf8.setBounds(170,320,200,34);
textf9.setBounds(170, 360, 200, 34);
dropmenu.setBounds(170, 400, 200, 34);
textf10.setBounds(390, 80, 200, 34);


registerbutt.setBounds(230, 460, 100, 30);
frame.setLayout(null);

frame.add(label1);
frame.add(label2);
frame.add(label3);
frame.add(label4);
frame.add(label5);
frame.add(label6);
frame.add(label7);
frame.add(label8);
frame.add(label9);
frame.add(label10);

frame.add(textf1);
frame.add(textf2);
frame.add(textf3);
frame.add(textf4);
frame.add(textf5);
frame.add(maleradiobut);
frame.add(femaleradiobut);
frame.add(textf7);
frame.add(textf8);
frame.add(textf9);
frame.add(dropmenu);
frame.add(textf10);

frame.add(registerbutt);


frame.setBounds(500, 100, 650, 600);
frame.setVisible(true);

    textf2.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf1.getText().matches("^(.+)@(.+)$")) {
jbean.setUsers_EmailID(textf1.getText().toString());
}
else {
if(textf1.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Email ID field cannot be empty");
textf1.requestFocus();
textf1.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Enter Email ID in proper format");
textf1.setText("");
textf1.requestFocus();
}
}
}

});
    textf10.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
textf10.setText("");
}
});
textf3.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf2.getText().matches(textf10.getText().toString())) {
if(textf10.getText().length()>=6) {
jbean.setUsers_Password(textf2.getText());
}
else {
JOptionPane.showMessageDialog(null, "Minimum length of password should be 6 ");
textf10.setText("");
textf10.requestFocus();
}

}
else {
JOptionPane.showMessageDialog(null, "Passwords Doesn't match");
textf10.setText("");
textf10.requestFocus();
}
}
});
textf4.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub
           String dateofbirth=textf4.getText();

String datecheck[]=dateofbirth.split("/");
if(datecheck.length>1) {
String age= String.valueOf(2021-Integer.parseInt(datecheck[2]));
textf5.setText(age);
}
}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf3.getText().matches("[a-zA-Z]+")) {
jbean.setUsers_UserName(textf3.getText());
}
else {
if(textf3.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Name field cannot be empty");
textf3.requestFocus();
textf3.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Name should contain only alphabets");
textf3.setText("");
textf3.requestFocus();

}
}
}
});
textf5.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf4.getText().matches("^(0[1-9]|[12][0-9]|3[01])[ /](0[1-9]|1[012])[ /]((19|20)\\d\\d)$")) {
jbean.setUsers_DateOfBirth(textf4.getText());
}
else {
if(textf4.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Date of Birth field cannot be empty");
textf4.requestFocus();
textf4.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Date Of Birth should be in dd/mm/yyyy format");
textf4.setText("");
textf4.requestFocus();
}
}
}
});
maleradiobut.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf5.getText().matches("\\d+")) {
jbean.setUsers_Age(textf5.getText());
}
else {
if(textf5.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Age field cannot be empty");
textf5.requestFocus();
textf5.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Age should be in number");
textf5.setText("");
textf5.requestFocus();
}
}
}
});
femaleradiobut.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf5.getText().matches("\\d+")) {
jbean.setUsers_Age(textf5.getText());
}
else {
if(textf5.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Age field cannot be empty");
textf5.requestFocus();
textf5.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Age should be in number");
textf5.setText("");
textf5.requestFocus();
}
}
}
});
textf7.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(!maleradiobut.isSelected() && !femaleradiobut.isSelected()) {
JOptionPane.showMessageDialog(null, "Please select the gender field");
maleradiobut.requestFocus();
}
else {
if(maleradiobut.isSelected()) {
jbean.setUsers_Gender("Male");
}
else {
jbean.setUsers_Gender("Female");
}
}
}
});
textf8.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf7.getText().matches("^[0-9]{10}$")) {
jbean.setUsers_PhoneNumber(textf7.getText());
}
else {
if(textf7.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Mobile number field cannot be empty");
textf7.requestFocus();
textf7.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Mobile should contain only 10 digits of numbers");
textf7.setText("");
textf7.requestFocus();
}
}
}
});
textf9.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
textf9.setText("");
if(textf8.getText().matches("^[a-zA-Z_ ]*$")){
jbean.setUsers_Address(textf8.getText());
}
else {
if(textf8.getText().equals("")) {
JOptionPane.showMessageDialog(null, "Address field cannot be empty");
textf8.requestFocus();
textf8.setText("");
}
else {
JOptionPane.showMessageDialog(null, "Enter proper Address");
textf8.requestFocus();
textf8.setText("");
}
}
}
});
dropmenu.addFocusListener(new FocusListener() {

@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
// TODO Auto-generated method stub
if(textf9.getText().matches("^[0-9]{6}$")) {
jbean.setUsers_LicenseNumber(textf9.getText());
}
else {
JOptionPane.showMessageDialog(null, "Enter Proper License number");
textf9.requestFocus();
textf9.setText("");
}
}
});

registerbutt.addFocusListener(new FocusListener() {
@Override
public void focusLost(FocusEvent e) {
// TODO Auto-generated method stub

}

@Override
public void focusGained(FocusEvent e) {
if(dropmenu.getSelectedIndex()==0) {
JOptionPane.showMessageDialog(null, "Please fill all the asked fields");
dropmenu.requestFocus();
}
else {
jbean.setUsers_DrivingKnown((String) dropmenu.getItemAt(dropmenu.getSelectedIndex()));
}
}
});
registerbutt.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
double k = Math.random()*Math.random()*999;
int kk = (int) (k*Math.random()*99);
jbean.setUsers_userID(String.valueOf(kk));
String query="Insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
try {
PreparedStatement statement = connect.prepareStatement(query);
statement.setString(1,jbean.getUsers_userID());
statement.setString(2, jbean.getUsers_EmailID());
statement.setString(3, jbean.getUsers_UserName());
statement.setString(4, jbean.getUsers_Password());
statement.setString(5, jbean.getUsers_DateOfBirth());
statement.setString(6, jbean.getUsers_Age());
statement.setString(7, jbean.getUsers_Gender());
statement.setString(8, jbean.getUsers_PhoneNumber());
statement.setString(9, jbean.getUsers_Address());
statement.setString(10, jbean.getUsers_LicenseNumber());
statement.setString(11, jbean.getUsers_DrivingKnown());



int i=statement.executeUpdate();
connect.setAutoCommit(true);
} catch (SQLException e1) {
// TODO Auto-generated catch block
System.out.println(e1);
}
JOptionPane.showMessageDialog(null,"Registration successful. Values added in the table! ");
}
});
}
public static void main(String[] args) throws Exception, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
String lookandfeel="com.jtattoo.plaf.noire.NoireLookAndFeel";
UIManager.setLookAndFeel(lookandfeel);
// TODO Auto-generated method stub
Register r = new Register();
}

}

