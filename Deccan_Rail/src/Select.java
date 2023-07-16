import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Select {
	public static void main(String[] args) {
		JFrame frame= new JFrame("Deccan_Railways");
		JLabel img=new JLabel(new ImageIcon("C:\\Users\\Mistral\\Downloads\\train.jpg"));
		img.setBounds(0, 0, 500, 500);
		JButton b1= new JButton("BOOK TICKET");
		JButton b2= new JButton("CANCEL TICKET");
		JButton b3= new JButton("VIEW TICKET");
		JButton b4= new JButton("Exit");
		b1.setBounds(150, 80, 200, 40);
		b2.setBounds(150, 180, 200, 40);
		b3.setBounds(150, 280, 200, 40);
		b4.setBounds(350, 370, 80, 30);
		b1.setFont(new Font("Verdana",Font.ITALIC,18));
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.GRAY);
		b2.setFont(new Font("Verdana",Font.ITALIC,18));
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.GRAY);
		b3.setFont(new Font("Verdana",Font.ITALIC,18));
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.GRAY);
		b4.setFont(new Font("Verdana",Font.ITALIC,16));
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.GRAY);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trainsearch.main(args);
				frame.dispose();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(img);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
