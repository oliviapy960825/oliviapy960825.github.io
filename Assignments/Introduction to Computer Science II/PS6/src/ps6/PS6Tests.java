package ps6;

import junit.framework.TestCase;

import static ps6.TicTacToeNxN.*;

public class PS6Tests extends TestCase {
    private static final char[][] GO_STATE_1 = {
            "     ".toCharArray(),
            "  w  ".toCharArray(),
            " wbw ".toCharArray(),
            "bwbww".toCharArray(),
            "bbwbb".toCharArray()};
    
    public static TicTacToeNxN createStartGame() {
        // uses the make start game method on TicTacToe5x5Game
        return TicTacToeNxN.makeStartGame(5);
    }
    
    public static TicTacToeNxN createMidGame1() {
        // an example board after 2 turns each (score 1 for x, 2 for o)
        char[][] board = 
            {{X, E, E, E, E},
             {E, E, E, E, O},
             {E, E, B, O, E},
             {X, E, E, E, E},
             {E, E, E, E, E}};
        return new TicTacToeNxN(board);
    }
    public static TicTacToeNxN createMidGame2() {
        // an example board mid-game (score 2 for x, 3 for o)
        char[][] board = 
            {{X, O, O, E, X},
             {X, E, O, E, O},
             {E, E, B, O, E},
             {X, O, X, X, E},
             {E, O, X, E, E}};
        return new TicTacToeNxN(board);
    }
    public static TicTacToeNxN createEndGame1() {
        // an example board where player x has won (score 4 for x, 3 for o)
        char[][] board = 
            {{X, O, O, E, X},
             {X, E, O, E, O},
             {X, E, B, O, E},
             {X, O, X, X, E},
             {E, E, E, E, E}};
        return new TicTacToeNxN(board);
    }
   
    public static TicTacToeNxN createEndGame2() {
        // an example board where nobody has won (score 3 for x, 3 for o) but there are no more moves
        char[][] board = 
            {{X, O, O, O, X},
             {O, O, O, X, O},
             {X, X, B, O, X},
             {X, O, X, X, X},
             {O, X, O, O, X}};
        return new TicTacToeNxN(board);
    }
    
    public void test_getMaxSequence() {
        TicTacToeNxN game = createMidGame2();
        
        // test row 0
        assertEquals(2, game.getMaxSequence(0, 0, 0, 1, 'o'));
        assertEquals(1, game.getMaxSequence(0, 0, 0, 1, 'x'));
        // test row 3
        assertEquals(1, game.getMaxSequence(3, 0, 0, 1, 'o'));
        assertEquals(2, game.getMaxSequence(3, 0, 0, 1, 'x'));

        // test column 0
        assertEquals(0, game.getMaxSequence(0, 0, 1, 0, 'o'));
        assertEquals(2, game.getMaxSequence(0, 0, 1, 0, 'x'));
        // test column 1
        assertEquals(2, game.getMaxSequence(0, 1, 1, 0, 'o'));
        assertEquals(0, game.getMaxSequence(0, 1, 1, 0, 'x'));

        // test down-right diagonal 1,0
        assertEquals(0, game.getMaxSequence(1, 0, 1, 1, 'o'));
        assertEquals(1, game.getMaxSequence(1, 0, 1, 1, 'x'));
        // test down-right diagonal 0,1
        assertEquals(3, game.getMaxSequence(0, 1, 1, 1, 'o'));
        assertEquals(0, game.getMaxSequence(0, 1, 1, 1, 'x'));

        // test down-left diagonal 1,4
        assertEquals(2, game.getMaxSequence(1, 4, 1, -1, 'o'));
        assertEquals(1, game.getMaxSequence(1, 4, 1, -1, 'x'));
        // test down-left diagonal 2,4
        assertEquals(0, game.getMaxSequence(2, 4, 1, -1, 'o'));
        assertEquals(2, game.getMaxSequence(2, 4, 1, -1, 'x'));
        
        // test middle square (it is not a free square, it is blocked)
        assertEquals(2, game.getMaxSequence(0, 2, 1, 0, 'o'));
        assertEquals(2, game.getMaxSequence(0, 2, 1, 0, 'x'));
        assertEquals(1, game.getMaxSequence(2, 0, 0, 1, 'o'));
        assertEquals(0, game.getMaxSequence(2, 0, 0, 1, 'x'));
        assertEquals(0, game.getMaxSequence(0, 0, 1, 1, 'o'));
        assertEquals(1, game.getMaxSequence(0, 0, 1, 1, 'x'));
        assertEquals(1, game.getMaxSequence(0, 4, 1, -1, 'o'));
        assertEquals(1, game.getMaxSequence(0, 4, 1, -1, 'x'));
    }
    
    public void test_getScore() {
        assertEquals(0, createStartGame().getScore('x'));
        assertEquals(0, createStartGame().getScore('o'));
        assertEquals(1, createMidGame1().getScore('x'));
        assertEquals(2, createMidGame1().getScore('o'));
        assertEquals(2, createMidGame2().getScore('x'));
        assertEquals(3, createMidGame2().getScore('o'));
        assertEquals(4, createEndGame1().getScore('x'));
        assertEquals(3, createEndGame1().getScore('o'));
        assertEquals(3, createEndGame2().getScore('x'));
        assertEquals(3, createEndGame2().getScore('o'));
    }
    
    public static void test_hasLiberty() {
        Go testGo = new Go(GO_STATE_1);
        assertFalse(testGo.hasLiberty(2, 2));
        assertFalse(testGo.hasLiberty(3, 2));
        assertFalse(testGo.hasLiberty(4, 2));
        assertFalse(testGo.hasLiberty(4, 3));
        assertFalse(testGo.hasLiberty(4, 4));

        assertTrue(testGo.hasLiberty(3, 0));
        assertTrue(testGo.hasLiberty(4, 0));
        assertTrue(testGo.hasLiberty(4, 1));
        assertTrue(testGo.hasLiberty(3, 3));
        
    }
    
    
    public static void main(String[] args) {
        // print some games
        System.out.println(createStartGame());
        System.out.println(createMidGame2());
        System.out.println(createEndGame2());
        
        System.out.println(new Go(GO_STATE_1));

    }
}
