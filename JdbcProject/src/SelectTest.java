import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		try {
	//		1. load the driver 
			System.out.println("Trying to load the driver");
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver looaded....");

			
			//		2. acquire the connection 
			System.out.println("trying to connet");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb");
			System.out.println("connected :  "+conn);
	
			//Connection conn = 	DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb", "SA", "");

			//		3. make desired statment
		
			Statement statement = conn.createStatement();
			System.out.println(" statement is created"+statement);
			
	//		4. execute that statemnt 
			ResultSet result = statement.executeQuery("SELECT * FROM MYDEPT120");
			
			//5. process teh result if any
			while(result.next()) {
				System.out.println("DEPTNO : "+result.getInt(1));
				System.out.println("DNAME  : "+result.getString(2));
				System.out.println("LOC    : "+result.getString(3));
				System.out.println("-------------");
			}
			//6. close the statement, and connection
			result.close();
			statement.close();
			conn.close();
			System.out.println("Disconnected from the database....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}