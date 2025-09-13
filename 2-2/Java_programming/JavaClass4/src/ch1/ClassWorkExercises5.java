package ch1;
import javax.swing.*;

public class ClassWorkExercises5 {
    public static void main(String[] args) {
        String name=JOptionPane.showInputDialog("Enter your name: ");
        int age=Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
        String hobby=JOptionPane.showInputDialog("Enter your hobby: ");
        String category;

        if(age<13){
            category="a Child";
        }else if(age<20){
            category="a Teenager";
        }else if(age<60){
            category="an Adult";
        }else{
            category="a Senior";
        }

        System.out.println("Hello Sejong University");
        System.out.println("You are "+age+" years old, which makes you "+category+".");
        System.out.println("Your favorite hobby is "+hobby+".");
    }
}
