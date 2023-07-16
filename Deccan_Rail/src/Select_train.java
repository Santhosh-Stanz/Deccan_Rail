import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class Select_train {
	static String confirm_train;
	static int count=0; 
	static String[] trains= new String[10];
	static String[] trainstime= new String[10];
	static void traincount() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","12345678");
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery("select train_name,depart,arraival from "+Trainsearch.from+" where destination='"+Trainsearch.to+"'");
			while(rs.next()) {
				trains[count]=rs.getString(1);
				trainstime[count]=Trainsearch.from.substring(0,3).toUpperCase()+"-"+rs.getString(2)+"               "+Trainsearch.to.substring(0,3).toUpperCase()+"-"+rs.getString(3);				
				count++;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Select_train.traincount();
		JFrame frame = new JFrame("Deccan_Railways");
		JLabel img=new JLabel(new ImageIcon("C:\\Users\\Mistral\\Downloads\\train.jpg"));
		img.setBounds(0, 0, 500, 500);
		for(int i=0;i<count;i++) {
			JLabel l1= new JLabel(trains[i]);
			l1.setBounds(180, 40+(i*150), 200, 40);
			l1.setForeground(Color.WHITE);
			l1.setFont(new Font("Verdana",Font.ITALIC,18));
			frame.add(l1);
			JLabel l2= new JLabel(trainstime[i]);
			l2.setBounds(120, 70+(i*150), 300, 40);
			l2.setForeground(Color.WHITE);
			l2.setFont(new Font("Verdana",Font.ITALIC,18));
			frame.add(l2);
			JButton b= new JButton("Sleeper");
			JButton b1= new JButton("Chair");
			b1.setBounds(300, 120+(i*150), 120, 40);
			b1.setFont(new Font("Verdana",Font.ITALIC,18));
			b1.setBackground(Color.WHITE);
			b1.setForeground(Color.GRAY);
			frame.add(b1);
			b.setBounds(100, 120+(i*150), 120, 40);
			b.setFont(new Font("Verdana",Font.ITALIC,18));
			b.setBackground(Color.WHITE);
			b.setForeground(Color.GRAY);
			frame.add(b);
			b.setName("b"+String.valueOf(i));
			b1.setName("b"+String.valueOf(i));
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Trainsearch.clas="Sleeper";
					confirm_train=trains[Integer.parseInt(b.getName().substring(1))];
					Booking.main(args);
				}
			});
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Trainsearch.clas="Chair";
					confirm_train=trains[Integer.parseInt(b1.getName().substring(1))];
					Booking.main(args);	
				}
			});
		}
		frame.add(img);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
