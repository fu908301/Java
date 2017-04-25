package myjava.homework;

import java.util.*;
public class Fighter extends Adventurer implements Skill{
	
	public Fighter(int hp,int atk,int unique){
		super(hp,atk,unique);
	}
	public int action(){
		Scanner scan = new Scanner(System.in);
		int choice;
		try{
			System.out.println("(1) Brandish (2) Iron Body (3) Rage");
			System.out.println("Action:(By default 1)");
			choice = scan.nextInt();
			if(choice == 1){
				int attack = this.attack_skill();
				System.out.println("[Brandish] : " + attack + " damage");
				return attack;
			}
			else if(choice == 2){
				System.out.println("[Iron Body] : DEF + " + super.getUnique() + " points");
				super.setUnique(this.defense_skill());
				return 0;
			}
			else if(choice == 3){
				System.out.println("[Rage] : ATK + " + super.getAtk() + " points");
				super.setAtk(this.buff_skill());
				return 0;
			}
			else{
				int attack = this.attack_skill();
				System.out.println("[Brandish] : " + attack + " damage");
				return attack;
			}
				
		}
		catch(InputMismatchException e){
			scan.next();
			int attack = this.attack_skill();
			System.out.println("[Brandish] : " + attack + " damage");
			return attack;
		}
	}
	
	public int attack_skill(){
		Random ran = new Random();
		int range = ran.nextInt(11);
		int return_atk = super.getAtk() + range;
		return return_atk;
	}
	
	public int defense_skill(){
		return super.getUnique() * 2;
	}
	
	public int buff_skill(){
		return super.getAtk() * 2;
	}
	
}
