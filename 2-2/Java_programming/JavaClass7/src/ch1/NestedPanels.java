package ch1;
import javax.swing.*;
import java.awt.*;

public class NestedPanels {
	public static void main(String[] args) {
		JFrame frame=new JFrame("nested panels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon=new ImageIcon("src/ch1/javaimage.png");
		
		JPanel subpanel1=new JPanel();
		subpanel1.setPreferredSize(new Dimension(600,600));
		subpanel1.setBackground(Color.green);
		
		JLabel label1=new JLabel("First Panel",icon,SwingConstants.CENTER);
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setVerticalTextPosition(SwingConstants.BOTTOM);
		subpanel1.add(label1);

		JPanel subpanel2=new JPanel();
		subpanel2.setPreferredSize(new Dimension(600,600));
		subpanel2.setBackground(Color.orange);
		JLabel label2=new JLabel("Second Panel");
		subpanel2.add(label2);
		
		JPanel primary=new JPanel();
		primary.setBackground(Color.blue);
		primary.add(subpanel1);
		primary.add(subpanel2);
		
		frame.getContentPane().add(primary);
		frame.pack();
		frame.setVisible(true);

	}
}
