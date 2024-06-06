package mainPages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import loginSignup.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JButton;

public class CreateGame extends JFrame implements ActionListener{
	
	private JButton playButton;
	private JButton goBackButton;
	private JSlider slider;
	private User user;

	/**
	 * takes the current user and creates the game.
	 * @param user
	 */
	public CreateGame(User user) {
		this.user = user;
		getContentPane().setLayout(null);
		
		JLabel selectLabel = new JLabel("Select The Number Of Bots");
		selectLabel.setFont(new Font("Arial", Font.PLAIN, 60));
		selectLabel.setBounds(272, 6, 838, 157);
		getContentPane().add(selectLabel);
		
		slider = new JSlider();
		slider.setFont(new Font("Arial", Font.PLAIN, 40));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setValue(1);
		slider.setMajorTickSpacing(1);
		slider.setForeground(new Color(102, 51, 255));
		slider.setBackground(new Color(0, 255, 255));
		slider.setMaximum(9);
		slider.setMinimum(1);
		slider.setBounds(262, 210, 739, 157);
		getContentPane().add(slider);
		
		goBackButton = new JButton("Go Back");
		goBackButton.setFont(new Font("Arial", Font.PLAIN, 30));
		goBackButton.setBounds(17, 36, 178, 85);
		getContentPane().add(goBackButton);
		goBackButton.addActionListener(this);
		
		playButton = new JButton("Play!");
		playButton.setFont(new Font("Arial", Font.PLAIN, 60));
		playButton.setBounds(393, 465, 492, 150);
		getContentPane().add(playButton);
		playButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * creates the game based on the selected number of bots
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playButton) {
			int botNum = slider.getValue();
			this.dispose();
			ArrayList<String> playerIds = new ArrayList<String>();
			playerIds.add(user.getNickname());
			for (int i = 1; i <= botNum; i++) {
				playerIds.add("BOT-"+i);
			}
			this.dispose();
			new GameStage(user, playerIds);
			
		}
		
		if (e.getSource() == goBackButton) {
			this.dispose();
			new MainPage(user);
		}
	}
}
