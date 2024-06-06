package unoCards;

public class Card {
	private Color color;
	private Value value;
	
	public enum Value{
		Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Reverse, Skip, Wild, WildFour;
		private static final Value[] values = Value.values();
		public static Value getValue(int index) {
			return Value.values[index];
		}
	}
	public enum Color {
		Red, Yellow, Blue, Green, Wild;
		private static final Color[] colors = Color.values();
		public static Color getColor(int index) {
			return Color.colors[index];
		}
	}
	
	/**
	 * basic constructor for uno Card
	 * @param color
	 * @param value
	 */
	public Card(Color color, Value value){
		this.color = color;
		this.value = value;
	}
	public Color getColor(){
		return this.color;
		}
	public Value getValue() {
		return this.value;}
	
	public String toString() {
		return color + "_" + value;
	}
	/**
	 * returns the numericla value of the card given the card value, this method is required to calculate the scores at the end of the game
	 * @param value
	 * @return
	 */
	public int getNumericValue(Card.Value value) {
        switch (value) {
            case Zero:
                return 0;
            case One:
                return 1;
            case Two:
                return 2;
            case Three:
                return 3;
            case Four:
                return 4;
            case Five:
                return 5;
            case Six:
                return 6;
            case Seven:
                return 7;
            case Eight:
                return 8;
            case Nine:
                return 9;
            case DrawTwo:
            case Skip:
            case Reverse:
                return 20;
            case WildFour:
                return 50;
            default:
              	return 0;
        }
	
	}
}
