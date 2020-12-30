/*
 * This is a class called Card which specifies the card number, the card 
 * suite, and the card name.
 */
public class Card {

	private int cardNo;
	private String cardSuite;
	private String cardName = null;

	/*
	 * Constructor that initializes the card number and card suite.
	 */
	public Card() {
		cardNo = 0;
		cardSuite = "";
	}

	/*
	 * Getter method for card number
	 */
	public int getcardNo() {
		return cardNo;
	}

	/**
	 * Setter method for card number where King, Queen and Jack all have card
	 * numbers of 10. Ace has card number of only 1.
	 * 
	 * @param cardNo
	 */
	public void setcardNo(int cardNo) {
		setcardName(cardNo);
		this.cardNo = cardNo > 10 ? 10 : cardNo;
	}

	/*
	 * Getter method for card suite
	 */
	public String getcardSuite() {
		return cardSuite;
	}

	/**
	 * Setter method for card suite
	 * 
	 * @param cardSuite
	 */
	public void setcardSuite(String cardSuite) {
		this.cardSuite = cardSuite;
	}

	/*
	 * Public method to print the card in the correct format. eg. 2 of Hearts
	 */
	public String toString() {
		String s = this.cardName + " of " + this.cardSuite;
		return s;
	}

	/*
	 * Getter method for card name
	 */
	public String getcardName() {
		return this.cardName;
	}

	/**
	 * Setter method for the card name
	 * 
	 * @param cardNo
	 */
	private void setcardName(int cardNo) {
		switch (cardNo) {
		case 1:
			cardName = "A";
			break;
		case 11:
			cardName = "J";
			break;
		case 12:
			cardName = "Q";
			break;
		case 13:
			cardName = "K";
			break;
		default:
			cardName = Integer.toString(cardNo);
			break;
		}
	}
}
