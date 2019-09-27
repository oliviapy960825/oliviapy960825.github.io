import java.util.Random;

/**
 * Created by Diana Li on 4/19/2017.
 */

public class Board
{
    public static final int SIZE = 6;
    private Card[][] board;
    private int score;

    /**
     * Constructor. Make a new 6x6 game board
     */
    public Board()
    {
        board = new Card[SIZE][SIZE];
        score = 0;
    }

    /**
     * Check if one row/col have suits/types are the same.
     * Return a number which represent how many pairs are the same
     * (this number will be used in the function updateScore)
     * 
     * Iterate over the board
     * @return
     */
    public int rowSuit(int row)
    { 
      int count=1;
      int max=1;
    		for(int col=0;col<5;col++){
    			if(board[row][col].sameSuit(board[row][col+1])){
    				count++;
    			}
    			else{
    				count=1;
    			}
    			max=Math.max(count, max);
    		}
    	return max;
    }
    
    public int colSuit(int col)
    {
    	int count=1;
        int max=1;
        	for(int row=0;row<5;row++){
        		if(board[row][col].sameSuit(board[row+1][col])){
        			count++;
        		}
        		else{
        			count=1;
        		}
        		max=Math.max(count, max);
        	}
        return max;
    }
    public int rowNumber(int row)
    {
    	int count=1;
        int max=1;
    		for(int col=0;col<5;col++){
    			if(board[row][col].sameNumber(board[row][col+1])){
    				count++;
    			}
    			else{
    				count=1;
    			}
    			max=Math.max(count, max);
    		}
    		
    	return max;
    }
    public int colNumber(int col)
    {
    	int count=1;
        int max=1;
        	for(int row=0;row<5;row++){
        		if(board[row][col].sameNumber(board[row+1][col])){
        			count++;
        		}
        		else{
        			count=1;
        		}
        		max=Math.max(count, max);
        	}
        return max;
    }

    
    /**
     * Create a new game board with all cards filled
     */
    public void newGameBoard()
    {
    	for(int i=0; i<SIZE; i++)
    	{
    		for(int j=0; j<SIZE; j++)
    		{
    			board[i][j] = new Card();
    		}
    	}
    }

    public int getScore()
    {return score;}
    
    public void updataScore()
    {
    	int score = this.score;
    	for(int startRow=0; startRow<board.length; startRow++)
    	{
    		if(this.rowSuit(startRow) == 3)
    		{score += 20;}
    		if(this.rowSuit(startRow) > 3)
    		{score += 50;}
    		if(this.rowNumber(startRow) == 3 )
    		{score += 50;}
    		if(this.rowNumber(startRow) > 3)
    		{score += 200;}
    		else
    		{score += 0;}
    	}
    	for(int startCol=0;startCol<board[0].length;startCol++){
    		if(this.colSuit(startCol)==3){
    			score+=20;
    		}
    		if(this.colSuit(startCol)>3){
    			score+=50;
    		}
    		if(this.colNumber(startCol)==3){
    			score+=50;
    		}
    		if(this.colNumber(startCol)>3){
    			score+=200;
    		}
    		else{
    			score+=0;
    		}
    	}
    }

    /**
     * Returns a "visual" representation of a CharBoardGame board
     */
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                buffer.append(board[i][j].toString());
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
