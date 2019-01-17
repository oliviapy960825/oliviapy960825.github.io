package midterm2;

public class TryCatch {
 public void f1() throws FriedEggException
{
	 throw new FriedEggException();
	 }
 public static void main(String[] args){
	 TryCatch newTryCatch=new TryCatch();
	 try{
		 newTryCatch.f1();
	 }
	 catch(FriedEggException e){
		 System.out.println(e);
	 }
 }
}
