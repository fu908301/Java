package part1;

import java.util.*;
import java.io.*;
public class Dictionary {
	public static Set<String> Ini_to_set() throws IOException{
		Set<String> words = new HashSet<String>();
		try{
			FileReader fr = new FileReader("words.txt");
			BufferedReader br = new BufferedReader(fr);
			String s_split;
			while(br.ready()){
				s_split = br.readLine();
				words.add(s_split);
			}
			fr.close();
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		catch(IOException e){
			System.out.println("Other error");
		}
		return words;
	}
	public static Set<String> Test_to_set() throws IOException{
		Set<String> test = new HashSet<String>();
		try{
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine().toString();
			String [] s_split = s.split(" ");
			for(int i = 0; i < s_split.length; i++){
				test.add(s_split[i]);
			}
			fr.close();
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
		catch(IOException e){
			System.out.println("Other error");
		}
		return test;
	}
	public static void main(String [] args) throws IOException{
		Set<String> words;
		Set<String> test;
		test = Test_to_set();
		words = Ini_to_set();
		boolean the_same = false;
		Iterator<String> it_w;
		Iterator<String> it_t = test.iterator();
		while(it_t.hasNext()){
			it_w = words.iterator();
			the_same = false;
			String s_t = it_t.next();
			while(it_w.hasNext()){
				String s_w = it_w.next();
				if(s_t.equals(s_w)){
					the_same = true;
					break;
				}
			}
			if(!the_same)
				System.out.println(s_t);
		}
	}
}
