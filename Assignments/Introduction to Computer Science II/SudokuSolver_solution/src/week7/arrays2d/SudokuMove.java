package week7.arrays2d;

public class SudokuMove {
    private int row;
    private int column;
    private int value;

    public SudokuMove(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }
    
    public boolean equals(Object o) {
        SudokuMove other = (SudokuMove)o;
        return row == other.row && column == other.column && value == other.value;
    }

    @Override
    public String toString() {
        return "SudokuMove [row=" + row + ", column=" + column + ", value=" + value + "]";
    }

}
