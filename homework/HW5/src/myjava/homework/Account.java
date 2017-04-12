package myjava.homework;

public class Account {
	private int accountNumber;
	private int pin;
	private int totalBalance;
	private int debt = 0;
	private char creditLevel;
	public Account(int accountNumber,int pin ,int totalBalance,char creditLevel){
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.totalBalance = totalBalance;
		this.creditLevel = creditLevel;
	}
	
	public boolean validatePIN(int input_PIN){
		if(input_PIN != this.pin)
			return false;
		else 
			return true;
	}
	
	public int getAccountNumber(){
		return this.accountNumber;
	}
	
	public int getTotalBalance(){
		return this.totalBalance;
	}
	
	public char getCreditLevel(){
		return this.creditLevel;
	}
	
	public int getDebt(){
		return this.debt;
	}
	
	public void credit(int input){
		Screen sc = new Screen();
		int tempBalance = this.totalBalance - input;
		if(tempBalance < 0)
			sc.displayMessageLine("You dont have that much money");
		else{
			this.totalBalance = this.totalBalance - input;
			sc.displayMessageLine("Success");
		}
	}
		
	
	public void debit(int input){
		this.totalBalance = this.totalBalance + input;
	}
	
	public void loan(int input){
		int tempdebt = this.debt + input;
		Screen sc = new Screen();
		if(creditLevel == 'A' && tempdebt > 12000)
			sc.displayMessageLine("Transaction error,you dont have enough loan limit");
		else if(creditLevel == 'B' && tempdebt > 9000)
			sc.displayMessageLine("Transaction error,you dont have enough loan limit");
		else if(creditLevel == 'B' && tempdebt > 7000)
			sc.displayMessageLine("Transaction error,you dont have enough loan limit");
		else{
			this.debt = this.debt + input;
			sc.displayMessageLine("Loan success");
		}
		
	}
}
