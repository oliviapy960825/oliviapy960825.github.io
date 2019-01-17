package Solution;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class FlipHorizontal extends TestCase {

	char[][] test_board = {
			{'O','O','X',' ',' ',' '},
			{' ','X','O','O',' ',' '},
			{'X','O',' ','O','X',' '},
			{' ','X','O','X','O',' '},
			{' ',' ','X','X','O',' '},
			{' ',' ','X',' ',' ',' '}
	};
	
	public static void flipHorizontal(char[][] board, int row, int col,
			char symbol, char oppositeSymbol) {
		// We need to check in both directions and stop when we
		// reach a piece of the same symbol
		
		// Maintain a list of columns to change at the given row
		ArrayList<Integer> columnsToChange = new ArrayList<Integer>();
		
		// Check to the right
		int currentCol = col + 1;
		while(currentCol < board[row].length) {
			if (board[row][currentCol] == symbol||board[row][currentCol] == ' ') {
				break;
			}
			else if(board[row][currentCol] == oppositeSymbol) {
				// Add this column to the list if it is the
				// opposite symbol
				columnsToChange.add(currentCol);
			}
			currentCol++;
		}
		
		// Check to the left
		currentCol = col - 1;
		while(currentCol > 0) {
			if (board[row][currentCol] == symbol||board[row][currentCol] == ' ') {
				break;
			}
			else if(board[row][currentCol] == oppositeSymbol) {
				// Add this column to the list if it is the
				// opposite symbol
				columnsToChange.add(currentCol);
			}
			currentCol--;
		}
		
		// Loop through the list of columns, changing the symbol
		for(int i = 0; i < columnsToChange.size(); i++) {
			board[row][columnsToChange.get(i)] = symbol; 
		}
		
	}
	
	
	public void test_flipHorizontal() {
		char[][] board = test_board;
		
		board[1][4] = 'X';
		flipHorizontal(board, 1, 4, 'X', 'O'); // CALL #1
		assertEquals('X', board[1][3]);
		assertEquals('X', board[1][2]);

		board[3][0] = 'O';
		flipHorizontal(board, 3, 0, 'O', 'X'); // CALL #2
		assertEquals('O', board[3][1]);

		board[2][2] = 'X';
		flipHorizontal(board, 2, 2, 'X', 'O'); // CALL #3
		assertEquals('X', board[2][1]);
		assertEquals('X', board[2][3]);
	}
}
