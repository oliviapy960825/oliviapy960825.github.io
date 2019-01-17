import java.util.ArrayList;
import java.util.Collection;
//Problem5
public class Dog {
public int legs;
public String name;
public Dog(String name, int legs){
	this.name=name;
	this.legs=legs;
}
public String toString(){
	return name;
}
public static int sum(Collection<Dog> dogs){
	int sumOfLegs=0;
	for(Dog d: dogs){
		sumOfLegs+=d.legs;
	}
	return sumOfLegs;
}
public static void main(String[] args){
	Collection<Dog> dogs=new ArrayList<Dog>();
	dogs.add(new Dog("Kathy",4));
	dogs.add(new Dog("Jake",4));
	System.out.println(sum(dogs));
}
}
