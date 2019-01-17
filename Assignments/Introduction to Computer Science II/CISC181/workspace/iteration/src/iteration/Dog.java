package iteration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//1
public class Dog {
public String name;
@Override
public String toString(){
 return name;
}
public Dog(String name){
	this.name=name;
}
public Dog(){
	
}

public static void main(String[] args){
	//2
	Collection<Dog> dogs =new ArrayList<Dog>();//collection s include trees, set and list
	Dog Fido =new Dog("Fido");
	Dog Spot=new Dog("Spot");
	Dog Lucy=new Dog("Lucy");

    dogs.add(Fido);
	dogs.add(Spot);
	dogs.add(Lucy);
	//3
	System.out.println(dogs);
	//4
	for(Dog a:dogs){
		if(a.name=="Spot"){
			System.out.println(a);
		}
	}
	//5
	Iterator<Dog> dogIterator=dogs.iterator();
	for(Dog d=dogIterator.next();dogIterator.hasNext();d=dogIterator.next()){//have to use iterator.next() to get the first object in the iterator
		if(d.name=="Spot"){
		    //dogs.add(new Dog("newDog"));
			//dogIterator.add(new Dog("newDog"));//iterator doesn't have an add method
		    //dogs.remove(d);
				//don't mess with your collections when you are running your iterators
			dogIterator.remove();
		    //but when you call iterator to remove the object from your collections, your system will be consistent and the object will be removed from the collection and the iterator 
			System.out.println(dogs);
		}
	}//use iterators and for each most of the time. The only thing for each cannot do is removing an object, and that's when we add in iterator
	//6
}
}

