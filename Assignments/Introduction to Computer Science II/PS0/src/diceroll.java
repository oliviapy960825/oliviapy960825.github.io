//import java.lang.Math;
//import java.lang.*;
public class diceroll {
	public static int dice(int n1,int n2,int n3){
		if(n1==n2&&n2==n3){
			return 20;
		}
		else if(n1==n2||n1==n3||n2==n3){
			return 10;
		}
		else{
			return Math.max(n1, Math.max(n2, n3));
			}
				
			}
	public static void main(String[] args){
	System.out.println(dice(1,2,3));
	System.out.println(dice(1,1,3));
	System.out.println(dice(2,2,2));
	}
		
	}

