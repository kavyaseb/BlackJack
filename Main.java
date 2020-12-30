import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * cs400, p0_JavaIOPractice, Kavya Sebastian, ksebastian3@wisc.edu
 * 
 * This program is a game called Black Jack. The aim of the game is to get cards
 * that add up to the value of 21. The opponent is the dealer and the user wins
 * the game if the card value is higher than the dealer's. Ace has the card 
 * value of 1 only and Jack, Queen and King gave the card values of 10 each. 
 * 
 * @author kavya
 *
 */
public class Main {

	private static final String title = "Kavya ksebastian3@wisc.edu";
	private static final Scanner scn = new Scanner(System.in);

	/*
	 * Main method that reads from an input file, runs the game of Black Jack and
	 * stores the details of the game to an output file.
	 */
	public static void main(String[] args) {
		String str = "";

		System.out.println(title + "\n");

		while (true) {
			try {

				System.out.println("Enter the name of the file: ");
				String line = scn.nextLine();

				File file = new File(line); // input file
				Scanner scn = new Scanner(file);

				while (scn.hasNextLine()) {

					str += scn.nextLine() + "\n";

				}
				System.out.println(str); // printing the contents in the input file to
				// the console
				scn.close();

				File myFile = new File("output.txt");
				myFile.createNewFile(); // creating an output file
				FileWriter myFileWriter = new FileWriter("output.txt");
				PlayingCards p = new PlayingCards(); // creating an instance of playingCards
				p.driver();
				myFileWriter.write(str); // printing input file's contents to the output
				// file
				myFileWriter.write("Name: " + p.getuserName() + "\n");

				myFileWriter.write(
						p.getuserName() + "'s Score: " + p.getuserWinCount() + "\n");
				myFileWriter.write("Dealer's Score: " + p.getdealerWinCount() + "\n");
				myFileWriter
				.write("Thank you for playing in " + "SEBASTIAN'S CASINO!\n");
				myFileWriter.close();
				break;
			} catch (IllegalArgumentException a) {
				System.out.println("Enter the correct file name: " + a.getMessage());
			} catch (FileNotFoundException f) {
				System.out.println("Error encountered1: " + f.getMessage());
			} catch (IOException i) {
				System.out.println("Error encountered2: " + i.getMessage());
			} catch (Exception e) {
				System.out.println("Error encountered3: " + e.getMessage());
			}
		}
	}
}
