package myjava.homework;

public class  Withdrawal extends Transaction{
	private int account;
	public Withdrawal(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		bk.credit(account);
	}
}
