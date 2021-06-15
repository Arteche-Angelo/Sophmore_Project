
/* Author:  Hannah Latouf v1
  
*/ 

package spend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class rpmysql {  

	public static String username, fname, lname, email, phonenumber;
	public static boolean read(String n){  

		boolean status=false;  
		String sql = null;
		Statement stmt = null;
		
		Connection conn1 = null;
		try {
			// connect way #1
			String url1 = "jdbc:mysql://localhost:3306/spend";
	//		System.out.println("name:" + n + "\n");
	//		System.out.println("pass:" + p + "\n");
			conn1 = DriverManager.getConnection(url1, "root", "sqlpass");
			if (conn1 != null) {
				status=true;
				stmt = conn1.createStatement();
				sql = "use spend;";
				stmt.execute(sql);
				sql = "SELECT username,fname, lname, email, phonenumber from userprofile where username = " + "'" + n + "'" + ";";
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				username = rs.getString("username");
				fname =  rs.getString("fname");
				lname =  rs.getString("lname");
				email =  rs.getString("email");
				phonenumber =  rs.getString("phonenumber");
			}
		}
		catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			ex.printStackTrace();
		}

	return status;  

	}  
}
