package chap15_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CWE_calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CWE_calculator frame = new CWE_calculator();
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
	public CWE_calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 6, 438, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setBounds(6, 70, 60, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.setBounds(6, 122, 60, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("7");
		btnNewButton_2.setBounds(6, 174, 60, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("7");
		btnNewButton_3.setBounds(6, 226, 60, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("7");
		btnNewButton_3_1.setBounds(93, 227, 60, 40);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_2_1 = new JButton("7");
		btnNewButton_2_1.setBounds(93, 175, 60, 40);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1 = new JButton("7");
		btnNewButton_1_1.setBounds(93, 123, 60, 40);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_4 = new JButton("8");
		btnNewButton_4.setBounds(93, 71, 60, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3_2 = new JButton("7");
		btnNewButton_3_2.setBounds(189, 227, 60, 40);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnNewButton_2_2 = new JButton("7");
		btnNewButton_2_2.setBounds(189, 175, 60, 40);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_1_2 = new JButton("7");
		btnNewButton_1_2.setBounds(189, 123, 60, 40);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_5 = new JButton("7");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(189, 71, 60, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_3_3 = new JButton("7");
		btnNewButton_3_3.setBounds(279, 227, 60, 40);
		contentPane.add(btnNewButton_3_3);
		
		JButton btnNewButton_2_3 = new JButton("7");
		btnNewButton_2_3.setBounds(279, 175, 60, 40);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_1_3 = new JButton("7");
		btnNewButton_1_3.setBounds(279, 123, 60, 40);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setBounds(279, 71, 60, 40);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("7");
		btnNewButton_6_1.setBounds(384, 71, 60, 195);
		contentPane.add(btnNewButton_6_1);

	}
}
