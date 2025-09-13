package ch1;
import javax.swing.*;

public class ClassWorkExercises3 {
    public static void main(String[] args) {
        double a=Double.parseDouble(JOptionPane.showInputDialog("First number:"));
        double b=Double.parseDouble(JOptionPane.showInputDialog("Second number:"));
        double c=Double.parseDouble(JOptionPane.showInputDialog("Third number:"));
        double d=Double.parseDouble(JOptionPane.showInputDialog("Fourth number:"));
        double max=(a>b?(a>c?(a>d?a:d):(c>d?c:d)):(b>c?(b>d?b:d):(c>d?c:d)));
        double min=(a<b?(a<c?(a<d?a:d):(c<d?c:d)):(b<c?(b<d?b:d):(c<d?c:d)));


        JOptionPane.showMessageDialog(null,"Largest:"+max,"Message",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Smallest:"+min,"Message",JOptionPane.INFORMATION_MESSAGE);
    }
}