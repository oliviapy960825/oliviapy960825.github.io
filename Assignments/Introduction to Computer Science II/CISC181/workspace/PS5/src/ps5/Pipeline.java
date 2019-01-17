package ps5;


import java.util.ArrayList;
import java.util.List;

/**
 * A Pipeline contains segments of pipe in a List arrangement.
 * Each segment has a length and diameters of the incoming and outgoing connectors.
 */
public class Pipeline {
    private List<PipelineSegment> segments;

    /**
     * Creates an empty list
     */
    public Pipeline() {
        this.segments = new ArrayList<PipelineSegment>();
    }
    
    /**
     * Adds a segment to the end of the List.
     * 
     * @param segment
     */
    public void addAtEnd(PipelineSegment segment) {
        this.segments.add(segment);
    }
    
    /**
     * Returns a sublist of the segments as a new Pipeline.
     * 
     * @param position
     * @return
     */
    public Pipeline getSubPipeline(int position) {
        Pipeline p = new Pipeline();
        p.segments.addAll(this.segments.subList(position, this.segments.size()));
        return p;
    }

    /**
     * Returns the total length of all PipelineSegments in the list.
     * 
     * If the list is empty it should return 0.
     */
    public int getTotalLength() {
    	int totalLength=0;
    	if(segments.isEmpty()){
    		totalLength=0;
    	}
    	else{
    		for(PipelineSegment o:segments){
    			totalLength+=o.getLength();
        }
    	}
        return totalLength;
    }

    /**
     * Returns true if any PipelineSegment in the list has an
     * outDiameter that is not equal to the next PipelineSegment's inDiameter.
     * 
     * If the list is empty it should return false.
     * 
     * Hint: you should use the size() and get() methods on List
     */
    public boolean hasLeak() {
       boolean result=false;
       if(segments.isEmpty()){
    	   result=false;
       }
       else{
       for(int i=0;i<segments.size()-1;i++){
    	   if(segments.get(i).getOutDiameter()!=segments.get(i+1).getInDiameter()){
    		   result=true;
    	   }
       }
       }
       return result;
    }
    
    /**
     * Returns the maximum flow of any PipelineSegment in the list. The
     * maximum flow is equal to the minimum diameter, either incoming
     * or outgoing. 
     * 
     * If the list is empty it should return Integer.MAX_VALUE.
     */
    public int getMaxFlow() {
    	int maxFlow=0;
        if(segments.size()==0){
        	return Integer.MAX_VALUE; 
        }
        else if(segments.size()==1){
        	if(segments.get(0).getInDiameter()==segments.get(0).getOutDiameter()){
        		maxFlow=segments.get(0).getInDiameter();
        	}
        	else{
        		maxFlow=Math.min(segments.get(0).getInDiameter(), segments.get(0).getOutDiameter());
        	}
        	return maxFlow;
        }
        else{
        	for(int i=0;i<segments.size()-1;i++){
        		 if(segments.get(i).getInDiameter()==segments.get(i).getOutDiameter()&&segments.get(i).getOutDiameter()==segments.get(i+1).getInDiameter()&&segments.get(i+1).getInDiameter()==segments.get(i+1).getOutDiameter()){
        			maxFlow=segments.get(i).getInDiameter();
        		}
        		else{
        		maxFlow=Math.min(Math.min(segments.get(i).getInDiameter(),segments.get(i).getOutDiameter()),Math.min(segments.get(i+1).getInDiameter(), segments.get(i+1).getOutDiameter()));
        		}
        	}
        	return maxFlow;
        	
        }
        
        }
    
    
    /**
     * Replaces the last PipelineSegment in the list. This method
     * should not change the size of the list
     * (if there were 2 PipelineSegments in the list before then there
     * will be 2 in it after, but the last one is now replacement).
     * 
     * This method WILL now work when there is only 1 PipelineSegment.
     * It does not need to work when the list has 0 size.
     * 
     * Hint: you should use the size() and set() methods on List
     */
    public void replaceEnd(PipelineSegment replacement) {
    	if(segments.size()==0||segments.size()==1){
    		
    	}
    	else{
    		segments.set(segments.size()-1,replacement);
    	}
    }
}
