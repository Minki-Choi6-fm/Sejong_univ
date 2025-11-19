package function;

import DB.Repository;
import data.Course;
import data.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UI_Course extends BaseUI {

    private Student student;
    private ArrayList<Course> courses;
    private Repository repo;

    public UI_Course(Student student) {
        this.student = student;
        this.repo = new Repository();
        this.courses = new ArrayList<>();
    }

    protected void viewContent() {
        JPanel inputRow = new JPanel();
        inputRow.setBackground(new Color(225, 225, 225));
        inputRow.setPreferredSize(new Dimension(650, 50));
        inputRow.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        JLabel course_ID = new JLabel("Course ID");
        JTextField ID_input = new JTextField(10);
        JLabel interest_count = new JLabel("Interest Count");
        JTextField count_input = new JTextField(10);
        JButton add_button = new JButton("Add");
        JButton submit_button = new JButton("Get Result");

        inputRow.add(course_ID);
        inputRow.add(ID_input);
        inputRow.add(interest_count);
        inputRow.add(count_input);
        inputRow.add(add_button);
        inputRow.add(submit_button);

        JTextArea list_input = new JTextArea("\n        Course ID\t\tCourse Name\tCourse Type\tYear\tTotal Seats\tInterest\n---------------------------------------------------------------------------------\n");
        list_input.setBackground(new Color(225, 225, 225));
        list_input.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(list_input);
        scrollPane.setPreferredSize(new Dimension(650, 400));

        add_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String course_id = ID_input.getText();
                String count = count_input.getText();

                if(course_id.isEmpty() || count.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please fill the form");
                    return;
                }

                int interest_count = 0;
                try {
                    interest_count = Integer.parseInt(count);
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Interest count must be a number");
                    return;
                }

                Course course = repo.getCourseByCode(course_id);
                if(course == null) {
                    JOptionPane.showMessageDialog(frame, "Course not found in DB");
                    return;
                }

                course.setInterestCount(interest_count);
                courses.add(course);

                String str=course_id+"\t"+course.getCourseName()+"\t"+course.getCourseType()+"\t"+course.getTargetYear()+"\t"+course.getTotalSeats()+"\t"+course.getInterestCount();
                list_input.append("        " + str + "\n");

                ID_input.setText("");
                count_input.setText("");
            }
        });

        submit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (courses.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Add at least one course!");
                    return;
                }

                Calculate calculate = new Calculate(courses);

                close();
                UI_Result result = new UI_Result();
                result.window();
            }
        });

        content.add(inputRow);
        content.add(scrollPane);
    }
    //public static void main(String[] args) {
        //Student student1=new Student("22011955","Choi","IME",2);
        //UI_Course course = new UI_Course(student1);
        //course.window();
    //}
}
