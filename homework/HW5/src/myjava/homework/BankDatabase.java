package myjava.homework;

public class BankDatabase {
	private Account[] accounts; // array of Accounts
	
    // no-argument BankDatabase constructor initializes accounts
	public BankDatabase () {
		accounts = new Account[3];  // just 3 accounts for testing
		accounts[0] = new Account(123, 321, 5000,'A');
		accounts[1] = new Account(456, 654, 3000,'B');
		accounts[2] = new Account(789, 987, 1000,'C');
	}
	
	int getAccountloc(int account_input){
		int temp_loc = -1;
		for(int i = 0; i < 3; i++){
			if(accounts[i].getAccountNumber() == account_input){
				temp_loc = i;
				break;
			}
			else{
				System.out.println("Account not exist!");
				temp_loc = -1;
			}
		}
		return temp_loc;
	}
	public boolean authenticateUser(int account_input,int PIN_input){
		boolean final_judge = false;
		int temp_account_loc = 0;
		for(int i = 0; i < 3; i++){
			if(accounts[i].getAccountNumber() == account_input){
				final_judge = true;
				temp_account_loc = i;
				break;
			}
			else 
				final_judge = false;
		}
		if(final_judge){
			if(accounts[temp_account_loc].validatePIN(PIN_input))
				final_judge = true;
			else 
				final_judge = false;
		}
		return final_judge;
	}
	
	public int getTotalBalance(int account_input){
		return accounts[getAccountloc(account_input)].getTotalBalance();
	}
	
	public char getCreditLevel(int account_input){
		return accounts[getAccountloc(account_input)].getCreditLevel();
	}
	
	public int getDebt(int account_input){
		return accounts[getAccountloc(account_input)].getDebt();
	}
	
	public void credit(int account_input){
		int dollars;
		Keypad input = new Keypad();
		dollars = input.getInput();
		accounts[getAccountloc(account_input)].credit(dollars);
	}
	
	public void debit(int account_input){
		int dollars;
		Keypad input = new Keypad();
		dollars = input.getInput();
		accounts[getAccountloc(account_input)].debit(dollars);
	}
	
	public void loan(int account_input){
		int dollars;
		Keypad input = new Keypad();
		dollars = input.getInput();
		accounts[getAccountloc(account_input)].loan(dollars);
	}
}
	


