package myjava.homework.part1;
import java.io.*;
import java.util.*;
import com.opencsv.*;
public class Part1_Main {
	public static void main(String [] args){
		String filename = "query_result.csv";
		HashMap<String,String> map = new HashMap<String, String>();
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
					if(data.get(i).check_same(nextLine[0],nextLine[1])){
						check = true;
						break;
					}
					else
						check = false;	
				}
				if(check == false){
					one_data = new Data_Store(nextLine[0],nextLine[1],nextLine[2]);
					data.add(one_data);
				}
				map.put(nextLine[0], nextLine[2]);
			}
			pieChart Chart = new pieChart(data,map);
			Chart.run();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
