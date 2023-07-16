import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.toedter.calendar.JDateChooser;
public class Trainsearch{
	static String from=null,to=null,date=null,clas=null;
	static boolean trainavailability(String start,String to) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","12345678");
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery("select train_name from "+start+" where destination='"+to+"'");
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		JFrame frame= new JFrame("Deccan_Rail");
		JLabel img=new JLabel(new ImageIcon("C:\\Users\\Mistral\\Downloads\\train.jpg"));
		img.setBounds(0, 0, 500, 500);
		JLabel l0= new JLabel("SEARCH TICKET");
		l0.setBounds(175, 20,150, 30);
		l0.setFont(new Font("Verdana",Font.ITALIC,20));
		JLabel l1= new JLabel("From");
		l1.setBounds(20,100,50,40);
		l1.setForeground(Color.gray);
		l1.setFont(new Font("Verdana",Font.ITALIC,18));
		JLabel l2= new JLabel("To");
		l2.setBounds(20,190,50,30);
		l2.setForeground(Color.gray);
		l2.setFont(new Font("Verdana",Font.ITALIC,18));
		JLabel l3= new JLabel("Select Date");
		l3.setBounds(250,100,200,40);
		l3.setFont(new Font("Verdana",Font.ITALIC,18));
		l3.setForeground(Color.gray);
		JTextField temp1= new JTextField();
		temp1.setBounds(20,100,200,40);
		JTextField temp2= new JTextField();
		temp2.setBounds(20,190,200,40);
		JTextField t1= new JTextField();
		t1.setBounds(20,100,200,40);
		t1.setOpaque(false);
		t1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				l1.setVisible(false);}
		});
		JTextField t2= new JTextField();
		t2.setBounds(20,190,200,40);
		t2.setOpaque(false);
		t2.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				l2.setVisible(false);}
		});
		JDateChooser datechooser= new JDateChooser();
		datechooser.setBounds(250,100,200,40);
		datechooser.setOpaque(false);
		datechooser.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
			l3.setVisible(false);}
		});
		JLabel l4= new JLabel("Select Class");
		l4.setBounds(250,190,200,40);
		l4.setFont(new Font("Verdana",Font.ITALIC,18));
		l4.setForeground(Color.gray);
		String[] options= {"  ","Chair","AC Sleeper"};
 		JComboBox<Object> quota= new JComboBox<Object>(options);
 		quota.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
			l4.setVisible(false);}
		});
		quota.setBounds(250,190,200,40);
		quota.setOpaque(false);
		JButton search= new JButton("Search");
		search.setFont(new Font("Verdana",Font.ITALIC,18));
		search.setBackground(Color.WHITE);
		search.setForeground(Color.GRAY);
		search.setBounds(175,300,150, 40);
		JButton back= new JButton("Back");
		back.setFont(new Font("Verdana",Font.ITALIC,18));
		back.setBackground(Color.WHITE);
		back.setForeground(Color.GRAY);
		back.setBounds(25,370,100, 35);
		JButton exit= new JButton("Exit");
		exit.setFont(new Font("Verdana",Font.ITALIC,18));
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.GRAY);
		exit.setBounds(350,370,100, 35);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select.main(args);
				frame.dispose();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainsearch.trainavailability(t1.getText(),t2.getText())) {
				from=t1.getText();
				to=t2.getText();
				String dat=datechooser.getDate().toString();
				String arr[]=dat.split(" ");
				date=arr[2]+arr[1]+arr[5];
				clas=quota.getSelectedItem().toString();
				frame.dispose();
				Select_train.main(args);
				}
				else {
					JOptionPane.showMessageDialog(null,"NO available trains for the entered locations");
				}
			}
		});
		frame.add(l4);
		frame.add(exit);
		frame.add(back);
		frame.add(search);
		frame.add(quota);
		frame.add(l3);
		frame.add(datechooser);
		frame.add(l0);
		frame.add(t1);
		frame.add(t2);
		frame.add(l1);
		frame.add(l2);
		frame.add(temp1);
		frame.add(temp2);
		frame.add(img);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
