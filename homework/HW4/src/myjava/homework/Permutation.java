package myjava.homework;
import java.util.*;

public class Permutation extends fourStarGame{
	public Permutation(){
		super();
	}
	public void checkOfWin(){
		ArrayList<Integer> userNums = super.getUserNums();
		ArrayList<Integer> winNums = super.getWinNums();
		boolean check = true;
		for(int i = 0; i < 4; i++)
			if(winNums.get(i) != userNums.get(i)){
				check = false;
				break;
			}
		if(check)
			System.out.println("**You Win!");
		else
			System.out.println("**You lose!");
	}
}
