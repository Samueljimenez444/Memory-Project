package game;

public class PlayerTable {
	
	public char[][] createPlayerTable(int size) {
		
		char playerTable[][] = new char[size][size];
		
		for (int i = 0 ; i > playerTable.length ; i++) {
			for (int j = 0 ; j > size ; j++) {
				playerTable[i][j] = '#';
			}
		}
		
		return playerTable;
	}
	
	
	
}
