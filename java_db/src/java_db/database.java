package java_db;

import java.sql.*;
public class database {
	static final String DB_URL = "jdbc:mysql://localhost/java"; //DataBase Location
	static final String USER = "root";
	static final String PASS = "";
	static final String QUERY = "SELECT * FROM java_db"; //Database Name
	
	public static void main(String[] args) {
	try {
		Connection conn = DriverManager.getConnection(DB_URL ,USER, PASS);
		Statement stmt = conn.createStatement();
		
		Read(stmt);
		Update(stmt);
		Insert(stmt);
		
		
	} catch (SQLException e) {
		System.out.println(e);
	}
	}
	public static void Read(Statement stmt) {
		try {
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while(rs.next()) {
				System.out.print(" ID: " + rs.getInt("id"));
				System.out.print(" Name: " + rs.getString("name"));
				System.out.print(" Address: " + rs.getString("address"));
				System.out.print(" Contact: " + rs.getInt("contact"));
				System.out.println();
			}
		} 
		
		catch (SQLException e) {
			System.out.println(e);
		}
	}






public static void Update(Statement stmt) {
	String sql = "Update java_db set name = 'John' where id=101";
	try {
		stmt.executeUpdate(sql);
	}
	catch(SQLException e) {
		System.out.println(e);
	}
}


  public static void Insert(Statement stmt) { 
	  String sql ="INSERT INTO java_db VALUES (102,'Adeep', 'KTM',63246)"; 
  try {
      stmt.executeUpdate(sql); 
  } 
  catch(SQLException e) { 
	  System.out.println(e); 
  } 
}
 
  
  
}