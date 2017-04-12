package myjava.homework;

public class Deposit extends Transaction{
	private int account;
	public Deposit(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		bk.debit(account);
		Screen sc = new Screen();
		sc.displayMessageLine("Success!");
	}
}
