import java.util.Stack;

public class islands {
	static void helper(int matrix[][], int row, int col, boolean visited[][],Stack myStack){
		
		int rowHelper[]={-1,0,0,1};
		int colHelper[]={0,-1,1,0};
		visited[row][col]=true;
		myStack.push(matrix[row][col]);
		
		for(int i=0;i<4;i++){
			
			if((row+rowHelper[i]>=0)&&(row+rowHelper[i]<matrix.length)&&(col+colHelper[i]>=0)&&(col+colHelper[i]<matrix[0].length)&&matrix[row+rowHelper[i]][col+colHelper[i]]==1&&visited[row+rowHelper[i]][col+colHelper[i]]==false){
				helper(matrix,row+rowHelper[i],col+colHelper[i],visited,myStack);
			}
		}
		myStack.pop();
	}
 static int findIslands(int matrix[][]){
	 int num=0;
	 boolean visited[][]=new boolean[matrix.length][matrix[0].length];
	 Stack myStack= new Stack();
	 for(int i=0;i<matrix.length;i++){
		 for(int j=0;j<matrix[i].length;j++){
			 if (matrix[i][j]==1&&visited[i][j]==false){
				 helper(matrix,i,j,visited,myStack);
				 if(myStack.isEmpty()){
					 num++;
				 }
			 }
		 }
	 }
	 return num;
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][]=  new int[][] {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 1, 0, 0}, 
            {0, 0, 0, 1, 1}
           }; 
        int L[][]=new int[][]{{1,1,0,0,0},
        	{1,1,0,0,0},
        	{1,1,0,0,0},
        	{0,0,1,0,0},
        	{1,0,0,0,0},
        	{0,0,0,1,1},
        	{0,0,0,1,1}
        };
 
System.out.println("Number of islands is: "+ findIslands(M)); 
System.out.println("Number of islands is: "+ findIslands(L));
} 
	}
