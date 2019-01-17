package First;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import First.MyClass;
public class MyClassTest {
public void test(){
	assertEquals(0, MyClass.multiply(5, 0),0.01);
}
}
