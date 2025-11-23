package ch1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ClassExercise_Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	private double a = 0;
	private String operator = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassExercise_Calculator frame = new ClassExercise_Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClassExercise_Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton seven = new JButton("7");
		seven.setBounds(6, 83, 69, 47);
		contentPane.add(seven);
		
		JButton eight = new JButton("8");
		eight.setBounds(98, 83, 69, 47);
		contentPane.add(eight);
		
		JButton nine = new JButton("9");
		nine.setBounds(189, 83, 69, 47);
		contentPane.add(nine);
		
		JButton six = new JButton("6");
		six.setBounds(189, 142, 69, 47);
		contentPane.add(six);
		
		JButton five = new JButton("5");
		five.setBounds(98, 142, 69, 47);
		contentPane.add(five);
		
		JButton four = new JButton("4");
		four.setBounds(6, 142, 69, 47);
		contentPane.add(four);
		
		JButton three = new JButton("3");
		three.setBounds(189, 201, 69, 47);
		contentPane.add(three);
		
		JButton two = new JButton("2");
		two.setBounds(98, 201, 69, 47);
		contentPane.add(two);
		
		JButton one = new JButton("1");
		one.setBounds(6, 201, 69, 47);
		contentPane.add(one);
		
		JButton zero = new JButton("0");
		zero.setBounds(6, 260, 69, 47);
		contentPane.add(zero);
		
		JButton dot = new JButton(".");
		dot.setBounds(98, 260, 69, 47);
		contentPane.add(dot);
		
		JButton reset = new JButton("C");
		reset.setBounds(189, 260, 69, 47);
		contentPane.add(reset);
		
		JButton add = new JButton("+");
		add.setBounds(278, 260, 69, 47);
		contentPane.add(add);
		
		JButton subtract = new JButton("-");
		subtract.setBounds(278, 201, 69, 47);
		contentPane.add(subtract);
		
		JButton multiply = new JButton("*");
		multiply.setBounds(278, 142, 69, 47);
		contentPane.add(multiply);
		
		JButton divide = new JButton("/");
		divide.setBounds(278, 83, 69, 47);
		contentPane.add(divide);
		
		JButton equal = new JButton("=");
		equal.setBounds(375, 83, 69, 224);
		contentPane.add(equal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(6, 6, 438, 65);
		contentPane.add(textField);
		textField.setColumns(10);
		
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"0");
			}
		});
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"1");
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"2");
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"3");
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"4");
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"5");
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"6");
			}
		});
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"7");
			}
		});
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"8");
			}
		});
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"9");
			}
		});
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().contains(".")) {
					textField.setText(textField.getText()+".");
				}
			}
		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				a = 0;
				operator = "";
			}
		});

		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if(!operator.isEmpty()) {
						double val = Double.parseDouble(textField.getText());
						if(operator.equals("+")) a += val;
						else if(operator.equals("-")) a -= val;
						else if(operator.equals("*")) a *= val;
						else if(operator.equals("/")) a /= val;
					} else {
						a = Double.parseDouble(textField.getText());
					}
					operator = "/";
					textField.setText("");
				}
			}
		});
		
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if(!operator.isEmpty()) {
						double val = Double.parseDouble(textField.getText());
						if(operator.equals("+")) a += val;
						else if(operator.equals("-")) a -= val;
						else if(operator.equals("*")) a *= val;
						else if(operator.equals("/")) a /= val;
					} else {
						a = Double.parseDouble(textField.getText());
					}
					operator = "*";
					textField.setText("");
				}
			}
		});
		
		subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if(!operator.isEmpty()) {
						double val = Double.parseDouble(textField.getText());
						if(operator.equals("+")) a += val;
						else if(operator.equals("-")) a -= val;
						else if(operator.equals("*")) a *= val;
						else if(operator.equals("/")) a /= val;
					} else {
						a = Double.parseDouble(textField.getText());
					}
					operator = "-";
					textField.setText("");
				}
			}
		});
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if(!operator.isEmpty()) {
						double val = Double.parseDouble(textField.getText());
						if(operator.equals("+")) a += val;
						else if(operator.equals("-")) a -= val;
						else if(operator.equals("*")) a *= val;
						else if(operator.equals("/")) a /= val;
					} else {
						a = Double.parseDouble(textField.getText());
					}
					operator = "+";
					textField.setText("");
				}
			}
		});
		
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && !operator.isEmpty()) {
					double b = Double.parseDouble(textField.getText());
					double result = 0;
					
					switch (operator) {
						case "+": result = a + b; break;
						case "-": result = a - b; break;
						case "*": result = a * b; break;
						case "/": 
							if(b != 0) result = a / b; 
							else result = 0;
							break;
					}
					
					textField.setText(String.valueOf(result));
					a = result;
					operator = "";
				}
			}
		});
	}
}