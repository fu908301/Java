package myjava.homework;

public class Magician extends Adventurer implements Skill{
	
	public Magician(int hp,int atk,int unique){
		super(hp,atk,unique);
	}
	public int action(){
		return 0;
	}
	
	public int attack_skill(){
		return 0;
	}
	
	public int defense_skill(){
		return 0;
	}
	
	public int buff_skill(){
		return 0;
	}
	
}
