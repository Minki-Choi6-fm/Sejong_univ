package ch1;
import javax.swing.*;
import java.awt.*;

public class NestedPanels {
	public static void main(String[] args) {
		JFrame frame=new JFrame("nested panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel subpanel1=new JPanel();
		subpanel1.setPreferredSize(new Dimension(150,100));
		subpanel1.setBackground(Color.green);
		
		JLabel label1=new JLabel("First Panel");
		subpanel1.add(label1);
		
	}
}
