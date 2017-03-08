package myjava.homework.part2;

import java.util.*;

public class Controller {
	public static void main(String[] args){
		int option;
		Scanner scan = new Scanner(System.in);
		String input = null;
		ItemList mylist = new ItemList();
		while(true){
			try{
				System.out.println("type 1 : add item to list");
				System.out.println("type 2 : remove item from list");
				System.out.println("type 3 : show the list");
				option = scan.nextInt();
				switch(option){
					case 1 :
						System.out.print("Add item name : ");
						input = scan.next();
						mylist.addItem(input);
						break;
					case 2 :
						System.out.print("Remove item name : ");
						input = scan.next();
						mylist.remove(input);
						break;
					case 3 :
						System.out.println("Show the list");
						mylist.printList();
				}
			}
			catch(InputMismatchException e){
				System.out.println("Input error!ONLY integers");
			}
		}
		
	}
}
