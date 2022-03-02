package Frontpage;

import admin.AdminAccessories;
import admin.AdminCarSales;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class AdminPage extends JFrame {
    Container c;
    JButton car,access;
    
    public AdminPage()
    {
        BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\admin.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1550, 835, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
    setTitle("ADMIN MAIN PAGE");
      setSize(1550,835);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
      c.setLayout(null);
      
      JLabel wel=new JLabel("Welcome to Admin Page!");
      wel.setBounds(250, 100, 400, 30);
      wel.setFont(new Font("Algerian",Font.BOLD,25));
      c.add(wel);
      
      car = new JButton("ADD CAR");
      car.setBounds(310, 200, 240, 35);
      car.setFont(new Font("seriff",Font.PLAIN,18));
      c.add(car);
      car.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminCarSales();
            }
          
      });

      access = new JButton("ADD ACCESSORIES");
      access.setBounds(580, 200, 240, 35);
      access.setFont(new Font("seriff",Font.PLAIN,18));
      c.add(access);
      access.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               new AdminAccessories();
            }
          
      });

      setVisible(true); 
    }
    public static void main(String args[])
    {
        new AdminPage();
    }
}
