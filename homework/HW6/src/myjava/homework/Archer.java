package myjava.homework;
import java.util.*;

public class Archer extends Adventurer implements Skill{
	int CRI = 0;
	public Archer(int hp,int atk,int unique){
		super(hp,atk,unique);
	}
	public int action(){
		Scanner scan = new Scanner(System.in);
		int choice;
		try{
			System.out.println("(1) Arrow Blow (2) Speed Boost (3) Critical shot");
			System.out.println("Action:(By default 1)");
			choice = scan.nextInt();
			if(choice == 1){
				int attack = this.attack_skill();
				System.out.println("[Arrow Blow] : " + attack + " damage");
				return attack;
			}
			else if(choice == 2){
				super.setUnique(this.defense_skill());
				System.out.println("[Evasion Boost] : EVA : " + super.getUnique() + " %");
				return 0;
			}
			else if(choice == 3){
				int new_CRI = this.buff_skill();
				System.out.println("[Critical Shot] : CRI : " + new_CRI + " %");
				return 0;
			}
			else{
				int attack = this.attack_skill();
				System.out.println("[Arrow Blow] : " + attack + " damage");
				return attack;
			}
				
		}
		catch(InputMismatchException e){
			scan.next();
			int attack = this.attack_skill();
			System.out.println("[Arrow Blow] : " + attack + " damage");
			return attack;
		}
	}
	
	public int attack_skill(){
		Random ran = new Random();
		int percentage = ran.nextInt(100) + 1;
		int real_atk = super.getAtk() + ran.nextInt(11);
		if(percentage <= this.CRI)
			return real_atk * 2;
		else 
			return real_atk;
	}
	
	public int defense_skill(){
		int new_EVA = super.getUnique() * 2;
		if(new_EVA > 100)
			return super.getUnique();
		else
			return new_EVA;
	}
	
	public int buff_skill(){
		int new_CRI = this.CRI + 25;
		if(new_CRI > 100)
			return this.CRI;
		else {
			this.CRI += 25;
			return new_CRI;
		}
	}
}
