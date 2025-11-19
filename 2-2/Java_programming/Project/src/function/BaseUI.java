package function;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BaseUI {

    protected JFrame frame;
    protected JPanel main;
    protected JPanel content;

    protected Color bgColor = new Color(25, 25, 25);
    protected Color boxColor = new Color(125, 125, 125);
    protected Color textColor = new Color(200, 200, 200);

    public void window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Course Recommander");

        main = new JPanel();
        main.setBackground(bgColor);
        main.setPreferredSize(new Dimension(800, 600));

        JLabel title = new JLabel("Course Recommander");
        title.setForeground(textColor);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        main.add(title);

        content = new JPanel();
        content.setBackground(boxColor);
        content.setPreferredSize(new Dimension(700, 500));
        Border paddingBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        content.setBorder(new LineBorder(Color.white, 5, true));
        content.setBorder(paddingBorder);

        viewContent();

        main.add(content);
        frame.setContentPane(main);
        frame.setVisible(true);
        frame.pack();
    }

    void viewContent(){
    }

    public void close() {
        frame.dispose();
    }
}