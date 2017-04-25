package myjava.homework;

public abstract class Adventurer {
	private int hp;
	private int atk;
	private int unique;
	
	public Adventurer(int hp,int atk,int unique){
		this.hp = hp;
		this.atk = atk;
		this.unique = unique;
	}
	public int getHp(){
		return hp;
	}
	
	public int getAtk(){
		return atk;
	}
	
	public int getUnique(){
		return unique;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public void setAtk(int atk){
		this.atk = atk;
	}
	
	public void setUnique(int unique){
		this.unique = unique;
	}
	
	public abstract int action();
}
