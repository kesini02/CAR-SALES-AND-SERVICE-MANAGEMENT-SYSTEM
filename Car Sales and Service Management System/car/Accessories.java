package car;
import database.DatabaseOperations;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Accessories implements ActionListener{
JFrame frame = new JFrame();
JLabel title, brand_name, part_name, page, tool_name, background;
JComboBox brand, part, tools;
JButton search;
String[] ss = {"Select"};
public String choosebrand;
public String choosemodel;
public String choosetool;
public String toolno;
public String toolprice, tooldescrip;
public int a,b;
JLabel retImage;

Accessories(){
//Logo
ImageIcon image = new ImageIcon("logo.jpg");
frame.setIconImage(image.getImage());

//Frame Setup
frame.setSize(1920, 1080);
//frame.setLocation(500, 200);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Background
ImageIcon img = new ImageIcon("background.png");
background = new JLabel("", img, JLabel.CENTER);
background.setBounds(0, 0, 1920, 1080);



//Title Setup
title = new JLabel("Select your Vehicle Brand and Model");
title.setBounds(580, 150, 1000, 100);
title.setFont(new Font("null",Font.BOLD, 20));

//page name
page = new JLabel("WELCOME TO E-ACCESSORIES SHOP");
page.setBounds(400, 50, 1000, 100);
page.setFont(new Font("null",Font.BOLD, 40));

//Combo Box Brand
brand = new JComboBox(ss);
brand.setFont(new Font("null", Font.ITALIC, 14));
fillbrand();
brand.setBounds(700, 250, 250, 25);


//Combo Box Part
part = new JComboBox(ss);
part.setFont(new Font("null", Font.ITALIC, 14));
part.setBounds(700, 300, 250, 25);
fillmodel();

//Combo Box Tools
tools = new JComboBox(ss);
tools.setFont(new Font("null", Font.ITALIC, 14));
tools.setBounds(700, 350, 250, 25);
filltool();


//Name of Brand Combo Box
brand_name = new JLabel("Brand Name");
brand_name.setBounds(580, 250, 250, 25);
brand_name.setFont(new Font("null", Font.PLAIN, 14));



//Name of Part Combo Box
part_name = new JLabel("Model Name");
part_name.setBounds(580, 300, 150, 25);
part_name.setFont(new Font("null", Font.PLAIN, 14));

//Name of Tools Combo Box
tool_name = new JLabel("Accessories");
tool_name.setBounds(580, 350, 150, 25);
tool_name.setFont(new Font("null", Font.PLAIN, 14));


//Search Button
search = new JButton("Buy Accessories");
search.setBounds(700, 450, 250, 25);
search.addActionListener(this);


//Add Components
frame.add(title);
frame.add(brand);
frame.add(part);
frame.add(brand_name);
frame.add(part_name);
frame.add(search);
frame.add(page);
frame.add(tools);
frame.add(tool_name);
frame.add(background);
frame.setVisible(true);
}
public static void main(String[] args) {
Accessories a = new Accessories();


}

public void fillbrand() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list";
PreparedStatement st = co.prepareStatement(sql);

ResultSet rs = st.executeQuery();
while(rs.next()) {
String brandname = rs.getString("car_brand");
brand.addItem(brandname);
}


co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

public void fillmodel() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list";
PreparedStatement st = co.prepareStatement(sql);

ResultSet rs = st.executeQuery();
while(rs.next()) {
String partname = rs.getString("car_model");
part.addItem(partname);
}

co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

public void filltool() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list";
PreparedStatement st = co.prepareStatement(sql);

ResultSet rs = st.executeQuery();
while(rs.next()) {
String toolname = rs.getString("access_name");
tools.addItem(toolname);
}

co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

public void fillno() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list where access_name = ?";
PreparedStatement st = co.prepareStatement(sql);
st.setString(1, choosetool);

ResultSet rs = st.executeQuery();
while(rs.next()) {
String toolno = rs.getString("product_id");
a = Integer.parseInt(toolno);
//System.out.println(a);
}

co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

public void productPrice() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list where access_name = ?";
PreparedStatement st = co.prepareStatement(sql);
st.setString(1, choosetool);

ResultSet rs = st.executeQuery();
while(rs.next()) {
toolprice = rs.getString("price");
System.out.println(toolprice);
}

co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

public void productdes() {
try {

 Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
String sql = "SELECT * FROM access_list where access_name = ?";
PreparedStatement st = co.prepareStatement(sql);
st.setString(1, choosetool);

ResultSet rs = st.executeQuery();
while(rs.next()) {
tooldescrip = rs.getString("access_desc");
System.out.println(tooldescrip);
}

co.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}

/*public void ImageRet() {
try {

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CAR", "root", "java24");
String sql = "SELECT * FROM access_list where acess_name = ?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1, choosetool);

ResultSet rs = st.executeQuery();
while(rs.next()) {
toolprice = rs.getString("price");
System.out.println(toolprice);
}

con.close();
}
catch(Exception ex) {
JOptionPane.showMessageDialog(null, ex);
}
}*/

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub


choosebrand = brand.getSelectedItem().toString();
choosemodel = part.getSelectedItem().toString();
choosetool = tools.getSelectedItem().toString();
fillno();
productPrice();
productdes();
//System.out.println(toolprice);
//System.out.println(choosebrand);
frame.dispose();
new Purchase(choosetool, a, toolprice, tooldescrip).setVisible(true);

}


}
