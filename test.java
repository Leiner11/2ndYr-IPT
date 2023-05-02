package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {
	public static void main (String []args) throws SQLException{
		String url ="jdbc:sqlite:CCS.db";
		String query = "select * from ccsstudents";
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try{
			Connection con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				String universitydata = " ";
				for (int i=1; i<=4; i++) {
					universitydata += result.getString(i) + ":";
				}
				System.out.println(universitydata);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
