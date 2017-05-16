package myjava.homework;
import java.sql.*;
import java.util.Scanner;

public class SQLProject {
	
	static void query1(Statement st){
		try{
			ResultSet rs = st.getResultSet();
			st.execute("select avg(chinese),max(math),min(chinese) from java_db.grades");
			rs = st.getResultSet();
			System.out.println("Query 1 :");
			System.out.println("c_avg     m_max    c_min");
			while(rs.next())
			{
				System.out.println(rs.getString("avg(chinese)") + "   " +rs.getString("max(math)") + "      " + rs.getString("min(chinese)"));
			}
			System.out.println("");
			rs.close();
		}catch(Exception e){
			System.out.println("Some error happened1");
		}
	}
	
	static void query2(Statement st){
		try{
			ResultSet rs = st.getResultSet();
			st.execute("select id , chinese from java_db.grades order by chinese desc limit 0 ,1");
            rs = st.getResultSet();
            System.out.println("Query 2 :");
            System.out.println("id     chinese");
            while(rs.next())
            {
                System.out.println(rs.getString("id") + "   " +rs.getString("chinese"));
            }
            System.out.println("");
            rs.close();
		}catch(Exception e){
			System.out.println("Some error happened2");
		}
	}
	
	static void query3(Statement st){
		try{
			ResultSet rs = st.getResultSet();
			st.execute("select id ,sex ,birthmonth from java_db.students where id like 'A%' order by sex,birthmonth DESC");
            rs = st.getResultSet();
            System.out.println("Query 3 :");
            System.out.println("id     sex     birthmonth");
            while(rs.next())
            {
                System.out.println(rs.getString("id") + "   " +rs.getString("sex") + "     " + rs.getString("birthmonth"));
            }
            System.out.println("");
            rs.close();
		}catch(Exception e){
			System.out.println("Some error happened3");
		}
	}
	
	static void query4(Statement st){
		try{
			ResultSet rs = st.getResultSet();
			st.execute("select avg(english) from java_db.students,java_db.grades where java_db.students.sex = 'F'");
            rs = st.getResultSet();
            System.out.println("Query 4:");
            System.out.println("e_avg");
            while(rs.next())
            {
                System.out.println(rs.getString("avg(english)"));
            }
            System.out.println("");
            rs.close();
		}catch(Exception e){
			System.out.println("Some error happened4");
		}
	}
	static void query5(Statement st){
		try{
			ResultSet rs = st.getResultSet();
			st.execute("select sex,count(sex)  from java_db.students where birthmonth > 5 and birthmonth < 11 group by sex");
            rs = st.getResultSet();
            System.out.println("Query 5:");
            System.out.println("sex     count");
            while(rs.next())
            {
                System.out.println(rs.getString("sex") + "     " + rs.getString("count(sex)"));
            }
            System.out.println("");
            rs.close();
		}catch(Exception e){
			System.out.println("Some error happened4");
		}
	}
	public static void main(String [] args) throws ClassNotFoundException{
		Connection conn = null;
		String root;
		String pwd;
		Scanner scan = new Scanner(System.in);
		try{
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
            query1(st);
            query2(st);
            query3(st);
            query4(st);
            query5(st);
            conn.close();
            st.close();
            scan.close();
		}catch(Exception e){
			System.out.println("Some error happened");
		}
	}
}
