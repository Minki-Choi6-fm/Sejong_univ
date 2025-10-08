package ch1;

import javax.swing.*;
import java.awt.*;

class nested_panel{
    public nested_panel(){
        JFrame frame = new JFrame("Nested Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.blue);

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.green);
        firstPanel.setPreferredSize(new Dimension(150,150));
        JLabel label1 = new JLabel("First Label");
        firstPanel.add(label1);

        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(180,600));
        secondPanel.setBackground(Color.cyan);
        JLabel label2 = new JLabel("Second Label");
        secondPanel.add(label2);
        secondPanel.add(firstPanel);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setBackground(Color.orange);
        thirdPanel.setPreferredSize(new Dimension(600,600));
        ImageIcon img=new ImageIcon("src/ch1/Test.png");
        JLabel label3 = new JLabel("세종대학교(Sejong University)",img,JLabel.CENTER);
        label3.setVerticalAlignment(SwingConstants.BOTTOM);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPanel.add(label3);

        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

}

public class P2 {
    public static void main(String[] args) {
        new nested_panel();
    }
}
