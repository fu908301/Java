package myjava.homework;
import java.util.*;
public class User {
	private String username;
	private Set<User> friends;
	public User(String username){
		this.friends = new HashSet<User>();
		this.set_name(username);
	}
	
	public void set_name(String username){
		this.username = username;
	}
	
	public void set_friend(User name){
		friends.add(name);
	}
	
	public String get_name(){
		return this.username;
	}
	
	public Set<User> get_friends(){
		return this.friends;
	}
}
