package ch1;
import javax.swing.*;                               //JOptionPane 쓸라면 꼭 불러와야 하는 라이브러리

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "This is GUI Dialogue Box");        //화면에 GUI로 메세지 창을 띄워줌
        JOptionPane.showMessageDialog(null, "Try again","Error",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Testing","Plain message",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Warning","Warning",JOptionPane.WARNING_MESSAGE);

        JOptionPane.showConfirmDialog(null,"Check");                //화면에 GUI로 선택지 yes,no,cancel을 줌

        String str = JOptionPane.showInputDialog("Enter Item name");                    //화면에 GUI로 입력칸을 주고 String으로 입력받음
        int num=Integer.parseInt(JOptionPane.showInputDialog("Enter Number"));          //화면에 GUI로 입력칸을 주고 Int로 입력받음(Integer.parseInt는 str->int해주는 함수)

        System.out.println(str);
        System.out.println(num);
    }
}