package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassWorkExercise2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,200));
        JButton button = new JButton("Order");
        JCheckBox b1 = new JCheckBox("KFC@7500(set)");
        JCheckBox b2 = new JCheckBox("BurgerKing@6500(set)");
        JCheckBox b3 = new JCheckBox("McDonalds@5500(set)");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount=0;
                String ans="";
                if(b1.isSelected()){
                    amount+=7500;
                    ans="KFC:7500\n";
                }
                if(b2.isSelected()){
                    amount+=6500;
                    ans+="BurgerKing:6500\n";
                }
                if(b3.isSelected()){
                    amount+=5500;
                    ans+="McDonalds:5500\n";
                }
                ans+=".................\nTotal: "+amount;
                JOptionPane.showMessageDialog(null, ans);
            }
        });
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
