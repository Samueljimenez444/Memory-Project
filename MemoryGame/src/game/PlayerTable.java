package game;

public class PlayerTable {
	
	/**
	 * The board that the player interacts with
	 * It is a 2D array of strings representing the player's game board
	 */
	static String[][] playerTable;
	
	
	/**
	 * Constructor for the PlayerTable class
	 * It initializes the playerTable with a given size
	 * 
	 * @param size The size of the player table (the number of rows and columns)
	 */
	public PlayerTable(int size) {
		createPlayerTable(size);
	}
	
	
	/**
	 * Displays the values of two positions on the board and updates the player table accordingly
	 * If the values at the given positions do not match, they are reset to "#" and the table is printed again
	 * 
	 * @param x1 The row index of the first position to reveal
	 * @param y1 The column index of the first position to reveal
	 * @param x2 The row index of the second position to reveal
	 * @param y2 The column index of the second position to reveal
	 */
	public void showPositions(int x1, int y1, int x2, int y2) {
		
		int number1 = HiddenTable.getNumber(x1, y1);
		int number2 = HiddenTable.getNumber(x2, y2);
		
		playerTable[x1][y1] = String.valueOf(number1);
		playerTable[x2][y2] = String.valueOf(number2);
		
		System.out.println(playerTable);
		
		if (number1 != number2) {
			playerTable[x1][y1] = "#";
			playerTable[x2][y2] = "#";
			System.out.println(playerTable);
		}
	}
	
	
	/**
	 * Creates and initializes the player table with a specified size
	 * Each position in the table is initially set to "#", indicating an unknown value
	 * 
	 * @param size The size of the player table (the number of rows and columns)
	 * @return The initialized player table
	 */
	private String[][] createPlayerTable(int size) {
		
		playerTable = new String[size][size];
		
		for (int i = 0; i < playerTable.length; i++) {
			for (int j = 0; j < size; j++) {
				playerTable[i][j] = "#";
			}
		}
		
		return playerTable;
	}
	
	
	/**
	 * Returns a string representation of the playerTable array
	 * This method iterates through the 2D array `playerTable`, appending each element's value (as a string) to the result
	 * Each row is separated by a newline character, and the columns within a row are separated by a tab character
	 * The returned string provides a visual representation of the structure of the `playerTable` array
	 *
	 * @return A string representing the contents of the `playerTable` array
	 */
	public String toString() {
	    String res = "";
	    
	    for (int i = 0; i < playerTable.length; i++) {
	        for (int j = 0; j < playerTable[i].length; j++) {
	            res += "playerTable[i][j]" + "\t";
	        }
	        res += "\n";
	    }
	    
	    return res;
	}

}

