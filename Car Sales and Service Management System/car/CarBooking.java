package car;

import database.DatabaseOperations;
import database.datas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import static java.awt.SystemColor.text;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import car.javabean;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.jdbcconnect;


public class CarBooking extends JFrame {
    Container co;
    JLabel lab_Booking,lab_BookingId,lab_RegistrationName,lab_AadharNumber,lab_Occupation,lab_DeliveryDate,lab_PanCardNumber,lab_Accessories,lab_PaymentMethod,lab_ModelNo,lab_CarBrand,l;
    JTextField txt_BookingId,txt_RegistrationName,txt_AadharNumber,txt_Occupation,txt_DeliveryDate,txt_PanCardNumber,txt_ModelNo,txt_CarBrand,t;
    JComboBox jcb_Accessories,jcb_PaymentMethod;
    JButton submit,edit,delete;
    PreparedStatement ptmt=null;
    
    public CarBooking()
    {
         BufferedImage img=null;
       try {
       img = ImageIO.read(new File("C:\\book.jpg"));
       } catch (Exception e) {
       e.printStackTrace();
       }
       Image dimg = img.getScaledInstance(1550,1035, Image.SCALE_SMOOTH);
       ImageIcon imageIcon = new ImageIcon(dimg);
       setContentPane(new JLabel(imageIcon));
       
        co=getContentPane();
        co.setLayout(null);
        setTitle("CAR BOOKING");
        lab_Booking =new JLabel("CAR BOOKING");
        lab_Booking.setBounds(575,30,260,40);
        lab_Booking.setFont(new Font("TIMES NEW ROMAN",Font.ITALIC,35));
        lab_Booking.setForeground(Color.BLACK);
        co.add(lab_Booking);
        
        lab_BookingId =new JLabel("BOOKING ID :");
        lab_BookingId.setBounds(380,100,200,20);
        lab_BookingId.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_BookingId.setForeground(Color.BLACK);
        co.add(lab_BookingId);
        
        txt_BookingId = new JTextField();
        txt_BookingId.setBounds(700,100,200,30);
        txt_BookingId.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_BookingId);
        
        lab_RegistrationName =new JLabel("REGISTRATION NAME :");
        lab_RegistrationName.setBounds(380,150,240,40);
        lab_RegistrationName.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_RegistrationName.setForeground(Color.BLACK);
        co.add(lab_RegistrationName);
        
