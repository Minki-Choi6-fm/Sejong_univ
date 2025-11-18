package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxwithItemListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 200));
        JLabel label = new JLabel();
        JCheckBox b1 = new JCheckBox("KFC");
        JCheckBox b2 = new JCheckBox("Burger King");
        JCheckBox b3 = new JCheckBox("McDonald's");
        b1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("KFC checkBox:"+(e.getStateChange()==1?"Checked":"Unchecked"));
            }
        });
        b2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("BurgerKing checkBox:"+(e.getStateChange()==1?"Checked":"Unchecked"));
            }
        });
        b3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                label.setText("McDonald's checkBox:"+(e.getStateChange()==1?"Checked":"Unchecked"));
            }
        });
        panel.add(label);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
