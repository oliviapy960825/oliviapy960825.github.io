
public class ArrayStaticMethods {
	public static double mean(double[] data){
		double mean = 0;
		double count=0;
		for(double a:data){
			mean+=a;
			count++;
		}
		mean=mean/count;
		return mean;
	}
	public static int countWords(char[] sentence){
		int count=0;
		for(int i=0;i<sentence.length;i++){
			if(sentence[i]==' '||sentence[i]=='.'){
				count=count+1;
			}
		}
		return count;
	}
	public static int[] replace(int[] values, int value1, int value2){
		int a[]=new int[values.length];
		for(int i=0;i<=values.length-1;i++){
			a[i]=values[i];
			if(a[i]==value1){
				a[i]=value2;
			}
			else{
				a[i]=a[i];
			}
		}
		return a;
	}
	public static int[] evenFront(int[] is) {
		int a[]=new int[is.length];
		int count=0;
		for(int i=0;i<=is.length-1;i++){
			if(is[i]%2==0){
				a[count]=is[i];
                  count++;
			}
		}
		for(int i=0,j=count;i<=is.length-1;i++){
		       if(is[i]%2!=0){
		    	   a[j]=is[i];
		    	   j++;
		       }
			}
		return a;
		}
	
	public static Object surroundedCharacter(char[] charArray) {
		for(int i=0;i+2<=charArray.length-1;i++){
			if(charArray[i]==charArray[i+2]&&charArray[i+1]!=charArray[i]){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		System.out.println("No.".toCharArray());
	}
	}