        txt_RegistrationName = new JTextField();
        txt_RegistrationName.setBounds(700,150,200,30);
        txt_RegistrationName.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_RegistrationName);
        
        lab_ModelNo =new JLabel("CAR MODELNO :");
        lab_ModelNo.setBounds(380,200,240,40);
        lab_ModelNo.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_ModelNo.setForeground(Color.BLACK);
        co.add(lab_ModelNo);
        
        txt_ModelNo = new JTextField();
        txt_ModelNo.setBounds(700,200,200,30);
        txt_ModelNo.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_ModelNo);
        
        lab_CarBrand =new JLabel("CAR BRAND :");
        lab_CarBrand.setBounds(380,250,240,40);
        lab_CarBrand.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_CarBrand.setForeground(Color.BLACK);
        co.add(lab_CarBrand);
        
        txt_CarBrand = new JTextField();
        txt_CarBrand.setBounds(700,250,200,30);
        txt_CarBrand.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_CarBrand);  
        
        lab_DeliveryDate=new JLabel("DELIVERY DATE :");
        lab_DeliveryDate.setBounds(380,300,240,40);
        lab_DeliveryDate.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_DeliveryDate.setForeground(Color.BLACK);
        co.add(lab_DeliveryDate);
        
        txt_DeliveryDate=new JTextField();
        txt_DeliveryDate.setBounds(700,300,200,30);
        txt_DeliveryDate.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_DeliveryDate);
        
        lab_PanCardNumber=new JLabel("PANCARD NO :");
        lab_PanCardNumber.setBounds(380,350,240,40);
        lab_PanCardNumber.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_PanCardNumber.setForeground(Color.BLACK);
        co.add(lab_PanCardNumber);
        
        txt_PanCardNumber=new JTextField();
        txt_PanCardNumber.setBounds(700,350,200,30);
        txt_PanCardNumber.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_PanCardNumber);
        
        JButton b=new JButton("SELECT");
        b.setBounds(920,300,100,30);
        b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
				txt_DeliveryDate.setText(new DatePicker().setPickedDate());
            }
        });
        
        co.add(b);
        
        lab_Accessories=new JLabel("ACCESSORIES:");
        lab_Accessories.setBounds(380,400,240,40);
        lab_Accessories.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_Accessories.setForeground(Color.BLACK);
        co.add(lab_Accessories);
        
        jcb_Accessories=new JComboBox();
        jcb_Accessories.addItem("NEEDED");
        jcb_Accessories.addItem("NOT NEEDED");
        jcb_Accessories.setBounds(700, 400, 200, 30);
        co.add(jcb_Accessories);
        
        lab_PaymentMethod=new JLabel("PAYMENT METHOD:");
        lab_PaymentMethod.setBounds(380,450,240,40);
        lab_PaymentMethod.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_PaymentMethod.setForeground(Color.BLACK);
        co.add(lab_PaymentMethod);
        
        jcb_PaymentMethod=new JComboBox();
        jcb_PaymentMethod.addItem("CASH");
        jcb_PaymentMethod.addItem("PAYORDER");
        jcb_PaymentMethod.addItem("CHEQUE");
        jcb_PaymentMethod.addItem("DEMAND DRAFT");
        jcb_PaymentMethod.setBounds(700, 450, 200, 30);
        co.add(jcb_PaymentMethod);
        
        lab_AadharNumber =new JLabel("AADHAAR NUMBER:");
        lab_AadharNumber.setBounds(380,500,240,40);
        lab_AadharNumber.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_AadharNumber.setForeground(Color.BLACK);
        co.add(lab_AadharNumber);
        
        txt_AadharNumber = new JTextField();
        txt_AadharNumber.setBounds(700,500,200,30);
        txt_AadharNumber.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_AadharNumber);
        
        lab_Occupation =new JLabel("OCCUPATION:");
        lab_Occupation.setBounds(380,550,240,40);
        lab_Occupation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        lab_Occupation.setForeground(Color.BLACK);
        co.add(lab_Occupation);
        
        txt_Occupation = new JTextField();
        txt_Occupation.setBounds(700,550,200,30);
        txt_Occupation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(txt_Occupation);
        
        l=new JLabel("PHONE NO :");
        l.setBounds(380,600,240,40);
        l.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        l.setForeground(Color.BLACK);
        co.add(l);
        
        t = new JTextField();
        t.setBounds(700,600,200,30);
        t.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        co.add(t);
        
        
        submit =new JButton("SUBMIT");
        submit.setBounds(450,690,90,25);
        submit.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
        co.add(submit);
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                db1_sample();
            }
            
        });
       
        edit =new JButton("UPDATE");
        edit.setBounds(550,690,90,25);
        edit.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
        co.add(edit);
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="update Car_Booking set RegistrationName=?,CarModelNo=?,CarBrand=?,DeliveryDate=?,PancardNo=?,Accessories=?,PaymentMethod=?,AadhaarNumber=?,Occupation=? where BookingId=?"; 
            
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt_RegistrationName.getText());
            
            ptmt.setString(2,txt_ModelNo.getText());
            ptmt.setString(3,txt_CarBrand.getText());
            ptmt.setString(4,txt_DeliveryDate.getText());
            
            ptmt.setString(5,txt_PanCardNumber.getText());
            ptmt.setString(6,jcb_Accessories.getSelectedItem().toString());
            ptmt.setString(7,jcb_PaymentMethod.getSelectedItem().toString());
            
            ptmt.setString(8,txt_AadharNumber.getText());
            ptmt.setString(9,txt_Occupation.getText());
            ptmt.setString(10,txt_BookingId.getText());
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"UPDATION SUCCESSFULL");
            
        }
        catch(Exception ee){
             JOptionPane.showMessageDialog(null,ee);
        }
            }
            
        });
       
        delete =new JButton("DELETE");
        delete.setBounds(650,690,90,25);
        delete.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
        co.add(delete);
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 try{
            
            Connection co = DatabaseOperations.getConnection();
            Statement stmt=co.createStatement();
            
            String query="delete from Car_Booking where car_modelNo=?";
            ptmt=co.prepareStatement(query);
            ptmt.setString(1,txt_BookingId.getText());
             
            
            ptmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");
            
        }
        catch(Exception ee){
             JOptionPane.showMessageDialog(null,ee);
        }
            }
            
        });
        
       JButton print =new JButton("PRINT RECEIPT");
       print.setBounds(750, 690, 140, 25);
       print.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,13));
       add(print);
       print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 try {
                    new salesbill(txt_BookingId.getText(),txt_RegistrationName.getText(),txt_DeliveryDate.getText(),txt_ModelNo.getText(),txt_CarBrand.getText(),jcb_PaymentMethod.getSelectedItem().toString(),t.getText());
                } catch (Exception ex) {
                    Logger.getLogger(CarBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        setLayout(new BorderLayout());
        
        setSize(1550,1035);      
        
        
    }
    void db1_insert(datas ss1)
    {
         try{
             String BookingId=ss1.getBookingId();
             String RegistrationName=ss1.getRegistrationName();
             String CarModelNo=ss1.getCarModelNo();
             String CarBrand=ss1.getCarBrand();
             String DeliveryDate=ss1.getDeliveryDate();
             String PancardNo=ss1.getPancardNo();
             String Accessories=ss1.getAccessories();
             String PaymentMethod=ss1.getPaymentMethod();
             String AadhaarNumber=ss1.getAadhaarNumber();
             String Occupation=ss1.getOccupation();
             String phone=ss1.getPhoneno();
                
           Connection co = DatabaseOperations.getConnection();
           Statement stmt=co.createStatement();
           String query="insert into Car_Booking values('"+BookingId+"','"+RegistrationName+"',"+CarModelNo+",'"+CarBrand+"','"+DeliveryDate+"','"+PancardNo+"','"+Accessories+"','"+PaymentMethod+"','"+AadhaarNumber+"','"+Occupation+"','"+phone+"')";
           stmt.executeUpdate(query);
           co.setAutoCommit(true);
           co.close();
           JOptionPane.showMessageDialog(null,"Success!");
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void db1_sample()
    {
             String regex1="^[a-zA-Z]{5,30}$";
             String BookingId=txt_BookingId.getText();
             boolean b1=Pattern.matches(regex1, BookingId);
             if(b1==false)
             {
                 JOptionPane.showMessageDialog(null,"BookingId is invalid");
             }
             
             String regex2="^[a-zA-Z]{5,30}$";
             String RegistrationName=txt_RegistrationName.getText();
             boolean b2=Pattern.matches(regex2, RegistrationName);
             if(b2==false)
             {
                 JOptionPane.showMessageDialog(null,"Enter valid Name");
             }
             
             String regex3="^[0-9a-zA-z]{1,30}$";
             String CarModelNo=(txt_ModelNo.getText());
              boolean b3=Pattern.matches(regex3,CarModelNo );
             if(b3==false)
             {
                 JOptionPane.showMessageDialog(null,"ModelNo is invalid");
             }
             
             String regex4="^[A-Za-z]{5,30}$";
             String CarBrand=txt_CarBrand.getText();
             boolean b4=Pattern.matches(regex4,CarBrand );
             if(b4==false)
             {
                 JOptionPane.showMessageDialog(null,"Enter valid CarBrand");
             }
             
             String regex5="^[0-9]{0,2}[-][0-9]{0,2}[-][0-9]{0,4}$";
             String DeliveryDate=txt_DeliveryDate.getText();
             boolean b5=Pattern.matches(regex5,DeliveryDate );
             if(b5==false)
             {
                 JOptionPane.showMessageDialog(null,"Enter valid Date");
             }
             
             String regex6="^[0-9]{5,30}$";
             String PancardNo=txt_PanCardNumber.getText();
             boolean b6=Pattern.matches(regex6,PancardNo );
             if(b6==false)
             {
                 JOptionPane.showMessageDialog(null,"Enter valid Pancard No");
             }
             
             String Accessories=jcb_Accessories.getSelectedItem().toString();
             String PaymentMethod=jcb_PaymentMethod.getSelectedItem().toString();
             
             String regex7="^[0-9]{5,30}$";
             String AadhaarNumber=txt_AadharNumber.getText();
             boolean b7=Pattern.matches(regex7,AadhaarNumber );
             if(b7==false)
             {
                 JOptionPane.showMessageDialog(null,"AadharNumber is invalid");
             }
             
             String regex8="^[a-zA-z]{5,30}$";
             String Occupation=txt_Occupation.getText();
             boolean b8=Pattern.matches(regex8,Occupation );
             if(b8==false)
             {
                 JOptionPane.showMessageDialog(null,"Occupation is invalid");
             }
             
             String regex9="^[0-9]{10}$";
             String phone=t.getText();
             boolean b9=Pattern.matches(regex9,phone );
             if(b9==false)
             {
                 JOptionPane.showMessageDialog(null,"Occupation is invalid");
             }
             datas s1 = new datas();
             
             s1.setBookingId(BookingId);
             s1.setRegistrationName(RegistrationName);
             s1.setCarModelNo(CarModelNo);
             s1.setCarBrand(CarBrand);
             s1.setDeliveryDate(DeliveryDate);
             s1.setPancardNo(PancardNo);
             s1.setAccessories(Accessories);
             s1.setPaymentMethod(PaymentMethod);
             s1.setAadhaarNumber(AadhaarNumber);
             s1.setOccupation(Occupation);
             s1.setPhoneno(phone);
            
             db1_insert(s1);
    }
    
    public static void main(String args[])
   {
    new CarBooking();
   }
}


class DatePicker {
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker() {
		d = new JDialog();
                d.setSize(520,280 );
		d.setModal(true);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}


   
    