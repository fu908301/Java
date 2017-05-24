package myjava.homework;

import java.util.ArrayList;

public class HealthCheck <T extends Number, K extends Comparable<K>>{
	public double AverageBloodPressure(ArrayList<T> input){
		double return_d = 0.0;
		for(int i = 0; i < input.size(); i++){
			return_d = return_d + input.get(i).doubleValue();
		}
		return_d = return_d / input.size();
		return return_d;
	}
	public double AverageWeight(ArrayList<T> input){
		double return_d = 0.0;
		for(int i = 0; i < input.size(); i++){
			return_d = return_d + input.get(i).doubleValue();
		}
		return_d = return_d / input.size();
		return return_d;
	}
	
	public K MaxBloodPressure(ArrayList<K> input){
		K max = input.get(0);
		for(int i = 1; i < input.size(); i++){
			if(max.compareTo(input.get(i)) < 0){
				max = input.get(i);
			}
		}
		return max;
	}
	
	public K MaxWeight(ArrayList<K> input){
		K max = input.get(0);
		for(int i = 1; i < input.size(); i++){
			if(max.compareTo(input.get(i)) < 0){
				max = input.get(i);
			}
		}
		return max;
	}
	public K MinBloodPressure(ArrayList<K> input){
		K min = input.get(0);
		for(int i = 1; i < input.size(); i++){
			if(min.compareTo(input.get(i)) > 0){
				min = input.get(i);
			}
		}
		return min;
	}
	
	public K MinWeight(ArrayList<K> input){
		K min = input.get(0);
		for(int i = 1; i < input.size(); i++){
			if(min.compareTo(input.get(i)) > 0){
				min = input.get(i);
			}
		}
		return min;
	}
		
}


