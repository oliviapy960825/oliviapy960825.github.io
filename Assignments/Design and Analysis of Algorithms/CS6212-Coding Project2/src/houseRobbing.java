	import java.io.*;


	public class houseRobbing{

	/*
	Let me explain my through of house robbing problem:

	First, if we don't consider the houses are not arranged as circle but as a line. It is a problem that find the
	max sum in a list without adjacent.

	Therefore, we set a dynamic programming dp[i] to store the max value since i-th house.

	Whether we should rob the i-th house depend on that dp[i] = max ( arr[i] + dp[i-2], dp[i-1]).



	Second, because the housing is arranged as a circle which mean if we rob the 1th house we can not rob the last one,
	same as opposite.

	There are many method online I studied to label the previous house a boolean value which are
	all complicated. But I figured out a kind of cheating way that I do the dp[] list twice: first dp_1[] to get the
	max value from arr[0] to arr[n-1], and second dp_2[] to get the max_value from arr[1] to arr[n]. Then compare
	max(dp_1[i], dp_2[i])

	Therefore, we don't need to worried about the circle, just find the dp_maxvalue of two list: one from 1th house
	to the n-1 house and second from 2th house to the last house.

	*/
		static int HouseRobbing(int house[]) {
			

			int size= house.length;

			// checked if size == 0, 1, or 2
			if (size == 0) {
				return 0;
			}
			if (size == 1) {
				return house [0];
			}
			if (size == 2) {
				return Math.max(house[0],house[1]);
			}

			// when size >2 we start build dp

			int [] robbing_1 = new int[size-1];
			int [] robbing_2 = new int[size-1];

			robbing_1[0] = house[0];
			robbing_2[0] = house[1];

			robbing_1[1] = Math.max(house[0], house[1]);
			robbing_2[1] = Math.max(house[1], house[2]);

			for (int i = 2; i < size-1; i++) {
				robbing_1[i] = Math.max(house[i] + robbing_1[i-2],robbing_1[i-1]);

			}

			for (int i = 2; i < size-1; i++) {
				robbing_2[i] = Math.max(house[i+1] + robbing_2[i-2],robbing_2[i-1]);

			}

			return Math.max(robbing_1[size-2],robbing_2[size-2]);
		}

		// Check with examples
		public static void main(String[] args)
		{

			int[] ex1 = {2,3,2};
			System.out.println("Solution1: " + HouseRobbing(ex1));
			System.out.println();

			int[] ex2 = {1,2,3,1};
			System.out.println("Solution2: " + HouseRobbing(ex2));
			System.out.println();


	        int[] ex3={1,2,3,5,8,11};
			System.out.println("The max money you can rob is: "+HouseRobbing(ex3));
			System.out.println();
		}
	}

