package ch1;
import java.util.*;
import javax.swing.*;

class student{
    String name;
    int Id;

    public student(String name,int Id) {
        this.name=name;
        this.Id=Id;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        String name1=JOptionPane.showInputDialog(null,"Name:","Student:1",JOptionPane.QUESTION_MESSAGE);
        int Id1=Integer.parseInt(JOptionPane.showInputDialog(null,"Id:","Student:1",JOptionPane.QUESTION_MESSAGE));
        student student1=new student(name1,Id1);


        String name2=JOptionPane.showInputDialog(null,"Name:","Student:2",JOptionPane.QUESTION_MESSAGE);
        int Id2=Integer.parseInt(JOptionPane.showInputDialog(null,"Id:","Student:2",JOptionPane.QUESTION_MESSAGE));
        student student2=new student(name2,Id2);

        if(student1.name.equals(student2.name)&&student1.Id==student2.Id) {
            JOptionPane.showMessageDialog(null,"Duplicate entry","*****Output*****",JOptionPane.ERROR_MESSAGE);
        }
        else {
            String output = "Student: 1\n" + "Name:"+student1.name+"\nId:"+student1.Id + "\nStudent: 2\n" + "Name:"+student2.name+"\nId:"+student2.Id;
            JOptionPane.showMessageDialog(null, output, "*****Output*****", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}