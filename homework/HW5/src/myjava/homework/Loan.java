package myjava.homework;

public class Loan extends Transaction{
	public Loan(int accountNumber,BankDatabase bk) {
		super(accountNumber,bk);
	}
	public void execute(){
		int account;
		int debt;
		char level;
		int limit = 0;
		BankDatabase bk = super.getbk();
		account = super.getAccountNumber();
		debt = bk.getDebt(account);
		level = bk.getCreditLevel(account);
		if(level == 'A')
			limit = 12000 - debt;
		else if(level == 'B')
			limit = 9000 - debt;
		else if(level == 'C')
			limit = 7000 - debt;
		String Stringdebt = Integer.toString(debt);
		String Stringlimit = Integer.toString(limit);
		Screen sc = new Screen();
		sc.displayMessageLine("Your debt : " + Stringdebt);
		if(limit > 0){
			sc.displayMessageLine("Your loan limit is " + Stringlimit + ".How much do you want to loan?");
			bk.loan(account); 
		}	
		else
			sc.displayMessageLine("Sorry.You can't loan any money now.Please repay your debt at our counter");
	}
}
