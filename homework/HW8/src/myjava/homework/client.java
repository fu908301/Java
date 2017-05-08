package myjava.homework;

import java.io.*;

import java.net.*;
import java.util.*;

public class client {
	private Socket socket;
	private DataInputStream reader;
	private DataOutputStream writer;
	public client(String ip, int port){
		try{
			socket = new Socket(ip,port);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void run(){
		Scanner scan = new Scanner(System.in);
		int choice;
		int password;
		int return_int;//This is for receiving the choice from server.
		int money;
		int return_money;//This is used for returning money from server.
		String id;
		try{
			if(socket != null){
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());
				while(true){
					System.out.println("1. Add new account.");
					System.out.println("2. Sign in.");
					System.out.println("3. Leave");
					choice = scan.nextInt();
					writer.writeInt(choice);//Pass the choice to the server first.
					writer.flush();
					switch(choice){
						case 1 :
							System.out.println("Input your account : ");
							id = scan.next();
							System.out.println("Input your password : ");
							password = scan.nextInt();
							writer.writeUTF(id);//Pass the id to the server
							writer.flush();
							writer.writeInt(password);//Pass the password to the server 
							writer.flush();
							return_int = reader.readInt();//Receive the choice from server
							if(return_int == 0)//This means server successfully store the id and password
								break;
							else if(return_int == -1){//This means server has the same id.
								System.out.println("Error, having the same account.");
								break;
							}
							else{
								System.out.println("Some error happened.");
								break;
							}
						case 2 :
							System.out.println("Input your account : ");
							id = scan.next();
							System.out.println("Input your password : ");
							password = scan.nextInt();
							writer.writeUTF(id);//Pass the id to the server
							writer.flush();
							writer.writeInt(password);//Pass the password to the server 
							writer.flush();
							return_int = reader.readInt();//Receive the choice from server
							if(return_int == 0){ //Successfully found the account
								System.out.println("Input your money : ");
								money = scan.nextInt();
								writer.writeInt(money);
								writer.flush();
								return_money = reader.readInt();
								System.out.println(return_money);
								break;
							}
							else if(return_int == -1){//This means server cannot find the account
								System.out.println("Can't find the account.");
								break;
							}
							else if(return_int == -2){//This means password is not correct.
								System.out.println("ERROR! Password is not correct");
								break;
							}
							else {
								System.out.println("Some error happened 2.");
								break;
							}
						case 3 :
							System.out.println("System shut down now!");
							socket.close();
							System.exit(0);
							break;
						default :
							System.out.println("Input must be in 1~3, please retype again!");
							break;
					}
				}
			}
		}catch(IOException e){
			System.out.println("Error happened, system closed now");
			System.exit(0);
		}catch(InputMismatchException e){
			scan.next();
			System.out.println("Input error, system closed now");
			System.exit(0);
		}
	}
	
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		client main_client;
		String ip;
		int port;
		try{
			System.out.println("Input your address:");
			ip = scan.next();
			System.out.println("Input your port:");
			port = scan.nextInt();
			System.out.println("Connecting...");
			main_client = new client(ip, port);
			main_client.run();
		}catch(InputMismatchException e){
			scan.next();
			System.out.println("Input error,System closed now");
			System.exit(0);
		}
		
		
	}
}
