package ps6;

import java.util.Arrays;

/**
 * A basic TicTacToe game model that has been modified to allow
 * play on a NxN board. In addition, pieces may be specified to 
 * be empty, x, o, or blocked (neither player can place a piece there).
 * 
 * @author jatlas
 */
public class TicTacToeNxN extends CharBoardGame {
    public static final char X = 'x';
    public static final char O = 'o';
    public static final char B = '#'; // blocked
    
    public TicTacToeNxN(char[][] board) {
        super(board);
    }
        
    /**
     * Gets the maximum sequential times that the given symbol appears
     * in a linear iteration of the board. Starts at row, column and iterates by
     * dr, dc each loop iteration as long as row, column are within
     * bounds. 
     */
    public int getMaxSequence(int row, int column, int dr, int dc, char symbol) {
        // You must complete this method
    	char[][] map = this.board;
        int maxRow = map.length - 1;
        int maxCol = map[0].length - 1;
        int max = 0;
        int count = 0;
        if (dr == 0 && dc == 1) {
            for (int i = column; i <= maxCol; i++) {
                if (map[row][i] == symbol) {
                    count++;
                } 
                else {
                    count = 0;
                }
                max = Math.max(max, count);
            }

        } 
        else if (dr == 1 && dc == 0) {
            for (int i = row; i <= maxRow; i++) {
                if (map[i][column] == symbol) {
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(count, max);
            }

        } 
        else if (dr == 1 && dc == 1) {
            for (int i = row, j = column; i <= maxRow && j <= maxCol; i++, j++) {
                if (map[i][j] == symbol) {
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }

        } else {
            for (int i = row, j = column; i <= maxRow && j >= 0; i++, j--) {
                if (map[i][j] == symbol) {
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }


    
    /**
     * Gets the score for the given symbol in the board. The score is
     * the max value from all results returned from calling getMaxSequence
     * for each unique left-to-right, top-to-bottom, down-right-diagonal, 
     * and down-left-diagonal path.
     * 
     * Technically we shouldn't check all of the diagonals but it won't hurt
     * because we are just finding a max.
     */
    public int getScore(char symbol) {
        int maxScore = 0;
        // assumes the board is a square
        for (int i = 0; i < board.length; i++) {
            // check the row indicated by i
            maxScore = Math.max(maxScore, getMaxSequence(i, 0, 0, 1, symbol));
            // check the column indicated by i
            maxScore = Math.max(maxScore, getMaxSequence(0, i, 1, 0, symbol));
            // check the left-to-right diagonals indicated by i
            maxScore = Math.max(maxScore, getMaxSequence(i, 0, 1, 1, symbol));
            maxScore = Math.max(maxScore, getMaxSequence(0, i, 1, 1, symbol));
            // check the right-to-left diagonals indicated by i
            maxScore = Math.max(maxScore, getMaxSequence(i, 0, 1, -1, symbol));
            maxScore = Math.max(maxScore, getMaxSequence(i, board.length-1, 1, -1, symbol));
        }
        return maxScore;
    }
    
    public static TicTacToeNxN makeStartGame(int n) {
        // creates a starting board
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, E);
        }
        if (n > 4) {
            board[n/2][n/2] = B; // center square in NxN > 4 is blocked
        }
        return new TicTacToeNxN(board);
    }
}
