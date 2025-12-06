package chap11_2;

//chapter 11_2,p.40

import javax.swing.*;

class Student {
    String name;
    int age;
    double GPA;

    Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }
}

public class CA_1 {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        int oldest = 0;
        double highest = 0.0;

        for (int i = 0; i < students.length; i++) {
            try {
                String name = JOptionPane.showInputDialog("Enter student name: ");
                if (name == null) throw new NullPointerException();

                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter student age: "));
                double GPA = Double.parseDouble(JOptionPane.showInputDialog("Enter student GPA: "));

                if (GPA < 0 || GPA > 4.5) {
                    throw new Exception("Invalid GPA");
                }

                students[i] = new Student(name, age, GPA);

                oldest = (students[i].age > oldest) ? students[i].age : oldest;
                highest = (students[i].GPA > highest) ? students[i].GPA : highest;
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Please enter something!");
                i--;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Put a number format");
                i--;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                i--;
            }
        }
        JOptionPane.showMessageDialog(null, "Oldest: " + oldest + "\nHighest: " + highest);
    }
}