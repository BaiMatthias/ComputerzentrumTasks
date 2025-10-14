/**
 * 
 * Hangman for Computerzentrum Strausberg
 * 
 * @author Matthias Baidinger
 * 
 */

package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		String secretWord = "Computerzentrum";
		List<String> usedLetters = new ArrayList<String>();
		int tries = 10;
		String placeholder = "_".repeat(secretWord.length());
		boolean isSolved = false;
		Scanner sc = new Scanner(System.in);
		
		while(!isSolved) {
			
			printProgress(tries, placeholder, usedLetters);
			String guess = readLetter(sc);
			tries--;
			usedLetters.add(guess);
			if(secretWord.toLowerCase().contains(guess)) {
				placeholder = replaceLetters(placeholder, findIndices(secretWord, guess), guess);
				if(isWordSolved(secretWord, placeholder)) {
					isSolved = true;
					break;
				}
				printCorrectGuess(guess, placeholder);
				
			} else printWrongGuess(guess);
			Boolean solvedWord = solveSecretWord(secretWord, sc);
			if(Boolean.TRUE.equals(solvedWord)) {
				isSolved = true;
			}
			else if(Boolean.FALSE.equals(solvedWord)) break;
			
		}
			
		printResult(isSolved, tries, secretWord);
		
	}
	
	/**
	 * Reads the user input. The input must consist of a single letter and not be a number or any non-letter character
	 * @param sc Scanner object for reading the user input
	 * @return The user input in lower case
	 */
	public static String readLetter(Scanner sc) {
		String input;
		do {
			System.out.println("Please enter a letter:");
			input = sc.next();
		} while(input.length() != 1 || !Character.isLetter(input.toCharArray()[0]));
		
		
		return input.toLowerCase();
		
	}
	/**
	 * Outputs the current progress regarding remaining attempts, already solved letters and
	 * used letters to the console
	 * @param tries The remaining attempts left to solve the secret word
	 * @param placeholder The placeholder word containing all found letters so far
	 * @param usedLetters The letters the user has entered to find the secret word
	 */
	public static void printProgress(int tries, String placeholder, List<String> usedLetters) {
		System.out.println("Remaining attempts: " + tries); 
		System.out.println("You used the following letters: " + String.join(" ", usedLetters));
		System.out.println("Current word: " + placeholder.substring(0,1).toUpperCase() + placeholder.substring(1));
	}
	/**
	 * Outputs a message to the console that the guessed letter is not included in the secret word
	 * @param guess The letter entered by the user
	 */
	public static void printWrongGuess(String guess) {
		System.out.println("The secret word doesn't contain the letter " + guess);
	}
	/**
	 * Outputs a message to the console stating that the entered letter has been found in the secret
	 * word and prints the current progress
	 * @param guess The letter entered by the user
	 * @param placeholder The placeholder word containing all found letters so far
	 */
	public static void printCorrectGuess(String guess, String placeholder) {
		System.out.println("Correct guess. The secret word does contain the letter " + guess);
		System.out.println("Current word: " + placeholder.substring(0,1).toUpperCase() + placeholder.substring(1));
	}
	/**
	 * Finds all indices where the given letter occurs in the secret word
	 * @param secretWord The word to search in
	 * @param input The letter to look for
	 * @return A list of zero based positions where the letter occurs in the secret word.
	 * 		   Can return an empty list if no occurences could be found
	 */
	public static List<Integer> findIndices(String secretWord, String input){
		List<Integer> indices = new ArrayList<Integer>();
		int index = 0;
		while(index != -1) {
			index = secretWord.toLowerCase().indexOf(input, index);
			if (index != -1) {
                indices.add(index);
                index++;
            }
		}
		return indices;
		
	}
	/**
	 * Replaces the placeholder letters in the word with the guessed letter on given zero based indices
	 * @param placeholder The current placeholder string with underscore ( _ ) characters as a substitute for letters
	 * 					  that haven't been found yet
	 * @param indices The zero based positions where the guessed letter should be inserted
	 * @param guess The letter to be inserted
	 * @return A string with the guessed letter inserted at the given indices
	 */
	public static String replaceLetters(String placeholder, List<Integer> indices, String guess) {
		
		StringBuilder sb = new StringBuilder(placeholder);
		for (int index : indices) {
			sb.setCharAt(index, guess.toCharArray()[0]);
		}
		
		return sb.toString();
	}
	/**
	 * Prompts the user to decide whether to solve the secret word directly 
	 * @param secretWord The word to solve
	 * @param sc Scanner object for reading the user input
	 * @return Returns {@code true} if the user input is correct and {@code false} if it's not.
	 *         If the user don't want to solve the word {@code null} is returned
	 */
	public static Boolean solveSecretWord(String secretWord, Scanner sc) {
		String input;
		do {
			System.out.println("Would you like to solve the word? y / n");
			input = sc.next().toLowerCase();
			
		} while (!input.equals("y") && !input.equals("n"));
		
		if(input.equals("y")) {
			System.out.println("Enter word: ");
			if(sc.next().equalsIgnoreCase(secretWord)){
				return Boolean.TRUE;
			} else return Boolean.FALSE;
		}
		return null;
		
	}
	/**
	 * Checks if the secret word has been completely solved
	 * @param secretWord The secret word to be solved
	 * @param placeholder The current placeholder string
	 * @return Returns {@code true} if the word is solved and returns {@code false}
	 *         if the words don't match
	 */
	public static boolean isWordSolved(String secretWord, String placeholder) {
	    return placeholder.equalsIgnoreCase(secretWord);
	}
	/**
	 * Prints the result of the game. Displays a message that the user has won if the word was guessed correctly.
	 * Displays a message that the has lost otherwise with the correct secret word
	 * @param isSolved  Whether the word was solved or not
	 * @param tries The number of remaining attempts
	 * @param secretWord The secret word that had to be guessed
	 */
	public static void printResult(boolean isSolved, int tries, String secretWord) {
		if (isSolved) {
	        System.out.println("You guessed the word correctly. It took you " + (10 - tries) + " attempts");
	    } else {
	        System.out.println("Too bad. You lost. The secret word was " + secretWord);
	    }
	}

}
