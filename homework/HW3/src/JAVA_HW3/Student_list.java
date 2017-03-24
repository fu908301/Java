package JAVA_HW3;

import java.util.*;
public class Student_list {
	ArrayList<Student_info> students;
	public Student_list(){
		this.students = new ArrayList<Student_info>();
	}
	public void add(Student_info input){
		this.students.add(input);
	}
	public int remove(String input){
		if(students.size() <= 0)
			return -2;
		for(int i = 0; i < students.size(); i++){
			String temp = students.get(i).getName();
			if(input.equals(temp)){
				students.remove(i);
				return 0;
			}
		}
		return -1;
	}
	public int remove(int input){
		if(students.size() <= 0)
			return -2;
		for(int i = 0; i < students.size(); i++){
			if(input == students.get(i).getID()){
				students.remove(i);
				return 0;
			}
		}
		return -1;
	}
	public void display(){
		if(students.size() <= 0)
			System.out.println("List is empty.");
		else if(students.size() > 0)
			for(int i = 0; i < students.size(); i++){
				int count = i + 1;
				System.out.println("<"+ count + ">");
				students.get(i).show_data();
			}
	}
}
