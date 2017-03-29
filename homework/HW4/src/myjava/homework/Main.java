package myjava.homework;
import java.util.*;

public class Main {
	public static void main(String[] args){
		int input;
		Scanner scan = new Scanner(System.in);
		Combination com;
		Permutation per;
		ArrayList<Integer> temp;
		while(true){
			try{
				System.out.println("Choose your Four Star Game type : (1:Permutation 2:Combination 3:Exit)");
				input = scan.nextInt();
				switch(input){
					case 1 :
						per = new Permutation();
						per.generateWinNums();
						temp = per.getWinNums();
						System.out.print("Win numbers : ");
						for(int i = 0;i < 4; i++)
							System.out.print(temp.get(i) + " ");
						System.out.println("");
						System.out.print("Input four user numbers : ");
						per.generateUserNums();
						per.checkOfWin();
						break;
					case 2 :
						com = new Combination();
						com.generateWinNums();
						temp = com.getWinNums();
						System.out.print("Win numbers : ");
						for(int i = 0;i < 4; i++)
							System.out.print(temp.get(i) + " ");
						System.out.println("");
						System.out.print("Input four user numbers : ");
						com.generateUserNums();
						com.checkOfWin();
						break;
					case 3 :
						System.exit(0);
				}
			}
			catch(InputMismatchException e){
				System.out.println("[Error] Wrong input.");
				System.out.println("[Error] Try again.");
			}
		}
	}
}
