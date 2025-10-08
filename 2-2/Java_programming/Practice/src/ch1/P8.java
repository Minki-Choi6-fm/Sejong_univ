package ch1;

import javax.swing.*;
import java.awt.*;

// GUI 구성을 담당하는 클래스 (public이 아님)
class PanelCreator {
    public PanelCreator() {
        JFrame frame = new JFrame("Nested Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 모든 것을 담을 메인 패널. JPanel은 기본적으로 FlowLayout을 사용합니다.
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLUE);

        // --- 기존 코드와 동일한 패널 생성 ---
        JPanel subPanel1 = new JPanel();
        subPanel1.setBackground(Color.GREEN);
        subPanel1.setPreferredSize(new Dimension(300, 150)); // 크기 약간 조절
        subPanel1.add(new JLabel("First Panel"));

        JPanel subPanel2 = new JPanel();
        subPanel2.setBackground(Color.ORANGE);
        subPanel2.setPreferredSize(new Dimension(300, 150)); // 크기 약간 조절
        subPanel2.add(new JLabel("Second Panel"));

        JPanel subPanel3 = new JPanel();
        subPanel3.setBackground(Color.ORANGE);
        subPanel3.setPreferredSize(new Dimension(600, 600));
        ImageIcon img = new ImageIcon("src/ch1/img-ui-logo.png");
        JLabel imageLabel = new JLabel("세종대학교(Sejong University)",img,JLabel.CENTER); // 이미지만 담는 JLabel
        imageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        imageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        subPanel3.add(imageLabel);

        // --- 수정된 부분 ---
        // 1. 상단 패널 두 개를 묶어줄 topContainer 패널 (사용자님의 좋은 아이디어)
        JPanel topContainer = new JPanel();
        topContainer.setBackground(Color.BLUE); // 배경색 통일
        topContainer.add(subPanel1);
        topContainer.add(subPanel2);

        // 2. mainPanel에 topContainer와 imageLabel을 그냥 추가합니다.
        // FlowLayout이 알아서 배치합니다. (창이 넓으면 옆으로, 좁으면 아래로)
        mainPanel.add(topContainer);
        mainPanel.add(subPanel3);

        frame.getContentPane().add(mainPanel);
        frame.pack(); // 컴포넌트 크기에 맞춰 창 크기 조절
        frame.setVisible(true);
    }
}

// 프로그램을 실행하는 public 클래스
public class P8{
    public static void main(String[] args) {
        new PanelCreator();
    }
}