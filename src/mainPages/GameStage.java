package mainPages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import gameManager.Game;
import loginSignup.User;
import unoCards.Card;
import unoCards.Card.Color;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GameStage extends JFrame{
	
	
	
	ArrayList<String> temp = new ArrayList<String>();
	String[] pids;
 	private Game game;
 	ArrayList<JButton> cardButtons = new ArrayList<JButton>();
 	ArrayList<String> cardIds;
 	PopUp window;
 	private JButton cardButton1;
 	private JButton cardButton2;
 	private JButton cardButton3;
 	private JButton cardButton4;
 	private JButton cardButton5;
 	private JButton cardButton6;
 	private JButton cardButton7;
 	private JButton cardButton8;
 	private JButton cardButton9;
 	private JButton cardButton10;
 	private JButton cardButton11;
 	private JButton cardButton12;
 	private JButton cardButton13;
 	private JButton cardButton14;
 	private JButton cardButton15;
 	private JButton cardButton16;
 	private JButton cardButton17;
 	private JButton cardButton18;
 	private JButton cardButton19;
 	private JButton cardButton20;
 	private JButton cardButton21;
 	private JButton cardButton22;
 	private JButton cardButton23;
 	private JButton cardButton24;
 	private JButton cardButton25;
 	private JButton cardButton26;
 	private JButton cardButton27;
 	private JButton cardButton28;
 	private JButton cardButton29;
 	private JButton cardButton30;
 	
 	private JButton drawButton;
 	private JButton downCard;
 	private JButton topCardButton;
 	private JLabel playerNameLabel;
 	private JLabel cardsLeftLabel;
 	private JTextArea bot1Label;
 	private JTextArea bot2Label;
 	private JTextArea bot3Label;
 	private JTextArea bot4Label;
 	private JTextArea bot5Label;
 	private JTextArea bot6Label;
 	private JTextArea bot7Label;
 	private JTextArea bot8Label;
 	private JTextArea bot9Label;
 	private JButton sayUnoButton;
 	private boolean unoButtonClicked = false;
 	private User user;
 	private JButton botPlayButton;
 	private JLabel deckSizeLabel;
 	private JLabel directionLabel;
 	private JButton exitButton;

 	/**
 	 * creates the gamestage with the current user and all of the other bots ids
 	 * @param user
 	 * @param playerIds
 	 */
	public GameStage(User user, ArrayList<String> playerIds) {
		this.user = user;
		GameStage gameStage = this;
		temp = playerIds;
		pids = temp.toArray(new String[temp.size()]);
		game = new Game(pids, user, gameStage);
		game.start(game);
		topCardButton = new JButton();
		topCardButton.setBounds(536, 235, 70, 120);
		getContentPane().add(topCardButton);
		topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+game.getTopImage()).getImage().getScaledInstance(topCardButton.getWidth(), topCardButton.getHeight(), Image.SCALE_SMOOTH)));

		getContentPane().setLayout(null);
		
		cardButton1 = new JButton();
		cardButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(0) != null) {
					int index = 0;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton1.setBounds(22, 430, 70, 120);
		getContentPane().add(cardButton1);
		
		cardButton2 = new JButton();
		cardButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(1) != null) {
					int index = 1;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton2.setBounds(104, 430, 70, 120);
		getContentPane().add(cardButton2);
		
		cardButton3 = new JButton();
		cardButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(2) != null) {
					int index = 2;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton3.setBounds(186, 430, 70, 120);
		getContentPane().add(cardButton3);
		
		cardButton4 = new JButton();
		cardButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(3) != null) {
					int index = 3;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton4.setBounds(268, 430, 70, 120);
		getContentPane().add(cardButton4);
		
		cardButton5 = new JButton();
		cardButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(4) != null) {
					int index = 4;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton5.setBounds(350, 430, 70, 120);
		getContentPane().add(cardButton5);
		
		cardButton6 = new JButton();
		cardButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(5) != null) {
					int index = 5;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton6.setBounds(432, 430, 70, 120);
		getContentPane().add(cardButton6);
		
		cardButton7 = new JButton();
		cardButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(6) != null) {
					int index = 6;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton7.setBounds(514, 430, 70, 120);
		getContentPane().add(cardButton7);
		
		cardButton8 = new JButton();
		cardButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(7) != null) {
					int index = 7;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton8.setBounds(596, 430, 70, 120);
		getContentPane().add(cardButton8);
		
		cardButton9 = new JButton();
		cardButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(8) != null) {
					int index = 8;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton9.setBounds(678, 430, 70, 120);
		getContentPane().add(cardButton9);
		
		cardButton10 = new JButton();
		cardButton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(9) != null) {
					int index = 9;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton10.setBounds(760, 430, 70, 120);
		getContentPane().add(cardButton10);
		
		cardButton11 = new JButton();
		cardButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(10) != null) {
					int index = 10;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton11.setBounds(842, 430, 70, 120);
		getContentPane().add(cardButton11);
		
		cardButton12 = new JButton();
		cardButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(11) != null) {
					int index = 11;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton12.setBounds(924, 430, 70, 120);
		getContentPane().add(cardButton12);
		
		cardButton13 = new JButton();
		cardButton13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(12) != null) {
					int index = 12;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton13.setBounds(1006, 430, 70, 120);
		getContentPane().add(cardButton13);
		
		cardButton14 = new JButton();
		cardButton14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(13) != null) {
					int index = 13;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton14.setBounds(1088, 430, 70, 120);
		getContentPane().add(cardButton14);
		
		cardButton15 = new JButton();
		cardButton15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(14) != null) {
					int index = 14;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton15.setBounds(1170, 430, 70, 120);
		getContentPane().add(cardButton15);
		
		cardButton16 = new JButton();
		cardButton16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(15) != null) {
					int index = 15;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				
			}
		});
		cardButton16.setBounds(22, 566, 70, 120);
		getContentPane().add(cardButton16);
		
		cardButton17 = new JButton();
		cardButton17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(16) != null) {
					int index = 16;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton17.setBounds(104, 562, 70, 120);
		getContentPane().add(cardButton17);
		
		cardButton18 = new JButton();
		cardButton18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(17) != null) {
					int index = 17;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton18.setBounds(186, 562, 70, 120);
		getContentPane().add(cardButton18);
		
		cardButton19 = new JButton();
		cardButton19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(18) != null) {
					int index = 18;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton19.setBounds(268, 562, 70, 120);
		getContentPane().add(cardButton19);
		
		cardButton20 = new JButton();
		cardButton20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(19) != null) {
					int index = 19;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton20.setBounds(350, 562, 70, 120);
		getContentPane().add(cardButton20);
		
		cardButton21 = new JButton();
		cardButton21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(20) != null) {
					int index = 20;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton21.setBounds(432, 562, 70, 120);
		getContentPane().add(cardButton21);
		
		cardButton22 = new JButton();
		cardButton22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(21) != null) {
					int index = 21;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton22.setBounds(514, 562, 70, 120);
		getContentPane().add(cardButton22);
		
		cardButton23 = new JButton();
		cardButton23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(22) != null) {
					int index = 22;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton23.setBounds(596, 562, 70, 120);
		getContentPane().add(cardButton23);
		
		cardButton24 = new JButton();
		cardButton24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(23) != null) {
					int index = 23;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton24.setBounds(678, 562, 70, 120);
		getContentPane().add(cardButton24);
		
		cardButton25 = new JButton();
		cardButton25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(24) != null) {
					int index = 24;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton25.setBounds(760, 562, 70, 120);
		getContentPane().add(cardButton25);
		
		cardButton26 = new JButton();
		cardButton26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(25) != null) {
					int index = 25;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton26.setBounds(842, 562, 70, 120);
		getContentPane().add(cardButton26);
		
		cardButton27 = new JButton();
		cardButton27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(26) != null) {
					int index = 26;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton27.setBounds(924, 562, 70, 120);
		getContentPane().add(cardButton27);
		
		cardButton28 = new JButton();
		cardButton28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(27) != null) {
					int index = 27;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton28.setBounds(1006, 562, 70, 120);
		getContentPane().add(cardButton28);
		
		cardButton29 = new JButton();
		cardButton29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(28) != null) {
					int index = 28;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton29.setBounds(1088, 562, 70, 120);
		getContentPane().add(cardButton29);
		
		cardButton30 = new JButton();
		cardButton30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cardIds.get(29) != null) {
					int index = 29;
					String cardId = cardIds.get(index);
					window = new PopUp(cardId, game, index, cardButtons, gameStage, topCardButton, user);
					window.setVisible(true);
					window.setResizable(false);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			}
		});
		cardButton30.setBounds(1170, 562, 70, 120);
		getContentPane().add(cardButton30);
		
		botPlayButton = new JButton("Simulate Bot");
		botPlayButton.setFont(new Font("Arial", Font.PLAIN, 24));
		
		/**
		 * Plays the bots turn by checking the valid plays.
		 */
		botPlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean didSubmit = false;
				ArrayList<Card> playableCards = game.getPlayableCards(game.getCurrentPlayer());
				if (playableCards.size() != 0) {
					Color declaredColor = playableCards.get(0).getColor();
					if (game.getPlayerHandSize(game.getCurrentPlayer()) == 2 && playableCards.size() != 0) {
	                	JLabel message = new JLabel(game.getCurrentPlayer() + " said UNO");
	    				message.setFont(new Font("Arial",Font.BOLD, 48));
	    				JOptionPane.showMessageDialog(null, message);
					}
					try {
		                game.submitPlayerCard(game.getCurrentPlayer(), playableCards.get(0), declaredColor);
		                didSubmit = true;
		            } catch (Exception e2) {
		            	e2.printStackTrace();
		            }
				}
				else {
					try {
						game.submitDraw(game.getCurrentPlayer());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				revalidate();
				setPlayerName(game.getCurrentPlayer());
		        setButtonIcons();
		        if(didSubmit == true) {
		        	topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+playableCards.get(0) + ".png").getImage().getScaledInstance(topCardButton.getWidth(), topCardButton.getHeight(), Image.SCALE_SMOOTH)));

		        }
			}
		});
		botPlayButton.setBounds(22, 280, 188, 75);
		getContentPane().add(botPlayButton);
		
		/**
		 * performs drawing a card.
		 */
		drawButton = new JButton("Draw Card");
		drawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					game.submitDraw(game.getCurrentPlayer());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				setPlayerName(game.getCurrentPlayer());
				setButtonIcons();
			}
		});
		drawButton.setFont(new Font("Arial", Font.PLAIN, 25));
		drawButton.setBounds(959, 320, 168, 61);
		getContentPane().add(drawButton);
		
		downCard = new JButton();
		downCard.setBounds(1170, 280, 70, 120);
		getContentPane().add(downCard);
		downCard.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/Card_Back.png").getImage().getScaledInstance(topCardButton.getWidth(), topCardButton.getHeight(), Image.SCALE_SMOOTH)));

		
		createArrayList();
		playerNameLabel = new JLabel();
		playerNameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		playerNameLabel.setBounds(22, 360, 398, 61);
		getContentPane().add(playerNameLabel);
		
		cardsLeftLabel = new JLabel("Cards Left: ");
		cardsLeftLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		cardsLeftLabel.setBounds(6, 61, 138, 55);
		getContentPane().add(cardsLeftLabel);
		
		bot1Label = new JTextArea();
		bot1Label.setEditable(false);
		bot1Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot1Label.setBounds(156, 6, 100, 110);
		getContentPane().add(bot1Label);
		
		bot2Label = new JTextArea();
		bot2Label.setVisible(false);
		bot2Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot2Label.setBounds(280, 6, 100, 110);
		getContentPane().add(bot2Label);
		
		bot3Label = new JTextArea();
		bot3Label.setVisible(false);
		bot3Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot3Label.setBounds(404, 6, 100, 110);
		getContentPane().add(bot3Label);
		
		bot4Label = new JTextArea();
		bot4Label.setVisible(false);
		bot4Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot4Label.setBounds(528, 6, 100, 110);
		getContentPane().add(bot4Label);
		
		bot5Label = new JTextArea();
		bot5Label.setVisible(false);
		bot5Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot5Label.setBounds(652, 6, 100, 110);
		getContentPane().add(bot5Label);
		
		bot6Label = new JTextArea();
		bot6Label.setVisible(false);
		bot6Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot6Label.setBounds(776, 6, 100, 110);
		getContentPane().add(bot6Label);
		
		bot7Label = new JTextArea();
		bot7Label.setVisible(false);
		bot7Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot7Label.setBounds(900, 6, 100, 110);
		getContentPane().add(bot7Label);
		
		bot8Label = new JTextArea();
		bot8Label.setVisible(false);
		bot8Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot8Label.setBounds(1024, 6, 100, 110);
		getContentPane().add(bot8Label);
		
		bot9Label = new JTextArea();
		bot9Label.setVisible(false);
		bot9Label.setFont(new Font("Arial", Font.PLAIN, 20));
		bot9Label.setBounds(1148, 6, 100, 110);
		getContentPane().add(bot9Label);
		
		sayUnoButton = new JButton();
		sayUnoButton.setForeground(java.awt.Color.RED);
		sayUnoButton.setBackground(java.awt.Color.WHITE);
		sayUnoButton.setFont(new Font("Arial", Font.PLAIN, 24));
		sayUnoButton.setText("Say Uno");
		
		/**
		 * sets unoButtonClicked true for later checks
		 */
		sayUnoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unoButtonClicked = true;
			}
		});
		sayUnoButton.setBounds(22, 191, 188, 75);
		getContentPane().add(sayUnoButton);
		
		directionLabel = new JLabel("Game Direction: ");
		directionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		directionLabel.setBounds(930, 145, 350, 50);
		getContentPane().add(directionLabel);
		
		deckSizeLabel = new JLabel();
		deckSizeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		deckSizeLabel.setBounds(1190, 235, 50, 40);
		getContentPane().add(deckSizeLabel);
		
		exitButton = new JButton("Exit Game");
		/**
		 * exits the game and redirects to main page.
		 */
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainPage(user);
			}
		});
		exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
		exitButton.setBounds(6, 7, 124, 40);
		getContentPane().add(exitButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setResizable(false);
		this.setVisible(true);
		setPlayerName();
		setButtonIcons();
		checkUnoButton();
		
	}
	/**
	 * checks if the user said uno or not
	 */
	public void checkUnoButton() {
	    if (game.getPlayerHandSize(game.getCurrentPlayer()) == 1 && !unoButtonClicked) {
	        JLabel message = new JLabel("You forgot to say uno! 2 cards penalty.");
	        message.setFont(new Font("Arial", Font.BOLD, 24));
	        JOptionPane.showMessageDialog(null, message);
	        try {
	            game.submitDraw(game.getCurrentPlayer());
	            game.submitDraw(game.getCurrentPlayer());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        unoButtonClicked = true;
	    }
	}

	/**
	 * sets the ingame label text to the current players name
	 */
	public void setPlayerName() {
		String currentPlayer = game.getCurrentPlayer();
		playerNameLabel.setText(currentPlayer +"'s Cards");
	}
	
	/**
	 * sets the ingame label text to given String in parameter
	 * @param currentPlayer
	 */
	public void setPlayerName(String currentPlayer) {
		playerNameLabel.setText(currentPlayer +"'s Cards");
	}

	/**
	 * sets buton icons 
	 */
	public void setButtonIcons() {
		
		checkUnoButton();
		if(game.getCurrentPlayer().equals(user.getNickname())) {
			botPlayButton.setVisible(false);
		}
		else {
			botPlayButton.setVisible(true);
		}
		deckSizeLabel.setText(String.valueOf(game.deck.deckSize));
		if (game.gameDirection == false) {
			directionLabel.setText("Game Direction: Clockwise");
		}
		else {
			directionLabel.setText("Game Direction: Counter Clockwise");
		}
		
		if(!game.getCurrentPlayer().equals(user.getNickname())) {
			String list = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
			String[] cardNames = list.split(",");
			cardIds = new ArrayList<>(Arrays.asList(cardNames));
			for(int card = 0; card < cardIds.size(); card++) {
				cardButtons.get(card).setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/Card_Back.png").getImage().getScaledInstance(topCardButton.getWidth(), topCardButton.getHeight(), Image.SCALE_SMOOTH)));
			}
			
			for(int i = cardIds.size(); i < cardButtons.size(); i++) {
				cardButtons.get(i).setIcon(null);
			}
		}
		else {
			String list = game.getPlayerHand(game.getCurrentPlayer()).stream().map(Object::toString).collect(Collectors.joining(","));
			String[] cardNames = list.split(",");
			cardIds = new ArrayList<>(Arrays.asList(cardNames));
			for(int card = 0; card < cardIds.size(); card++) {
				cardButtons.get(card).setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+cardIds.get(card) + ".png").getImage().getScaledInstance(cardButton1.getWidth(), cardButton1.getHeight(), Image.SCALE_SMOOTH)));
			}
			
			for(int i = cardIds.size(); i < cardButtons.size(); i++) {
				cardButtons.get(i).setIcon(null);
			}
		} 
		
		bot1Label.setText("BOT-1\n\n\n     " + game.getPlayerHandSize("BOT-1"));
		if(pids.length > 2) {
			bot2Label.setText("BOT-2\n\n\n     " + game.getPlayerHandSize("BOT-2"));
			bot2Label.setVisible(true);
		}
		if(pids.length > 3) {
			bot3Label.setText("BOT-3\n\n\n     " + game.getPlayerHandSize("BOT-3"));
			bot3Label.setVisible(true);
		}
		if(pids.length > 4) {
			bot4Label.setText("BOT-4\n\n\n     " + game.getPlayerHandSize("BOT-4"));
			bot4Label.setVisible(true);
		}
		if(pids.length > 5) {
			bot5Label.setText("BOT-5\n\n\n     " + game.getPlayerHandSize("BOT-5"));
			bot5Label.setVisible(true);
		}
		if(pids.length > 6) {
			bot6Label.setText("BOT-6\n\n\n     " + game.getPlayerHandSize("BOT-6"));
			bot6Label.setVisible(true);
		}
		if(pids.length > 7) {
			bot7Label.setText("BOT-7\n\n\n     " + game.getPlayerHandSize("BOT-7"));
			bot7Label.setVisible(true);
		}
		if(pids.length > 8) {
			bot8Label.setText("BOT-8\n\n\n     " + game.getPlayerHandSize("BOT-8"));
			bot8Label.setVisible(true);
		}
		if(pids.length > 9) {
			bot9Label.setText("BOT-9\n\n\n     " + game.getPlayerHandSize("BOT-9"));
			bot9Label.setVisible(true);
		}
	}
	
	/**
	 * creates the button arraylist
	 */
	public void createArrayList() {
		cardButtons.add(cardButton1);
		cardButtons.add(cardButton2);
		cardButtons.add(cardButton3);
		cardButtons.add(cardButton4);
		cardButtons.add(cardButton5);
		cardButtons.add(cardButton6);
		cardButtons.add(cardButton7);
		cardButtons.add(cardButton8);
		cardButtons.add(cardButton9);
		cardButtons.add(cardButton10);
		cardButtons.add(cardButton11);
		cardButtons.add(cardButton12);
		cardButtons.add(cardButton13);
		cardButtons.add(cardButton14);
		cardButtons.add(cardButton15);
		cardButtons.add(cardButton16);
		cardButtons.add(cardButton17);
		cardButtons.add(cardButton18);
		cardButtons.add(cardButton19);
		cardButtons.add(cardButton20);
		cardButtons.add(cardButton21);
		cardButtons.add(cardButton22);
		cardButtons.add(cardButton23);
		cardButtons.add(cardButton24);
		cardButtons.add(cardButton25);
		cardButtons.add(cardButton26);
		cardButtons.add(cardButton27);
		cardButtons.add(cardButton28);
		cardButtons.add(cardButton29);
		cardButtons.add(cardButton30);
	}
}
