package myjava.homework;

import java.io.BufferedReader;

import java.io.InputStreamReader;
public class Keypad {
	private BufferedReader br;
	private String inputS;
	
	// initializes 
	public Keypad () {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	

	public int getInput() {
		int input = 0;
		try{
			inputS = br.readLine();
			input = Integer.parseInt(inputS);
		}
		catch(Exception e){
			System.out.println("Error");
		}
		return input;
	}
}
