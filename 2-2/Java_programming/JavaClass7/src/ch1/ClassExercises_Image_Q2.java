package ch1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;

class Modify{
	public Modify(){
		JFrame frame=new JFrame("Nested Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1=new JPanel();
		panel1.setPreferredSize(new Dimension(300,200));
		panel1.setBackground(Color.green);
		JLabel label1=new JLabel("First Panel");
		panel1.add(label1);
		
		JPanel panel2=new JPanel();
		panel2.setPreferredSize(new Dimension(300,200));
		panel2.setBackground(Color.orange);
		JLabel label2=new JLabel("Second Panel");
		panel2.add(label2);
		
		JPanel panel3=new JPanel();
		panel3.setPreferredSize(new Dimension(600,600));
		panel3.setBackground(Color.orange);
		ImageIcon icon=new ImageIcon("src/ch1/download.png");
		JLabel label3=new JLabel("세종대학교",icon,SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel3.add(label3);
		
		JPanel panel4=new JPanel();
		panel4.setBackground(Color.blue);
		panel4.add(panel1);
		panel4.add(panel2);
		
		JPanel panel5=new JPanel();
		panel5.setBackground(Color.blue);
		panel5.add(panel3);
		
		JPanel primary=new JPanel();
		primary.setBackground(Color.blue);
		primary.setLayout(new BorderLayout());
		primary.add(panel4,BorderLayout.NORTH);
		primary.add(panel5,BorderLayout.CENTER);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}

public class ClassExercises_Image_Q2 {
	public static void main(String[] args) {
		new Modify();
	}
}
