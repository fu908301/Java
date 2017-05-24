package myjava.homework;
import java.sql.*;
import java.util.*;

public class HW10_Main{
	
	@SuppressWarnings("unchecked")
	static void result(Statement st, String animal){
		try{
			String id;
			String sex;
			@SuppressWarnings("rawtypes")
			Animal temp = null;
			@SuppressWarnings("rawtypes")
			HealthCheck hc = new HealthCheck();
			@SuppressWarnings("rawtypes")
			Set<Animal> hs = new HashSet<Animal>();
			ResultSet rs = st.executeQuery("select * from java_db." + animal);
			ResultSetMetaData rsmd = rs.getMetaData();
			//type 4 = int type 8 = double
			if(rsmd.getColumnType(3) == 4){
				while(rs.next()){
					id = rs.getString(rsmd.getColumnName(1));
					sex = rs.getString(rsmd.getColumnName(2));
					int weight = rs.getInt(rsmd.getColumnName(3));
					double pressure = rs.getDouble(rsmd.getColumnName(4));
					Animal<Double, Integer> am = new Animal<Double, Integer>(pressure, id, sex, weight);
					hs.add(am);
				}
				@SuppressWarnings("rawtypes")
				Iterator<Animal> iterator = hs.iterator();
				ArrayList <Double> pressures = new ArrayList<Double>();
				ArrayList <String> ids = new ArrayList<String>();
				ArrayList <String> sexs = new ArrayList<String>();
				ArrayList <Integer> weights = new ArrayList<Integer>();
				while(iterator.hasNext()) {
					temp = iterator.next();
					pressures.add((Double) temp.get_blood());
					ids.add(temp.get_id());
					sexs.add(temp.get_sex());
					weights.add((Integer)temp.get_weight());
				}
				System.out.println("--------------------["+ animal + "]------------------");
				System.out.println(animal + "List : " + hs);
				System.out.println("Max Weight : " + hc.MaxWeight(weights));
				System.out.println("Min Weight : " + hc.MinWeight(weights));
				System.out.println("Average weight :" + hc.AverageWeight(weights));
				System.out.println("Max blood pressure : " + hc.MaxBloodPressure(pressures));
				System.out.println("Min blood pressure : " + hc.MinBloodPressure(pressures));
				System.out.println("Average blood pressure : " + hc.AverageBloodPressure(pressures));
				System.out.println("-----------------------------------------");
			}
			else if(rsmd.getColumnType(3) == 8){
				while(rs.next()){
					id = rs.getString(rsmd.getColumnName(1));
					sex = rs.getString(rsmd.getColumnName(2));
					double weight = rs.getDouble(rsmd.getColumnName(3));
					int pressure = rs.getInt(rsmd.getColumnName(4));
					Animal<Integer, Double> am = new Animal<Integer, Double>(pressure, id, sex, weight);
					hs.add(am);
				}
				@SuppressWarnings("rawtypes")
				Iterator<Animal> iterator = hs.iterator();
				ArrayList <Integer> pressures = new ArrayList<Integer>();
				ArrayList <String> ids = new ArrayList<String>();
				ArrayList <String> sexs = new ArrayList<String>();
				ArrayList <Double> weights = new ArrayList<Double>();
				while(iterator.hasNext()) {
					temp = iterator.next();
					pressures.add((Integer) temp.get_blood());
					ids.add(temp.get_id());
					sexs.add(temp.get_sex());
					weights.add((Double)temp.get_weight());
				}
				System.out.println("--------------------[" + animal + "]------------------");
				System.out.println(animal  + "List : " + hs);
				System.out.println("Max Weight : " + hc.MaxWeight(weights));
				System.out.println("Min Weight : " + hc.MinWeight(weights));
				System.out.println("Average weight : " + hc.AverageWeight(weights));
				System.out.println("Max blood pressure : " + hc.MaxBloodPressure(pressures));
				System.out.println("Min blood pressure : " + hc.MinBloodPressure(pressures));
				System.out.println("Average blood pressure : " + hc.AverageBloodPressure(pressures));
				System.out.println("-----------------------------------------");
			}
			rs.close();
		}catch(Exception e){
			System.out.println("Some error happened at cat function");
		}
	}
	public static void main(String [] args) throws ClassNotFoundException{
		Connection conn = null;
		String root;
		String pwd;
		Scanner scan = new Scanner(System.in);
		try{
			System.out.println("Connecting...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connected Success");
			System.out.println("Input account");
			root = scan.next();
			System.out.println("Input password");
			pwd = scan.next();
			String datasource = "jdbc:mysql://localhost/java_db?user=" + root + "&password=" + pwd;
			conn = DriverManager.getConnection(datasource);
			System.out.println("MYSQL connected success");
            Statement st = conn.createStatement();
            result(st, "cat");
            result(st, "dog");
            conn.close();
            st.close();
            scan.close();
		}catch(Exception e){
			System.out.println("Some error happened at main");
		}
	}
}
