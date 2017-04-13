package myjava.homework;

public class ATM {
	private boolean userAuthenticated;
	int account;
	int PIN;
	int choice;
	BankDatabase bk = new BankDatabase();
	Keypad kp = new Keypad();
	Screen sc = new Screen();
	
	void printMessage(){
		sc.displayMessageLine("Main menu:");
		sc.displayMessageLine("1.View my balance");
		sc.displayMessageLine("2.Withdraw");
		sc.displayMessageLine("3.Deposit");
		sc.displayMessageLine("4.Loan");
		sc.displayMessageLine("5.Exit");
		sc.displayMessage("Enter a choice : ");
	}
	
	void exe(Transaction input){
		input.execute();
	}
	
	public void run(){
		while(true){
			sc.displayMessageLine("Welcome!");
			sc.displayMessage("Please enter your account number : ");
			account = kp.getInput();
			sc.displayMessage("Please enter your PIN : ");
			PIN = kp.getInput();
			userAuthenticated = bk.authenticateUser(account, PIN);
			if(!userAuthenticated){
				sc.displayMessageLine("Account or PIN error,please type again.");
				continue;
			}
			while(true){
				printMessage();
				choice = kp.getInput();
				if(choice == 5)
					break;
				switch(choice){
					case 1 :
						Balancelnquiry bl = new Balancelnquiry(account,bk);
						exe(bl);
						break;
					case 2 :
						Withdrawal wd = new Withdrawal(account,bk);
						exe(wd);
						break;
					case 3 :
						Deposit dp = new Deposit(account,bk);
						exe(dp);
						break;
					case 4 :
						Loan ln = new Loan(account,bk);
						exe(ln);
						break;
					default : 
						sc.displayMessageLine("Input error!");
						continue;
				}
			}
			
		}
	}
}
