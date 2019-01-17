import junit.framework.TestCase;

public class PS0 extends TestCase{
	
public static double compute_tax(double income,double exemption,boolean non_profit){
	
	int adjusted_income=(int) (income-(exemption*5000));
	
	double return_number;
	
	if(non_profit||adjusted_income<0){
		return 0;
	}
	
	else if(adjusted_income<10000){
		return return_number=adjusted_income*0.1;
	}
	
	else if(adjusted_income<20000){
		return return_number=adjusted_income*0.15;
	}
	
	else if(adjusted_income<50000){
		return return_number=adjusted_income*0.2;
	}
	
	else{
		return return_number=adjusted_income*0.25;
	}
}
public static double gross_income(double income,double exemption,boolean non_profit)
{
	return income-compute_tax(income,exemption,non_profit);
}
	public static void main(String[] args)
	{
		System.out.println(compute_tax(30000,2,false));
		System.out.println(compute_tax(10000,6,false));
		System.out.println(compute_tax(75000,1,false));
		System.out.println(compute_tax(75000,1,true));
		System.out.println(gross_income(30000,2,false));
		System.out.println(gross_income(10000,6,false));
		System.out.println(gross_income(75000,1,false));
		System.out.println(gross_income(75000,1,true));
		System.out.println(findExemptions(0));
		System.out.println(findExemptions(10000));
		System.out.println(findExemptions(20000));
		System.out.println(findExemptions(50000));
		System.out.println(sumLuhnDigits(0L,false));
		System.out.println(sumLuhnDigits(21L,true));
		System.out.println(sumLuhnDigits(7992739871005L,false));
		System.out.println(sumLuhnDigits(7992739871003L,false));
	}
	
    public static void test_static(){
    	assertEquals(4000.0,compute_tax(30000,2,false),0.0);
    	assertEquals(0.0,compute_tax(10000,6,false),0.0);
    	assertEquals(17500.0,compute_tax(75000,1,false),0.0);
    	assertEquals(0.0,compute_tax(75000,1,true),0.0);
    }
    public static void test_static2(){
    	assertEquals(26000.0,gross_income(30000,2,false));
    	assertEquals(10000.0,gross_income(10000,6,false));
    	assertEquals(57500.0,gross_income(75000,1,false));
    	assertEquals(75000.0,gross_income(75000,1,true));
    }
    public static double findExemptions(double income){
    	int exemption=0;
    	while(0.95*income>gross_income(income,exemption,false)){
    		exemption++;
    	}
		return exemption;
    }
    public static void test_static3(){
    	assertEquals(0,findExemptions(0),0.0);
    	assertEquals(1,findExemptions(10000),0.0);
    	assertEquals(3,findExemptions(20000),0.0);
    	assertEquals(7,findExemptions(50000),0.0);
    }
    
	
    public static long sumLuhnDigits(long number,boolean odd){
    	String str=String.valueOf(number);
    	long sum;
		if(odd&&number>0){
	     sum=((number%10)*2)%10+((number%10)*2)/10+(number/10)%10+sumLuhnDigits(number/100,odd);
		    return sum;
		}
    	else if(number>0)
    		{	
    		sum=number%10+(((number/10)%10)*2)%10+(((number/10)%10)*2)/10+sumLuhnDigits(number/100,odd);
    		return sum;   	
    		}
    		
    	
    	else
    		return 0;
    	}
    public static long sumLuhnDigits_2(long number,boolean odd){
    	if(number==0){
    		return 0;
    	}
    	else{
    		long sumRest=sumLuhnDigits_2(number/10,!odd);
    		long x=(odd?2:1)*(number%10);
    		return x/10+x%10+sumRest;
    	}
    }
   
    public static long sumLuhnDigits_3(long number,boolean odd){
    	long sumRest=0;
    	while(number!=0){
    		long x=(odd?2:1)*(number%10);
    		sumRest=x/10+x%10+sumRest;
    		number=number/10;
    		odd=!odd;
    	}
    	return sumRest;
    }
    public static void test_sumLuhnDigits(){
    	assertEquals(0,sumLuhnDigits(0L,false));
    	assertEquals(4,sumLuhnDigits(21L,true));
    	assertEquals(72,sumLuhnDigits(7992739871005L,false));
    	assertEquals(70,sumLuhnDigits(7992739871003L,false));
    }
	public static boolean luhnCheck(long number){
    	if(sumLuhnDigits(number,false)%10==0)
    		return true;
    	else
    		return false;
    }
    public static void test_luhnCheck() {
        assertTrue(luhnCheck(0L));
        assertFalse(luhnCheck(21L));
        assertFalse(luhnCheck(7992739871005L));
        assertTrue(luhnCheck(7992739871003L));
   }
    
}
