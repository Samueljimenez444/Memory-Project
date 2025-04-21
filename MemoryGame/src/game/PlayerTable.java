package game;

/**
 * This class represents a table that the player interacts with during the game.
 * The table is used to store and track the player's guesses and the state of the hidden table.
 * The player table is initialized with a specific size and is updated as the player makes moves.
 * It provides functionality to reveal clues, verify plays, hide values again, and check if the table is completed.
 */
public class PlayerTable {
    
    // A 2D array to represent the player’s table
    private static String[][] playerTable;
    
    /**
     * Constructs a new PlayerTable with the specified size.
     * Initializes the table with all values set to "#".
     *
     * @param size the size of the table (size x size)
     */
    public PlayerTable(int size) {
        createPlayerTable(size);
    }
    
    /**
     * Reveals the numbers at two positions on the hidden table and updates the player's table.
     * The revealed numbers are stored at the corresponding positions in the player's table.
     *
     * @param x1 the row index of the first position
     * @param y1 the column index of the first position
     * @param x2 the row index of the second position
     * @param y2 the column index of the second position
     * @param hiddenTable the hidden table where the actual numbers are stored
     */
    public void cluePositions(int x1, int y1, int x2, int y2, HiddenTable hiddenTable) {
        int number1 = hiddenTable.getNumber(x1, y1);
        int number2 = hiddenTable.getNumber(x2, y2);
        
        playerTable[x1][y1] = String.valueOf(number1);
        playerTable[x2][y2] = String.valueOf(number2);
    }
    
    /**
     * Verifies if the player's guess at two positions matches the hidden values.
     * Returns true if the numbers at the two positions are the same, false otherwise.
     *
     * @param x1 the row index of the first position
     * @param y1 the column index of the first position
     * @param x2 the row index of the second position
     * @param y2 the column index of the second position
     * @param hiddenTable the hidden table used for verification
     * @return true if the values at the two positions match, false otherwise
     */
    public boolean verificatePlay(int x1, int y1, int x2, int y2, HiddenTable hiddenTable) {
        boolean correct = false;
        
        if(hiddenTable.getNumber(x1, y1) == hiddenTable.getNumber(x2, y2)) {
            correct = true;
        }
        
        return correct;
    }
    
    /**
     * Hides the values at the specified positions by resetting them to "#".
     * This is used after the player has made an incorrect guess or to reset the table.
     *
     * @param x1 the row index of the first position
     * @param y1 the column index of the first position
     * @param x2 the row index of the second position
     * @param y2 the column index of the second position
     */
    public void hideAgain(int x1, int y1, int x2, int y2) {
        playerTable[x1][y1] = "#";
        playerTable[x2][y2] = "#";
    }
    
    /**
     * Checks if the player has completed the table by filling all positions.
     * The table is considered completed if there are no "#" characters remaining.
     *
     * @return true if the player has completed the table, false otherwise
     */
    public boolean completedTable() {
        boolean completed = true;
        
        for (int i = 0; i < playerTable.length && completed; i++) {
            for (int j = 0; j < playerTable[0].length && completed; j++) {
                if(playerTable[i][j].equals("#")) {
                    completed = false;
                }
            }
        }
        
        return completed;
    }
    
    /**
     * Creates the player table with the specified size and initializes all positions with "#".
     *
     * @param size the size of the table (size x size)
     */
    private void createPlayerTable(int size) {
        playerTable = new String[size][size];
        
        for (int i = 0 ; i < playerTable.length ; i++) {
            for (int j = 0 ; j < size ; j++) {
                playerTable[i][j] = "#";
            }
        }
    }
    
    /**
     * Returns a string representation of the player table.
     * Each row is displayed with tab-separated values.
     *
     * @return a string representation of the player table
     */
    @Override
    public String toString() {
        String info = "";
        String number;
        
        for (int i = 0; i < PlayerTable.playerTable.length; i++) {
            for (int j = 0; j < PlayerTable.playerTable[0].length; j++) {
                number = String.valueOf(PlayerTable.playerTable[i][j]);
                info += (number + "\t");
            }
            info += "\n";
        }
        
        return info;
    }
}
