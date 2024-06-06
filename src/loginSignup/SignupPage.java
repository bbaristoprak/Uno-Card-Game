package loginSignup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SignupPage extends JFrame implements ActionListener {
	
	 private JTextField usernameField;
	 private JPasswordField passwordField;
	 private JButton signupButton;
	 private JButton goBackButton;
	 private JTextArea warningText;
	 
	 /**
	  * Initializes the GUI components of the signup page
	  */
	 public SignupPage() {
		 getContentPane().setLayout(null);
	     setSize(600, 300);
	     setVisible(true);
	     setResizable(false);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         
         JLabel signupLabel = new JLabel("Sign Up to Uno Card Game!");
         signupLabel.setForeground(Color.BLUE);
         signupLabel.setFont(new Font("Arial", Font.BOLD, 30));
         signupLabel.setBounds(97, 6, 438, 46);
         getContentPane().add(signupLabel);
         
         signupButton = new JButton("Sign Up Now!");
         signupButton.setFont(new Font("Arial", Font.PLAIN, 24));
         signupButton.setBounds(124, 196, 334, 46);
         getContentPane().add(signupButton);
         signupButton.addActionListener(this);
         
         JLabel usernameLabel = new JLabel("Username:");
         usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
         usernameLabel.setBounds(6, 85, 111, 30);
         getContentPane().add(usernameLabel);
         
         JLabel passwordLabel = new JLabel("Password:");
         passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
         passwordLabel.setBounds(6, 127, 118, 30);
         getContentPane().add(passwordLabel);
         
         usernameField = new JTextField();
         usernameField.setBounds(124, 87, 130, 30);
         getContentPane().add(usernameField);
         usernameField.setColumns(10);
         
         passwordField = new JPasswordField();
 		 passwordField.setBounds(124, 129, 130, 30);
 		 getContentPane().add(passwordField);
 		 
 		warningText = new JTextArea();
		warningText.setForeground(Color.RED);
		warningText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		warningText.setText("Invalid Registration!\nEnter a unique nickname.\nMake sure it is at least 4 characters.\nEnter password at least 6 characters.");
		warningText.setBounds(303, 85, 275, 80);
		getContentPane().add(warningText);
		warningText.setVisible(false);
	 }
	 
	 /**
	  * Takes the entered username and password, creates a new user.
	  */
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == signupButton) {
			 if(!isUsernameExists(usernameField.getText()) && usernameField.getText().length() >= 4 && passwordField.getPassword().length >= 6) {
				 try {
						FileWriter userDataWriter = new FileWriter("userData.txt", true);
			            FileWriter logWriter = new FileWriter("logs.txt", true);
			            String passwordString = new String(passwordField.getPassword());
			            userDataWriter.write(usernameField.getText() + " " + passwordString + "\n");
			            userDataWriter.close();
			            logWriter.write("New user with nickname "+ usernameField.getText() + " has been registered at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");	            
			            logWriter.close();
			            this.dispose();
			            UserOperations userOperations = new UserOperations();
			            User user = new User(usernameField.getText(), passwordString);
			            LoginPage loginPage = new LoginPage();
			          
			        } catch (IOException exception) {
			        	exception.printStackTrace();
			        }
				}
				else {
					warningText.setVisible(true);
				}
			 }
		 else if (e.getSource() == goBackButton) {
				this.dispose();
				UserOperations userOperations = new UserOperations();
				new LoginPage();
			}
		 }
	 
	 /**
	  * checks if there is already a player with the same username
	  * @param username
	  * @return
	  */
	private boolean isUsernameExists(String username) {
		try {
	        File userData = new File("userData.txt");
	        Scanner scanner = new Scanner(userData);
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] parts = line.split(" ");
	            if (parts.length > 0 && parts[0].equals(username)) {
	                scanner.close();
	                return true;
	            }
	        }
	        scanner.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
