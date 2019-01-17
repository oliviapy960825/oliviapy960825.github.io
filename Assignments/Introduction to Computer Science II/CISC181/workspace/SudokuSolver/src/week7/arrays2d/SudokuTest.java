package week7.arrays2d;


import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;


public class SudokuTest extends TestCase {
    private static final int[][] VALID_PUZZLE = {{6,2,3,7,1,4,8,5,9},
                                                 {4,8,9,3,6,5,2,1,7},
                                                 {5,7,1,8,2,9,6,4,3},
                                                 {2,4,7,9,5,3,1,8,6},
                                                 {8,1,5,4,7,6,9,3,2},
                                                 {9,3,6,2,8,1,4,7,5},
                                                 {1,6,4,5,9,7,3,2,8},
                                                 {3,5,8,6,4,2,7,9,1},
                                                 {7,9,2,1,3,8,5,6,4}};
    private static final int[][] INVALID_PUZZLE_COL = {{6,2,3,7,1,4,8,5,9},
                                                       {4,8,9,3,6,5,2,1,7},
                                                       {5,7,1,8,2,9,6,4,3},
                                                       {7,4,2,9,5,3,1,8,6},
                                                       {8,1,5,4,7,6,9,3,2},
                                                       {9,3,6,2,8,1,4,7,5},
                                                       {1,6,4,5,9,7,3,2,8},
                                                       {3,5,8,6,4,2,7,9,1},
                                                       {7,9,2,1,3,8,5,6,4}};
    private static final int[][] INVALID_PUZZLE_ROW = {{6,2,3,7,1,4,8,5,9},
                                                       {4,7,9,3,6,5,2,1,7},
                                                       {5,8,1,8,2,9,6,4,3},
                                                       {2,4,7,9,5,3,1,8,6},
                                                       {8,1,5,4,7,6,9,3,2},
                                                       {9,3,6,2,8,1,4,7,5},
                                                       {1,6,4,5,9,7,3,2,8},
                                                       {3,5,8,6,4,2,7,9,1},
                                                       {7,9,2,1,3,8,5,6,4}};
    private static final int[][] INVALID_PUZZLE_BOX = {{6,2,3,7,1,4,8,5,9},
                                                       {4,8,3,9,6,5,2,1,7},
                                                       {5,7,1,8,2,9,6,4,3},
                                                       {2,4,7,9,5,3,1,8,6},
                                                       {8,1,5,4,7,6,9,3,2},
                                                       {9,3,6,2,8,1,4,7,5},
                                                       {1,6,4,5,9,7,3,2,8},
                                                       {3,5,8,6,4,2,7,9,1},
                                                       {7,9,2,1,3,8,5,6,4}};
    private static final int[][] UNSOLVED_PUZZLE = {{6,2,3,7,1,4,8,5,9},
                                                    {4,8,9,3,6,5,2,1,7},
                                                    {5,7,1,8,2,9,6,4,3},
                                                    {2,4,0,9,0,3,1,8,6},
                                                    {8,1,5,4,7,6,9,3,2},
                                                    {9,3,0,2,0,1,4,7,5},
                                                    {1,6,4,5,9,7,3,2,8},
                                                    {3,5,8,6,4,2,7,9,1},
                                                    {7,9,2,1,3,8,5,6,4}};
    private static final int[][] EMPTY_PUZZLE = {{0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0},
                                                 {0,0,0,0,0,0,0,0,0}};
    public void test_Sudoku_isValidRow() {
        Sudoku invalidRow = new Sudoku(INVALID_PUZZLE_ROW);
        assertFalse(invalidRow.isValidRow(1)); // row 1 has two 7's
        assertFalse(invalidRow.isValidRow(2)); // row 2 has two 8's
        assertTrue(invalidRow.isValidRow(0)); // row 0 is okay
        assertTrue(invalidRow.isValidRow(3)); // row 3 is okay
    }
    
    public void test_Sudoku_isValidColumn() {
        Sudoku invalidColumn = new Sudoku(INVALID_PUZZLE_COL);
        assertFalse(invalidColumn.isValidColumn(0)); // column 0 has two 7's
        assertFalse(invalidColumn.isValidColumn(2)); // column 2 has two 2's
        assertTrue(invalidColumn.isValidColumn(1)); // column 1 is okay
        assertTrue(invalidColumn.isValidColumn(8)); // column 8 is okay
    }
    
    public void test_Sudoku_isValidBox() {
        Sudoku invalidBox = new Sudoku(INVALID_PUZZLE_BOX);
        assertFalse(invalidBox.isValidBox(0)); // box has two 3's
        assertFalse(invalidBox.isValidBox(1)); // box has two 9's
        assertTrue(invalidBox.isValidBox(2)); // box is okay
        assertTrue(invalidBox.isValidBox(3)); // box is okay
    }
    
    public void test_Sudoku_valid() {
        Sudoku valid = new Sudoku(VALID_PUZZLE);
        // 9 of each, rows cols boxes
        for (int i = 0; i < 9; i++) {
            assertTrue(valid.isValidRow(i));
            assertTrue(valid.isValidColumn(i));
            assertTrue(valid.isValidBox(i));
        }
    }
    
    
    public void test_Sudoku_getAllValidMoves() {
        Sudoku simple = new Sudoku(UNSOLVED_PUZZLE);
        List<SudokuMove> moves = simple.getAllValidMoves(3, 2);
        assertTrue(moves.containsAll(Arrays.asList(new SudokuMove(3, 2, 7))));
        assertEquals(1, moves.size());
        
        Sudoku empty = new Sudoku(EMPTY_PUZZLE);
        moves = empty.getAllValidMoves(3, 2);
        assertTrue(moves.containsAll(Arrays.asList(new SudokuMove(3, 2, 1), new SudokuMove(3, 2, 2), new SudokuMove(3, 2, 3),
            new SudokuMove(3, 2, 4), new SudokuMove(3, 2, 5), new SudokuMove(3, 2, 6),
            new SudokuMove(3, 2, 7), new SudokuMove(3, 2, 8), new SudokuMove(3, 2, 9))));
        assertEquals(9, moves.size());
    }
    
    public void test_Sudoku_getNextOpenSpace() {
        Sudoku simple = new Sudoku(UNSOLVED_PUZZLE);
        SudokuMove openSpace = simple.getNextOpenSpace();
        assertNotNull(openSpace);

        SudokuMove[] possibilities = {new SudokuMove(3,2,0),new SudokuMove(5,2,0),
                                      new SudokuMove(3,4,0),new SudokuMove(5,4,0)};
        boolean found = false;
        for (SudokuMove p : possibilities) {
            found = found || openSpace.equals(p);
        }
        assertTrue(found);
    }
    
    
    public void test_Sudoku_solve() {
        Sudoku simple = new Sudoku(UNSOLVED_PUZZLE);
        simple.solve();
        Sudoku simpleSolved = new Sudoku(VALID_PUZZLE);
        
        assertTrue(simple.hasWon());
        assertEquals(simpleSolved, simple);
    }
}
