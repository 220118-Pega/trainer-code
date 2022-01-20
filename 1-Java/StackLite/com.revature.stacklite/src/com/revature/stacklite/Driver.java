package com.revature.stacklite;

import java.util.Scanner;

import com.revature.stacklite.ui.MainMenu;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// We'll start our app here somewhere
		MainMenu menu = new MainMenu(new Scanner(System.in));
		menu.start();
	}

}
