package ch1;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class PanelFrame {
    public PanelFrame() {
        // 1. 프레임 생성
        JFrame frame = new JFrame("Nested Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. 패널 및 레이블 생성
        // 첫 번째 패널
        JPanel firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(400, 600));
        firstPanel.setBackground(Color.green);
        JLabel label1 = new JLabel("First Panel");
        firstPanel.add(label1);

        // 두 번째 패널 (첫 번째 패널을 포함)
        JPanel secondPanel = new JPanel();
        secondPanel.setPreferredSize(new Dimension(500, 800));
        secondPanel.setBackground(Color.cyan);
        JButton button1 = new JButton("Click here");
        JLabel label2 = new JLabel("If you want to proceed");
        secondPanel.add(label2);
        secondPanel.add(button1);

        secondPanel.add(firstPanel);

        // 세 번째 패널 (이미지 포함)
        JPanel thirdPanel = new JPanel();
        thirdPanel.setPreferredSize(new Dimension(800, 800));
        thirdPanel.setBackground(Color.orange);
        // ImageIcon을 사용하여 이미지를 불러옵니다.
        ImageIcon icon = new ImageIcon("src/ch1/download.png");
        JLabel imageLabel = new JLabel("(Sejong University)",icon,SwingConstants.CENTER);
        imageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        imageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        thirdPanel.add(imageLabel);

        // 3. 메인 패널에 모든 컴포넌트 추가
        // 메인 패널은 다른 패널들을 담는 컨테이너 역할
        JPanel primaryPanel = new JPanel();
        primaryPanel.setBackground(Color.blue);
        primaryPanel.add(secondPanel); // 두 번째 패널(첫 번째 패널 포함)을 메인에 추가
        primaryPanel.add(thirdPanel); // 세 번째 패널을 메인에 추가

        // 4. 프레임에 메인 패널을 추가하고 화면에 표시
        frame.getContentPane().add(primaryPanel);
        frame.pack(); // 컴포넌트 크기에 맞게 프레임 크기 조절
        frame.setVisible(true); // 프레임을 화면에 보이게 함
    }
}
public class ClassAssignment_1 {
    public static void main(String[] args) {
        new PanelFrame();
    }
}
