package game;

import java.util.Scanner;

public class Main {
	public static int tableLength;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String playerName;

		String changeName;

		boolean game = true;

		System.out.println("Welcome to the Memory Game");

		System.out.println("Introduce your Name");
		playerName = sc.nextLine();
		System.out.println("Are you sure you want this name? (yes to keep the name no to change it)");
		changeName = sc.nextLine();
		if (changeName.equals("yes")) {
			System.out.println("Your final name is: " + playerName);
		} else {
			System.out.println("Introduce your new name");
			playerName = sc.nextLine();
		}

		while (game) {

		}
		
		sc.close();
	}

}
