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
        for(int i=0;i<4;i++){
            oldest=0;
            highest=0;
            try{
                obj[i].name=JOptionPane.showInputDialog("Enter your name");
                if (obj[i].name == null || obj[i].name.trim().isEmpty() || obj[i].name.matches("\\d+")) {
                    throw new Exception("Wrong name format");
                }
                obj[i].age=Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
                if(obj[i].age<=0)throw new Exception("Wrong age");
                obj[i].GPA=Double.parseDouble(JOptionPane.showInputDialog("Enter your GPA"));
                if(obj[i].GPA<=0||obj[i].GPA>4.5)throw new Exception("Wrong GPA");

                oldest=(oldest>obj[i].age)?oldest:obj[i].age;
                highest=(highest>obj[i].GPA)?highest:obj[i].GPA;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() + ". Please try again.");
                i--;
            }
        }

        JOptionPane.showMessageDialog(null, oldest,"Oldest student",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, highest,"Highest GPA student",JOptionPane.INFORMATION_MESSAGE);

    }
}
