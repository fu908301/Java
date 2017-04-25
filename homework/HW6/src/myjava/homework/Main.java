package myjava.homework;

import java.util.*;

public class Main {
	static void fighter(){
		Adventurer f = new Fighter(80,40,10);
		Random ran = new Random();
		int monster_hp = ran.nextInt(151) + 150;
		int monster_atk = ran.nextInt(6) + 30;
		System.out.println("[Monster appeared!]");
		System.out.println("---Adventurer---     ---Monster---");
		System.out.println("HP : " + f.getHp() + "                  HP : " + monster_hp);
		System.out.println("ATK : " + f.getAtk() + "                 ATK : " + monster_atk);
		System.out.println("DEF : " + f.getUnique());
		System.out.println("---------------       ---------------");
		while(true){
			int monster_real_atk = monster_atk + ran.nextInt(11);
			int real_damage = monster_real_atk - f.getUnique();
			int atk = f.action();
			if(atk != 0)
				monster_hp -= atk;
			if(monster_hp > 0)
				f.setHp(f.getHp() - real_damage);
			int A_HP = f.getHp();
			if(A_HP < 0)
				A_HP = 0;
			if(monster_hp < 0)
				monster_hp = 0;
			System.out.println("[Monster] : " + monster_real_atk + " damage");
			System.out.println("HP - " + real_damage + " points");
			System.out.println("---Adventurer---     ---Monster---");
			System.out.println("HP : " + A_HP + "          HP : " + monster_hp);
			System.out.println("ATK : " + f.getAtk() + "          ATK : " + monster_atk);
			System.out.println("DEF : " + f.getUnique());
			System.out.println("---------------       ---------------");
			if(monster_hp <= 0){
				System.out.println("You win");
				break;
			}
			if(A_HP <= 0){
				System.out.println("You lose");
				break;
			}
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int choice;
		try{
			choice = scan.nextInt();
			if(choice == 1){
				fighter();
			}
			else if(choice == 2){
				System.out.println("This is Magician");
			}
			else if(choice == 3){
				System.out.println("This is Archer");
			}
			else{ 
				fighter();
			}
		}
		catch(InputMismatchException e){
			scan.next();
			fighter();
		}
	}
}
