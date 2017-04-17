package myjava.homework;

public class Deposit extends Transaction{
	private int account;
	public Deposit(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		int amount;
		Keypad kp = new Keypad();
		Screen sc = new Screen();
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		sc.displayMessageLine("How much do you want to deposit?");
		amount = kp.getInput();
		bk.debit(account,amount);
		sc.displayMessageLine("Success!");
	}
}
