package chap13;

//Chapter 13-14,p.55,p.61

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Practice_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java Programming");

        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        panel.setPreferredSize(new Dimension(600, 150));

        JButton button = new JButton("Submit");
        JTextField text = new JTextField("Enter your name",10);
        JTextField text2 = new JTextField("Enter your city",10);
        JTextField text3 = new JTextField("Enter your age",10);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = text.getText();
                    if(name.equals("")) throw new Exception("Name is empty");
                    String city = text2.getText();
                    if(city.equals("")) throw new Exception("city is empty");
                    String age = text3.getText();
                    if(age.equals(""))throw new Exception("age is empty");
                    int ageInt = Integer.parseInt(age);
                    String info="information\n"+name+"\n"+city+"\n"+age;
                    JOptionPane.showMessageDialog(frame, info,"Message",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Enter a number in age");
                }
                catch(Exception ek){
                    JOptionPane.showMessageDialog(null,ek);
                }
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
