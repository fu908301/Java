package myjava.homework.part2;

import java.util.HashMap;

public class Data_Store {
	private String id;
	private HashMap<String, Integer> product_count;
	public Data_Store(String id){
		this.id = id;
		product_count = new HashMap<String, Integer>();
	}
	
	public String getid(){
		return this.id;
	}
	
	public HashMap<String, Integer> get_data(){
		return product_count;
	}
	public void set_Data(String input){
		final Integer count = product_count.get(input);
		if(count == null)
			product_count.put(input, 1);
		else
			product_count.put(input, count + 1);
	}
}
