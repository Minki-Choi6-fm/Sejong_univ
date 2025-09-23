package ch1;
import javax.swing.*;
import java.awt.*;


public class FramePanel {
	public static void main(String[] args) {
		JFrame frame=new JFrame("JAVA PROGRAMMING");
		//프로그램의 전체 창(Window)을 생성합니다
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//창의 오른쪽 위에 있는 닫기(X) 버튼을 눌렀을 때 프로그램을 완전히 종료하도록 설정합니다. 이 설정이 없으면 창은 닫혀도 프로그램은 계속 실행 상태로 남아있게 됩니다.
		
		JPanel primary=new JPanel();
		//창 안에 다른 부품들을 올려놓을 깨끗한 도화지(패널)를 하나 생성합니다.
		primary.setBackground(Color.orange);
		//방금 만든 primary 도화지의 배경색을 주황색으로 칠합니다.
		primary.setPreferredSize(new Dimension(300,100));
		//primary 도화지의 선호하는 크기를 가로 300픽셀, 세로 100픽셀로 지정합니다.
		
		JLabel label1=new JLabel("This is JAVA Programming,");
		JLabel label2=new JLabel("with frame,panel and labels");
		//화면에 글자를 표시할 라벨 부품 두 개를 생성합니다.
		
		primary.add(label1);
		primary.add(label2);
		//앞에서 만든 두 개의 라벨(label1, label2)을 주황색 도화지(primary) 위에 차례대로 올려놓습니다
		frame.getContentPane().add(primary);
		// 라벨들이 올라가 있는 주황색 도화지(primary)를 맨 처음 만들었던 전체 창(frame)에 부착합니다. 
		frame.pack();
		//창(frame)의 크기를 내부의 내용물(주황색 도화지)에 딱 맞게 자동으로 조절해주는 매우 편리한 기능입니다.
		
		frame.setVisible(true);
		//지금까지 메모리에서만 조립했던 창을 사용자에게 보이도록 화면에 실제로 나타나게 합니다. 이 명령어가 없으면 프로그램은 실행되어도 아무것도 보이지 않습니다
	}

}
