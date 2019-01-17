package ps6;

public class Go extends CharBoardGame {
    public static final char B = 'b';
    public static final char W = 'w';
   
    
    private boolean[][] visited;
    
    public Go(char[][] board) {
        super(board);
        this.visited = new boolean[board.length][board[0].length];
     
    }
    
    public void resetVisited() {
        for (boolean[] row : visited) {
            for (int column = 0; column < row.length; column++) {
                row[column] = false;
            }
        }
    }
    
    /**
     * Returns true if the piece at the given row and column has
     * a liberty or is chained with a piece that has a liberty.
     * 
     * @param row
     * @param column
     * @return
     */
    public boolean hasLiberty(int row, int column) {
        resetVisited(); // clears the visited structure
        return hasLiberty(row, column, board[row][column]);
    }
    
    /**
     * Returns true if the piece at the given row and column has
     * a liberty for the given color. This could be because the space
     * is empty, or it could be because the space is occupied by a
     * piece of the given color and one of its neighbors has a liberty.
     * 
     * @param row
     * @param column
     * @param color
     * @return
     */
    public boolean hasLiberty(int row, int column, char color) {
        // You must complete this method
    	if (!isWithinBounds(row,column)) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }
        visited[row][column] = true;
        if (board[row][column] == ' ') {
            return true;
        } 
        else if (board[row][column] != color) {
            return false;
        } 
        else {
            return hasLiberty(row - 1, column, color) || hasLiberty(row, column - 1, color)
                    || hasLiberty(row + 1, column, color) || hasLiberty(row, column + 1, color);
        }
    }

  
    
    /**
     * Returns the count of how many pieces matching the given symbol
     * are in the board.
     */
    public int getScore(char symbol) {
        int total = 0;
        for (char[] row : board) {
            for (char p : row) {
                total += (p == symbol) ? 1 : 0;
            }
        }
        return total;
    }
}