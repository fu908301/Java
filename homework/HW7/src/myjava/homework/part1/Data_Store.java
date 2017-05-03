package myjava.homework.part1;

public class Data_Store {
	private String id;
	private String buy;
	private String sex;
	public Data_Store(String id,String buy,String sex){
		this.id = id;
		this.buy = buy;
		this.sex = sex;
	}
	public String getid(){
		return id;
	}
	
	public String getbuy(){
		return buy;
	}
	
	public String getsex(){
		return sex;
	}
	
	public void setid(String id){
		this.id = id;
	}
	
	public void setbuy(String buy){
		this.buy = buy;
	}
	
	public void setsex(String sex){
		this.sex = sex;
	}
	
	public boolean check_same(String id, String buy){
		if(this.id.equals(id) && this.buy.equals(buy) )
			return true;
		else
			return false;
	}
	public void print_data(){
		System.out.println(this.id + " " + this.buy + " " + this.sex);
	}
}
