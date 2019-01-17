import java.util.ArrayList;
import java.util.Collection;
//for Problem 16
public class Cat {
public String name;
public double weight;
public int legs;
public Cat(int legs, double weight, String name){
	this.legs=legs;
	this.weight=weight;
	this.name=name;
}
public Cat(String name, double weight){
	this.name=name;
	this.weight=weight;
}
public Cat(String name, int legs){
	this.name=name;
	this.legs=legs;
}
public String toString(){
	return name;
}
public static void main(String[] args){
Cat cat1=new Cat("Luna",12.5);
Cat cat2=new Cat(4,14,"Kathy");
Cat cat3=new Cat("Jake",4);

ArrayList<Cat> cats=new ArrayList<Cat>();
cats.add(cat1);
cats.add(cat2);
cats.add(cat3);

System.out.println(cats);
}
}