package First;

public class SubCat extends Cat2{
public String name="Xenon";
public String toString(){
	return "Krypton";
}
public static void printName(Cat2 c1, Cat2 c2){
	System.out.println(c1+" "+c2.name);
}
}
