package First;

public class Wombat2 implements Comparable<Wombat2>{
public int numLegs;
public String name;
public Wombat2(String name, int numLegs){
	this.name=name;
	this.numLegs=numLegs;
}
	@Override
	public int compareTo(Wombat2 o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}
