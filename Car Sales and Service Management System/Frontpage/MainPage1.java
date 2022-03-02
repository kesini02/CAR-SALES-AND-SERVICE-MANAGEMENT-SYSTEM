package Frontpage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import service.Service;
import car.CarSales;
import car.UsedCarBuying;
public class MainPage1  extends JFrame {
JTree tree;
DefaultMutableTreeNode Ourservices,Ssales,Sservice,Saccessories;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10;
Container c;


public MainPage1(){
    
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
    
Ourservices = new DefaultMutableTreeNode("Our Services");

Ssales = new DefaultMutableTreeNode("Car sales");
Sservice = new DefaultMutableTreeNode("Car service");
Saccessories = new DefaultMutableTreeNode("Car Accessories");
DefaultMutableTreeNode AddUsedCars=new DefaultMutableTreeNode("Add Used Cars");

DefaultMutableTreeNode BuyCar=new DefaultMutableTreeNode("Buy Cars");
Ssales.add(BuyCar);

TreeModel model = new DefaultTreeModel(Ourservices);
tree = new JTree(model);
tree.setFont(new Font("Calibri",Font.BOLD,20));
tree.setBounds(0, 0,200, 1035);
tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {

@Override
public void valueChanged(TreeSelectionEvent e) {
Ourservices.add(Ssales);
Ourservices.add(Sservice);
Ourservices.add(Saccessories);
Ourservices.add(AddUsedCars);
DefaultMutableTreeNode selectednode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
if(selectednode==Sservice) {
     new Service();
}
if(selectednode==BuyCar) {
     new CarSales();
}
if(selectednode==Sservice) {
     new Service();
}
if(selectednode==AddUsedCars) {
    new UsedCarBuying();
}
if(selectednode==Saccessories) {
     //new Service();
}
}

});

lb1 = new JLabel("BUY AND SELL CARS ONLINE");
lb1.setBounds(700, 50, 500, 130);
lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
lb1.setForeground(Color.GRAY);
lb2 = new JLabel("FIND YOUR DREAM CAR");
lb2.setBounds(640, 100, 600, 130);
lb2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
lb2.setForeground(Color.BLACK);

lb8=new JLabel("Book a car now and start the journey anywhere,anytime..!");
lb8.setBounds(600, 210, 700, 30);
lb8.setFont(new Font("Segoe Script",Font.PLAIN,20));
lb8.setForeground(Color.WHITE);
c.add(lb8);

lb4=new JLabel("POPULAR CARS");
lb4.setBounds(870, 270, 700, 30);
lb4.setFont(new Font("calibri",Font.PLAIN,25));

lb3 = new JLabel("cartest@gmail.com");
lb3.setBounds(1400, 100, 400, 130);
lb3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
lb3.setForeground(Color.black);

lb5 = new JLabel("8734902371");
lb5.setBounds(1600, 100, 360, 130); 
lb5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
lb5.setForeground(Color.black);

lb10=new JLabel("CONTACT US ");
lb10.setBounds(1350, 60, 250, 130);
lb10.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
lb10.setForeground(Color.RED);

JTextArea area=new JTextArea("  POPULAR HATCHBACKS\n        Maruti Swift\n        Hyundai i10\n          Ford Figo");  
        area.setBounds(500,330, 250,120); 
        Font font = new Font("Segoe Script", Font.BOLD, 15);
        area.setFont(font);
        c.add(area);
        
        JTextArea area1=new JTextArea("     POPULAR SEDANS\n        Maruti Dzire\n           Honda City\n        Hyundai Verna");  
        area1.setBounds(830,330, 250,120); 
        Font font1 = new Font("Segoe Script", Font.BOLD, 15);
        area1.setFont(font1);
        c.add(area1);
        
        JTextArea area2=new JTextArea("       POPULAR SUVs\n        Toyota Innova\n      Mahindra Scorpio\n        Maruti Ertiga");  
        area2.setBounds(1160,330, 250,120); 
        Font font2 = new Font("Segoe Script", Font.BOLD, 15);
        area2.setFont(font2);
        c.add(area2);
        
c.add(tree);
c.add(lb1);
c.add(lb2);
c.add(lb3);
c.add(lb10);
c.add(lb5);
c.add(lb4);

setVisible(true);
}
public static void main(String[] args ) throws Exception, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

MainPage1 mp = new MainPage1();

}    
}
