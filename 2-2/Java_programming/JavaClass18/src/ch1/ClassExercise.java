package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClassExercise {
    static int x;
    static int y;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        panel.setBackground(Color.green);

        JButton button = new JButton("ADD");
        JTextField text = new JTextField("Number 1",10);
        JTextField text2 = new JTextField("Number 2",10);
        JTextField text3 = new JTextField("Sum",5);
        text3.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x = Integer.parseInt(text.getText());
                y = Integer.parseInt(text2.getText());
                text3.setText(String.valueOf(x+y));
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
