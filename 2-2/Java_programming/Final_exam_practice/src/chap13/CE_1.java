package chap13;

//Chapter 13-14,p.63

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CE_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Programming");

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(300, 100));

        JButton button = new JButton("ADD");
        JTextField text = new JTextField("Number 1",5);
        JTextField text2 = new JTextField("Number 2",5);
        JTextField text3 = new JTextField("Sum",5);
        text3.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a=Integer.parseInt(text.getText());
                int b=Integer.parseInt(text2.getText());
                int c=a+b;
                text3.setText(String.valueOf(c));
            }
        });
        panel.add(button);
        panel.add(text);
        panel.add(text2);
        panel.add(text3);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
