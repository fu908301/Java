package JAVA_HW3;

public class Student_info {
	String name;
	int ID;
	public Student_info(String inputS,int inputI){
		this.name = inputS;
		this.ID = inputI;
	}
	public void show_data(){
		System.out.println("Name:" + name);
		System.out.println("ID:" + ID);
	}
	public String getName(){
		return this.name;
	}
	public int getID(){
		return this.ID;
	}
}
