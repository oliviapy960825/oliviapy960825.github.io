package Pretest;
import java.util.ArrayList;

public class Cat {
int legs;
double weight;
String name;
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
public static void main (String[] args){
	Cat c1=new Cat("Mary",4);
	Cat c2=new Cat("Will", 5.0);
	Cat c3=new Cat(3,4.0,"Betty");
	ArrayList<Cat> cats=new ArrayList<Cat>();
	cats.add(c1);
	cats.add(c2);
	cats.add(c3);
	System.out.println(cats);
}

}
