package ps6;

public abstract class CharBoardGame {
    public static final char E = ' '; // empty
    protected char[][] board;
    
    public CharBoardGame(char[][] board) {
        this.board = board;
    }

    /**
     * A simple setter for board at a row, column.
     * Does not enforce any rules.
     */
    public void setPiece(int row, int column, char piece) {
        board[row][column] = piece;
    }
    
    public char[][] getBoard() {
        return board;
    }
    
    /**
     * Checks to see if the row and column are within the bounds of
     * the board.
     * 
     * @param row
     * @param column
     * @return
     */
    public boolean isWithinBounds(int row, int column) {
        return row >= 0 && column >= 0 && 
                row < getBoard().length && 
                column < getBoard()[row].length;
    }
    
    /**
     * Returns a "visual" representation of a CharBoardGame board
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                buffer.append(board[i][j]);
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
    
    /**
     * Returns an integer "score" for a given symbol. For most games
     * the symbol represents a player.
     * @param symbol
     * @return
     */
    public abstract int getScore(char symbol);
}
