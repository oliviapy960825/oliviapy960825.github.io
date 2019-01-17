package Pretest;

public class MyStringEquality {
public static void main(String[] argyle){
	String s1 = "dog";
	String s2="cat";
	String s3="dogcat";
	String temp=s1+s2;
	System.out.println(temp==s3);
	System.out.println(temp.equals(s3));
}
}
