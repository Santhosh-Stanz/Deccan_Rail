import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class Sign_in {
	static String user=null;
	boolean check(String s1,String s2){
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","system","12345678");
		Statement st=con.createStatement();	
		ResultSet rs=st.executeQuery("select UserName,Password from Deccan_users where UserName='"+s1+"'");
		String t=null,p=null;
		while(rs.next()) {
			t=rs.getString(1);
			p=rs.getString(2);
			break;
		}
		if(s1.equals(t) && s2.equals(p)) {
			return true;
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public static void main(String[] args) {
	Sign_in ob= new Sign_in();
	JFrame frame= new JFrame("Deccan_Rail");
	JLabel img=new JLabel(new ImageIcon("C:\\Users\\Mistral\\Downloads\\train.jpg"));
	img.setBounds(0, 0, 500, 500);
	JLabel l1= new JLabel("Deccan Railways");
	JLabel l2= new JLabel("Username: ");
	JLabel l3= new JLabel("Password: ");
	JCheckBox cb= new JCheckBox("Doesn't have a account??");
	JCheckBox cb1= new JCheckBox("Show Password");
	JTextField t1= new JTextField();
	JPasswordField t2= new JPasswordField();
	JButton b1= new JButton("Sign in");
	JButton b2= new JButton("Exit");
	l1.setBounds(160, 10, 200, 40);
	l1.setForeground(Color.WHITE);
	l1.setFont(new Font("Verdana",Font.ITALIC,20));
	frame.add(l1);
	l2.setBounds(100, 120, 200, 20);
	l2.setForeground(Color.WHITE);
	l2.setFont(new Font("Verdana",Font.ITALIC,20));
	frame.add(l2);
	l3.setBounds(100, 200, 200, 20);
	l3.setForeground(Color.WHITE);
	l3.setFont(new Font("Verdana",Font.ITALIC,20));
	frame.add(l3);
	t1.setBounds(250, 110, 175, 40);
	frame.add(t1);
	t2.setBounds(250, 190, 175, 40);
	frame.add(t2);
	cb1.setBounds(249, 230,175,40);
	cb1.setForeground(Color.WHITE);
	cb1.setFont(new Font("Verdana",Font.ITALIC,15));
	cb1.setOpaque(false);
	frame.add(cb1);
	cb.setBounds(170, 270, 250, 40);
	cb.setForeground(Color.WHITE);
	cb.setFont(new Font("Verdana",Font.ITALIC,15));
	cb.setOpaque(false);
	frame.add(cb);
	b1.setBounds(100, 350, 100, 35);
	b1.setFont(new Font("Verdana",Font.ITALIC,18));
	b1.setBackground(Color.WHITE);
	b1.setForeground(Color.GRAY);
	frame.add(b1);
	b2.setBounds(300, 350, 100, 35);
	b2.setFont(new Font("Verdana",Font.ITALIC,18));
	b2.setBackground(Color.WHITE);
	b2.setForeground(Color.GRAY);
	frame.add(b2);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String s1=t1.getText();
			@SuppressWarnings("deprecation")
			String s2=t2.getText();
			if(ob.check(s1, s2)) {
				JOptionPane.showMessageDialog(null,"Login Succesfull....");
				user=t1.getText();
				t1.setText(" ");
				t2.setText(" ");
				frame.dispose();
				Select.main(args);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid UserName or Password");
				t1.setText(" ");
				t2.setText(" ");
			}
		}
	});
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	cb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Sign_up.main(args);
		}
	});
	cb1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(cb1.isSelected()) {
				t2.setEchoChar((char)0);
			}
			else {
				t2.setEchoChar('*');
			}
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
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(t2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Password can't be Empty");
			}	
		}
	});
	frame.add(img);
	frame.getContentPane().setBackground(Color.WHITE);
	frame.setSize(500,500);
	frame.setLayout(null);
	frame.setVisible(true);
	}
}