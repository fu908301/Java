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
			if(monster_hp > 0){
				f.setHp(f.getHp() - real_damage);
				System.out.println("[Monster] : " + monster_real_atk + " damage");
				System.out.println("[Fighter] HP - " + real_damage + " points");
			}
			int A_HP = f.getHp();
			if(A_HP < 0)
				A_HP = 0;
			if(monster_hp < 0)
				monster_hp = 0;
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
	
	static void magician(){
		Adventurer f = new Magician(40,20,0);
		Random ran = new Random();
		int monster_hp = ran.nextInt(151) + 150;
		int monster_atk = ran.nextInt(6) + 30;
		System.out.println("[Monster appeared!]");
		System.out.println("---Adventurer---     ---Monster---");
		System.out.println("HP : " + f.getHp() + "                  HP : " + monster_hp);
		System.out.println("ATK : " + f.getAtk() + "                 ATK : " + monster_atk);
		System.out.println("ES : " + f.getUnique());
		System.out.println("---------------       ---------------");
		while(true){
			int monster_real_atk = monster_atk + ran.nextInt(11);
			int atk = f.action();
			if(atk != 0)
				monster_hp -= atk;
			if(monster_hp > 0){
				if(f.getUnique() <= 0){
					f.setHp(f.getHp() - monster_real_atk);
					System.out.println("[Monster] : " + monster_real_atk + " damage");
					System.out.println("[Energy Shield] : shield - 0 points");
					System.out.println("[Magician] : HP - " + monster_real_atk + " points");
				}
				else if(f.getUnique() > 0){
					f.setUnique(f.getUnique() - monster_real_atk);
					System.out.println("[Monster] : " + monster_real_atk + " damage");
					System.out.println("[Energy Shield] : shield - " + monster_real_atk + " points");
				}
					
			}
			int A_HP = f.getHp();
			if(A_HP < 0)
				A_HP = 0;
			if(monster_hp < 0)
				monster_hp = 0;
			if(f.getUnique() < 0)
				f.setUnique(0);
			System.out.println("---Adventurer---     ---Monster---");
			System.out.println("HP : " + A_HP + "          HP : " + monster_hp);
			System.out.println("ATK : " + f.getAtk() + "          ATK : " + monster_atk);
			System.out.println("ES : " + f.getUnique());
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
	
	static void archer(){
		Adventurer f = new Archer(70,60,40);
		Random ran = new Random();
		int monster_hp = ran.nextInt(151) + 150;
		int monster_atk = ran.nextInt(6) + 30;
		System.out.println("[Monster appeared!]");
		System.out.println("---Adventurer---     ---Monster---");
		System.out.println("HP : " + f.getHp() + "                  HP : " + monster_hp);
		System.out.println("ATK : " + f.getAtk() + "                 ATK : " + monster_atk);
		System.out.println("EVA : " + f.getUnique());
		System.out.println("---------------       ---------------");
		while(true){
			int monster_real_atk = monster_atk + ran.nextInt(11);
			int atk = f.action();
			if(atk != 0)
				monster_hp -= atk;
			if(monster_hp > 0){
				int EVA = f.getUnique();
				int percentage = ran.nextInt(100) + 1;
				System.out.println("[Monster] : " + monster_real_atk + " damage");
				if(percentage < EVA)
					System.out.println("Evasion success!");
				else {
					f.setHp(f.getHp() - monster_real_atk);
					System.out.println("[Archer] : HP - " + monster_real_atk + " points");
				}
				
			}
			int A_HP = f.getHp();
			if(A_HP < 0)
				A_HP = 0;
			if(monster_hp < 0)
				monster_hp = 0;
			System.out.println("---Adventurer---     ---Monster---");
			System.out.println("HP : " + A_HP + "          HP : " + monster_hp);
			System.out.println("ATK : " + f.getAtk() + "          ATK : " + monster_atk);
			System.out.println("EVA : " + f.getUnique());
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
		System.out.println("(1) Fighter (2) Magician (3) Archer");
		System.out.println("Choose your character (By default 1)");
		try{
			choice = scan.nextInt();
			if(choice == 1){
				fighter();
			}
			else if(choice == 2){
				magician();
			}
			else if(choice == 3){
				archer();
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
