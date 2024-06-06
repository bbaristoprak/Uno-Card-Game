package mainPages;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import unoCards.Card;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PickColorFrame extends JFrame{
	
	private Card.Color wildColor = null;
	Boolean allow = false;
	PopUp popUp;
	
	/**
	 * initializes the popup screen when a wildcard is played to select a color
	 * @param popUp
	 */
	public PickColorFrame(PopUp popUp) {
		this.popUp = popUp;
		getContentPane().setLayout(null);
		
		JLabel pickLabel = new JLabel("Pick a Color!");
		pickLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		pickLabel.setBounds(64, 6, 177, 52);
		getContentPane().add(pickLabel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JButton redButton = new JButton("RED");
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wildColor = Card.Color.Red;
				JLabel message = new JLabel("Wild Card Color is Red");
				message.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, message);
				allow = true;
				dispose();
				popUp.declaredColor = Card.Color.Red;
				popUp.gameStage.setPlayerName(popUp.game.getCurrentPlayer());
				popUp.gameStage.setButtonIcons();
				popUp.topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+popUp.game.getTopImage()).getImage().getScaledInstance(popUp.topCardButton.getWidth(), popUp.topCardButton.getHeight(), Image.SCALE_SMOOTH)));
				popUp.game.setCardColor(Card.Color.Red);
				popUp.dispose();
			}
		});
		redButton.setForeground(Color.RED);
		redButton.setFont(new Font("Arial", Font.PLAIN, 20));
		redButton.setBounds(87, 125, 117, 52);
		getContentPane().add(redButton);
		
		JButton blueButton = new JButton("BLUE");
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wildColor = Card.Color.Blue;
				JLabel message = new JLabel("Wild Card Color is Blue");
				message.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, message);
				allow = true;
				dispose();
				popUp.declaredColor = Card.Color.Blue;
				popUp.gameStage.setPlayerName(popUp.game.getCurrentPlayer());
				popUp.gameStage.setButtonIcons();
				popUp.topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+popUp.game.getTopImage()).getImage().getScaledInstance(popUp.topCardButton.getWidth(), popUp.topCardButton.getHeight(), Image.SCALE_SMOOTH)));
				popUp.game.setCardColor(Card.Color.Blue);
				popUp.dispose();
			}
		});
		blueButton.setForeground(Color.BLUE);
		blueButton.setFont(new Font("Arial", Font.PLAIN, 20));
		blueButton.setBounds(87, 189, 117, 52);
		getContentPane().add(blueButton);
		
		JButton greenButton = new JButton("GREEN");
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wildColor = Card.Color.Green;
				JLabel message = new JLabel("Wild Card Color is Green");
				message.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, message);
				allow = true;
				dispose();
				popUp.declaredColor = Card.Color.Green;
				popUp.gameStage.setPlayerName(popUp.game.getCurrentPlayer());
				popUp.gameStage.setButtonIcons();
				popUp.topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+popUp.game.getTopImage()).getImage().getScaledInstance(popUp.topCardButton.getWidth(), popUp.topCardButton.getHeight(), Image.SCALE_SMOOTH)));
				popUp.game.setCardColor(Card.Color.Green);
				popUp.dispose();
			}
		});
		greenButton.setForeground(Color.GREEN);
		greenButton.setFont(new Font("Arial", Font.PLAIN, 20));
		greenButton.setBounds(87, 253, 117, 52);
		getContentPane().add(greenButton);
		
		JButton yellowButton = new JButton("YELLOW");
		yellowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wildColor = Card.Color.Yellow;
				JLabel message = new JLabel("Wild Card Color is Yellow");
				message.setFont(new Font("Arial", Font.BOLD, 48));
				JOptionPane.showMessageDialog(null, message);
				allow = true;
				dispose();
				popUp.declaredColor = Card.Color.Yellow;
				popUp.gameStage.setPlayerName(popUp.game.getCurrentPlayer());
				popUp.gameStage.setButtonIcons();
				popUp.topCardButton.setIcon(new ImageIcon(new ImageIcon("/Users/baris/eclipse-workspace/UnoCardGame/src/images/"+popUp.game.getTopImage()).getImage().getScaledInstance(popUp.topCardButton.getWidth(), popUp.topCardButton.getHeight(), Image.SCALE_SMOOTH)));
				popUp.game.setCardColor(Card.Color.Yellow);
				popUp.dispose();
			}
		});
		yellowButton.setForeground(Color.YELLOW);
		yellowButton.setFont(new Font("Arial", Font.PLAIN, 20));
		yellowButton.setBounds(87, 317, 117, 52);
		getContentPane().add(yellowButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);
		setResizable(false);
		this.setVisible(true);
	}
	
	public Card.Color chooseColor(Card card){
		if (card.getColor() == Card.Color.Wild) {
			setVisible(true);
			setResizable(false);
			setBounds(100,150,300,500);
		}
		return card.getColor();
	}
	

}
