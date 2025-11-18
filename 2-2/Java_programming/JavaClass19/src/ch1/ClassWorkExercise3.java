package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassWorkExercise3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,100));
        panel.setBackground(Color.ORANGE);
        JRadioButton r1 = new JRadioButton("Java");
        JRadioButton r2 = new JRadioButton("C#");
        JRadioButton r3 = new JRadioButton("Capston");
        JButton b = new JButton("Click");
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "You selected Java");
                }
                if (r2.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "You selected C#");
                }
                if (r3.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "You selected Capston");
                }
            }
        });

        panel.add(b);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
