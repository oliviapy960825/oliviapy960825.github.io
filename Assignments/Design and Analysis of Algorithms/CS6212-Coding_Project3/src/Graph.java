import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    int num = 0; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);    //Add v to w's list 
    } 
    void initialization(){
    	boolean visited[]=new boolean[V];
    	int DFN[]=new int[V];
    	int L[]=new int[V];
    	int parent[]=new int[V];
    	boolean APList[]=new boolean[V];
    	
    	for (int i=0;i<V;i++){
    		visited[i]=false;
    		parent[i]=-1;
    		APList[i]=false;
    	}
    	for(int i=0;i<V;i++){
    		if(!visited[i]){
    			DFS(i, visited, DFN, L, parent, APList);
    		}
    	}
    	for(int i=0;i<V;i++){
    		if(APList[i]){
    			System.out.println("Articulation Point: "+i);
    		}
    	}
    }
    void DFS(int startingPoint, boolean visited[], int DFN[], int L[], int parent[], boolean APList[]){//push every vertex in the graph into the stack
    	num++;
    	int children=0;
    	visited[startingPoint]=true;
    	
    	DFN[startingPoint]=num;
    	L[startingPoint]=DFN[startingPoint];
    	
    	Iterator<Integer> iterator=adj[startingPoint].iterator();
    	while(iterator.hasNext()){
    			int v=iterator.next();
    			if(!visited[v]){
    				children++;
    				parent[v]=startingPoint;
    				DFS(v,visited,DFN,L,parent,APList);
    				L[startingPoint]=Math.min(L[startingPoint],L[v]);
    				if(parent[startingPoint]==-1&&children>1){
    					APList[startingPoint]=true;
    				}
    				else if(parent[startingPoint]!=-1&&L[v]>DFN[startingPoint]){
    					APList[startingPoint]=true;
    				}
    			}
    			else if(parent[startingPoint]!=v){
    				L[startingPoint]=Math.min(L[startingPoint],DFN[v]);
    			}
    		}
    	}
    
    public static void main(String[] args) {
    	System.out.println("Articulation points in first graph "); 
        Graph g1 = new Graph(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.initialization(); 
        System.out.println(); 
        
        
    }
}
