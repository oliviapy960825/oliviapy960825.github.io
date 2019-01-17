package Second;

public class Wombat {
int legs;
double weight;
Wombat(int legs, double weight){
	this.legs=legs;
	this.weight=weight;
}
@Override
public boolean equals(Object o){
	System.out.print("J");
	if(o instanceof Wombat){
		Wombat other=(Wombat)o;
		return this.legs==other.legs&&this.weight==other.weight;
	}
	else return false;
}
@Override
public int hashCode(){
	System.out.print("K");
	return legs;
}
}
