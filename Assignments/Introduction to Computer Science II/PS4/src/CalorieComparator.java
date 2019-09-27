import java.util.Comparator;

public class CalorieComparator implements Comparator<Edible>{
	CalorieComparator(){
		
	}
@Override
public int compare(Edible o1, Edible o2) {
	if(o1.getCalories()>o2.getCalories()){
		return 1;
	}
	else if(o1.getCalories()<o2.getCalories()){
		return -1;
	}
	else{
		return 0;
	}
}


}
