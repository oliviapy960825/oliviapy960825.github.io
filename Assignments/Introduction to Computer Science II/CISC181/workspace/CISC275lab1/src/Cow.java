 import java.util.ArrayList;
import java.util.Collection;

public class Cow extends Move implements speakable{
String name;
//for problem2
/*public Cow(String name){
	this.name=name;
}*/
//for Problem14
public Cow(String name,String color){
	super(name, color);
	this.name=name;
	this.color=color;
}
public String toString(){
	return name;
}
@Override
public String speak() {
	// TODO Auto-generated method stub
	return "MOO";
}
public static void main(String[] args){
	//problem2
	Collection<speakable> speakables=new ArrayList<speakable>();
	speakables.add(new Cow("cow1","black"));
	speakables.add(new Horse("horse1","white"));
	
	for(speakable s:speakables){
		System.out.println(s.speak());
	}
	System.out.println(speakables);
}
@Override
public String move() {
	// TODO Auto-generated method stub
	return "Hooves";
}



}
