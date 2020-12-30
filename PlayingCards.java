import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * This is the class PlayingCards where cards are displayed and the card 
 * numbers are added to a total value till the user stops or it goes
 * bust or the user gets Black Jack. The dealer also gets a total value and is
 * compared with the user and is added to a score.
 */
public class PlayingCards {
	private static final Scanner scn = new Scanner(System.in);

	private static Card[] deck;
	private static int userWinCount = 0;
	private static int dealerWinCount = 0;
	private static String userName = null;

	/*
	 * Constructor which stores each of the cards' numbers and suites respectively
	 * to a deck.
	 */
	public PlayingCards() {
		deck = new Card[52];
		for (int i = 0; i < 52; i++) {
			deck[i] = new Card();
			switch (i / 13) {
			case 0:
				deck[i].setcardNo((i % 13) + 1);
				deck[i].setcardSuite("Spades");
				break;
			case 1:
				deck[i].setcardNo((i % 13) + 1);
				deck[i].setcardSuite("Clubs");
				break;
			case 2:
				deck[i].setcardNo((i % 13) + 1);
				deck[i].setcardSuite("Hearts");
				break;
			case 3:
				deck[i].setcardNo((i % 13) + 1);
				deck[i].setcardSuite("Diamonds");
				break;
			}
		}

	}

	/*
	 * Private method helper to shuffle the cards without repetition
	 */
	private static void shuffle() {
		List<Card> cardList = Arrays.asList(deck);
		Collections.shuffle(cardList);
		cardList.toArray(deck);

	}

	/*
	 * Private method that deals the cards systematically when requested. It stops
	 * if the card count reaches 21 or more.
	 */
	private static void deal() {
		shuffle();
		int k = 0;
		String str = "y";
		int userCardCount = 0;
		int dealerCardCount = 0;

		Card[] userTmpArr = new Card[10];

		System.out.println("\n" + userName + " :"); // user's turn to play
		System.out.print(deck[k].toString() + "\t"); // user starts with two cards
		// in their hand
		userTmpArr[k] = deck[k]; // stores the cards in the user's hand to an array
		userCardCount += deck[k++].getcardNo();
		System.out.print(deck[k].toString() + "\t");
		userTmpArr[k] = deck[k];
		userCardCount += deck[k++].getcardNo();
		System.out.println("Total: " + userCardCount);

		if (userCardCount > 21) {
			System.out.println("BUSTED!");

		} else if (userCardCount == 21) {
			System.out.println("BLACK JACK!");

		}

		else {
			System.out.println("If you want to continue, enter (y/Y): "); // user
			// continues till they decide to stop or if they go bust or black jack
			str = scn.nextLine();
			while (str.equals("y") || str.equals("Y")) {
				userTmpArr[k] = deck[k];

				for (int i = 0; i <= k; i++) {
					System.out.print(userTmpArr[i].toString() + "\t"); // prints the
					// user's hand each time
				}
				userCardCount += deck[k++].getcardNo();
				System.out.println("Total: " + userCardCount);

				if (userCardCount > 21) {
					System.out.println("BUSTED!");
					userCardCount = 0;
					break;
				}
				if (userCardCount == 21) {
					System.out.println("IT'S A BLACK JACK!");
					break;
				}
				System.out.println("Do you want to continue(y/Y)?: ");
				str = scn.nextLine();
			}
		}

		System.out.println("Dealer:"); // dealer's turn to play
		while (true) {
			if (dealerCardCount >= 17 && dealerCardCount < 21) { // stops the in
				// flow of cards after the count reaches 17
				System.out.println("Total: " + dealerCardCount);
				break;
			} else if (dealerCardCount > 21) {
				System.out.println("Total: " + dealerCardCount);
				System.out.println("BUSTED!");
				dealerCardCount = 0;
				break;
			} else if (dealerCardCount == 21) {
				System.out.println("Total: " + dealerCardCount);
				System.out.println("IT'S A BLACK JACK!");
				break;
			} else {
				System.out.print(deck[k].toString() + "\t");
				dealerCardCount += deck[k++].getcardNo();
			}
		}

		if (userCardCount > dealerCardCount) { // determining the winner based on
			// the addition of the cards in both hands
			System.out.println("YOU ARE THE WINNER!");
			userWinCount++;
			System.out.println(
					userName + "=" + userWinCount + "\tDealer=" + dealerWinCount);

		} else if (userCardCount == dealerCardCount) {
			System.out.println("IT'S A TIE!");
			System.out.println(
					userName + "=" + userWinCount + "\tDealer=" + dealerWinCount);
		} else {
			System.out.println("YOU LOST! BETTER LUCK NEXT TIME");
			dealerWinCount++;
			System.out.println(
					userName + "=" + userWinCount + "\tDealer=" + dealerWinCount);
		}
	}

	/*
	 * Public method that interacts with the user and allows the user to play the
	 * game again or exit the program
	 */
	public void driver() {
		String str = "y";

		System.out.println("Enter your name: ");
		userName = scn.nextLine();
		if (userName.isEmpty()) {
			userName = "Player";
		}

		do {
			deal(); // calls the method to play the game again
			System.out.println("Do you want to play again? ");
			System.out.println("Enter (y/Y) for yes: ");
			str = scn.nextLine();
		} while (str.contentEquals("y") || str.contentEquals("Y"));
		System.out.println("Thank you for playing in SEBASTIAN'S CASINO!");
		return;
	}

	/*
	 * Getter method for the user's name
	 */
	public String getuserName() {
		return PlayingCards.userName;
	}

	/*
	 * Getter method for the number of games the dealer has won
	 */
	public int getdealerWinCount() {
		return PlayingCards.dealerWinCount;
	}

	/*
	 * Getter method for the number of games the user has won
	 */
	public int getuserWinCount() {
		return PlayingCards.userWinCount;
	}
}
