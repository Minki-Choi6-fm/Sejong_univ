package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class four {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));

        JTextField tf = new JTextField(20);
        JRadioButton rb = new JRadioButton("Undergraduate - $500");
        JRadioButton rb1 = new JRadioButton("Graduate - $800");
        JCheckBox cb1 = new JCheckBox("Dormitory Request (+$200)");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb);
        bg.add(rb1);

        JButton b1 = new JButton("Register");
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!rb1.isSelected()&&!rb.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "You have not selected Course Type", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int n=0;
                    if(rb1.isSelected()){
                        n+=800;
                    }
                    if(rb.isSelected()){
                        n+=500;
                    }
                    if(cb1.isSelected()){
                        n+=200;
                    }
                    JOptionPane.showMessageDialog(null,"Student name: "+tf.getText()+"\nTotal tuition fee: "+n);
                }
            }
        });
        panel.add(tf);
        panel.add(rb);
        panel.add(rb1);
        panel.add(cb1);
        panel.add(b1);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
