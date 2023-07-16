import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Sign_up extends Sign_in{
	static boolean passwordcheck(String s) {
		if(Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", s)) {
			return false;
		}
		return true;
	}
	static boolean duplicate(String s) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","12345678");
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("Select Username from Deccan_users where username='"+s+"'");
			if(rs.next()){
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	static boolean insert(String s1,String s2,String s3,String s4) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","12345678");
			Statement stt=conn.createStatement();
			long a=Long.parseLong(s2);
			String q1="insert into Deccan_users values('"+s1+"',"+a+","+"'"+s3+"')";
			stt.executeUpdate(q1);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}
	public static void main(String[] args) {
		JFrame frame= new JFrame("Deccan_Railways");
		JLabel img=new JLabel(new ImageIcon("C:\\Users\\Mistral\\Downloads\\train.jpg"));
		img.setBounds(0, 0, 500, 500);
		JLabel l1= new JLabel("Your UserName: ");
		JLabel l2= new JLabel("Your PhoneNumber: ");
		JLabel l3= new JLabel("Set new Password: ");
		JLabel l4= new JLabel("Confirm password: ");
		JTextField t1= new JTextField();
		JTextField t2= new JTextField();
		JPasswordField t3= new JPasswordField();
		JPasswordField t4= new JPasswordField();
		JCheckBox cb= new JCheckBox("Show Password");
		JButton b1= new JButton("Submit");
		JButton b2= new JButton("Exit");
		JButton b3= new JButton("Clear");
		l1.setBounds(40, 60, 200, 40);
		l1.setFont(new Font("Verdana",Font.ITALIC,20));
		l1.setForeground(Color.WHITE);
		frame.add(l1);
		l2.setBounds(40, 120, 230, 40);
		l2.setFont(new Font("Verdana",Font.ITALIC,20));
		l2.setForeground(Color.WHITE);
		frame.add(l2);
		l3.setBounds(40, 180, 200, 40);
		l3.setFont(new Font("Verdana",Font.ITALIC,20));
		l3.setForeground(Color.WHITE);
		frame.add(l3);
		l4.setBounds(40, 240, 200, 40);
		l4.setFont(new Font("Verdana",Font.ITALIC,20));
		l4.setForeground(Color.WHITE);
		frame.add(l4);
		t1.setBounds(270, 65, 175, 40);
		frame.add(t1);
		t2.setBounds(270, 125, 175, 40);
		frame.add(t2);
		t3.setBounds(270, 185, 175, 40);
		frame.add(t3);
		t4.setBounds(270, 245, 175, 40);
		frame.add(t4);
		cb.setBounds(269, 225, 150, 20);
		cb.setFont(new Font("Verdana",Font.ITALIC,10));
		cb.setForeground(Color.black);
		cb.setOpaque(false);
		frame.add(cb);
		b1.setBounds(200, 340, 100, 35);
		b1.setFont(new Font("Verdana",Font.ITALIC,18));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.GRAY);
		frame.add(b1);
		b2.setBounds(330, 340, 100, 35);
		b2.setFont(new Font("Verdana",Font.ITALIC,18));
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.GRAY);
		frame.add(b2);
		b3.setBounds(70, 340, 100, 35);
		b3.setFont(new Font("Verdana",Font.ITALIC,18));
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.GRAY);
		frame.add(b3);
		t1.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e){
				boolean flag1=Pattern.matches("\\D*",t1.getText());
				if(!flag1) {
					JOptionPane.showMessageDialog(null,"Name should only contain alphabets");
					t1.setText("");
				} 
			}
			public void keyPressed(KeyEvent e) {	
			}
		});
		t2.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				boolean flag2=Pattern.matches("^[0-9]*$",t2.getText());
				if(!flag2) {
					JOptionPane.showMessageDialog(null,"Phone Number should contain only numbers");
					t2.setText("");
				}
			}
			public void keyPressed(KeyEvent e) {}
		});
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb.isSelected()) {
					t3.setEchoChar((char)0);
					t4.setEchoChar((char)0);
				}
				else {
					t3.setEchoChar('*');
					t4.setEchoChar('*');
				}
			}
		});
		b1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String s1=t1.getText();
				String s2=t2.getText();
				String s3=t3.getText();
				String s4=t4.getText();
				if(s1.isEmpty() || s2.isEmpty() ||s3.isEmpty() ||s4.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Fields can not be empty");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
				else if(Sign_up.duplicate(s1)) {
					JOptionPane.showMessageDialog(null,"UserName Already Exsists");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
				else if(!s3.equals(s4)) {
					JOptionPane.showMessageDialog(null,"Passwords doesn't match");
					t3.setText("");
					t4.setText("");
				}
				else if(t2.getText().length()<10 || t2.getText().length()>10) {
					JOptionPane.showMessageDialog(null,"Phone number should contain 10 numbers");
					t2.setText("");
				}
				else {
					Sign_up.insert(s1,s2,s3,s4);
					JOptionPane.showMessageDialog(null,"Registration Succesfull");
					Sign_in.main(args);
					frame.dispose();
				}
			}	
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				cb.setSelected(false);
			}
		});
		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"UserName can't be Empty");
				}
				else
				t2.requestFocus();
			}
		});
		t2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(t2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Phone number can't be Empty");
				}
				else if(t2.getText().length()!=10) {
					JOptionPane.showMessageDialog(null,"Phone number should contain only 10 numbers");
					t2.setText("");
				}
				else
				t3.requestFocus();
			}
		});
		t3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(t3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Password can't be Empty");
				}
				else if(t3.getText().length()<8 || t3.getText().length()>16) {
					JOptionPane.showMessageDialog(null,"Password should be of 8 to 16 characters");
				}
				else if(Sign_up.passwordcheck(t3.getText())) {
					JOptionPane.showMessageDialog(null,"The password must contain minimum \n 1 Upper case \n 1 lower case \n 1 special character \n 1 number");
				}
				else
				t4.requestFocus();	
			}
		});
		t4.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(t4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Password can't be Empty");
				}
				else if(t4.getText().length()<8 || t4.getText().length()>16) {
					JOptionPane.showMessageDialog(null,"Password should be of 8 to 16 characters");
				}
				else if(Sign_up.passwordcheck(t4.getText())) {
					JOptionPane.showMessageDialog(null,"The password must contain minimum \n 1 Upper case \n 1 lower case \n 1 special character \n 1 number");
				}
			}
		});
		frame.add(img);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}