package ch1;

import javax.swing.*;

class Student_GUI{
    String name;
    int age;
    double GPA;
}

public class ClassAssignment1 {
    public static void main(String[] args) {
        Student_GUI[] obj=new Student_GUI[4];
        int oldest=0;
        double highest=0.0;
        void input(){
            for(int i=0;i<4;i++){
                try{
                    name=JOptionPane.showInputDialog("Enter your name");
                    if (name == null || name.trim().isEmpty() || name.matches("\\d+")) {
                        throw new Exception("Wrong name format");
                    }
                    age=Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
                    if(age<=0)throw new Exception("Wrong age");
                    GPA=Double.parseDouble(JOptionPane.showInputDialog("Enter your GPA"));
                    if(GPA<=0||GPA>4.5)throw new Exception("Wrong GPA");

                    oldest=(oldest>age)?oldest:age;
                    highest=(highest>GPA)?highest:GPA;
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + ". Please try again.");
                    i--;
                }
            }
        }
        void display(){
            JOptionPane.showMessageDialog(null, oldest,"Oldest student",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, highest,"Highest GPA student",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
