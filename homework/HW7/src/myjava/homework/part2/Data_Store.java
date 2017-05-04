package myjava.homework.part2;

public class Data_Store {
	private String id;
	private int product_A;
	private int product_B;
	private int product_C;
	public Data_Store(String id){
		this.id = id;
		this.product_A = 0;
		this.product_B = 0;
		this.product_C = 0;
	}
	
	public int getA(){
		return this.product_A;
	}
	
	public int getB(){
		return this.product_B;
	}
	
	public int getC(){
		return this.product_C;
	}
	
	public String getid(){
		return this.id;
	}
	public void set_Data(String input){
		if(input.equals("Product_A"))
			this.product_A++;
		else if(input.equals("Product_B"))
			this.product_B++;
		else if(input.equals("Product_C"))
			this.product_C++;
		else
			System.out.println("Some error happened!");
	}
}
