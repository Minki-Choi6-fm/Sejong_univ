package chap15;

//Chapter 15,p.31

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemListener_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Check Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);

        JRadioButton radioButton = new JRadioButton("Java");
        JRadioButton radioButton2 = new JRadioButton("C#");
        JRadioButton radioButton3 = new JRadioButton("Capston");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton2);
        group.add(radioButton3);

        radioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(frame, "Java is selected");
                }
            }
        });
        radioButton2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(frame, "C# is selected");
                }
            }
        });
        radioButton3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(frame, "Capston is selected");
                }
            }
        });

        panel.add(radioButton);
        panel.add(radioButton2);
        panel.add(radioButton3);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
