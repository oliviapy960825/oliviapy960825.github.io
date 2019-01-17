package First;

public class Cat2 {
public String name="Argon";
public String toString(){return "Neon";}
public static void printNames(Cat2 c1, Cat2 c2){
	System.out.println(c1.name+" "+c2.name);
}
public static void main(String[] args){
	Cat2 c1=new Cat2();
	SubCat s1=new SubCat();
	Cat2 c2=s1;
	System.out.println(s1.name);
	Cat2.printNames(c1,s1);
	SubCat.printName(c1, c2);
	SubCat.printName(s1, s1);
	SubCat.printName(c2, c1);
	System.out.println(c1+" "+c2);
	}
}
