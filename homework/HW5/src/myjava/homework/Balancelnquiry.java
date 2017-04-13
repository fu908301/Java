package myjava.homework;

public class Balancelnquiry extends Transaction{
	public Balancelnquiry(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		int balance;
		int account;
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		balance = bk.getTotalBalance(account);
		Screen sc = new Screen();
		String StringBalance = Integer.toString(balance);
		sc.displayMessageLine("Balance information");
		sc.displayMessageLine("Total Balance : " + StringBalance);
	}
}
