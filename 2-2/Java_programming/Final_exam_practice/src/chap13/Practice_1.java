package chap13;

//Chapter 13-14,p.42

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Programming");

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(400, 200));
        JLabel label = new JLabel("This is a Java Programming");
        JButton button = new JButton("Upload");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=JOptionPane.showConfirmDialog(null,"Do you want to continue","Select an Option",JOptionPane.YES_NO_OPTION);
                if(a==JOptionPane.YES_OPTION){

                }
            }
        });
        panel.add(label);
        panel.add(button);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
