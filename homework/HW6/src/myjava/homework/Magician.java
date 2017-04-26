package myjava.homework;

import java.util.*;

public class Magician extends Adventurer implements Skill{
	
	public Magician(int hp,int atk,int unique){
		super(hp,atk,unique);
	}
	public int action(){
		Scanner scan = new Scanner(System.in);
		int choice;
		try{
			System.out.println("(1) Cold Beam (2) Energy Shield (3) Heal");
			System.out.println("Action:(By default 1)");
			choice = scan.nextInt();
			if(choice == 1){
				int attack = this.attack_skill();
				System.out.println("[Cold Beam] : " + attack + " damage");
				return attack;
			}
			else if(choice == 2){
				int shield = this.defense_skill();
				if(super.getUnique() <= 0){
					System.out.println("[Energy Shield] : Shield + " + shield + " points");
					super.setUnique(super.getUnique() + shield);
				}
				else if(super.getUnique() > 0){
					System.out.println("[Energy Shield] : Shield + 0 points");
				}
				return 0;
			}
			else if(choice == 3){
				int heal = this.buff_skill();
				int over_heal = 40 - super.getHp();
				if(super.getHp() + heal <= 40){
					System.out.println("[Heal] : Hp + " + heal + " points");
					super.setHp(super.getHp() + heal);
				}
				else if(super.getHp() + heal > 40){
					System.out.println("[Heal] : Hp + " + over_heal + " points");
					super.setHp(40);
				}
				return 0;
			}
			else{
				int attack = this.attack_skill();
				System.out.println("[Cold Beam] : " + attack + " damage");
				return attack;
			}
				
		}
		catch(InputMismatchException e){
			scan.next();
			int attack = this.attack_skill();
			System.out.println("[Cold Beam] : " + attack + " damage");
			return attack;
		}
	}
	
	public int attack_skill(){
		Random ran = new Random();
		int range = ran.nextInt(11);
		int damage = super.getAtk() * 4 + range;
		return damage;
	}
	
	public int defense_skill(){
		Random ran = new Random();
		int range = ran.nextInt(11);
		int shield = super.getAtk() * 4 + range;
		return shield;
	}
	
	public int buff_skill(){
		Random ran = new Random();
		int range = ran.nextInt(11);
		int heal = super.getAtk() * 4 + range;
		return heal;
	}
	
}
