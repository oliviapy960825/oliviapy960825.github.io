
public class Snowflake {
Snowflake(double radius,double depth){
}
private double radius;
private double depth;
public double getRadius(){
	return radius;
}
public double getDepth(){
	return depth;
}

public double setRadius(double radius){
	this.radius=radius;
	return radius;
}

public double setDepth(double depth){
	this.depth=depth;
	return depth;
}
public void draw(Turtle turtle){
	while(depth==1){
		for(int i=1;i<=12;i++){
		turtle.forward(radius*0.8);
		turtle.back(radius*0.8);
		turtle.left(30);
	}
		depth--;
	}
	if(depth>1){
		for(int i=1;i<=12;i++){
		drawLittle(turtle,radius*0.6);
		turtle.left(30);
	}
		depth--;
		draw(turtle);
	}
}
public void drawLittle(Turtle turtle,double radius){
	for(int i=1;i<=6;i++){
		turtle.forward(radius);
		turtle.left(60);
	}
}
public void draw(Turtle turtle,double r,double d){
	if(d==0){
		return;
	}else{
		for(int i=1;i<=6;i++){
			turtle.forward(r);
			turtle.left(30);
			draw(turtle,r*0.5,d-1);
			turtle.right(30);
			turtle.back(r);
			turtle.left(60);
		}
	}
}
}




