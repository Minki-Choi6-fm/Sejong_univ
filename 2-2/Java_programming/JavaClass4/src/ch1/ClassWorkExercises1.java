package ch1;
import javax.swing.*;

public class ClassWorkExercises1 {
    public static void main(String[] args) {
        String product=JOptionPane.showInputDialog("Enter Product");
        int quantity=Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity"));
        int rate=Integer.parseInt(JOptionPane.showInputDialog("Enter Rate"));
        float total=quantity*rate;

        JOptionPane.showMessageDialog(null,"Total Milk price:"+total+" Won","Message",JOptionPane.INFORMATION_MESSAGE);
    }
}
