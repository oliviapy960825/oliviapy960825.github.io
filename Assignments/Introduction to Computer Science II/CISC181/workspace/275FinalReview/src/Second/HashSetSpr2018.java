package Second;

import java.util.HashSet;

public class HashSetSpr2018 {
public static void main(String[] args){
	HashSet<Wombat> team=new HashSet<Wombat>();
	if(team.add(new Wombat(5,10)))
		System.out.println("L");
	if(team.add(new Wombat(5,12)))
		System.out.println("L");
	if(team.add(new Wombat(3,10)))
		System.out.println("L");
	if(team.add(new Wombat(3,10)))
		System.out.println("L");
	if(team.add(new Wombat(5,10)))
		System.out.println("L");
	if(team.add(new Wombat(3,12)))
		System.out.println("L");
	System.out.println(team.size());
}
}
