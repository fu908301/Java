package myjava.homework;
import java.io.*;

import java.util.*;
import java.net.*;
import org.json.*;

public class Server {
	private ServerSocket SS;
	private Socket socket;
	private DataOutputStream writer;
	private static int PORT_NUM = 12345;
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private Map<String, User> map;
	private JSONObject Jmap;
	public Server(){
		this.set_friends();
		try{
			SS = new ServerSocket(PORT_NUM);
		}catch(IOException e){
			System.out.println("Server Socket error");
		}
	}
	public void set_friends(){
		u1 = new User("Saber");
		u2 = new User("Lancer");
		u3 = new User("Archer");
		u4 = new User("Avenger");
		u1.set_friend(u2);
		u1.set_friend(u3);
		u1.set_friend(u4);
		u2.set_friend(u3);
		u3.set_friend(u1);
		u4.set_friend(u1);
		u4.set_friend(u3);
		map = new HashMap<String, User>();
		map.put("Saber", u1);
		map.put("Lancer", u2);
		map.put("Archer", u3);
		map.put("Avenger", u4);
		String json_s = J_to_string(map);
		Jmap = new JSONObject(json_s);
	}
	public String J_to_string(Map<String, User> input){
		String s = "";
		Iterator<User> it;
		User temp;
		s += "{";
		for(Object key : map.keySet()){
			s += "\"" + input.get(key).get_name() + "\"" + ":[";
			it = input.get(key).get_friends().iterator();
			while(it.hasNext()){
				temp = it.next();
				s += "\"" + temp.get_name()+ "\"" + ",";
			}
			s += "],";
		}
		s += "}";
		return s;
	}
	public void run(){
		try{
			String S_Jmap = Jmap.toString();
			System.out.println("Waiting for connection...");
			socket = SS.accept();
			System.out.println("Connected success!");
			SS.close();
			writer = new DataOutputStream(socket.getOutputStream());
			writer.writeUTF(S_Jmap);
			writer.flush();
			socket.close();
		}catch(IOException e){
			System.out.println("Socket error");
		}
	}
	public static void main(String [] args){
		Server s = new Server();
		s.run();
	}
}
