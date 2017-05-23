package myjava.homework;

import java.util.ArrayList;

public class HealthCheck <T extends Number>{
	public double AverageBloodPressure(ArrayList<T> input){
		double return_d = 0.0;
		for(int i = 0; i < input.size(); i++){
			return_d = return_d + input.get(i).doubleValue();
		}
		return_d = return_d / input.size();
		return return_d;
	}
	
	
}


