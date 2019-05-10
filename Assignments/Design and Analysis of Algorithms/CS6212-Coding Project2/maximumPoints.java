public class maximumPoints
{

	//Looks one step ahead at what the opponent will do, always assumes the opponent will pick whatever gives you the minimum in terms of options.
	static int maxPoints(int n[])
	{
		//initializations
		int yourTotal = 0, opponentTotal = 0;
		int indexToTake = 0;
		boolean yourTurn = true;

		int i, j;
		int size = n.length;
		i=0;
		j=size-1;

		int optioni;
		int optionj;

		//because minimums are going to be taken, must be at a base of integer maximum.
		int optionLeft=Integer.MAX_VALUE, optionMiddle=Integer.MAX_VALUE, optionRight=Integer.MAX_VALUE;

		//i is the beginning of the remaining array, j is the end of the remaining array, i and j are incremented according to what is chosen
		while(i<=j){

			//find all of the possible options for choices after you play and the opponent plays
			if(i<=j-2) optionLeft = Math.max(n[i],n[j-2]);
			if(i+1<=j-1) optionMiddle = Math.max(n[i+1],n[j-1]);
			if(i+2<=j) optionRight = Math.max(n[i+2],n[j]);
			
			//optioni is taking from the left, optionj is taking from the right
			optioni = n[i] + Math.min(optionMiddle, optionRight);
			optionj = n[j] + Math.min(optionLeft, optionMiddle);

			//whichever option will make the greatest output, pick that one with the exception of if the one immediately after what you pick is biggest. 
			if(optioni>optionj)
			{
				if(j-i>2){
					if(n[i+1] == max(n[i],n[i+1],n[j-1],n[j])) indexToTake = j;
					else indexToTake = i;
				}
				else indexToTake = i;
			}
			else 
			{
				if(j-i>2){
					if(n[j-1] == max(n[i],n[i+1],n[j-1],n[j])) indexToTake = i;
					else indexToTake = j;
				}
				else indexToTake = j;
			}

			//resets all options 
			optionLeft = Integer.MAX_VALUE;
			optionMiddle = Integer.MAX_VALUE;
			optionRight = Integer.MAX_VALUE;


			//if the turn is yours, add the point to you, if not add it to the opponenet and switch turns for next loop.
			if(yourTurn){
				yourTotal = yourTotal+n[indexToTake];
				if(indexToTake == i) i++;
				else j--;
			}
			else{
				opponentTotal = opponentTotal + n[indexToTake];
				if(indexToTake == i) i++;
				else j--;
			}
			yourTurn = !yourTurn;

		}


		return yourTotal;

	}

	static int max(int a, int b, int c, int d){
		return Math.max(a,Math.max(b,Math.max(c,d)));
	}

	public static void main(String[] args)
	{
		//10 Different Tests of the above system.
		int[] ex1 = {5,3,7,10};
		System.out.println("For coins: 5,3,7,10"); 
		System.out.println("Solution: " + maxPoints(ex1) + " Should be 15.");
		System.out.println();

		int[] ex2 = {8,15,3,7};
		System.out.println("For coins: 8,15,3,7");
		System.out.println("Solution: " + maxPoints(ex2) + " Should be 22.");
		System.out.println();

		int[] ex3 = {8,2,5,6,6,3,15,9};
		System.out.println("For coins: 8,2,5,6,6,3,15,9");
		System.out.println("Solution: " + maxPoints(ex3) + " Should be 34.");
		System.out.println();

		int[] ex4 = {2,2,2,2};
		System.out.println("For coins: 2,2,2,2");
		System.out.println("Solution: " + maxPoints(ex4) + " Should be 4.");
		System.out.println();

		int[] ex5 = {20,30,2,2,2,10};
		System.out.println("For coins: 20,30,2,2,2,10");
		System.out.println("Solution: " + maxPoints(ex5) + " Should be 42.");
		System.out.println();
		
		int[] ex6 = {8,7,6,5,4,3,2,2,3,4,5,6,7,8};
		System.out.println("For coins: 8,7,6,5,4,3,2,2,3,4,5,6,7,8");
		System.out.println("Solution: " + maxPoints(ex6) + " Should be 35.");
		System.out.println();

		int[] ex7 = {4,2,3,7,26,8,9,4};
		System.out.println("For coins: 4,2,3,7,26,8,9,4");
		System.out.println("Solution: " + maxPoints(ex7) + " Should be 42.");
		System.out.println();

		int[] ex8 = {8,2,5,6,6,3,9,15,3,2};
		System.out.println("For coins: 8,2,5,6,6,3,9,15,3,2");
		System.out.println("Solution: " + maxPoints(ex8) + " Should be 34.");
		System.out.println();

		int[] ex9 = {7,3,4,9,2,6,4,5,2,3};
		System.out.println("For coins: 7,3,4,9,2,6,4,5,2,3");
		System.out.println("Solution: " + maxPoints(ex9) + " Should be 30.");
		System.out.println();

		int[] ex10 = {20,1};
		System.out.println("For coins: 20,1");
		System.out.println("Solution: " + maxPoints(ex10) + " Should be 20.");
		System.out.println();
	}
}