package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegistrWindow {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordRepeatField;
	private JButton registrButton;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrWindow window = new RegistrWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Введите имя");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(58, 15, 152, 17);
		frame.getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameField.setBounds(58, 43, 180, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel label = new JLabel("Введите пароль");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(58, 74, 180, 20);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Повторите пароль");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(58, 136, 180, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		registrButton = new JButton("Зарегистрироваться");
		registrButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registrButton.setBounds(58, 210, 180, 66);
		frame.getContentPane().add(registrButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(280, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(280, 169, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(58, 105, 180, 20);
		frame.getContentPane().add(passwordField);
		
		passwordRepeatField = new JPasswordField();
		passwordRepeatField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordRepeatField.setBounds(58, 166, 180, 20);
		frame.getContentPane().add(passwordRepeatField);
	}
	public JTextField getNameField() {
		return nameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JPasswordField getPasswordRepeatField() {
		return passwordRepeatField;
	}
	public JButton getBtnNewButton() {
		return registrButton;
	}
}
