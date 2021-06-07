
/* Author:  Hannah Latouf v1
  
*/

package spend;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class regmysql {  
public static boolean reg(String n,String p, String f,String l, String e, String ph){  

	boolean status=false;  
	String sql = null;
	Statement stmt = null;
	ResultSet rs = null;

	Connection conn1 = null;
	try {
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/spend";
		System.out.println("name:" + n + "\n");
		System.out.println("pass:" + p + "\n");
		conn1 = DriverManager.getConnection(url1, "root", "sqlpass");
		if (conn1 != null) {
			System.out.println("Connected to the database spend");
			status=true;
			stmt = conn1.createStatement();
		//	sql = "CREATE USER 'btest2'@'localhost' IDENTIFIED BY 'sqlpass2';";
			sql = "CREATE USER " + "'" + n + "'" + "@'localhost'" + "IDENTIFIED BY " + "'" + p + "'"; 
			stmt.execute(sql);
		//	sql = "INSERT INTO userprofile (username, fname, lname, email, phonenumber) Values ('btest1','Bob','Test','btest1@gmail.com','123456789');";
			sql = "INSERT INTO userprofile (username, fname, lname, email, phonenumber) Values (" + "'" + n + "', " + "'" + f + "', " + "'" + l + "', " + "'" + e + "', " + "'" + ph + "');";
			stmt.execute(sql);
		//  GRANT ALL PRIVILEGES ON spend . userprofile TO 'btest'@'localhost';
			sql = "GRANT ALL PRIVILEGES ON spend . userprofile TO " + "'" + n + "'@'localhost';";
			stmt.execute(sql);
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. Maybe user/password is invalid");
		System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
		ex.printStackTrace();
	}

	return status;  

	}  

}  