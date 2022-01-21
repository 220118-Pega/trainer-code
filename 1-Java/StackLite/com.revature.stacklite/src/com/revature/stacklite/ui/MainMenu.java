package com.revature.stacklite.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.stacklite.bl.IIssueBL;
import com.revature.stacklite.models.Issue;
import com.revature.stacklite.models.Solution;

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
	
	// Set up logging
	// You configure a logger per class so you have more flexibility in 
	// configuring your logs
	private final Logger logger = LogManager.getLogger(this.getClass());
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
			System.out.println("[2] View issue with proposed solution");
			System.out.println("[3] Add proposed solution to issue");
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
			case "2":
				getSpecificIssue();
				break;
			case "3":
				addSolution();
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

	private void addSolution() {
		// TODO Auto-generated method stub
		System.out.println("Enter the id of the issue you'd like to add a solution to: ");
		String stringId = myscanner.nextLine();
		System.out.println("Enter the answer to your proposed solution");
		String answer = myscanner.nextLine();
		Solution newSolution = new Solution(answer);
		logger.debug(answer);
		try {
			logger.info("Adding solution");
			newSolution.setIssueId(Integer.parseInt(stringId));
			issueBL.addSolution(newSolution);
		} catch (NumberFormatException ex) {
			System.out.println("Please only enter numerics");
			logger.error("Invalid user input");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No such issue found, try another id");
			logger.error("Issue not found");
		}
	}

	private void getSpecificIssue() {
		// TODO Auto-generated method stub
		System.out.println("Enter the id of the issue you'd like to view the solutions for: ");
		String stringId = myscanner.nextLine();
		// Integer.parseInt() is a method used to parse strings to integers
		Issue foundIssue;
		try {
			foundIssue = issueBL.getIssueById(Integer.parseInt(stringId));
			System.out.println(foundIssue);
			for (Solution solution : foundIssue.getSolutions()) {
				System.out.println(solution);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			System.out.println("Please only enter numerics");
			logger.error("Invalid user input");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("No such issue found, try another id");
			logger.error("Issue not found");
		}

	}

	private void getIssues() {
		// TODO Auto-generated method stub
		for (Issue issue : issueBL.getIssues()) {
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
