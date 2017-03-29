package myjava.homework;
import java.util.*;
public class fourStarGame {
	private ArrayList<Integer> userNums;
	private ArrayList<Integer> winNums;
	
	public fourStarGame(){
		userNums = new ArrayList<Integer>();
		winNums = new ArrayList<Integer>();
	}
	
	public void generateUserNums(){
		try{
			int input;
			Scanner scan = new Scanner(System.in);
			for(int i = 0; i < 4; i++){
				input = scan.nextInt();
				if(input >= 10 || input <= 0){
					System.out.println("Input out of range!");
					System.exit(0);
				}
				userNums.add(input);
			}
		}
		catch(InputMismatchException e){
			System.out.println("[Error] Wrong input.");
			System.out.println("[Error] Try again.");
		}
	}
	
	public void generateWinNums(){
		int input;
		int count = 0;
		Random ran = new Random();
		while(true){
			input = ran.nextInt(8) + 1;
			if(!winNums.contains(input)){
				winNums.add(input);
				count++;
			}
			if(count == 4)
				break;
		}
	}
	public ArrayList<Integer> getUserNums(){
		return userNums;
	}
	public ArrayList<Integer> getWinNums(){
		return winNums;
	}
}
