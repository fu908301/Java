package myjava.homework.part1;

public class StudentInformation {
	private String ID;
	private String name;
	private int score;
	public StudentInformation(){ //constructor
		ID = "";
		name = "";
		score = 0;
	}
	public void setID(String input){
		this.ID = input;
	}
	public void setName(String input){
		this.name = input;
	}
	public void setScore(int input){
		this.score = input;
	}
	public String getID(){
		return ID;
	}
	public String getName(){
		return name;
	}
	public int getScore(){
		return score;
	}
	public void setData(String inputID,String inputName,int inputscore){
		this.ID = inputID;
		this.name = inputName;
		this.score = inputscore;
	}
	public void show_data(){
		System.out.println("Student ID : " + this.ID);
		System.out.println("Student name : " + this.name);
	}
}
