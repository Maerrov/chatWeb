package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JDialog {

	private JFrame frame;
	private JMenu menu;
	private JTextField nameField;
	private JPasswordField passwordField;
	private TextArea messageArea;
	private JLabel labelOne;
	private JButton buRegistr;
	private JButton butEntry;
	private JButton butSend;
	private TextArea messageSendArea;
	private JMenuItem exitItem;
	private JMenuItem settingsItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Створюємо клієнта
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	// Метод для веріфікації та виконання запиту з виводом результату на консоль
	public static void executeRequest(HttpRequestBase request) throws Exception {
		HttpResponse response = httpClient.execute(request);
		int code = response.getStatusLine().getStatusCode();
		if (code != 200)
			throw new Exception(response.getStatusLine().toString());
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 635, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("Меню");
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.setPreferredSize(new Dimension(50, 22));
		menuBar.add(menu);
		
		settingsItem = new JMenuItem("Настройки");
		settingsItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConnectWindow connectwindow = new ConnectWindow();
				connectwindow.newScreen();
				
			}
		});
		
		settingsItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(settingsItem);
		
		exitItem = new JMenuItem("Выход");
		exitItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(exitItem);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Введите имя");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 11, 117, 17);
		frame.getContentPane().add(label);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameField.setBounds(10, 29, 188, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JLabel label_1 = new JLabel("Введите пароль");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 74, 130, 14);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(10, 99, 188, 20);
		frame.getContentPane().add(passwordField);
		
		butEntry = new JButton("Вход");
		butEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		butEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = nameField.getText();
				String password = new String(passwordField.getPassword());
				
				try {
					String uri = "http://localhost:8080/chatWeb/rest/restExample/user/" + name + "/" + password;
					System.out.println(uri);
					executeRequest(new HttpPut(uri));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		butEntry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		butEntry.setBounds(248, 20, 180, 39);
		frame.getContentPane().add(butEntry);
		
		buRegistr = new JButton("Регистрация");
		buRegistr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrWindow registr = new RegistrWindow();
				registr.newScreen();
			}
		});
		buRegistr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		buRegistr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buRegistr.setBounds(248, 74, 180, 45);
		frame.getContentPane().add(buRegistr);
		
		JLabel label_2 = new JLabel("Чат");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 130, 46, 14);
		frame.getContentPane().add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 155, 599, 135);
		frame.getContentPane().add(panel_1);
		
		messageArea = new TextArea();
		messageArea.setPreferredSize(new Dimension(600, 130));
		panel_1.add(messageArea);
		
		labelOne = new JLabel("1111");
		labelOne.setBounds(467, 34, 142, 85);
		frame.getContentPane().add(labelOne);
		
		JLabel label_3 = new JLabel("Введите ваше сообщение");
		label_3.setPreferredSize(new Dimension(131, 20));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 290, 228, 13);
		frame.getContentPane().add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 313, 470, 66);
		frame.getContentPane().add(panel);
		
		messageSendArea = new TextArea();
		messageSendArea.setPreferredSize(new Dimension(470, 65));
		panel.add(messageSendArea);
		
		butSend = new JButton("Отправить");
		butSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		butSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		butSend.setBounds(490, 313, 119, 66);
		frame.getContentPane().add(butSend);
		
		
/*===========================================*/		
		messageArea.setEditable(false);
		messageSendArea.setEditable(false);
		butSend.setEnabled(false);
	}

	
	public TextArea getTextArea() {
		return messageArea;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JTextField getTextField() {
		return nameField;
	}
	public JLabel getLblNewLabel() {
		return labelOne;
	}
	public JButton getButton_1() {
		return buRegistr;
	}
	public JButton getButton() {
		return butEntry;
	}
	public JButton getButton_2() {
		return butSend;
	}
	public TextArea getTextArea_1() {
		return messageSendArea;
	}
	
	public JMenu getMenu() {
		return menu;
	}
	public JMenuItem getMenuItem() {
		return exitItem;
	}
	public JMenuItem getSettingsItem() {
		ConnectWindow connectwindow = new ConnectWindow();
		return settingsItem;
	}
}
