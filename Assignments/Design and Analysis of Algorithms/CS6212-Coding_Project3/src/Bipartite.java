import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
	static int[][] helper(int matrix[][]){
		int[][] newMatrix=new int[matrix.length][matrix.length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix.length;j++){
				newMatrix[i][j]=0;
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				newMatrix[i][matrix[i][j]]=1;
			}
		}
		return newMatrix;
	}
	static boolean bipartiteHelper(int matrix[][],int i, int color[]){
		color[i]=1;
		LinkedList<Integer> q= new LinkedList<Integer>();
		q.add(i);
		while(!q.isEmpty()){
			int index= q.peek();
			q.pop();
			if(matrix[index][index]==1){
				return false;
			}
			for(int j=0;j<matrix.length;j++){
				if(matrix[index][j]==1 && color[j]==-1){
					color[j]=1-color[index];
					q.push(j);
				}
				else if(matrix[index][j]==1&& color[index]==color[j]){
					return false;
				}
			}
		}
		return true;
	}
	static boolean isBipartite(int matrix[][]){
		int color[]=new int [matrix.length];
		for (int i=0;i<matrix.length;i++){
			color[i]=-1;
		}
		for(int i=0;i<matrix.length;i++){
			if(color[i]==-1){
				if(!bipartiteHelper(matrix,i,color)){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][]={{1,2},{0,1,2},{0,1,3},{3}};
		int newMatrix[][]=helper(M);
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix.length;j++){
				System.out.println(newMatrix[i][j]);
			}
		}
		
	System.out.println("The matrix is bipartite?: " +isBipartite(newMatrix));
	}
}
