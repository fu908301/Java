package myjava.homework.part2;

import java.util.*;

public class ItemList {
	private ArrayList<String> ID;
	public ItemList(){
		ID = new ArrayList <String>();
	}
	public void addItem(String input){
		ID.add(input);
	}
	public void remove(String input){
		if(!ID.contains(input))
			System.out.println("Input item is not in list");
		else
			ID.remove(input);
	}
	public void printList(){
		int count;
		int print;
		String output = null;
		count = ID.size();
		if(ID.isEmpty())
			System.out.println("No item in list");
		else{
			for(int i = 0;i < count;i++){
				print = i + 1;
				output = ID.get(i);
				System.out.println(print + ":" + output);
			}
		}
		
	}
}
