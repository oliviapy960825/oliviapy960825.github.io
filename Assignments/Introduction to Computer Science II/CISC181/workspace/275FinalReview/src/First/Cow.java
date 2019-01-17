package First;

public class Cow implements Comparable<Cow> {
public String name;
public int numLegs;
public Cow(String name, int numLegs){
	this.name=name;
	this.numLegs=numLegs;
}
public String toString(){
	return name;
}
public int compareTo(Cow c1){
	return this.name.compareTo(c1.name);
}
}
