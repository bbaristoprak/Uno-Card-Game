package mainPages;

import javax.swing.JFrame;

import loginSignup.LoginPage;
import loginSignup.User;

import javax.swing.JButton;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class MainPage extends JFrame implements ActionListener{
	
	private JButton createGameButton;
	private JButton loadGameButton;
	private JLabel leaderboardLabel;
	private JButton logoutButton;
	private User user;
	private JPanel leaderboardPanel;
	private JLabel detailsLabel;
	
	/**
	 * initializes the main page where the create game and leaderboard are present. Takes the user as input because it's the users account.
	 * @param user
	 */
	public MainPage(User user) {
		this.user = user;
		
		getContentPane().setLayout(null);
		
		createGameButton = new JButton("Create New Game\n");
		createGameButton.setFont(new Font("Arial", Font.PLAIN, 30));
		createGameButton.setBounds(141, 259, 327, 91);
		getContentPane().add(createGameButton);
		
		loadGameButton = new JButton("Load Game");
		loadGameButton.setFont(new Font("Arial", Font.PLAIN, 30));
		loadGameButton.setBounds(141, 404, 327, 91);
		getContentPane().add(loadGameButton);
		
		JLabel unoLabel = new JLabel("Welcome " + user.getNickname() +", Play Uno Card Game!");
		unoLabel.setFont(new Font("Arial", Font.PLAIN, 48));
		unoLabel.setBounds(43, 6, 1044, 91);
		getContentPane().add(unoLabel);
		
		leaderboardLabel = new JLabel("Leaderboard - Best to Worst at UNO");
		leaderboardLabel.setFont(new Font("Arial", Font.BOLD, 32));
		leaderboardLabel.setBounds(650, 100, 570, 33);
		getContentPane().add(leaderboardLabel);
		
		logoutButton = new JButton("Log Out");
		logoutButton.setFont(new Font("Arial", Font.PLAIN, 28));
		logoutButton.setBounds(1099, 6, 146, 82);
		getContentPane().add(logoutButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setResizable(false);
		createGameButton.addActionListener(this);
	    loadGameButton.addActionListener(this);
	    logoutButton.addActionListener(this);
	    this.setVisible(true);
	    leaderboardLabel = new JLabel("Leaderboard");
        leaderboardLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        getContentPane().add(leaderboardLabel);
        
        leaderboardLabel = new JLabel("Leaderboard");
        leaderboardLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        getContentPane().add(leaderboardLabel);
        leaderboardPanel = new JPanel();
        leaderboardPanel.setLayout(null);
        leaderboardPanel.setBounds(600, 200, 650, 480);
        getContentPane().add(leaderboardPanel);
        
        detailsLabel = new JLabel("Click on any Player for Details");
        detailsLabel.setForeground(Color.GRAY);
        detailsLabel.setFont(new Font("Arial", Font.ITALIC, 24));
        detailsLabel.setBounds(760, 150, 350, 35);
        getContentPane().add(detailsLabel);
        displayLeaderboard();
		
	}
	
	/**
	 * displays the leaderboard, parses the data from scores.txt
	 */
	private void displayLeaderboard() {
	    leaderboardPanel.removeAll();
	    String fileName = "scores.txt";
	    List<String> lines = new ArrayList<>();

	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            lines.add(line);
	        }

	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Collections.sort(lines, new Comparator<String>() {
	        @Override
	        public int compare(String line1, String line2) {
	            int score1 = Integer.parseInt(line1.split(",")[1].trim());
	            int score2 = Integer.parseInt(line2.split(",")[1].trim());
	            return Integer.compare(score2, score1);
	        }
	    });

	    int yPos = 0;
	    int count = 0;
	    for (String line : lines) {
	        if (count >= 10) {
	            break;
	        }

	        String[] parts = line.split(",");
	        String nickname = parts[0].trim();
	        int score = Integer.parseInt(parts[1].trim());
	        int winCount = Integer.parseInt(parts[2].trim());
	        int loseCount = Integer.parseInt(parts[3].trim());

	        JLabel entryLabel = new JLabel(nickname + " - Score: " + score + " Wins: " + winCount + " Losses: " + loseCount);
	        entryLabel.setFont(new Font("Arial", Font.PLAIN, 24));
	        entryLabel.setBounds(0, yPos, 500, 30);
	        entryLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        entryLabel.addMouseListener(new MouseAdapter() {
	        	int gamesPlayed = winCount + loseCount;
	            int winrate = 100*winCount/(gamesPlayed);
	            public void mouseClicked(MouseEvent e) {
	                JOptionPane.showMessageDialog(null, "Nickname: " + nickname + "\nScore: " + score + "\nWins: " + winCount + "\nLosses: " +loseCount + "\nGames Played: " + gamesPlayed +"\nAverage Score per Game: " + score/(gamesPlayed) + "\nWinrate: " + winrate +"%");
	            }
	        });
	        leaderboardPanel.add(entryLabel);
	        yPos += 50;
	        count++;
	    }

	    leaderboardPanel.revalidate();
	    leaderboardPanel.repaint();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createGameButton) {
			this.dispose();
			new CreateGame(user);
		}
		
		if(e.getSource() == loadGameButton) {
			
		}
		
		if(e.getSource() == logoutButton) {
			this.dispose();
			new LoginPage();
		}
		
	}
}
