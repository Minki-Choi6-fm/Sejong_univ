package function;

import data.Course;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI_Result extends BaseUI {
    private ArrayList<Course> majorList;
    private ArrayList<Course> otherList;

    public UI_Result(ArrayList<Course> majorList, ArrayList<Course> otherList) {
        this.majorList = majorList;
        this.otherList = otherList;
    }

    protected void viewContent() {
        content.setLayout(new BorderLayout(10, 10));
        JLabel majorLabel = new JLabel("Result",JLabel.CENTER);
        majorLabel.setFont(new Font("Arial", Font.BOLD, 50));

        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(1, 2, 10, 10));
        downPanel.setBackground(textColor);
        downPanel.setPreferredSize(new Dimension(650, 500));

        JTextArea majorArea = new JTextArea();
        majorArea.setEditable(false);
        majorArea.setFont(new Font("Arial", Font.BOLD, 14));
        majorArea.setText("=== [Primary] Priority Order ===\n(Same Major & Grade)\n\n");

        fillTextArea(majorArea, majorList);

        JTextArea otherArea = new JTextArea();
        otherArea.setEditable(false);
        otherArea.setFont(new Font("Arial", Font.BOLD, 14));
        otherArea.setText("=== [Exception] Other Order ===\n(Diff Major or Grade)\n\n");

        fillTextArea(otherArea, otherList);

        downPanel.add(new JScrollPane(majorArea));
        downPanel.add(new JScrollPane(otherArea));

        content.add(majorLabel, BorderLayout.NORTH);
        content.add(downPanel, BorderLayout.CENTER);
    }

    private void fillTextArea(JTextArea area, ArrayList<Course> list) {
        if (list.isEmpty()) {
            area.append("(No courses in this category)\n");
            return;
        }
        int rank = 1;
        for (Course c : list) {
            String line = String.format("%d. [%s] %s\n   Type: %s | Score: %.1f | Interest: %d\n\n", rank++, c.getCourseCode(), c.getCourseName(), c.getCourseType(), c.getScore(), c.getInterestCount());
            area.append(line);
        }
    }
    public static void main(String[] args) {
        ArrayList<Course> testMajorList = new ArrayList<>();
        ArrayList<Course> testOtherList = new ArrayList<>();

        Course c1 = new Course("CS001", "자바프로그래밍", "컴퓨터공학", 2, 40, 80, "전필");
        c1.setScore(12.5); // 점수도 임의로 설정
        testMajorList.add(c1);

        Course c2 = new Course("CS002", "알고리즘", "컴퓨터공학", 2, 35, 70, "전선");
        c2.setScore(8.4);
        testMajorList.add(c2);

        Course c3 = new Course("GE001", "글쓰기", "교양학부", 1, 100, 20, "교필");
        c3.setScore(1.2);
        testOtherList.add(c3);

        UI_Result testUI = new UI_Result(testMajorList, testOtherList);
        testUI.window();
    }
}