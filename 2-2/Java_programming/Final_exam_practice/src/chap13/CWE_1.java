package chap13;

//Chapter 13-14,p.64

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CWE_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.setPreferredSize(new Dimension(300, 100));
        JLabel label = new JLabel("Enter Fahrenheit temperature:");
        JTextField field = new JTextField(5);
        JLabel label1 = new JLabel("Temperature in Celsius:");
        field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(field.getText());
                double celsius = (temp-32)/1.8;
                label1.setText(String.format(label1.getText()+"%.2f", celsius));
            }
        });
        panel.add(label);
        panel.add(field);
        panel.add(label1);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
