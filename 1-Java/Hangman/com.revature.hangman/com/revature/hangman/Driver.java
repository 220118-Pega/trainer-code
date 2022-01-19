package com.revature.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// Use scanner to read console to get user input via console
		// needs a input stream, in this case we use the System.in, which is the console
		Scanner myScanner = new Scanner(System.in);
		// Everytime you guess wrong, a body part gets added to the noose
		int bodyParts = 6;
		// Just asks for user input
		System.out.println("Enter word to be guessed: ");
		// Gets user input
		String mysteryWord = myScanner.nextLine();
		List<String> correctlyGuessedLetters = new ArrayList<String>();
		// To print current guess state, since we're removing letters from mystery word
		String originalWord = mysteryWord;

		while (bodyParts > 0) {
			// guessing part of the game
			// ask player for a letter they think is in the mystery word
			System.out.println("Guess a letter in the word: ");
			String guessedLetter = myScanner.nextLine();

			// Use if else block to specify what to print out if a player correctly guesses
			// a letter in the word
			if (mysteryWord.contains(guessedLetter)) {
				// What you do if the mysteryWord contains the letter you guessed
				// if mysteryWord.contains(guessedLetter) returns true
				System.out.println(mysteryWord.contains(guessedLetter));
				System.out.println("the word contains " + guessedLetter);
				// "Remove" all correctly guessed letters 
				mysteryWord = mysteryWord.replaceAll(guessedLetter, "");
				// Add all my correctly guessed letters to a collection
				correctlyGuessedLetters.add(guessedLetter);

			} else {
				// This is what you do when the mystery word does not contain the letter you
				// guessed
				// if mysteryWord.contains(guessedLetter) returns false
				System.out.println(mysteryWord.contains(guessedLetter));
				System.out.println("the word does not contain " + guessedLetter);
				// Decrement the bodyParts. (i.e. add a body part to the noose
				bodyParts--;
			}
			System.out.println("How the guessing is going: ");
			//print the current state of my mystery word
			// use the wrapper class Character instead of char primitive, so we can make use of the toString method available to Objects
			// primitives don't have access to certain object methods, we use wrapper classes to "wrap" around primitive data types 
			// to be able to treat them like objects 
			for(Character letter:originalWord.toCharArray())
			{
				if(correctlyGuessedLetters.contains(letter.toString()))
				{
					System.out.print(letter);
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
			if(mysteryWord.length() == 0) {
				System.out.println("Congratulations you've guessed all the letters in the word");
				break;
			}
		}
		if(bodyParts == 0)
		{	//If you run out of chances
			System.out.println("Better luck next time");
		}

	}

}
