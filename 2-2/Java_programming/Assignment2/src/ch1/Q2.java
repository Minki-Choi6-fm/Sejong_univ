package ch1;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class PanelFrame {
    public PanelFrame() {
        JFrame frame = new JFrame("Nested Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(150, 250));
        firstPanel.setBackground(Color.green);
        JLabel label1 = new JLabel("First Panel");
        firstPanel.add(label1);

        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(180, 500));
        secondPanel.setBackground(Color.cyan);
        JLabel label2 = new JLabel("Second Panel");
        secondPanel.add(label2);
        secondPanel.add(firstPanel);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setPreferredSize(new Dimension(500, 500));
        thirdPanel.setBackground(Color.orange);
        ImageIcon icon = new ImageIcon("src/ch1/download.jpg");
        JLabel imageLabel = new JLabel("세종대학교 (Sejong University)",icon,SwingConstants.CENTER);
        imageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        imageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        thirdPanel.add(imageLabel);

        JPanel primaryPanel = new JPanel();
        primaryPanel.setBackground(Color.blue);
        primaryPanel.add(secondPanel);
        primaryPanel.add(thirdPanel);

        frame.getContentPane().add(primaryPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

public class Q2 {
    public static void main(String[] args) {
        new PanelFrame();
    }
}
