package ch1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtNum_1;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(30, 100, 75, 29);
		contentPane.add(btnNewButton);
		
		txtNum = new JTextField();
		txtNum.setText("num 1");
		txtNum.setBounds(117, 100, 75, 26);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtNum_1 = new JTextField();
		txtNum_1.setText("num 2");
		txtNum_1.setBounds(204, 100, 75, 26);
		contentPane.add(txtNum_1);
		txtNum_1.setColumns(10);
		
		txtResult = new JTextField();
		txtResult.setText("Result");
		txtResult.setBounds(291, 100, 130, 26);
		contentPane.add(txtResult);
		txtResult.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(txtNum.getText());
				int b=Integer.parseInt(txtNum_1.getText());
				int c=a+b;
				txtResult.setText("Sum"+c);
			}
		});

	}
}
