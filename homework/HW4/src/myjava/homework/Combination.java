package myjava.homework;

import java.util.ArrayList;

public class Combination extends fourStarGame{
	public Combination(){
		super();
	}
	public void checkOfWin(){
		ArrayList<Integer> userNums = super.getUserNums();
		ArrayList<Integer> winNums = super.getWinNums();
		boolean check = true;
		for(int i = 0; i < 4; i++)
			if(!winNums.contains(userNums.get(i))){
				check = false;
				break;
			}
		if(check)
			System.out.println("**You Win!");
		else
			System.out.println("**You lose!");
	}
}
