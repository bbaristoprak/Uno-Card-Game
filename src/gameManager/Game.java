package gameManager;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import fileHandle.GameLogger;
import loginSignup.User;
import mainPages.GameStage;
import mainPages.MainPage;
import unoCards.Card;
import unoCards.Deck;

public class Game {
	private int currentPlayer;
	private String[] playerNameList;
	
	public Deck deck;
	private ArrayList<ArrayList<Card>> playersHand;
	
	private Card.Color validColor;
	private Card.Value validValue;
	
	private ArrayList<Card> stockPile;
	
	public boolean gameDirection;
	private User user;
	private GameStage gameStage;
	
	/**
	 * This constructor takes playerNames, the user and the game stage. It prepares the deck and distrubutes 7 cards to each player.
	 * @param playerNames
	 * @param user
	 * @param gameStage
	 */
	public Game(String[] playerNames, User user, GameStage gameStage) {
		this.user = user;
		this.gameStage = gameStage;
		deck = new Deck();
		deck.shuffle();
		
		stockPile = new ArrayList<Card>();
		playerNameList = playerNames;
		currentPlayer = 0;
		gameDirection = false;
		
		playersHand = new ArrayList<ArrayList<Card>>();
		
		for (int i = 0; i < playerNames.length; i++) {
			ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(deck.drawCard(7)));
			playersHand.add(hand);
		}
		
	}
	
	/**
	 * This method starts the uno game, if the first card is not a number card, it restarts the process.
	 * @param game
	 */
	public void start(Game game) {
		Card card = deck.drawCard();
		card = deck.drawCard();
		validColor = card.getColor();
		validValue = card.getValue();
		
		if (card.getValue() == Card.Value.Wild) {
			start(game);
		}
		if (card.getValue() == Card.Value.WildFour || card.getValue() == Card.Value.DrawTwo) {
			start(game);
		}
		if (card.getValue() == Card.Value.Skip) {
			start(game);
		}
		if (card.getValue() == Card.Value.Reverse) {
			start(game);
		}
		stockPile.add(card);
	}
	
	/**
	 * returns the top card of the discard deck.
	 * @return
	 */
	public Card getTop() {
		return new Card(validColor, validValue);
	}
	
	/**
	 * returns the top card of the discard decks image.
	 * @return
	 */
	public ImageIcon getTopImage() {
		return new ImageIcon(validColor + "_" + validValue + ".png");
	}
	
	/**
	 * checks whether the game is over
	 * @return
	 */
	public boolean isGameOver() {
		for (String playerName : this.playerNameList) {
			if (hasEmptyHand(playerName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * returns the current players name as a String.
	 * @return
	 */
	public String getCurrentPlayer() {
		return this.playerNameList[this.currentPlayer];
	}
	
	/**
	 * returns the previous players name as a String by taking current players index
	 * @param i
	 * @return
	 */
	public String getPreviousPlayer(int i) {
		int index = this.currentPlayer - i;
		if (index == -1) {
			index = playerNameList.length -1;
		}
		return this.playerNameList[index];
	}
	
	/**
	 * returns a list of player names
	 */
	public String[] getPlayers() {
		return this.playerNameList;
	}
	
	/**
	 * returns the players hand of cards, takes the players name as a parameter.
	 * @param pName
	 * @return
	 */
	public ArrayList<Card> getPlayerHand(String pName) {
		int index = Arrays.asList(playerNameList).indexOf(pName);
		return playersHand.get(index);
	}
	
	/**
	 * takes the players name, checks if the hand is empty.
	 * @param pName
	 * @return
	 */
	public boolean hasEmptyHand(String pName) {
		return getPlayerHand(pName).isEmpty();
	}
	
	/**
	 * returns players hand size by taking the players name
	 * @param pName
	 * @return
	 */
	public int getPlayerHandSize(String pName) {
		return getPlayerHand(pName).size();
	}
	
	/**
	 * returns players selected card.
	 * @param pName
	 * @param choice
	 * @return
	 */
	public Card getPlayerCard(String pName, int choice) {
		ArrayList<Card> hand = getPlayerHand(pName);
		return hand.get(choice);
	}
	
	/**
	 * checks if the players card is a valid play.
	 * @param card
	 * @return
	 */
	public boolean validCardPlay(Card card) {
		return card.getColor() == validColor || card.getValue() == validValue;
	}
	
	/**
	 * checks if the current player is correct, throws InvalidPlayerTurnException
	 * @param pName
	 * @throws InvalidPlayerTurnException
	 */
	public void checkPlayerTurn(String pName) throws InvalidPlayerTurnException{
		if (this.playerNameList[this.currentPlayer] != pName) {
			throw new InvalidPlayerTurnException("It's not " + pName + " 's turn!", pName);
		}
	}
	
	/**
	 * submits drawing a card, takes players name. Throws InvalidPlayerTurnException
	 * @param pName
	 * @throws InvalidPlayerTurnException
	 */
	public void submitDraw(String pName) throws InvalidPlayerTurnException{
		checkPlayerTurn(pName);
		
		if (deck.isEmpty()) {
			deck.updateDeck(stockPile);
			deck.shuffle();
		}
		
		getPlayerHand(pName).add(deck.drawCard());
		if (gameDirection == false) {
			currentPlayer = (currentPlayer + 1) % playerNameList.length;
		}
		
		else if (gameDirection == true) {
			currentPlayer = (currentPlayer - 1) % playerNameList.length;
			if (currentPlayer == -1) {
				currentPlayer = playerNameList.length -1;
			}
		}
	}
	
	/**
	 * sets card color to another given color in the parameter.
	 * @param color
	 */
	public void setCardColor(Card.Color color) {
		validColor = color;
	}
	
	/**
	 * performs submitting of a card, checks all the conditions and performs special card effects if there are any.
	 * @param pName
	 * @param card
	 * @param declaredColor
	 * @throws InvalidColorSubmissionException
	 * @throws InvalidValueSubmissionException
	 * @throws InvalidPlayerTurnException
	 */
	public void submitPlayerCard(String pName, Card card, Card.Color declaredColor)
		throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException{
			checkPlayerTurn(pName);
			
			ArrayList<Card> playerHand = getPlayerHand(pName);
			
			if (!validCardPlay(card)) {
				if (card.getColor() == Card.Color.Wild) {
					validColor = card.getColor();
					validValue = card.getValue();
				}
				
				if (card.getColor() != validColor) {
					JLabel colorMsg = new JLabel("Invalid player move, expected color: " + validColor);
					colorMsg.setFont(new Font("Arial", Font.BOLD, 24));
					JOptionPane.showMessageDialog(null, colorMsg); 
					throw new InvalidColorSubmissionException("Invalid player move, expected color: " + validColor, card.getColor(), validColor);
				}
				else if (card.getValue() != validValue) {
					JLabel valueMsg = new JLabel("Invalid player move, expected value: " + validValue);
					valueMsg.setFont(new Font("Arial", Font.BOLD, 24));
					JOptionPane.showMessageDialog(null, valueMsg);
					throw new InvalidValueSubmissionException("Invalid player move, expected value: " + validValue, card.getValue(), validValue);
				}
			}
			playerHand.remove(card);
			GameLogger.log(pName + " played " + card.getColor() + " " + card.getValue() + " at "+ LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
			
			if (hasEmptyHand(this.playerNameList[currentPlayer])) {
				GameLogger.log(pName + " has won the game at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
				
				try {
				    FileReader fileReader = new FileReader("scores.txt");
				    BufferedReader bufferedReader = new BufferedReader(fileReader);

				    StringBuilder fileContent = new StringBuilder();
				    String line;

				    while ((line = bufferedReader.readLine()) != null) {
				        String[] parts = line.split(",");
				        String nameFromFile = parts[0].trim();
				        if (nameFromFile.equals(user.getNickname())) {
				            int score = Integer.parseInt(parts[1].trim());
				            int winCount = Integer.parseInt(parts[2].trim());
				            int loseCount = Integer.parseInt(parts[3].trim());

				            if (playerNameList[currentPlayer].equals(user.getNickname())) {
				                int totalScore = 0;
				                for (String playerName : playerNameList) {
				                    if (!playerName.equals(user.getNickname())) {
				                        ArrayList<Card> pHand = getPlayerHand(playerName);
				                        for (Card playerCard : pHand) {
				                            if (playerCard.getValue().equals(Card.Value.Wild)) {
				                                totalScore += 50;
				                            } else if (playerCard.getValue().equals(Card.Value.WildFour) || playerCard.getValue().equals(Card.Value.DrawTwo) ||
				                                    playerCard.getValue().equals(Card.Value.Skip)) {
				                                totalScore += 20;
				                            } else {
				                                totalScore += playerCard.getNumericValue(playerCard.getValue());
				                            }
				                        }
				                    }
				                }
				                score += totalScore;
				                winCount++;
				            } else {
				                loseCount++;
				            }
				            line = user.getNickname() + "," + score + "," + winCount + "," + loseCount;
				        }
				        fileContent.append(line).append("\n");
				    }
				    if (!fileContent.toString().contains(user.getNickname())) {
				        int score = 0;
				        int winCount = 0;
				        int loseCount = 0;
				        if (playerNameList[currentPlayer].equals(user.getNickname())) {
				            int totalScore = 0;
				            for (String playerName : playerNameList) {
				                if (!playerName.equals(user.getNickname())) {
				                    ArrayList<Card> pHand = getPlayerHand(playerName);
				                    for (Card playerCard : pHand) {
				                        if (playerCard.getValue().equals(Card.Value.Wild)) {
				                            totalScore += 50;
				                        } else if (playerCard.getValue().equals(Card.Value.WildFour) || playerCard.getValue().equals(Card.Value.DrawTwo) ||
				                                playerCard.getValue().equals(Card.Value.Skip)) {
				                            totalScore += 20;
				                        } else {
				                        	totalScore += playerCard.getNumericValue(playerCard.getValue());
				                        }
				                    }
				                }
				            }
				            score += totalScore;
				            winCount++;
				        } else {
				            loseCount++;
				        }
				        fileContent.append(user.getNickname()).append(",").append(score).append(",").append(winCount).append(",").append(loseCount).append("\n");
				    }
				    FileWriter fileWriter = new FileWriter("scores.txt");
				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				    bufferedWriter.write(fileContent.toString());

				    bufferedReader.close();
				    bufferedWriter.close();
				} catch (IOException e) {
				    System.err.println("Error: writing to scores.txt file.");
				}

				JLabel message = new JLabel(this.playerNameList[currentPlayer] + " won the game.");
				message.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, message);
				gameStage.dispose();
				new MainPage(user);
			}
			
			validColor = card.getColor();
			validValue = card.getValue();
			stockPile.add(card);
			
		
			
			if (card.getColor() == Card.Color.Wild && playerNameList[currentPlayer].substring(0, 3).equals("BOT")) {
				Random random = new Random();
			    int randomColorIndex = random.nextInt(4);
			    switch (randomColorIndex) {
			        case 0:
			            validColor = Card.Color.Red;
			            break;
			        case 1:
			            validColor = Card.Color.Green;
			            break;
			        case 2:
			            validColor = Card.Color.Blue;
			            break;
			        case 3:
			            validColor = Card.Color.Yellow;
			            break;
			        default:
			            break;
			    }
			    JLabel colorMsg = new JLabel("BOT selected color: " + validColor);
				colorMsg.setFont(new Font("Arial", Font.BOLD, 24));
				JOptionPane.showMessageDialog(null, colorMsg); 
			}
			
			if (card.getValue() == Card.Value.WildFour && playerNameList[currentPlayer].substring(0, 3).equals("BOT")) { 
				pName = playerNameList[currentPlayer];
				getPlayerHand(pName).add(deck.drawCard());
				getPlayerHand(pName).add(deck.drawCard());
				getPlayerHand(pName).add(deck.drawCard());
				getPlayerHand(pName).add(deck.drawCard());
				GameLogger.log(pName + " drew 4 cards at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
			}
			
			
			if (gameDirection == false) {
				currentPlayer = (currentPlayer + 1) % playerNameList.length;
			}
			else if (gameDirection == true) {
				currentPlayer = (currentPlayer -1) % playerNameList.length;
				if (currentPlayer == -1) {
					currentPlayer = playerNameList.length -1;
				}
			}
			
			if (card.getValue() == Card.Value.DrawTwo) {
				pName = playerNameList[currentPlayer];
				getPlayerHand(pName).add(deck.drawCard());
				getPlayerHand(pName).add(deck.drawCard());
				GameLogger.log(pName + " drew 2 cards at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
			}
			
			if (card.getValue() == Card.Value.Skip) {
				JLabel msg = new JLabel(playerNameList[currentPlayer] + " was skipped");
				GameLogger.log(playerNameList[currentPlayer] + " was skipped at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
				msg.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, msg);
				if (gameDirection == false) {
					currentPlayer = (currentPlayer + 1) % playerNameList.length;
				}
				else if (gameDirection == true) {
					currentPlayer = (currentPlayer -1) % playerNameList.length;
					if (currentPlayer == -1) {
						currentPlayer = playerNameList.length -1;
					}
				}
			}
			if (card.getValue() == Card.Value.Reverse) {
				JLabel msg = new JLabel(pName + " reversed the game direction.");
				GameLogger.log(pName + " reversed the game direction at " + LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
				msg.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, msg);
				
				gameDirection ^= true;
				if (gameDirection == true) {
					currentPlayer = (currentPlayer - 2) % playerNameList.length;
					if (currentPlayer == -1) {
						currentPlayer = playerNameList.length -1;
					}
					if (currentPlayer == -2) {
						currentPlayer = playerNameList.length -2;
					}	
				}
				else if (gameDirection == false) {
					currentPlayer = (currentPlayer + 2) % playerNameList.length;
				}
			}
			
	}
	
	/**
	 * Makes a list of playable cards for bots.
	 * @param playerName
	 * @return
	 */
	public ArrayList<Card> getPlayableCards(String playerName) {
	    ArrayList<Card> playableCards = new ArrayList<>();
	    ArrayList<Card> playerHand = getPlayerHand(playerName);
	    for (Card card : playerHand) {
	        if (validCardPlay(card)) {
	            playableCards.add(card);
	        }
	        if (card.getValue() == Card.Value.Wild || card.getValue() == Card.Value.WildFour) {
				playableCards.add(card);
			}
	    }
	    return playableCards;
	}

	
	/**
	 * Checks the current players turn if it's correct.
	 */
	class InvalidPlayerTurnException extends Exception{
		private String playerName;
		
		public InvalidPlayerTurnException(String message, String playerName) {
			super(message);
			playerName = this.playerName;
		}
		
		public String getPlayerName() {
			return playerName;
		}
	}
	/**
	 * Checks the played cards color if it's valid.
	 */
	class InvalidColorSubmissionException extends Exception{
		public InvalidColorSubmissionException(String message, Card.Color actual, Card.Color expected) {
		}
		
	}
	
	/**
	 * Checks the played cards value if it's valid.
	 */
	class InvalidValueSubmissionException extends Exception{
		public InvalidValueSubmissionException(String message, Card.Value actual, Card.Value expected) {
		}
		
	}
	
	
}