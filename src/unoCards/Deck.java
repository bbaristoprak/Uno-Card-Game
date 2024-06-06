package unoCards;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Deck {
	private Card[] cards;
	public int deckSize;
	
	/**
	 * basic constructor for uno Deck
	 */
	public Deck() {
		cards = new Card[108];
		resetDeck();
	}
	
	/**
	 * inserts the right amount of cards to the deck
	 */
	public void resetDeck() {
		deckSize = 0;
		Card.Color[] colors = Card.Color.values();
		Card.Value[] specialValues = new Card.Value[] {Card.Value.DrawTwo, Card.Value.Skip, Card.Value.Reverse};
		
		for(int colorIterate = 0; colorIterate < colors.length-1; colorIterate++) {
			Card.Color color = colors[colorIterate];
			cards[deckSize++] = new Card(color, Card.Value.getValue(0));
			
			for(int value = 1; value<10; value++) {
				cards[deckSize++] = new Card(color, Card.Value.getValue(value));
				cards[deckSize++] = new Card(color, Card.Value.getValue(value));
			}
			for(Card.Value value : specialValues) {
				cards[deckSize++] = new Card(color, value);
				cards[deckSize++] = new Card(color, value);
			} 
		}
		Card.Value[] wildValues = new Card.Value[] {Card.Value.Wild, Card.Value.WildFour};
		for(Card.Value value : wildValues) {
			for(int count = 0; count < 4; count++) {
				cards[deckSize++] = new Card(Card.Color.Wild, value);
			}
		}
	}
	
	/**
	 * updates the deck based on given input
	 * @param cards
	 */
	public void updateDeck(ArrayList<Card> cards) {
	      this.cards = cards.toArray(new Card[cards.size()]);
	      this.deckSize = this.cards.length;
	}

	/**
	 * checks if the deck is emtpy
	 * @return
	 */
	public boolean isEmpty() {
		return deckSize == 0;
	}

	/**
	 * shuffles the deck
	 */
	public void shuffle() {
		int numOfCards = cards.length;
	    Random random = new Random();
	    for (int i = 0; i < cards.length; i++) {
	        int randomInt = i + random.nextInt(numOfCards - i);
	        Card randomCard = cards[randomInt];
	        cards[randomInt] = cards[i];
	        cards[i] = randomCard;
	    }

	}

	/**
	 * draws a card from the deck, throws IllegalArgumentException if the deck is empty.
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Card drawCard() throws IllegalArgumentException {
	    if (isEmpty()) {
		    throw new IllegalArgumentException("Cannot draw a card since there are no cards in the deck");
	    }
	    return cards[--deckSize];
	}
	
	/**
	 * returns the image of the drawn card
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ImageIcon drawCardImage() throws IllegalArgumentException {
        if(isEmpty()) {
	        throw new IllegalArgumentException("Cannot draw a card since the deck is empty");
	    }
	    return new ImageIcon(cards[--deckSize].toString() + ".png");
	}

	/**
	 * draws multiple cards based on given input
	 * @param drawCount
	 * @return
	 */
	public Card[] drawCard(int drawCount) {
	    if (drawCount < 0) {
	        throw new IllegalArgumentException("Must draw positiive cards but tried to draw " + drawCount + " cards.");
	    }

	    if (drawCount > deckSize) {
	        throw new IllegalArgumentException("Cannot draw " + drawCount + " cards since there are only " + deckSize + " cards.");
	    }
	    Card[] drawedCards = new Card[drawCount];

	    for (int i = 0; i < drawCount; i++) {
	          drawedCards[i] = cards[--deckSize];
	    }
	    return drawedCards;
	}

}
