package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PlayerTable player;
		HiddenTable table;

		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		int size = 0;
		boolean error;

		do {

			error = false;

			try {

				System.out.println("Introduce the size of a side of the table.");
				size = sc.nextInt();
				sc.nextLine();

				assert size % 2 == 0 && size > 0 : "The number has to be even and higher than zero.\n";

			} catch (AssertionError e) {

				System.out.println(e.getLocalizedMessage());
				error = true;

			}

		} while (error);

		table = new HiddenTable(size);
		player = new PlayerTable(size);

		do {

			System.out.println("Here is your current table.");
			player.printTable();
			System.out.println("\n");

			do {

				error = false;

				try {
					System.out.println("Now introduce the coordinates of the first number you want to reveal.");
					x1 = sc.nextInt();
					sc.nextLine();
					y1 = sc.nextInt();
					sc.nextLine();
					System.out.println();
					System.out.println("Now introduce the coordinates of the second number you want to reveal.");
					x2 = sc.nextInt();
					sc.nextLine();
					y2 = sc.nextInt();
					sc.nextLine();
					System.out.println();

					assert (x1 != x2) || (y1 != y2) : "Coordinates have to be different.\n";

				} catch (AssertionError e) {

					System.out.println(e.getLocalizedMessage());
					error = true;

				}

			} while (error);

			player.showPositions(x1, y1, x2, y2, table);
			System.out.println();

		} while (!player.completedTable());

		System.out.println("¡You won!");

		sc.close();

	}

}
