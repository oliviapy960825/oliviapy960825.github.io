package Second;

public class TryCatch {
public void f1() throws FriedEggException{
	throw new FriedEggException();
}
public void f2() throws ExamException{
	
}
public static void main(String[] args){
	TryCatch tryCatch=new TryCatch();
	try{
		tryCatch.f1();
	}
	catch(FriedEggException e){
		System.out.println(e);
	}
	try{
		tryCatch.f2();
	}
	catch(ExamException e){
		
	}
}
}
