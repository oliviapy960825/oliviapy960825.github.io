package Solution;

import junit.framework.TestCase;

public class Checkers extends TestCase {
	
	char[][] board1 = {{'r',' ','r',' '},
					   {' ',' ',' ',' '},
					   {' ',' ',' ',' '},
					   {' ','b',' ','b'}};
	
	char[][] board2 = {{' ',' ','r',' '},
			   		   {' ','r',' ',' '},
			   		   {' ',' ','b',' '},
			   		   {' ',' ',' ','b'}};
	
	char[][] board3 = {{' ',' ',' ',' '},
			   		   {' ','R',' ','B'},
			   		   {' ',' ',' ',' '},
			   		   {' ',' ',' ','b'}};

	char[][] board4 = {{' ','R',' ',' '},
	   		   	   	   {'r',' ',' ','B'},
	   		   	   	   {' ',' ',' ',' '},
	   		   	   	   {' ',' ',' ','b'}};
	/**
	 * Score Rubric
	 * 1-3 pts = point per pawn depending on row
	 * 4 pts = per kings
	 * 
	 * @param board
	 * @return
	 */
	public int score(char[][] board) {
		int totalScore = 0;
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 'r') {
					switch(row) {
						case 0:
							totalScore += 1;
							break;
						case 1:
							totalScore += 2;
							break;
						case 2:
							totalScore += 3;
							break;
					}
				}
				else if (board[row][col] == 'R') {
					totalScore += 4;
				}
			}
		}
		
		return totalScore;
	}
	
	public void test_Score() {
		assertTrue(score(board1) < score(board2));
		assertTrue(score(board2) < score(board3));
		assertTrue(score(board3) < score(board4));
	}

}
