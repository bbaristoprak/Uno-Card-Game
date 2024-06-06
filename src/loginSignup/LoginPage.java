package loginSignup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainPages.MainPage;

public class LoginPage extends JFrame implements ActionListener {
	
	private JFrame frame = new JFrame();
	private JButton loginButton = new JButton("Login");
	private JButton signUpButton = new JButton("Signup");
	private JTextField usernameInputField = new JTextField();
	private JPasswordField passwordInputField = new JPasswordField();
	private JLabel usernameLabel = new JLabel("Username: ");
	private JLabel passwordLabel = new JLabel("Password: ");
	private JLabel loginMessage = new JLabel();
	private JLabel welcomeLabel = new JLabel("Uno Card Game");
	private HashMap<String, User> loginInfo = new HashMap<String, User>();
	
	/**
	 * initializes the login page of the project
	 */
	public LoginPage() {
		this.loginInfo = UserOperations.loginInfo;
		
		usernameLabel.setForeground(new Color(102, 51, 255));
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		usernameLabel.setBounds(16,90,105,39);
		frame.getContentPane().setBackground(new Color(0, 204, 255));
		frame.setLocation(600,130);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		passwordLabel.setForeground(new Color(102, 51, 255));
		
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		passwordLabel.setBounds(16,150,105,39);
		
		loginMessage.setBounds(10,204,128,39);
		loginMessage.setFont(new Font("Serif", Font.BOLD, 15));
		
		signUpButton.setForeground(new Color(102, 51, 255));
		signUpButton.setBackground(new Color(51, 255, 255));
		signUpButton.setFont(new Font("Arial", Font.PLAIN, 17));
		
		
		signUpButton.setBounds(289,256,105,60);
		signUpButton.setFocusable(false);
		signUpButton.addActionListener(this);
		
		
		frame.getContentPane().add(usernameLabel);
		loginButton.setForeground(new Color(102, 51, 255));
		loginButton.setBackground(new Color(0, 255, 255));
		loginButton.setFont(new Font("Arial", Font.PLAIN, 17));
		
		loginButton.setBounds(145, 197, 115, 60);
		loginButton.setFocusable(false); 
		loginButton.addActionListener(this);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(passwordLabel);
		frame.getContentPane().add(loginMessage);
		frame.getContentPane().add(signUpButton);
		frame.getContentPane().add(signUpButton);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,350);
		frame.getContentPane().setLayout(null);
		
		usernameInputField.setBounds(135, 90, 140, 37);
		frame.getContentPane().add(usernameInputField);
		usernameInputField.setColumns(10);
		
		passwordInputField.setBounds(135, 150, 140, 37);
		frame.getContentPane().add(passwordInputField);
		welcomeLabel.setForeground(new Color(51, 51, 255));
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
		welcomeLabel.setBounds(82, 6, 277, 72);
		frame.getContentPane().add(welcomeLabel);
		
		JLabel signupNowLabel = new JLabel("Don't have an account yet? Sign up now!");
		signupNowLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		signupNowLabel.setForeground(new Color(102, 51, 255));
		signupNowLabel.setBounds(16, 265, 270, 50);
		frame.getContentPane().add(signupNowLabel);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String username = usernameInputField.getText();
			String password = String.valueOf(passwordInputField.getPassword());
			
			if (loginInfo.containsKey(username)) {
				if (loginInfo.get(username).getPassword().equals(password)) {
					frame.dispose();
					new MainPage(loginInfo.get(username));
					try {
						FileWriter logWriter = new FileWriter("logs.txt", true);
						logWriter.write(username + " has logged in at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
			            logWriter.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}	
				else {
					loginMessage.setForeground(Color.red);
					loginMessage.setText("Wrong password");
					loginMessage.setVisible(true);
				}
			}
			
			else {
				loginMessage.setForeground(Color.red);
				loginMessage.setText("Invalid Username");
				loginMessage.setVisible(true);
			}
		}
		
		if (e.getSource() == signUpButton) {
			frame.dispose();
			new SignupPage().setVisible(true);;
		}
	}
}
