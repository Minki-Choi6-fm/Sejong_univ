package ch1;
import javax.swing.*;

class calculate{
    int i=Integer.parseInt(JOptionPane.showInputDialog("First number:"));
    int j=Integer.parseInt(JOptionPane.showInputDialog("Second number:"));
    int k=Integer.parseInt(JOptionPane.showInputDialog("Third number:"));
    int MAX=(i>j?(i>k?i:k):(j>k?j:k));

    double a=Double.parseDouble(JOptionPane.showInputDialog("First number:"));
    double b=Double.parseDouble(JOptionPane.showInputDialog("Second number:"));
    double c=Double.parseDouble(JOptionPane.showInputDialog("Third number:"));
    double d=Double.parseDouble(JOptionPane.showInputDialog("Fourth number:"));
    double max=(a>b?(a>c?(a>d?a:d):(c>d?c:d)):(b>c?(b>d?b:d):(c>d?c:d)));
    double min=(a<b?(a<c?(a<d?a:d):(c<d?c:d)):(b<c?(b<d?b:d):(c<d?c:d)));
}

public class ClassWorkExercises4 {
    public static void main(String[] args) {
        JOptionPane.showConfirmDialog(null,"Choose an option");
    }
}
