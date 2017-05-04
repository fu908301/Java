package myjava.homework.part2;
import java.io.*;
import java.util.*;
import com.opencsv.*;



public class Part2_Main {
	public static void main(String [] args){
		String filename = "query_result.csv";
		Scanner scan = new Scanner(System.in);
		String ID;
		Data_Store one_data;
		ArrayList<Data_Store> data = new ArrayList<Data_Store>();
		CSVReader reader;
		String [] nextLine;
		boolean check = false;
		try{
			reader = new CSVReader(new FileReader(filename));
			reader.readNext();
			while ((nextLine = reader.readNext()) != null){
				for(int i = 0; i < data.size(); i++){
					if(nextLine[0].equals(data.get(i).getid())){
						check = true;
						data.get(i).set_Data(nextLine[1]);
						break;
					}
					else
						check = false;
				}
				if(check == false){
					one_data = new Data_Store(nextLine[0]);
					one_data.set_Data(nextLine[1]);
					data.add(one_data);
				}
			}
			while(true){
				System.out.println("Please input the ID");
				ID = scan.next();
				Columnar_Chart chart = new Columnar_Chart(ID , data);
				if(chart.check_id(ID))
					chart.run();
				else
					System.out.println("ID not found, please input again!");
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(InputMismatchException e){
			scan.next();
			System.out.println("Input error!!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
