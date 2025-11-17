package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button_Example2 {
    static int x=0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button_Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(400, 300));

        JLabel label = new JLabel("This is Java Programming");
        JButton button = new JButton("Push");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x++;
                JOptionPane.showMessageDialog(null,"Push:"+x);
            }
        });
        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
