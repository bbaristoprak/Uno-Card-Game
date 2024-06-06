package mainPages;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

import gameManager.Game;
import loginSignup.User;
import unoCards.Card;
import java.awt.event.ActionEvent;

public class PopUp extends JFrame{
	
	protected Game game;
	private ArrayList<Card> playerHand;
	protected GameStage gameStage;
	protected JButton topCardButton;
	protected Card.Color declaredColor;
	
	/**
	 * initializes the popup screen when clicked on a card to play, takes all the needed information to perform the submitting.
	 * @param cardName
	 * @param game
	 * @param index
	 * @param cardButtons
	 * @param gameStage
	 * @param topCardButton
	 * @param user
	 */
	public PopUp(String cardName, Game game, int index, ArrayList<JButton> cardButtons, GameStage gameStage, JButton topCardButton, User user) {
		
		this.game = game;
		playerHand = game.getPlayerHand(game.getCurrentPlayer());
		this.gameStage = gameStage;
		this.topCardButton = topCardButton;
		PopUp popUp = this;
		
		JLabel cardLabel = new JLabel();
		cardLabel.setBounds(24, 24, 250, 335);
		getContentPane().add(cardLabel);
		cardLabel.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+cardName + ".png").getImage().getScaledInstance(cardLabel.getWidth(), cardLabel.getHeight(), Image.SCALE_SMOOTH)));
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);
		setResizable(false);
		this.setVisible(true);
		
		JButton useCardButton = new JButton("Play Card");
		useCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean didSubmit = false;
				if (playerHand.get(index).getColor() == Card.Color.Wild) {
		            PickColorFrame pickColor = new PickColorFrame(popUp);
		            declaredColor = pickColor.chooseColor(playerHand.get(index));

		            if (declaredColor != null) {
		                try {
		                    game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(index), declaredColor);
		                } catch (Exception e2) {
		                    e2.printStackTrace();
		                }
		                revalidate();
		            }
		        } else {
		            declaredColor = playerHand.get(index).getColor();
		            try {
		                game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(index), declaredColor);
		                didSubmit = true;
		            } catch (Exception e2) {
		                
		            }
		            revalidate();
		        }

		        gameStage.setPlayerName(game.getCurrentPlayer());
		        gameStage.setButtonIcons();
		        if(didSubmit == true) {
		        	topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+cardName + ".png").getImage().getScaledInstance(topCardButton.getWidth(), topCardButton.getHeight(), Image.SCALE_SMOOTH)));

		        }
		        dispose();
					}
				
			
		});
		useCardButton.setFont(new Font("Arial", Font.PLAIN, 18));
		useCardButton.setBounds(6, 369, 117, 80);
		getContentPane().add(useCardButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Arial", Font.PLAIN, 18));
		cancelButton.setBounds(177, 369, 117, 80);
		getContentPane().add(cancelButton);
		
	}
	
}
