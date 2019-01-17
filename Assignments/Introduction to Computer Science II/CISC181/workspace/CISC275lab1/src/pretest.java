import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class pretest {
	//Problem4
	public static int sum(int[] intArray){
		int sumOfArray=0;
		for(int i: intArray){
			sumOfArray+=i;
		}
		return sumOfArray;
	}
	//Problem6
	public static double average(int[] intArray){
		double sumOfArray=0;
		double averageOfArray=0;
		for(int i:intArray){
			sumOfArray+=i;
		}
		averageOfArray=sumOfArray/intArray.length;
		return averageOfArray;
	}
	//Problem7
	public static int factorial(int num, int multiplication){
		if(num==0){
			return multiplication;
		}
		else{
			multiplication*=num;
			num--;
			return factorial(num,multiplication);
		}
	}
	//Problem8
	public static void swap(int[] intArray, int pivot){
		int temp;
		int leftIndex=0;
		int rightIndex=intArray.length-1;
		for(int i=0;i<intArray.length;i++){
			if(intArray[leftIndex]>=pivot){
				temp=intArray[leftIndex];
				if(intArray[rightIndex]<=pivot){
					intArray[leftIndex]=intArray[rightIndex];
					intArray[rightIndex]=temp;
				}
				else{
					rightIndex--;
				}
			}
			else{
				leftIndex++;
			}
		}
	}
	//Problem9
	public static int smallest(int[] intArray){
		int smallest=intArray[0];
		for(int i:intArray){
			if(i<smallest){
				smallest=i;
			}
		}
		return smallest;
	}
	
	//Problem10
	public static int smallest(Collection<Integer> intList){
		Iterator<Integer> i=intList.iterator();
		int smallest=i.next().intValue();
		for(Integer Int=i.next();i.hasNext();Int=i.next()){
			if(Int.intValue()<smallest){
				smallest=Int.intValue();
			}
		}
		return smallest;
	}
	//Problem 17
	public static void map(){
		int part1=0;
		int part2=0;
		int part3=0;
		int randomNum;
		Random randomGenerator =new Random();
		for(int i=0;i<1000000;i++){
			randomNum=randomGenerator.nextInt();
			if(randomNum%3==0){
				part1++;
			}
			else if(randomNum%3==1){
				part2++;
			}
			else{
				part3++;
			}
		}
		System.out.println("The first part contains "+part1+" numbers, and the second part contains "+part2+" numbers, and the third part contains "+part3+" numbers");
	}
	public static void main(String[] args){
		//problem3
		/*final int LENGTH=670;
		final int NUMS_PER_ROW=30;
		

		int[] intData=new int[LENGTH];
		for(int i=0;i<LENGTH;i++){
			intData[i]=i*4;
		}
		for(int i=0;i<LENGTH;i+=NUMS_PER_ROW){
			for(int j=0;j<NUMS_PER_ROW;j++){
				if(i+j<LENGTH){
				System.out.print(intData[i+j]+" ");}
			}
			System.out.println("\n");
		}
	}
	/*Test for Problem4
		int[] newIntArray=new int[]{1,2,3,4};
		System.out.println(sum(newIntArray));*/
		/*Test for Problem6
		int[] newArray=new int[]{1,2,3,4};
		System.out.println(average(newArray));*/
		/*Test for Problem7
		System.out.println(factorial(0,1));
		System.out.println(factorial(2,1));
		System.out.println(factorial(3,1));*/
		/*Test for Problem7
		int[] intArray=new int[]{2,4,5,1,8,3};
		swap(intArray, 7);
		for(int i=0;i<intArray.length;i++){
			System.out.println(intArray[i]);
		}*/
		/*Test for Problem9
		int[] newArray=new int[]{1,-2,3,4};
		System.out.println(smallest(newArray));*/
		/*Test for Problem 10
		Collection<Integer> intList=new ArrayList<Integer>();
		intList.add(new Integer(1));
		intList.add(new Integer(2));
		intList.add(new Integer(3));
		intList.add(new Integer(4));
		System.out.println(smallest(intList));*/
		/*Problem17
		map();*/
	//Problem18
/*final int CONSTANT=75;
int[] intArray=new int[CONSTANT];
 for(int i=0;i<CONSTANT;i++){
	intArray[i]=i;
}
for(int i=0;i<CONSTANT;i++){
	if(i==0){
		System.out.print(intArray[i]+" ");
	}
	else if(i%3!=0){
		System.out.print(intArray[i]+" ");
	}
	else{
		System.out.print("\n");
		System.out.print(intArray[i]+" ");
	}*/
		
}
}

