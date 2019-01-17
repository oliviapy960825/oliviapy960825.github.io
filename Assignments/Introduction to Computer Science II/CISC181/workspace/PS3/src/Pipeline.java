


/**
 * A Pipeline represents a segment of pipe in some linear arrangement.
 * It has a length and diameters of the incoming and outgoing connectors.
 * It also can have a next Pipeline or the next Pipeline may be null which
 * indicates the end of the connected Pipeline.
 * 
 * This Pipeline class is considered to be self-referential 
 * (i.e. recursive) because it contains a reference to its own type 
 * as a property. This software pattern allows us to chain specific
 * logic recursively so that we rely on the structure of the data
 * itself rather than a general purpose data structure.
 */
public class Pipeline {
    private int length;
    private int inDiameter;
    private int outDiameter;
    private Pipeline next;
    public int maxFlow;

    public Pipeline(int length, int inDiameter, int outDiameter) {
        this(length, inDiameter, outDiameter, null);
    }
    
    public Pipeline(int length, int inDiameter, int outDiameter, Pipeline next) {
        this.length = length;
        this.inDiameter = inDiameter;
        this.outDiameter = outDiameter;
        this.next = next;
    }

    public Pipeline getNext() {
        return next;
    }
    
    public void setNext(Pipeline next) {
        this.next = next;
    }

    /**
     * Returns the total length of all Pipelines in the linked list.
     */
    public int getTotalLength() {
    	int totalLength =length;
     if(next!=null){
    	   totalLength=totalLength+next.getTotalLength();
     }
     else{
    	 totalLength=totalLength;
     }
       
       return totalLength;
    }

    /**
     * Returns true if any Pipeline in the linked list has an
     * outDiameter that is not equal to its next Pipeline's inDiameter.
     */
    public boolean hasLeak() {
    	boolean hasLeak = false;
       if(next!=null){
    	   if(outDiameter!=next.inDiameter){
    	   hasLeak=true;
    	   }
    	   else
    	   hasLeak=false;
    	   next.hasLeak();
    	   
       }
       else{
    	   hasLeak=false;
       }
       return hasLeak;
    }
    
    /**
     * Returns the maximum flow of any Pipeline in the linked list. The
     * maximum flow is equal to the minimum diameter, either incoming
     * or outgoing. 
     */
    public int getMaxFlow() {
    	
    if(next==null){
    	maxFlow=Math.min(inDiameter, outDiameter);
    }
    else {
    	maxFlow=Math.min(Math.min(inDiameter, outDiameter),Math.min(next.inDiameter, next.outDiameter) );
    	next.getMaxFlow();
    }
    return maxFlow;
    }
    
    /**
     * Replaces the last pipeline in the linked list. This method
     * should not change the number of Pipelines in the list
     * (if there were 2 Pipelines in the list before then there
     * will be 2 in it after, but the last one is now replacement).
     * 
     * This method does not need to work when there is only 1
     * Pipeline.
     */
    public void replaceEnd(Pipeline replacement) {
       if(next!=null&&next.getNext()==null){
    	   setNext(replacement);
       }
       else{
    	   next.replaceEnd(replacement);
       }
}
}