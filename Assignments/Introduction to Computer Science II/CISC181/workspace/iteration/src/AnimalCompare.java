import java.util.Comparator;

public class AnimalCompare implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		if(o1.name.equals(o2.name)){
			if(o1.legs>o2.legs){
				return 1;
			}
			else{
				return -1;
			}
		}
		else 
			return o1.name.compareTo(o2.name);
		}
	}
