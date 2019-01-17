
class MyStringEquality{

    public static void main(String[] argyle){

	String s1 = "dog";
	String s2 = "cat";
	String s3 = "dogcat";

	String temp  = s1 + s2;
		
	System.out.println(temp == s3);
	System.out.println(temp.equals(s3));
	//what does this print? why are they different?
	//reference equality == just asks if two things are same object in heap
	// .equals() method is written to allow more complex semantic comparison
	//possibly helpful video https://www.youtube.com/watch?v=qQe69w1YF54
    }

}
