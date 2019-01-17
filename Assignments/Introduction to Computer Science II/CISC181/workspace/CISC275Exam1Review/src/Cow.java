
public class Cow implements Comparable<Cow>{
public String name;
public int numLegs;
public Cow(String name, int numLegs){
	this.name=name;
	this.numLegs=numLegs;
}
public String toString(){
	return "The cow named "+this.name+" has "+ this.numLegs+" legs";
}
@Override
public int compareTo(Cow cow1) {
	// TODO Auto-generated method stub
	return this.name.compareTo(cow1.name);
}
}

