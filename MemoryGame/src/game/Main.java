package game;

import java.util.Scanner;

/**
 * The main class that runs the game.
 * It manages the game flow, including receiving user input and updating the player's game state.
 */
public class Main {

    /**
     * The entry point of the program.
     * It handles the input of the table size and coordinates, initializes the game tables,
     * and manages the gameplay loop.
     * 
     * @param args the command-line arguments (not used)
     */
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

        // Request and validate the size of the table
        do {

            error = false;

            try {

                System.out.println("Introduce the size of a side of the table.");
                size = sc.nextInt();
                sc.nextLine();

                // Assert that the size is even and greater than zero
                assert size % 2 == 0 && size > 0 : "The number has to be even and higher than zero.\n";

            } catch (AssertionError e) {

                System.out.println(e.getLocalizedMessage());
                error = true;

            }

        } while (error);

        // Initialize the hidden and player tables
        table = new HiddenTable(size);
        player = new PlayerTable(size);

        // Main game loop
        do {

            System.out.println("Here is your current table.");
            System.out.println(player);
            System.out.println("\n");

            do {

                error = false;

                try {
                    // Request coordinates for the first number to reveal
                    System.out.println("Now introduce the coordinates of the first number you want to reveal.");
                    x1 = sc.nextInt();
                    sc.nextLine();
                    y1 = sc.nextInt();
                    sc.nextLine();

                    // Request coordinates for the second number to reveal
                    System.out.println("Now introduce the coordinates of the second number you want to reveal.");
                    x2 = sc.nextInt();
                    sc.nextLine();
                    y2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println();

                    // Assert that the coordinates are different
                    assert (x1 != x2) || (y1 != y2) : "Coordinates have to be different.\n";

                } catch (AssertionError e) {

                    System.out.println(e.getLocalizedMessage());
                    error = true;

                }

            } while (error);

            // Reveal the numbers at the given coordinates
            player.cluePositions(x1, y1, x2, y2, table);
            System.out.println(player);

            // Check if the player's guess was correct; if not, hide the numbers again
            if (!player.verificatePlay(x1, y1, x2, y2, table)) {
                player.hideAgain(x1, y1, x2, y2);
            }
            System.out.println();

        } while (!player.completedTable()); // Continue until the table is fully completed

        // Print the victory message
        System.out.println("¡You won!");

        // Close the scanner to prevent resource leakage
        sc.close();
    }

}
