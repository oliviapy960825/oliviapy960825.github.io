import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static double getScore(char[][] board) {
		double score = 0;
	
		int playerRow = 0, playerColumn = 0;
		int goalRow = 0, goalColumn = 0;
		
		for (int  row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 'X' ) {
					playerRow = row;
					playerColumn = col;
				}
				else if(board[row][col] == 'O') {
					goalRow = row;
					goalColumn = col;
				}
			}
		}
		
		score = Math.abs(playerRow - goalRow) + Math.abs(playerColumn - goalColumn);
		return score;
	}
	
	public static void m(int number, int[] numbers) {
		number = 2;
		numbers[number] = 30;
	}
	
	public static boolean linearIn(int[] outer, int[] inner) {
		int outerIndex = 0;
		int innnerIndex = 0;
		
		while (outerIndex < outer.length && innnerIndex < inner.length) {
			if (outer[outerIndex] > inner[innnerIndex]) {
				return false;
			}
			else if (outer[outerIndex] == inner[innnerIndex]) {
				outerIndex++;
				innnerIndex++;
			}
			else {
				outerIndex++;
			}
		}
		
		return innnerIndex == inner.length;
	}
	
	public static boolean canBalance(int[] nums) {
		
		int[] subtotals =  new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			if (i == 0) {
				subtotals[i] = nums[i];
			}else {
				subtotals[i] = nums[i] + subtotals[i - 1];
			}
		}
		
		double total = subtotals[subtotals.length - 1];
		
		for(int i = 0; i < subtotals.length; i++) {
			if (subtotals[i] == total / 2) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		
		// Testing getScore()
		char[][] board1 = {"     ".toCharArray(),
						   " XO  ".toCharArray(),
						   "     ".toCharArray(),
						   "     ".toCharArray(),
						   "     ".toCharArray()};
		
		char[][] board2 = {"     ".toCharArray(),
				           " X   ".toCharArray(),
				           "     ".toCharArray(),
				           "   O ".toCharArray(),
				           "     ".toCharArray()};
		
		char[][] board3 = {"X    ".toCharArray(),
				           "     ".toCharArray(),
				           "C    ".toCharArray(),
				           "     ".toCharArray(),
				           "O    ".toCharArray()};
		
		System.out.println("The score for board1 is: " + getScore(board1));
		System.out.println("The score for board2 is: " + getScore(board2));
		System.out.println("The score for board3 is: " + getScore(board3));
		
		
		/*
		// Page 4 - Problem 5
		Set<Integer> s1 = new HashSet<Integer>();
		for (int i = 0; i <= 7; i++) {
			s1.add(i);
		}
		Set<Integer> s2 = new HashSet<Integer>();
		for(int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				s2.add(i);
			}
		}
		System.out.println("s1: " + s1);
		System.out.println("s2: " + s2);
		
		Set<Integer> union = new HashSet<Integer>();
		union.addAll(s1);
		union.addAll(s2);
		System.out.println("Union of s1 + s2: " + union);
		
		Set<Integer> intersect = new HashSet<Integer>();
		intersect.addAll(s1);
		intersect.retainAll(s2);
		System.out.println("Intersection of s1 + s2: " + intersect);
		
		
		Set<Integer> uniqueToS1 = new HashSet<Integer>();//Set<Integer> uniqueToS1 = new HashSet<Integer>(s1) can also works;
		uniqueToS1.addAll(s1);
		uniqueToS1.removeAll(intersect);// can also use removeAll(s2)
		System.out.println("Unique to s1: " + uniqueToS1);
		
		Set<Integer> uniqueToS2 = new HashSet<Integer>();
		uniqueToS2.addAll(s2);
		uniqueToS2.removeAll(intersect);
		System.out.println("Unique to s2: " + uniqueToS2);	
		*/
		
		/*
		// Page 4 - Problem 4
		char[][] data = {{'p','e','r'},{'m','a','t'},{'t','o','k'}};
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i][i]);
		}
		for(int i = data.length - 1; i >= 0; i--) {
			System.out.print(data[data.length - 1 - i][i]);
		}
		*/
		
		/*
		// Page 4 - Problem 3
		char data[][] =  new char[2][5];
		data[1][3] = 7;
		char letters[][] = new char[2][];
		letters[1][3] = 7;
		System.out.println(data[1][3]);
		System.out.println(letters[1][3]);
		*/
		
		/*
		// Animal Class Hierarchy
		ArrayList<Mobile> mobileThings = new ArrayList<Mobile>();
		mobileThings.add(new Horse(124));
		mobileThings.add(new Vehicle());
		mobileThings.add(new Horse(134));
		mobileThings.add(new Horse(324));
		mobileThings.add(new Vehicle());
		for (Mobile m : mobileThings) {
			m.move();
		}
		
		Animal testAnimal_1 = new Cow(124);
		Animal testAnimal_2 = new Horse(124);
		 
		if (testAnimal_1.equals(testAnimal_2)) {
			System.out.println("These animals are equal by weight");
		}
		else {
			System.out.println("These animals are not equal by weight");
		}
		*/
		
		/*
		// Page 11 - Problem 5
		int x = 4;
		int[] y = {0, 1, 2, 3, 4, 5};
		m(x,y);
		for(int value: y) {
			System.out.print(value + ", ");
		}
		System.out.println();
		*/ 
		
		/*
		// Testing LinearIn
		if (linearIn(new int[]{1, 2, 4, 4, 6}, new int[]{2,4})) {
			System.out.println("Outer has all the elements of inner");
		}
		else {
			System.out.println("Outer doesn't have all the elements of inner");
		}
		*/
		
		
		/*
		// Testing canBalance
		if (canBalance(new int[]{2, 1, 1, 2, 1})) {
			System.out.println("You can balance this array");
		}
		else {
			System.out.println("You cannot balance this array");
		}
		*/
		
		
		
		
	}

}
