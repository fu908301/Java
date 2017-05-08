package myjava.homework;

public class information {
	private String account;
	private int password;
	private int money;
	public information(String account, int password, int money){
		this.account = account;
		this.password = password;
		this.money = money;
	}
	
	public String getAccount(){
		return this.account;
	}
	
	public int getPassword(){
		return this.password;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void setMoney(int input){
		this.money = this.money + input;
	}
}
