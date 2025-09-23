package ch1;
import javax.swing.*;
import java.awt.*;

class panels_frames{
	public void generate() {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel sub1=new JPanel();
		sub1.setPreferredSize(new Dimension(200, 300));
		sub1.setBackground(Color.green);
		
		JLabel label1=new JLabel("First Panel");
		sub1.add(label1);
		
		JPanel sub2=new JPanel();
		sub2.setPreferredSize(new Dimension(200, 300));
		sub2.setBackground(Color.orange);
		
		JLabel label2=new JLabel("Second Panel");
		sub2.add(label2);
		
		JPanel sub3=new JPanel();
		sub3.setPreferredSize(new Dimension(200, 300));
		sub3.setBackground(Color.gray);
		
		JLabel label3=new JLabel("Third Panel");
		sub3.add(label3);
		
		JPanel primary=new JPanel();
		primary.setBackground(Color.blue);
		primary.add(sub1);
		primary.add(sub2);
		primary.add(sub3);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);
	}
}

public class ClassExercises_Frame {
	public static void main(String[] args) {
		panels_frames p_f=new panels_frames(); 
		p_f.generate();
	}
}
