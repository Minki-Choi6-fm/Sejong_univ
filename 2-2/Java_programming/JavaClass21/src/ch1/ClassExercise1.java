package ch1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassExercise1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassExercise1 frame = new ClassExercise1();
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
	public ClassExercise1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 255, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(24, 20, 84, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterAge = new JLabel("Enter Age");
		lblEnterAge.setBounds(24, 80, 84, 16);
		contentPane.add(lblEnterAge);
		
		textField = new JTextField();
		textField.setBounds(135, 15, 193, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 75, 193, 26);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(135, 145, 84, 29);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(244, 145, 84, 29);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(135, 211, 150, 16);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int age=Integer.parseInt(textField_1.getText());
				if(age>18) {
					lblNewLabel_1.setText("You are eligible");
				}
				else {
					lblNewLabel_1.setText("You are not eligible");
				}
			}
		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
	}
}
