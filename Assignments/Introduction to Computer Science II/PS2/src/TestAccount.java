import junit.framework.TestCase;




public class TestAccount extends TestCase {
	
	
	public void test_series() {
		Account testAccount = new Account("John Doe", 0, 0.005);
		testAccount.deposit(50);
		testAccount.withdraw(10);
		testAccount.addMonthlyInterest();

		assertEquals(40.2, testAccount.getBalance(), 0.01);
		
	}
	public void test_series2() {
		Account testAccount = new Account("John Doe", 100, 0.002);
		testAccount.deposit(50);
		testAccount.withdraw(10);
		testAccount.addMonthlyInterest();

		assertEquals(140.28, testAccount.getBalance(), 0.001);
		
	}
	public void test_series3() {
		Account testAccount = new Account("John Doe",150, 0.004);
		testAccount.deposit(50);
		testAccount.withdraw(10);
		testAccount.addMonthlyInterest();

		assertEquals(190.76, testAccount.getBalance(), 0.001);
		
	}
	public void test_series4() {
		Account testAccount = new Account("John Doe", 10000, 0.005);
		testAccount.deposit(500);
		testAccount.withdraw(150);
		testAccount.addMonthlyInterest();

		assertEquals(10401.75, testAccount.getBalance(), 0.001);
		
	}
	public void test_series5() {
		Account testAccount = new Account("John Doe", 10000, 0.005,-1000);
		testAccount.deposit(500);
		testAccount.withdraw(11000);
		testAccount.addMonthlyInterest();

		assertEquals(-502.5, testAccount.getBalance(), 0.001);
}
}
