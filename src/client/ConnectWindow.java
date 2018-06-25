package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ConnectWindow {

	private JFrame frame;
	private JTextField IPField;
	private JTextField portField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectWindow window = new ConnectWindow();
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
	public ConnectWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 265, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Введите IP сервера");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 22, 163, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Введите порт сервера");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(33, 80, 176, 24);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Сохранить настройки");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(33, 152, 190, 47);
		frame.getContentPane().add(button);
		
		IPField = new JTextField();
		IPField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IPField.setBounds(33, 49, 190, 20);
		frame.getContentPane().add(IPField);
		IPField.setColumns(10);
		
		portField = new JTextField();
		portField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		portField.setText("7770");
		portField.setEditable(false);
		portField.setBounds(33, 115, 190, 20);
		frame.getContentPane().add(portField);
		portField.setColumns(10);
	}

}
