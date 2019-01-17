package week7.arrays2d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Sudoku {
    private int[][] puzzle;
    private long movesTested;
    private Set<Integer> unique;
  
    public Sudoku(int[][] puzzle) {
        this.puzzle = puzzle;
        this.unique = new HashSet<Integer>();
    }

    @Override
    public boolean equals(Object o) {
        Sudoku other = (Sudoku) o;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (puzzle[row][column] != other.puzzle[row][column]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks the row.  Returns true if the row contains non-duplicate numbers 1-9.
     * 0's indicate the square has no value yet and are considered valid.
     * 
     * @param row
     * @return
     */
    public boolean isValidRow(int row) {
        unique.clear();
        for (int column = 0; column < puzzle[row].length; column++) {
            int v = puzzle[row][column];
            if (v != 0 && !unique.add(v)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks the column.  Returns true if the row contains non-duplicate numbers 1-9.
     * 0's indicate the square has no value yet and are considered valid.
     * 
     * @param column
     * @return
     */
    public boolean isValidColumn(int column) {
        unique.clear();
        for (int row = 0; row < puzzle.length; row++) {
            int v = puzzle[row][column];
            if (v != 0 && !unique.add(v)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Checks the box. The box layout should be considered as smaller 3x3 grids with
     * the box parameter corresponding to:
     * 012
     * 345
     * 678
     * 
     * Returns true if the row contains non-duplicate numbers 1-9.
     * 0's indicate the square has no value yet and are considered valid.
     * 
     * @param box
     * @return
     */
    public boolean isValidBox(int box) {
        unique.clear();
        
        int startCol = 3 * (box % 3);
        int startRow = 3 * (box / 3);
        
        
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                int v = puzzle[startRow + row][startCol + column];
                if (v != 0 && !unique.add(v)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Returns true if all of the box, row, and column checks are valid.
     * 
     * @return
     */
    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (!isValidBox(i) || !isValidRow(i) || !isValidColumn(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Applies a move to the board by mutating the puzzle.
     * 
     * @param move
     */
    public void applyMove(SudokuMove move) {
        puzzle[move.getRow()][move.getColumn()] = move.getValue();
        movesTested++;
    }
    
    /**
     * Undoes a move on the board by mutating the puzzle.
     * 
     * @param move
     */
    public void undoMove(SudokuMove move) {
        puzzle[move.getRow()][move.getColumn()] = 0;
    }
    
    /**
     * Gets all valid moves for the given row and column. Returning a list
     * of all values 1-9 will cause the search to take way too long. This list
     * needs to be limited to only values that do not immediately invalidate
     * one of the game rules.
     * 
     * Hint: you can use the applyMove/undoMove methods.
     * 
     * @param row
     * @param column
     * @return
     */
    public List<SudokuMove> getAllValidMoves(int row, int column) {
        List<SudokuMove> result = new ArrayList<SudokuMove>();

        for (int value = 1; value <= 9; value++) {
            SudokuMove m = new SudokuMove(row, column, value);
            applyMove(m);
            if (isValid()) {
                result.add(m);
            }
            undoMove(m);
        }
        
        return result;
    }
    
    /**
     * Gets the next open space to search. This can be any existing space
     * that has a 0 value, but choosing wisely will shorten the length of
     * the search (i.e. solve the puzzle faster).
     * 
     * @return an SudokuMove with row and col and value of 0
     */
    public SudokuMove getNextOpenSpace() {
        SudokuMove best = null;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (puzzle[row][col] == 0) {
                    return new SudokuMove(row, col, 0);
                }
            }
        }
        return best;
    }
    
    /**
     * The game is won if there are no open spaces and the board is valid.
     * 
     * @return
     */
    public boolean hasWon() {
        return getNextOpenSpace() == null && isValid();
    }
    
    /**
     * Solves the puzzle using a backtracking search and the above methods.
     * 
     * You should not need to change this method.
     * 
     * @return
     */
    public void solve() {
        SudokuMove openSpace = getNextOpenSpace();
        if (openSpace != null) {
            for (SudokuMove move : getAllValidMoves(openSpace.getRow(), openSpace.getColumn())) {
                applyMove(move);
                solve();
                if (hasWon()) {
                    return;
                }
                else {
                    undoMove(move);
                }
            }
        }
        // no more open spaces but the game hasn't been won, allow return so that
        // search will continue down another branch
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] row : puzzle) {
            for (int value : row) {
                result.append(value);
            }
            result.append('\n');
        }
        return result.toString();
    }
    
    public long getMovesTested() {
        return movesTested;
    }
    
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        
        // extremely difficult sudoku
        Sudoku evil = new Sudoku(new int[][]{
                                             {0,0,0,0,5,0,4,2,0},                                  
                                             {3,7,0,0,0,1,0,0,6},
                                             {0,0,4,0,0,2,0,0,0},
                                             {0,0,0,0,0,0,0,9,8},
                                             {0,0,3,5,0,8,1,0,0},
                                             {1,2,0,0,0,0,0,0,0},
                                             {0,0,0,7,0,0,3,0,0},
                                             {6,0,0,9,0,0,0,7,2},
                                             {0,4,7,0,1,0,0,0,0}});
        evil.solve();
        long total = System.currentTimeMillis()-time;

        System.out.println(evil);
        System.out.println("Tested: " + evil.getMovesTested() + " moves before solving in " + total + "ms");
    }
}
