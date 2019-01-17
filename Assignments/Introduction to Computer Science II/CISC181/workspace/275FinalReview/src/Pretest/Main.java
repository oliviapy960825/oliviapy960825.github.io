package Pretest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Main {
	public static int Sum(int[] intArray2){
		int sum=0;
		for(int i=0; i<intArray2.length;i++){
			sum+=intArray2[i];
		}
		return sum;
	}
	public static int numOfLegs(ArrayList<Dog> dogs){
		int sum=0;
		for(Dog d: dogs){
			sum+=d.legs;
		}
		return sum;
	}
	public static double average(int[] intArray2){
		double sum=0;
		double average=0;
		for(int i:intArray2){
			sum+=i;
		}
		average=sum/intArray2.length;
		return average;
	}
	public static int factorial(int num){
		if(num<=1){
			return 1;
		}
		else{
			return num*factorial(num-1);
		}
	}
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
	/*final int LENGTH=670;//size of data set to go into array;
	final int NUMS_PER_ROW=30;//numbers per row when printed
	
	//declare an array to hold the integer data set
	int[] intArray =new int[LENGTH];
	//Initialize arrat to the multiples of four {0,4,8,...}
	for(int i=0; i<LENGTH; i++){
		intArray[i]=i*4;
	}
	
	//Print the array with NUMS_PER_ROW element per row; last row may have fewer.
	for(int i=0; i<LENGTH;i+=NUMS_PER_ROW){
		for(int j=0; j< NUMS_PER_ROW;j++){
			if(i+j<LENGTH){
				System.out.print(intArray[i+j]+" ");
		}
		
	}
		System.out.println();
	}*/
	//Problem4 test
	int[] intArray2={1,2,3,4};
	//System.out.println(Sum(intArray2));
	
	//Problem5 test
	/*Dog d1=new Dog(2);
	Dog d2=new Dog(3);
	Dog d3=new Dog(4);
	ArrayList<Dog> dogs=new ArrayList<Dog>();
	dogs.add(d1);
	dogs.add(d2);
	dogs.add(d3);
	System.out.println(numOfLegs(dogs));*/
	
	//Problem6 test
	//System.out.println(average(intArray2));
	
	//Problem7
	//System.out.println(factorial(3));
	
	Collection<Animal> animals=new ArrayList<Animal>();
	Cow cow=new Cow("Mary",4);
	Horse horse=new Horse("Will",4);
	animals.add(cow);
	animals.add(horse);
	for(Animal a:animals){
		System.out.println(a.speak());
	}
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
