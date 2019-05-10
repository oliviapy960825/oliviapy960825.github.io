import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Biconnectivity {
	
	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    int num = 0; 
  
    // Constructor 
    Biconnectivity(int v) 
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
    	Stack<Integer> myStack= new Stack<Integer>();
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
    	Stack<Integer> myStack=new Stack<Integer>();
    	visited[startingPoint]=true;
    	myStack.push(startingPoint);
    	System.out.println(myStack);
    	DFN[startingPoint]=num;
    	L[startingPoint]=DFN[startingPoint];
    	while(!myStack.isEmpty()){
    		//System.out.println(index);
    		int x=myStack.peek();
    		Iterator<Integer> iterator=adj[x].iterator();
    		while(iterator.hasNext()){
    			int v=iterator.next();
    			//System.out.println(v);
    			if(!visited[v]){
    				children++;
    				parent[v]=x;
    				DFS(v,visited,DFN,L,parent,APList);
    				
    		}
    			else if(v!=parent[x] && DFN[v]<DFN[x]){//v is 4, x=3, parent[4]=3
    				L[x]=Math.min(L[x], DFN[v]);
    			}
    			else{
    				
    				if(x==parent[v]){
						L[x]=Math.min(L[x], L[v]);
						}
    				System.out.println(v+"'s L is: "+L[v]);
    				System.out.println(x+"'s L is: "+L[x]);
    				System.out.println(v+"'s DFN is: "+DFN[v]);
					System.out.println(x+"'s DFN is: "+DFN[x]);
						if((L[x]>=DFN[v])&&(v!=0)){
							System.out.println(v+" is articulation Point? "+APList[v]);
									APList[v]=true;//v=3,x=5
									
								}
						
    			}
    		}
    				myStack.pop();
    				/*iterator=adj[x].iterator();
    				while(iterator.hasNext()){
    					int v=iterator.next();
    				if(v!=parent[x] && DFN[v]<DFN[x]){
    							L[x]=Math.min(L[x], DFN[v]);
    						}
    				else{
    						    if(x==parent[v]){
    							L[x]=Math.min(L[x], L[v]);
    							if(L[v]>=DFN[x]&&x!=0){
    										APList[x]=true;
    									}
    								}
    						}
    				}*/
    				//System.out.println(myStack.isEmpty());
    	}
    	//System.out.println(myStack.isEmpty());
    	//System.out.println(startingPoint+"'s children: "+children);
    	if(children>1){
    		APList[startingPoint]=true;
    	}
    	System.out.println(startingPoint+"'s children,"+children+" therefore it is articulation Point:"+APList[startingPoint]);
}
    public static void main(String[] args) {
    	/*System.out.println("Articulation points in first graph "); 
        Biconnectivity g1 = new Biconnectivity(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.initialization(); 
        System.out.println(); 
        
        System.out.println("Articulation points in Second graph"); 
        Biconnectivity g2 = new  Biconnectivity(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.initialization(); 
        System.out.println(); */
        
       System.out.println("Articulation points in Third graph "); 
        Biconnectivity g3 = new Biconnectivity(7); 
        g3.addEdge(0, 1); 
        g3.addEdge(1, 2); 
        g3.addEdge(2, 0); 
        g3.addEdge(1, 3); 
        g3.addEdge(1, 4); 
        g3.addEdge(1, 6); 
        g3.addEdge(3, 5); 
        g3.addEdge(4, 5); 
        g3.initialization(); 
    }
	}