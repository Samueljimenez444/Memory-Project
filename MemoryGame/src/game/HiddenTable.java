package game;

import java.util.Random;

public class HiddenTable {

	static Random rand = new Random();
	
	static int[][] hiddenTable;
	
	public HiddenTable(int n) {
		
		hiddenTable = new int[n][n];
		createTable(n);
		
	}
	
	public int[][] getTable() {
		
		return hiddenTable;
		
	}

	public int[][] createTable(int n) {

		int posX;
		int posY;

		for (int i = 0; i < hiddenTable.length; i++) {

			for (int j = 0; j < hiddenTable[0].length; j++) {

				hiddenTable[i][j] = 0;

			}

		}

		for (int number = 1; number <= (n*n) / 2 ; number++) {

			int counter = 0;
			
			while (counter < 2) {

				posX = rand.nextInt(0, n);
				posY = rand.nextInt(0, n);

				if (hiddenTable[posX][posY] == 0) {

					hiddenTable[posX][posY] = number;
					counter++;
					
				}

			}

		}
		 
		return hiddenTable;
	}
	
	public int getNumber(int x1, int y1) {
		
		return hiddenTable[x1][y1];
		
	}
	
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
