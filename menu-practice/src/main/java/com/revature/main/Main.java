package com.revature.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		loginScreen();

		menu();
		
	}
	
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		String inputUser;
		String inputPass;
		boolean correct = false;
		do {
			System.out.println("Please enter your username: ");
			inputUser = scan.nextLine();
			System.out.println("Please enter your password: ");
			inputPass = scan.nextLine();
			
			if(inputUser.equals(username) && inputPass.equals(password)) {
				correct = true;
			} else {
				System.out.println("You have entered the wrong credentials, please try again");
				correct = false;
			}
		} while (correct == false);
	}

	public static void menu() {

		System.out.println("Welcome to the Menu!");
		String choice = "";
		do {

			System.out.println("1. Print a random number!");
			System.out.println("2. Reverse a String!");
			System.out.println("3. Exit");
			System.out.println("Please Choose an Option:");
			choice = scan.nextLine();
			switch(choice) {
			case "1":
				System.out.println("Your random int is: " + (int)(Math.random() * 1000));
				System.out.println();
				break;
			case "2":
				String toBeReversed;
				System.out.println("Please enter your string to be reversed");
				toBeReversed = scan.nextLine();
				StringBuilder sb = new StringBuilder(toBeReversed);
				System.out.println(toBeReversed + " | " + sb.reverse());
				System.out.println();
				
				break;
			case "3":
				break;
			default:
				System.out.println("You have entered an invalid selection please try again");
				System.out.println();
				break;
			}
		} while (!choice.equals("3"));
		
	}
	
	
}
