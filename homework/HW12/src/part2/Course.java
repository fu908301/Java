package part2;
import java.util.*;
public class Course {
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		Map<Integer,ArrayList<String>> students = new HashMap<Integer,ArrayList<String>>();
		try{
			while(true){
					System.out.println("Please input data");
					String s = scan.nextLine();
					String[] s_split = s.split(" ");
					if(Integer.parseInt(s_split[0]) == -1){
						System.out.print("List : ");
						for(Object key : students.keySet()){
							System.out.print(key + " = " + students.get(key) + " ");
						}
						break;
					}
					if(s_split.length != 2){
						System.out.println("Input Error, please retype again.");
						continue;
					}
					int ID = Integer.parseInt(s_split[0]);
					String _class = s_split[1];
					if(students.get(ID) == null){
						ArrayList<String> class_s = new ArrayList<String>();
						class_s.add(_class);
						students.put(ID, class_s);
						continue;
					}
					else if(students.get(ID) != null){
						students.get(ID).add(_class);
						continue;
					}
			}
		}catch(Exception e){
			System.out.println("Error happened, System shut down now.");
		}
	}
}
