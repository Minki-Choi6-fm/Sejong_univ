package chap15;

//Chapter 15,p.20

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemListener_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Check Box");

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,300));
        JLabel label = new JLabel();
        JCheckBox checkBox = new JCheckBox("KFC");
        JCheckBox checkBox2 = new JCheckBox("Burger King");
        JCheckBox checkBox3 = new JCheckBox("McDonald's");
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("KFC checkBox:Checked");
                }
                else{
                    label.setText("KFC checkBox:Unchecked");
                }
            }
        });
        checkBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("Burger King:Checked");
                }
                else{
                    label.setText("Burger King:Unchecked");
                }
            }
        });
        checkBox3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    label.setText("McDonald's:Checked");
                }
                else{
                    label.setText("McDonald's:Unchecked");
                }
            }
        });
        panel.add(label);
        panel.add(checkBox);
        panel.add(checkBox2);
        panel.add(checkBox3);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
