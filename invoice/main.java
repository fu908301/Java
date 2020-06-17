import java.util.*;
import java.io.*;

public class main{
	public static void main(String[] args){
		invoice in = new invoice();
		in.run();
	}
}


class invoice{

	Scanner scanner;
	String sp1, sp2, nor1, nor2, nor3, six;
	public invoice(){
		scanner = new Scanner(System.in);
	}

	public void run(){
		int choice;
		choice = input_Choice();
		if(choice == 1){
			invoice_Number();
		}
		else if (choice == 2){
			input_Redeem();
			compare();
		}
		else if (choice == 3){
			try{
				FileWriter fw = new FileWriter("invoice");
				fw.write("");
				fw.flush();
				fw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	int input_Choice(){
		int choice;
		while(true){
			System.out.println("Input what you want to do : 1. Input invoice number; 2. Redeem 3. New Months");
			choice = scanner.nextInt();
			if(choice == 1 || choice == 2 || choice == 3){
				break;
			}
			else{
				System.out.println("Wrong input, please input again.");
				continue;
			}
		}
		return choice;
	}
	
	void invoice_Number(){
		FileWriter fw;
		String invoice;
		int choice;
		try{
			fw = new FileWriter("invoice", true);
			while(true){
				System.out.println("Please input invoice number");
				scanner.nextLine();
				invoice = scanner.nextLine();
				fw.write(invoice + "\r\n");
				fw.flush();
				System.out.println("Wanna to input again? 1 to type again, other number to exit");
				choice = scanner.nextInt();
				if(choice == 1){
					continue;
				}
				else{
					break;
				}
			}
		fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	void input_Redeem(){
		scanner.nextLine();
		System.out.println("Please input special number 1");
		sp1 = scanner.nextLine();
		System.out.println("Please input special number 2");
		sp2 = scanner.nextLine();
		System.out.println("Please input normal number 1");
		nor1 = scanner.nextLine();
		System.out.println("Please input normal number 2");
		nor2 = scanner.nextLine();
		System.out.println("Please input normal number 3");
		nor3 = scanner.nextLine();
		System.out.println("Please input six");
		six = scanner.nextLine();
	}

	void compareSP1(String origin){
		if(origin.equals(sp1)){
			System.out.println("Congratulations! You got ten million with " + origin);
		}
		else{
			System.out.println("You didn't get ten million");
		}
	}
	
	void compareSP2(String origin){
		if(origin.equals(sp2)){
			System.out.println("Congratulations! You got two million with " + origin);
		}
		else{
			System.out.println("You didn't get two million");
		}
	}
	
	
	void compareNor(String origin, String nor){
		String subOrigin1 = origin.substring(5);
		String subOrigin2 = origin.substring(4);
		String subOrigin3 = origin.substring(3);
		String subOrigin4 = origin.substring(2);
		String subOrigin5 = origin.substring(1);
		String subNor1 = nor.substring(5);
		String subNor2 = nor.substring(4);
		String subNor3 = nor.substring(3);
		String subNor4 = nor.substring(2);
		String subNor5 = nor.substring(1);
		if(origin.equals(nor)){
			System.out.println("Congratulations! You got two hundred thousand with " + origin);
		}
		else if (subOrigin5.equals(subNor5)){
			System.out.println("Congratulations! You got fourty thousand with " + origin);
		}
		else if (subOrigin4.equals(subNor4)){
			System.out.println("Congratulations! You got ten thousand with " + origin);
		}
		else if (subOrigin3.equals(subNor3)){
			System.out.println("Congratualtions! You got four thousand with " + origin);
		}
		else if (subOrigin2.equals(subNor2)){
			System.out.println("Congratulations! You got one thousand with " + origin);
		}
		else if (subOrigin1.equals(subNor1)){
			System.out.println("Congratulations! You got two hundred with " + origin);
		}
		else {
			System.out.println("You got nothing in normal");
		}
	}

	void compare6(String origin){
		String subOrigin = origin.substring(5);
		if(subOrigin.equals(six)){
			System.out.println("Congratulation! You got two hundred with " + origin);
		}
		else {
			System.out.println("You got nothing in six");
		}
	}
	
	void compare(){
		String get;
		FileReader fr;
		BufferedReader br;
		try{
			fr = new FileReader("invoice");
			br = new BufferedReader(fr);
			while(br.ready()){
				get = br.readLine();
				compareSP1(get);
				compareSP2(get);
				compareNor(get, nor1);
				compareNor(get, nor2);
				compareNor(get, nor3);
				compare6(get);
			}
			fr.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
