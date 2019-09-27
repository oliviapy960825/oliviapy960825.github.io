
public class Account {
private String customerName;
private double balance;
private double monthlyInterestRate;
private double balanceLimit;
Account(String customerName,double balance,double monthlyInterestRate){
	this.customerName=customerName;
	this.balance=balance;
	this.monthlyInterestRate=monthlyInterestRate;
	this.balanceLimit=0;
	
}
Account(String customerName,double balance,double monthlyInterestRate,double balanceLimit){
	this.customerName=customerName;
	this.balance=balance;
	this.monthlyInterestRate=monthlyInterestRate;
	this.balanceLimit=balanceLimit;
	
}
public double getBalance(){
	return balance;
}
public double deposit(double deposit){
	balance=balance+deposit;
	return balance;
}
public boolean withdraw(double withdraw){
	if(withdraw>balance-balanceLimit)
		return false;
	else{
		balance=balance-withdraw;
		return true;
	}
		
}
public double addMonthlyInterest(){
	balance=balance*(1+monthlyInterestRate);
	return balance;
}
}
