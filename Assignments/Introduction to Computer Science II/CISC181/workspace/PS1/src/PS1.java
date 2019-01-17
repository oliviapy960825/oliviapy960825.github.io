
public class PS1 {
	//Problem 1
public static double windChillTemperature(int ta,int v){
	double twc=35.74;
	double vc=Math.pow(v,0.16);
	twc=twc+0.6215*ta-35.75*vc+0.4275*ta*vc;
	return twc;
}
//Problem 2
public static int teaParty(double tea,double candy){
	int i;
	if(tea<5||candy<5){
		i=0;
	}
		else if(tea>=2*candy||candy>=2*tea){
			i=2;
		}
		else
			i=1;
	return i;
}
//Problem 3
public static boolean shareDigit(int a,int b){
	int a1=a%10;
	int a2=a/10;
	int b1=b%10;
	int b2=b/10;
	boolean c;
	c=a1==b1||a1==b2||a2==b1||a2==b2;
	return c;
		}
//Problem 4
public static int closestFactorToSqrt(double number){
	int closest=(int) Math.sqrt(number);
	while(number%closest!=0){
		closest--;
	}
	return closest;
}
//Problem 5
public static boolean oddParity(int number){
	int sum=0;
	boolean result;
	while(number!=0){
		sum+=number%10;
		number=number/10;
	}
	if(sum%2==0){
		result=false;
	}
	else
		result=true;
	return result;
}
//Problem 6
public static int countShared(char a){
	int numericalValue = (int)a;
	int sum=0;
	for(int i=65;i<=90;i++){
		if(shareDigit(numericalValue,i)){
			sum++;
		}
		else
        sum=sum+0;	
	}
	return sum;
}
}
