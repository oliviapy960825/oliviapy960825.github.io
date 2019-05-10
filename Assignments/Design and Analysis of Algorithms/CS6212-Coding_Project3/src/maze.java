import java.util.Stack;

public class maze {

	static void maze(int matrix[][], int startRow, int startCol, int endRow, int endCol){
		matrix[startRow][startCol]=0;
		boolean bool=false;
		if (startRow<endRow){
		for(int i=startRow;i<endRow;i++){
			if(matrix[i+1][startCol]!=1){
				matrix[i+1][startCol]=matrix[i][startCol];
			}
		}}
		if (startRow>endRow){
		for(int i=startRow;i>endRow;i--){
			if(matrix[i-1][startCol]!=1){
				matrix[i-1][startCol]=matrix[i][startCol];
			}
		}
		}
		if (startCol<endCol){
		for(int i=startCol;i<endCol;i++){
			if(matrix[startRow][i+1]!=1){
				matrix[startRow][i+1]=matrix[startRow][i];
			}
		}
		}
		if (startCol>endCol){
		for(int i=startCol;i>endCol;i--){
			if(matrix[startRow][i-1]!=1){
				matrix[startRow][i-1]=matrix[startRow][i];
			}
		}
		}
		if (startRow<endRow && startCol<endCol){
		for(int i=startRow+1;i<endRow;i++){
			for(int j=startCol+1;j<endCol;j++){
				if(matrix[i][j]!=1){
					matrix[i][j] = Math.min(matrix[i][j - 1], 
                            matrix[i - 1][j]); 
				}
			}
		}
		}
		else if(startRow<endRow && startCol>endCol){
			for(int i=startRow+1;i<endRow;i++){
				for(int j=startCol-1;j>endCol;j--){
					if(matrix[i][j]!=1){
						matrix[i][j] = Math.min(matrix[i][j + 1], 
	                            matrix[i - 1][j]); 
					}
				}
			}
		}
		else if(startRow>endRow && startCol>endCol){
			for(int i=startRow-1;i>endRow;i--){
				for(int j=startCol-1;j>endCol;j--){
					if(matrix[i][j]!=1){
						matrix[i][j] = Math.min(matrix[i][j + 1], 
	                            matrix[i + 1][j]); 
					}
				}
			}
		}
		else if(startRow>endRow && startCol<endCol){
			for(int i=startRow+1;i<endRow;i++){
				for(int j=startCol+1;j<endCol;j++){
					if(matrix[i][j]!=1){
						matrix[i][j] = Math.min(matrix[i][j - 1], 
	                            matrix[i + 1][j]); 
					}
				}
			}
		}
		if(startRow<=endRow && startCol<=endCol)
			bool=(matrix[endRow-1][endCol-1]==0);
		else if (startRow<=endRow && startCol>=endCol)
			bool=(matrix[endRow-1][endCol+1]==0);
		else if(startRow>=endRow && startCol>=endCol)
			bool=(matrix[endRow+1][endCol+1]==0);
		else if(startRow>=endRow && startCol<=endCol)
			bool=(matrix[endRow+1][endCol-1]==0);
		if(bool)
			 System.out.println("Yes");
		else
			System.out.println("No"); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[][] = { { 0, 0, 0, 1, 0 }, 
                 { 1, 0, 0, 1, 1 }, 
                 { 0, 0, 0, 1, 0 }, 
                 { 1, 0, 1, 0, 1 }, 
                 { 0, 0, 1, 0, 0 } }; 
		 maze(arr,0,0,4,4);
	            
	}

}
