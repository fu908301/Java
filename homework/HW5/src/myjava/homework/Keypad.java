package myjava.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad {
	private BufferedReader br;
	
	// initializes 
	public Keypad () {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	

	public int getInput() {
		int input = 0;
		try{
			input = Integer.parseInt(br.readLine());
		}
		catch(IOException e){
			System.out.println("[Error] Wrong input.");
			System.out.println("[Error] Try again.");
		}
		return input;
	}
}
