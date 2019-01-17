package sets;

import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static void main(String[] args){
Set<Cat1> cats =new HashSet<Cat1>();
Cat1 cat1=new Cat1("Fido");
Cat1 cat2=new Cat1("Phideaux");
Cat1 cat3=new Cat1("Fido");
cats.add(cat1);
cats.add(cat2);
cats.add(cat3);
cats.add(cat2);
cats.add(cat2);
}
}
