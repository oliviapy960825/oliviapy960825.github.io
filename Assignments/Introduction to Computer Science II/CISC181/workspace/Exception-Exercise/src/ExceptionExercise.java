
public class ExceptionExercise{

	public void f1(int x) throws XisFiveException{
		if(x==5){
			throw new XisFiveException("new XisFiveException");
		}
	}
	public void f2(int x) throws XisFiveException{
		try{
			f1(x);
		}
		catch(XisFiveException e){
			System.out.println("new number should be "+(x+1));
			f1(x+1);
		}
	}
}
