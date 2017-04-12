package myjava.homework;

public abstract class Transaction {
	private int accountNumber;
	private BankDatabase bk;
	public Transaction(int accountNumber,BankDatabase bk){
		this.accountNumber = accountNumber;
		this.bk = bk;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public BankDatabase getbk(){
		return bk;
	}
	public abstract void execute();
}
