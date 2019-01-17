
public class Spiderman extends Person{
public Spiderman() {
    	super("Peter Parker");
	}

public String toString(){
	return "Spiderman";
}
public boolean isAfraidOf(String thing) {
    if(thing=="spiders"){
    	return true;
    }
    else{
    	return false;
    }
}
}
