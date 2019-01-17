package midterm2;

public class Cow {
public String name;
public Cow(String name){
	this.name=name;
}
public int hashCode(){
	System.out.println("a");
	return this.name.hashCode();
}
public boolean equals(Object o)
{
	System.out.println("b");
return this.name==((Cow)o).name;	
}
}
