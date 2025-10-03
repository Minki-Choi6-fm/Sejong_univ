package ch1;
import javax.swing.*;

public class Q1 {
    public static void main(String[] args) {
        int a = Integer.parseInt(JOptionPane.showInputDialog("First number:"));
        int b = Integer.parseInt(JOptionPane.showInputDialog("Second number:"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Third number:"));

        int max = (a > b && a > c) ? a : (b > c ? b : c);
        int min = (a < b && a < c) ? a : (b < c ? b : c);

        JOptionPane.showMessageDialog(null, "Largest: " + max, "Message", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Smallest: " + min, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}