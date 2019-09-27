public class ExpressTrain extends Train{
private Engine middle; 
public ExpressTrain(Engine front, Engine rear, double passengers,Engine middle) {
		super(front, rear, passengers);
		this.middle=middle;
	}
public double totalHorsepower(){
	double totalHorsepower;
	if(front!=null&&rear!=null&&middle!=null){
		totalHorsepower=front.getHorsepower()+middle.getHorsepower()+rear.getHorsepower();
		}
	else if(front==null&&rear!=null&&middle!=null){
		totalHorsepower=rear.getHorsepower()+middle.getHorsepower();
		}
	else if(rear==null&&front!=null&&middle!=null){
		totalHorsepower=front.getHorsepower()+middle.getHorsepower();
		}
	else if(middle==null&&front!=null&&rear!=null){
		totalHorsepower=front.getHorsepower()+rear.getHorsepower();
		}
	else if(front==null&&middle==null&rear!=null){
		totalHorsepower=rear.getHorsepower();
	}
	else if(front==null&&middle!=null&&rear==null){
		totalHorsepower=middle.getHorsepower();
	}
	else if(front!=null&&middle==null&&rear==null){
		totalHorsepower=front.getHorsepower();
	}
	else{
		totalHorsepower=0;
	}
	return totalHorsepower;
}


}