package main;
import DB.*;
import data.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class UI_init{
    void window(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Course Recommander");                           //기본 창

        JPanel main = new JPanel();
        Color main_color = new Color(25, 25, 25);
        main.setPreferredSize(new Dimension(800, 600));
        main.setBackground(main_color);                                 //기본 배경 패널

        JLabel title = new JLabel("Course Recommander");
        Color title_color = new Color(200, 200, 200);
        title.setForeground(title_color);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        main.add(title);                                                //상단 제목

        JPanel input = new JPanel();                                    //입력 받는 패널
        Color input_color = new Color(125, 125, 125);          //색상 설정해주는 기본 클래스
        input.setBackground(input_color);
        input.setPreferredSize(new Dimension(700, 500));
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20); //CSS로 따지면 padding
        input.setBorder(paddingBorder);
        input.setBorder(new LineBorder(Color.white, 5, true));  //CSS로 따지면 border

        ImageIcon hedgehog= new ImageIcon("src/main/hedgehog.jpg");

        JLabel hedgehog_label = new JLabel(hedgehog, JLabel.CENTER);

        JLabel student_name_label = new JLabel("Student Name     ");
        JPanel student_name_panel = new JPanel();
        student_name_panel.setPreferredSize(new Dimension(650, 27));
        student_name_panel.setBackground(input_color);
        final JTextField student_name = new JTextField(15);                   //입력 창
        student_name_panel.add(student_name_label);
        student_name_panel.add(student_name);

        JLabel student_ID_label = new JLabel("Student ID          ");
        JPanel student_ID_panel = new JPanel();
        student_ID_panel.setPreferredSize(new Dimension(650, 27));
        student_ID_panel.setBackground(input_color);
        final JTextField student_ID = new JTextField(15);                   //입력 창
        student_ID_panel.add(student_ID_label);
        student_ID_panel.add(student_ID);

        JLabel student_major_label = new JLabel("Student major     ");
        JPanel student_major_panel = new JPanel();
        student_major_panel.setPreferredSize(new Dimension(650, 27));
        student_major_panel.setBackground(input_color);
        final JTextField student_major = new JTextField(15);                   //입력 창
        student_major_panel.add(student_major_label);
        student_major_panel.add(student_major);

        JLabel student_grade_label = new JLabel("Student Grade     ");
        JPanel student_grade_panel = new JPanel();
        student_grade_panel.setPreferredSize(new Dimension(650, 27));
        student_grade_panel.setBackground(input_color);
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
                    return;
                }

                Repository database = new Repository();
                Student student=database.getStudentById(ID);

                if(student==null){
                    JOptionPane.showMessageDialog(frame, "Student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String nameFromDB = student.getName();
                    String majorFromDB = student.getMajor();
                    int gradeFromDB = student.getGrade();

                    if (nameFromDB.equals(name) && majorFromDB.equals(major) && gradeFromDB == grade_int) {
                        JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + nameFromDB + ".");
                        frame.dispose();
                        UI_Course course = new UI_Course(student);
                        course.window();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Login Failed: Information does not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        input.add(hedgehog_label);
        input.add(student_ID_panel);
        input.add(student_name_panel);
        input.add(student_major_panel);
        input.add(student_grade_panel);

        input.add(button);
        main.add(input);

        frame.setContentPane(main);
        frame.setVisible(true);
        frame.pack();
    }
}
