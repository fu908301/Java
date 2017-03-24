package JAVA_HW3;
import java.util.*;

public class Main {
	static void print_success_fail(int option,String input){
		if(option == -2)
			System.out.println("The list is empty.");
		else if(option == -1)
			System.out.println(input + " is not in the list.");
		else if(option == 0)
			System.out.println("Remove succsee");
		else
			System.out.println("Some error happened.");
	}
	static void print_success_fail(int option,int input){
		if(option == -2)
			System.out.println("The list is empty.");
		else if(option == -1)
			System.out.println(input + " is not in the list.");
		else if(option == 0)
			System.out.println("Remove succsee");
		else
			System.out.println("Some error happened.");
	}
	 static void print_info(){
		System.out.println("<1> Add one student to the list.");
		System.out.println("<2> Remove one student from the list.");
		System.out.println("<3> Display the student list.");
		System.out.println("<4> Exit");
		System.out.print("Input:");
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Student_list students = new Student_list();
		String inputS = null;
		int inputI;
		int option;
		int option2;
		int option3;
		while(true){
			try{
				print_info();
				option = scan.nextInt();
				switch(option){
					case 1 :
						System.out.print("Name:");
						inputS = scan.next();
						System.out.print("ID:");
						inputI = scan.nextInt();
						Student_info one_student = new Student_info(inputS,inputI);
						students.add(one_student);
						break;
					case 2 :
						System.out.println("Removen from <1>name <2>ID:");
						option2 = scan.nextInt();
						if(option2 == 1){
							System.out.print("Student's name:");
							inputS = scan.next();
							option3 = students.remove(inputS);
							print_success_fail(option3,inputS);
						}
						else if(option2 == 2){
							System.out.print("Student's ID:");
							inputI = scan.nextInt();
							option3 = students.remove(inputI);
							print_success_fail(option3,inputI);
						}
						else{
							System.out.println("Input Error.");
						}
						break;
					case 3 :
						students.display();
						break;
					case 4 :
						System.out.println("Bye!");
						System.exit(0);
						break;
					default :
						System.out.println("[Error] Wrong input.");
						System.out.println("[Error] Try again.");
						break;
						
				}
			}
			catch(InputMismatchException e){
				System.out.println("[Error] Wrong input.");
				System.out.println("[Error] Try again.");
			}
		}
	}
}
