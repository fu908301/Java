package myjava.homework;

import java.io.*;
import java.util.*;
import java.net.*;

public class server {
	private ServerSocket SS;
	private Socket socket;
	private DataInputStream reader;
	private DataOutputStream writer;
	private static int PORT_NUM = 12345;
	private ArrayList<information> inf;
	public server(){
		information ini_inf = new information("a", 1, 50);
		inf = new ArrayList<information>();
		inf.add(ini_inf);
		try{
			SS = new ServerSocket(PORT_NUM);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void run(){
		information one_inf;
		int get_choice;
		boolean the_same = false;
		boolean found = false;
		boolean pwd = false;
		String get_id;
		int get_password;
		int get_money;
		int location = 0;
		try{
			System.out.println("Waiting for connection...");
			socket = SS.accept();
			System.out.println("Connected success!");
			SS.close();
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
			while(true){
				get_choice = reader.readInt();
				switch(get_choice){
					case 1 :
						get_id = reader.readUTF();
						get_password = reader.readInt();
						for(int i = 0; i < inf.size(); i++){
							if(inf.get(i).getAccount().equals(get_id)){
								the_same = true;
								break;
							}
							else
								the_same = false;
						}
						if(the_same){
							writer.writeInt(-1);
							writer.flush();
						}
						else if(!the_same){
							writer.writeInt(0);
							writer.flush();
							one_inf = new information(get_id, get_password, 0);
							inf.add(one_inf);
						}
						writer.flush();
						break;
					case 2 :
						get_id = reader.readUTF();
						get_password = reader.readInt();
						for(int i =0; i < inf.size(); i++){
							if(inf.get(i).getAccount().equals(get_id)){
								location = i;
								found = true;
								if(inf.get(i).getPassword() == get_password)
									pwd = true;
								else 
									pwd = false;
								break;
							}
							else 
								found = false;
						}
						if(!found){
							writer.writeInt(-1);
							writer.flush();
						}
						else if(found && !pwd){
							writer.writeInt(-2);
							writer.flush();
						}
						else if(found && pwd){
							writer.writeInt(0);
							get_money = reader.readInt();
							inf.get(location).setMoney(get_money);
							writer.writeInt(inf.get(location).getMoney());
						}
						else
							System.out.println("Some error happeded 3 ");
						break;
					case 3 :
						System.out.println("System shut down now!");
						socket.close();
						System.exit(0);
						break;
					default :
						break;
				}
			}
		}catch(IOException e){
			System.out.println("Error happened, system closed now");
			System.exit(0);
		}
	}
	public static void main(String [] args){
		server main_server = new server();
		main_server.run();
	}
}
