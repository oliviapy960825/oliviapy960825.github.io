
public class Dog extends Animal implements Comparable<Dog>{
public Dog(String name, int legs){
	super(name,legs);
}
public String toString(){
	return "the dog named "+name+" has "+legs+" legs";
}

@Override
public int compareTo(Dog o) {
	// TODO Auto-generated method stub
	if(this.legs>o.legs){
		return 1;
	}
	else if(this.legs<o.legs){
		return -1;
	}
	else{ //IF LEGS ARE SAME
		return this.name.compareTo(o.name);
	}
}

}
