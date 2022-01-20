package com.revature.stacklite.ui;

import java.util.Scanner;

import com.revature.stacklite.bl.IIssueBL;
import com.revature.stacklite.models.Issue;

/**
 * Class to present UI to end users to interact with program
 * 
 * @author MarielleNolasco
 *
 */
public class MainMenu {
	// the scanner is very important to a UI
	// declare it as a dependency
	private Scanner myscanner;
	private IIssueBL issueBL;
	// inject this dep via constructor
	public MainMenu(Scanner myscanner, IIssueBL issueBL) {
		this.myscanner = myscanner;
		this.issueBL = issueBL;
	}

	public void start() {
		// method signature : access modifier*, non access modifier*, return type,
		// methodName, (arguments), throws exceptions*
		boolean keepGoing = true;
		do {
			System.out.println("Welcome to Stacklite, what do you wanna do?");
			System.out.println("[0] Create an issue");
			System.out.println("[1] Get all issues");
			System.out.println("[x] Exit");

			String userInput = myscanner.nextLine();
			switch (userInput) {
			case "0": 
				System.out.println("Creating an issue");
				createIssue();
				break;
			case "1":
				System.out.println("Getting issues..");
				getIssues();
				break;
			case "x":
				System.out.println("Goodbye");
				keepGoing = false;
				break;
			default:
				System.out.println("Sorry wrong input, please try again");
				break;
			}

		} while (keepGoing);

	}

	private void getIssues() {
		// TODO Auto-generated method stub
		for(Issue issue:issueBL.getIssues())
		{
			System.out.println(issue);
		}
	}

	private void createIssue() {
		// TODO Auto-generated method stub
		System.out.println("Enter a title for your issue: ");
		String title = myscanner.nextLine();
		System.out.println("Enter a description for your issue: ");
		String description = myscanner.nextLine();
		Issue newIssue = new Issue(title, description);
		// saving to storage
		issueBL.addIssue(newIssue);
		System.out.println(newIssue);
	}
}
