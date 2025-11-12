package main;

import data.Student;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class UI_Course {
    private Student student;
    UI_Course(Student student) {
        this.student = student;
    }
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

        JPanel content = new JPanel();
        Color content_color = new Color(225, 225, 225);
        content.setBackground(content_color);
        content.setPreferredSize(new Dimension(650, 50));
        Border paddingBorder2 = BorderFactory.createEmptyBorder(5, 0, 5, 0);
        content.setBorder(paddingBorder2);
        JLabel course_ID = new JLabel("Course ID");
        JTextField ID_input = new JTextField(15);
        JLabel interest_count = new JLabel("Interest Count");
        JTextField count_input = new JTextField(15);
        JButton add_button = new JButton("Add");
        content.add(course_ID);
        content.add(ID_input);
        content.add(interest_count);
        content.add(count_input);
        content.add(add_button);

        JPanel list = new JPanel();
        list.setBackground(content_color);
        list.setPreferredSize(new Dimension(650, 350));

        input.add(content);
        input.add(list);
        main.add(input);

        frame.setContentPane(main);
        frame.setVisible(true);
        frame.pack();
    }
    public static void main(String[] args) {
        Student testStudent = new Student("22011955", "Choi", "IME", 2);

        UI_Course ui = new UI_Course(testStudent);

        ui.window();
    }
}
