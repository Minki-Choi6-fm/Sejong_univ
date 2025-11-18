package ch1;

import javax.swing.*;

public class ClassWorkExercise1 {
    public static void main(String[] args) {
        while(true) {
            int x=Integer.parseInt(JOptionPane.showInputDialog("Enter an integer:"));
            if(x%2==0){
                JOptionPane.showMessageDialog(null, "That number is even");
            }
            else{
                JOptionPane.showMessageDialog(null, "That number is odd");
            }
            int tf=JOptionPane.showConfirmDialog(null,"Do Another?");
            if(tf!=0){
                break;
            }
        }
    }
}
