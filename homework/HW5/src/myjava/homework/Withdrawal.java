package myjava.homework;

public class  Withdrawal extends Transaction{
	private int account;
	public Withdrawal(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		int amount;
		Screen sc = new Screen();
		Keypad kp = new Keypad();
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		sc.displayMessageLine("How much do you want to withdraw?");
		amount = kp.getInput();
		bk.credit(account,amount);
	}
}
