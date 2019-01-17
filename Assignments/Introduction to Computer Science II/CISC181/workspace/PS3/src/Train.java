
public class Train {
	protected Engine front;
	protected Engine rear;
	protected double passengers;
public Train(Engine front,Engine rear,double passengers){
	this.front=front;
	this.rear=rear;
	this.passengers=passengers;
}
public Engine getFront(){
	return front;
}
public Engine getRear(){
	return rear;
}
public double getPassengers(){
	return passengers;
}
public double totalHorsepower(){
	double totalHorsepower;
	if(front!=null&&rear!=null){
	totalHorsepower=front.getHorsepower()+rear.getHorsepower();
	}
	else if(front==null&&rear!=null){
	totalHorsepower=rear.getHorsepower();
	}
	else if(rear==null&&front!=null){
	totalHorsepower=front.getHorsepower();
	}
	else{
	totalHorsepower=0;
	}
	return totalHorsepower;
}
public void replaceOldest(Engine newEngine){
	if(front!=null&&rear!=null){
		front=newEngine;
	}
	else if(front==null){
		front=newEngine;
	}
	else{
		rear=newEngine;
	}

}
public boolean isOverloaded(){
	if(passengers>totalHorsepower()){
		return true;
	}
	else{
		return false;
	}
}
public void movePassengers(){
	if(isOverloaded()){
		passengers=passengers-totalHorsepower();
	}
	else{
		passengers=passengers;
	}
}
}


