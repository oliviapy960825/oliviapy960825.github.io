import java.util.HashSet;
import java.util.Collection;
 
/** inheritance **/
class Node extends HashSet {//don't do this
    Node left, right;  
    int stringCount = 0;
    public boolean add(Object o){ 
	if (o instanceof String) 
	    stringCount++; 
	return super.add(o); 
    }
    public boolean addAll( Collection n ){
	stringCount += n.size();
	return super.addAll(n); 
    }

    public static void main(String[] args){
	String s1 = "a";
	String s2 = "b";
	String s3 = "c";
	Node n1 = new Node();
	n1.add(s1);
	n1.add(s2);//interface is a safe way to avoid polymorphism--avoid releasing methods/behaviors
	n1.add(s3);
	System.out.println(n1);// "abc"
	System.out.println(n1.stringCount);//3
	Node n2 = new Node();
	n2.addAll(n1);
	System.out.println(n2);//"abc"
	System.out.println(n2.stringCount);//6--because when the node calls the addAll method, it goes to HashSet and calls the addAll method, while in hashSet it will call add to calculate the addAll, so stringCount got calculated twice
    }
}//Today's exercise isn't about HashSet's add/addAll methods--dispatch vector--when it calls add, it calls the latest version of add()
//don't using inheritance when you don't understand how the super class works
//is-a: inheritance; has-a: composition, using inheritance is always difficult and hard to understand; if you have a relationship, you can use the inheritance. Otherwise, use a composition instead--hard to go wrong with composition, but you won't have polymorphism
///The idea for this came from Josh Bloch, "Effective Java" 
