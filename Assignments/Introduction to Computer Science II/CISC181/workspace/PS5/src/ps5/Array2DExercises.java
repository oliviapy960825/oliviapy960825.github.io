package ps5;

public class Array2DExercises {
    
    /**
     * Returns the maximum value in the 2d parameter array a.
     * 
     * @param a
     * @return
     */
    public static int max(int[][] a) {
    	int maxValue=a[0][0];
    	for(int row=0;row<a.length;row++){
    		for(int col=0;col<a[row].length;col++){
    			if(a[row][col]>=maxValue){
    				maxValue=a[row][col];
    			}
    		}
    	}
        return maxValue;
    }
    
    /**
     * Returns the sum of the elements in Row x of a.
     *  
     * @param a
     * @param x
     * @return
     */
    public static int rowSum(int[][] a, int x) {
    	int rowSum=0;
    	for(int col=0;col<a[x].length;col++){
    		rowSum=rowSum+a[x][col];
    	}
        return rowSum;
    }
    
    /**
     * Returns the sum of the elements in Column x of a (careful with rows of different lengths!).
     * 
     * @param a
     * @param x
     * @return
     */
    public static int columnSum(int[][] a, int x) {
    	int colSum=0;
    	for(int row=0;row<a.length;row++){
    		if(a[row].length<=x){
    			colSum=colSum;
    		}
    		
    		else{
    			colSum=colSum+a[row][x];
    		}
    	}
        return colSum;
    }
    
    /**
     * Calculates the row sum for every row and returns each of the values in an array. 
     * Index i of the return array contains the sum of elements in row i.
     * 
     * @param a
     * @return
     */
    public static int[] allRowSums(int[][] a) {
    	int[] rowSum=new int[a.length];
    	for(int row=0;row<a.length;row++){
    		for(int col=0;col<a[row].length;col++){
    			rowSum[row]=rowSum[row]+a[row][col];
    		}
    		
    	}
        return rowSum;
    }
    
    /**
     * Checks to see if the array is increasing in every row and every column.
     */
    public static boolean isIncreasing(int[][] a) {
    	boolean isIncreasing=true;
    	for(int row=0;row<a.length-1;row++){
    		for(int col=0;col<a[row].length-1;col++){
    			if(a[row][col]>a[row][col+1]||a[row][col]>a[row+1][col]){
    				isIncreasing=false;
    			}
    		}
    	}
        return isIncreasing;
    }
}
