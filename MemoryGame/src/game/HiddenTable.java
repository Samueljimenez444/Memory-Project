package game;

import java.util.Random;

public class HiddenTable {

    // Random object used for generating random positions
    static Random rand = new Random();
    
    // 2D array representing the hidden table
    static int[][] hiddenTable;
    
    /**
     * Constructs a new HiddenTable with the specified size.
     * Initializes the table by calling the createTable method to randomly place numbers.
     *
     * @param n the size of the table (n x n)
     */
    public HiddenTable(int n) {
        hiddenTable = new int[n][n];
        createTable(n);
    }
    
    /**
     * Returns the 2D array representing the hidden table.
     * This method allows access to the entire table of numbers.
     *
     * @return the 2D array representing the hidden table
     */
    public int[][] getTable() {
        return hiddenTable;
    }

    /**
     * Creates the hidden table by randomly placing each number (1 through n*n/2) twice 
     * at random positions in the table. The table is initially filled with zeros, 
     * and the numbers are placed in empty spots.
     *
     * @param n the size of the table (n x n)
     * @return the generated hidden table
     */
    public int[][] createTable(int n) {
        int posX;
        int posY;

        // Initialize the table with zeros
        for (int i = 0; i < hiddenTable.length; i++) {
            for (int j = 0; j < hiddenTable[0].length; j++) {
                hiddenTable[i][j] = 0;
            }
        }

        // Randomly place each number from 1 to n*n/2 twice
        for (int number = 1; number <= (n * n) / 2; number++) {
            int counter = 0;

            while (counter < 2) {
                posX = rand.nextInt(0, n);
                posY = rand.nextInt(0, n);

                // If the spot is empty (0), place the number
                if (hiddenTable[posX][posY] == 0) {
                    hiddenTable[posX][posY] = number;
                    counter++;
                }
            }
        }

        return hiddenTable;
    }
    
    /**
     * Retrieves the number at the specified position in the hidden table.
     *
     * @param x1 the row index of the position
     * @param y1 the column index of the position
     * @return the number at the specified position
     */
    public int getNumber(int x1, int y1) {
        return hiddenTable[x1][y1];
    }

    /**
     * Returns a string representation of the hidden table.
     * Each row of the table is displayed with tab-separated values.
     *
     * @return a string representation of the hidden table
     */
    @Override
    public String toString() {
        String info = "";
        String number;

        for (int i = 0; i < HiddenTable.hiddenTable.length; i++) {
            for (int j = 0; j < HiddenTable.hiddenTable[0].length; j++) {
                number = String.valueOf(HiddenTable.hiddenTable[i][j]);
                info += (number + "\t");
            }
            info += "\n";
        }

        return info;
    }
}
