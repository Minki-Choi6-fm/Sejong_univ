package ch1;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Q3 {
    public static void main(String[] args){
        String[] name=new String[4];
        int[] age=new int[4];
        double[] GPA=new double[4];
        int i=0;
        int youngest=150;
        double lowest=4.5;

        while(i<4){
            name[i]=JOptionPane.showInputDialog("Name");
            age[i]=Integer.parseInt(JOptionPane.showInputDialog("Enter age"));
            GPA[i]=Double.parseDouble(JOptionPane.showInputDialog("Enter GPA"));
            youngest=(youngest<age[i]?youngest:age[i]);
            lowest=(lowest<GPA[i]?lowest:GPA[i]);
            i++;
        }
        JOptionPane.showMessageDialog(null,"Youngest Student Age:"+youngest+"\nStudent Lowest GPA:"+lowest);
    }
}
