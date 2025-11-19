package function;
import DB.*;
import data.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class UI_Init extends BaseUI{
    public void viewContent(){
        ImageIcon hedgehog= new ImageIcon("src/function/hedgehog.jpg");

        JLabel hedgehog_label = new JLabel(hedgehog, JLabel.CENTER);

        JLabel student_name_label = new JLabel("Student Name     ");
        JPanel student_name_panel = new JPanel();
        student_name_panel.setPreferredSize(new Dimension(650, 27));
        student_name_panel.setBackground(boxColor);
        final JTextField student_name = new JTextField(15);                   //입력 창
        student_name_panel.add(student_name_label);
        student_name_panel.add(student_name);

        JLabel student_ID_label = new JLabel("Student ID          ");
        JPanel student_ID_panel = new JPanel();
        student_ID_panel.setPreferredSize(new Dimension(650, 27));
        student_ID_panel.setBackground(boxColor);
        final JTextField student_ID = new JTextField(15);                   //입력 창
        student_ID_panel.add(student_ID_label);
        student_ID_panel.add(student_ID);

        JLabel student_major_label = new JLabel("Student major     ");
        JPanel student_major_panel = new JPanel();
        student_major_panel.setPreferredSize(new Dimension(650, 27));
        student_major_panel.setBackground(boxColor);
        final JTextField student_major = new JTextField(15);                   //입력 창
        student_major_panel.add(student_major_label);
        student_major_panel.add(student_major);

        JLabel student_grade_label = new JLabel("Student Grade     ");
        JPanel student_grade_panel = new JPanel();
        student_grade_panel.setPreferredSize(new Dimension(650, 27));
        student_grade_panel.setBackground(boxColor);
        final JTextField student_grade = new JTextField(15);
        student_grade_panel.add(student_grade_label);
        student_grade_panel.add(student_grade);

        JButton button = new JButton("LOGIN");                 //버튼

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = student_name.getText();
                String ID = student_ID.getText();
                String major = student_major.getText();
                String grade = student_grade.getText();
                int grade_int;

                if (ID.isEmpty() || name.isEmpty() || major.isEmpty() || grade.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    grade_int = Integer.parseInt(grade);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a grade as a number.", "Error", JOptionPane.ERROR_MESSAGE);
                    student_grade.setText("");
                    return;
                }

                Repository database = new Repository();
                Student student=database.getStudentById(ID);

                if(student==null){
                    JOptionPane.showMessageDialog(frame, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    student_grade.setText("");
                    student_ID.setText("");
                    student_major.setText("");
                    student_name.setText("");
                    return;
                }
                else{
                    String nameFromDB = student.getName();
                    String majorFromDB = student.getMajor();
                    int gradeFromDB = student.getGrade();

                    if (nameFromDB.equals(name) && majorFromDB.equals(major) && gradeFromDB == grade_int) {
                        JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + nameFromDB + ".");
                        close();
                        UI_Course course = new UI_Course(student);
                        course.window();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Login Failed: Information does not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        content.add(hedgehog_label);
        content.add(student_ID_panel);
        content.add(student_name_panel);
        content.add(student_major_panel);
        content.add(student_grade_panel);
        content.add(button);
    }
}
