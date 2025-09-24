package ch1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ClassExercises_Image_Q1_Modify{
	public ClassExercises_Image_Q1_Modify(){
		JFrame frame=new JFrame("Nested Panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1=new JPanel();
		panel1.setPreferredSize(new Dimension(600,600));
		panel1.setBackground(Color.white);
		ImageIcon icon1=new ImageIcon("src/ch1/javaimage.png");
		JLabel label1=new JLabel("First Panel",icon1,SwingConstants.CENTER);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);
		panel1.add(label1);
		
		JPanel panel2=new JPanel();
		panel2.setPreferredSize(new Dimension(600,600));
		panel2.setBackground(Color.white);
		ImageIcon icon2=new ImageIcon("src/ch1/download.png");
		JLabel label2=new JLabel("First Panel",icon2,SwingConstants.CENTER);
		panel2.add(label2);
		
		JPanel primary=new JPanel();
		primary.setBackground(Color.blue);
		primary.add(panel1);
		primary.add(panel2);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}