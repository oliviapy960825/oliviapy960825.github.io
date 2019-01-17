package sets;

public class Cat2 {
public String name;
	public Cat2(String name) {
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	@Override
public boolean equals(Object other){
		return (this.name==((Cat2)other).name);
	}
public int hashcode(){
	return this.name.hashCode();
}
//rewrite hashcode() method
//how sets check if an object is duplicate:
//1. the set calls hashcode()
//2. if the hashcode is the same, then it calls the .equals()
//when you overwite equals() you must overwrite hashcode()
}
