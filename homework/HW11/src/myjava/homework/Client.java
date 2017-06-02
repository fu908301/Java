package myjava.homework;
import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
public class Client {
	private Socket socket;
	private DataInputStream reader;
	private static int PORT_NUM = 12345;
	private static String ip = "127.0.0.1";
	private Map<String, User> friend;
	public Client(){
		try{
			socket = new Socket(ip, PORT_NUM);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public void set_map(JSONObject js){
		friend = new HashMap<String,  User>();
		Iterator <?> keys = js.keys();
		User u;
		User temp;
		while(keys.hasNext()){
			String key = (String)keys.next();
			u = new User(key);
			for(int i = 0; i < js.getJSONArray(key).length(); i++){
				temp = new User(js.getJSONArray(key).get(i).toString());
				u.set_friend(temp);
			}
			friend.put(key, u);
		}
	}
	public String if_double(String input){
		String output = "";
		Iterator<User> it;
		output += "[";
		for(Object key : friend.keySet()){
			if(key.toString().equals(input))
				continue;
			it = friend.get(key).get_friends().iterator();
			while(it.hasNext()){
				String temp = it.next().get_name();
				if(temp.equals(input))
					output += key + ",";
			}
		}
		output += "]";
		return output;
	}
	public boolean not_exist(String input){
		for(Object key : friend.keySet()){
			if(key.toString().equals(input))
				return false;
		}
		return true;
	}
	public void run(){
		Scanner scan = new Scanner(System.in);
		String name = "";
		try{
			reader = new DataInputStream(socket.getInputStream());
			String strjson = reader.readUTF();
			JSONObject js = new JSONObject(strjson);
			this.set_map(js);
			System.out.println("Here is firendship : ");
			System.out.println(strjson);
			while(true){
				System.out.println("Enter a name, or type exit to finish");
				name = scan.next();
				if(name.equals("exit"))
					break;
				if(not_exist(name)){
					System.out.println(name + "doesn't have friends QAQ");
					continue;
				}
				System.out.println("Undirectional : ");
				System.out.print(name + " -> ");
				System.out.println(js.get(name));
				System.out.println("------------------");
				System.out.println("Bidirectional : ");
				System.out.print(name + " <-> ");
				System.out.println(if_double(name));
			}
			socket.close();
		}catch(IOException e){
			System.out.println("Socket error");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String [] args){
		Client c = new Client();
		c.run();
	}
}

