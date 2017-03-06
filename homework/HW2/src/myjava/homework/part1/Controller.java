package myjava.homework.part1;
import java.util.*;
public class Controller {
	public static String pass_fail(int score,String name){   //To judge the score is pass or fail
		String returnString = null;
		if(score < 60)
			returnString = "Student " + name + " fail this project.";
		else if(score >= 60)
			returnString = "Student " + name + " pass this project.";
		return returnString;
	}
	
	public static void main(String[] args){
		int option;
		int option2;
		int count = 0;
		int inputscore;
		int tempscore;
		int pass;
		int fail;
		int temp;
		String inputID;
		String tempID;
		String inputName;
		String tempName;
		Scanner scan = new Scanner(System.in);
		StudentInformation one_student = new StudentInformation();
		ArrayList<StudentInformation> students = new ArrayList <StudentInformation>();//use arraylist
		while(true){
			try{
				pass = 0;
				fail = 0;
				System.out.println("Type 1 : add a student's data(student ID,student name and score)");
				System.out.println("Type 2 : show student's data");
				System.out.println("Type 3 : show all students' data");
				option = scan.nextInt();
				switch(option){
					case 1 :
						one_student = new StudentInformation();//need to initial again or data will be covered
						count = count + 1;
						System.out.println("Add new student's data");
						System.out.print("Student id : ");
						inputID = scan.next();
						System.out.print("Student name : ");
						inputName = scan.next();
						System.out.print("Score : ");
						inputscore = scan.nextInt();
						one_student.setData(inputID, inputName, inputscore);
						students.add(one_student);//add class into arraylist
						System.out.println("This is student "+ count);
						System.out.println("\r\n");
						break;
					case 2 :
						System.out.println("To show which student's information");
						option2 = scan.nextInt();
						if(option2 > count)
							System.out.println("Data not found");
						else{
							tempID = students.get(option2-1).getID();//take the data from specific class
							tempName = students.get(option2-1).getName();
							tempscore = students.get(option2-1).getScore();
							System.out.println("Student ID : " + tempID);
							System.out.println("Student name :¡@" + tempName);
							System.out.println(pass_fail(tempscore,tempName));
							System.out.println("This is student " + option2);
						}
						break;
					case 3 :
						System.out.println("===Students' data===");
						for(int i = 0;i < count;i++){
							temp = i + 1; 
							System.out.println("Number : " + temp);
							tempID = students.get(i).getID();
							tempName = students.get(i).getName();
							tempscore = students.get(i).getScore();
							if(tempscore >= 60)
								pass = pass + 1;
							else if(tempscore < 60)
								fail = fail + 1;
							System.out.println("Student ID : " + tempID);
							System.out.println("Student name :¡@" + tempName);
							System.out.println(pass_fail(tempscore,tempName));
							System.out.println("\r\n");
						}
						System.out.println("===============");
						System.out.println("Pass : " + pass);
						System.out.println("Fail :" + fail);
				}
			}
			catch(InputMismatchException e){
				System.out.println("Input error!ONLY integers");
			}
		}
	}

}
