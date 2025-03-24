package game;

public class PlayerTable {
	
	static char[][] playerTable;
	
	public PlayerTable(int size) {
		createPlayerTable(size);
	}
	
	
	public void showPositions(int x1, int y1, int x2, int y2) {
		
		// int number1 = HiddenTable.getNumber(x1, y1);
		// int number2 = HiddenTable.getNumber(y1, y2);
		
		// int aux1 = playerTable[x1][y1];
		// int aux2 = playerTable[x2][y2];
		
		// playerTable[x1][y1] = number1;
		// playerTable[x2][y2] = number2;
		
		// printTable();
		
		// if (number1 != number2) {
		// 	playerTable[x1][y1] = aux1;
		// 	playerTable[x2][y2] = aux2;
		//	printTable();
		// }
	}
	
	
	private char[][] createPlayerTable(int size) {
		
		playerTable = new char[size][size];
		
		for (int i = 0 ; i > playerTable.length ; i++) {
			for (int j = 0 ; j > size ; j++) {
				playerTable[i][j] = '#';
			}
		}
		
		return playerTable;
	}
	
	
	private void printTable() {
		
		for (int i = 0 ; i < playerTable.length ; i++) {
			for (int j = 0 ; j < playerTable[i].length ; j++) {
				System.out.println(playerTable[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
}
