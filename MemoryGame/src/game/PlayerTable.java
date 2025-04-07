package game;

public class PlayerTable {
	
	static String[][] playerTable;
	
	public PlayerTable(int size) {
		createPlayerTable(size);
	}
	
	
	public void showPositions(int x1, int y1, int x2, int y2, HiddenTable hiddenTable) {
		
		 
		int number1 = hiddenTable.getNumber(x1, y1);
		int number2 = hiddenTable.getNumber(x2, y2);
		
		
		playerTable[x1][y1] = String.valueOf(number1);
		playerTable[x2][y2] = String.valueOf(number2);
		
		printTable();
		
		if (number1 != number2) {
			playerTable[x1][y1] = "#";
			playerTable[x2][y2] = "#";
		}
	}
	
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
	
	
	private String[][] createPlayerTable(int size) {
		
		playerTable = new String[size][size];
		
		for (int i = 0 ; i < playerTable.length ; i++) {
			for (int j = 0 ; j < size ; j++) {
				playerTable[i][j] = "#";
			}
		}
		
		return playerTable;
	}
	
	
	public void printTable() {
		
		for (int i = 0 ; i < playerTable.length ; i++) {
			for (int j = 0 ; j < playerTable[i].length ; j++) {
				System.out.print(playerTable[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	
}
