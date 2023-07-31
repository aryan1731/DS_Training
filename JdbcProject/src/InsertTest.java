import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
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

			//		3. make desired statment (insert/ delete/update/select)
		
			PreparedStatement pst = conn.prepareStatement("INSERT INTO MYDEPT120 VALUES( ?, ? ,?)");
			pst.setInt(1,50);
			pst.setString(2,"SERVICE");
			pst.setString(3, "DELHI");
			
	//		4. execute that statement 
			int rows = pst.executeUpdate();
			System.out.println("rows created : "+rows);
			
			//6. close the statement, and connection
//			result.close();
			pst.close();
			conn.close();
			System.out.println("Disconnected from the database....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}