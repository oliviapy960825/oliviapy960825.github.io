import java.util.Comparator;

public class Wombat {
public int numLegs;
public String name;

public Wombat(String name, int numLegs){
	this.name=name;
	this.numLegs=numLegs;
}
public String toString(){
	return "The wombat named "+this.name+" has "+this.numLegs+" legs";
}
}

