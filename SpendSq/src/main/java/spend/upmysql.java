
/* Author:  Hannah Latouf 
  
*/

package spend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class upmysql {  

	public static String username, password, firstname, lastname, email, phonenumber;
	
	upmysql(String n,String p, String f,String l, String e, String ph) {
		username = n;
		password = p;
		firstname = f;
		lastname = l;
		email = e;
		phonenumber = ph;	
	}
	
	public boolean up(){  

		boolean status=false;  
		String sql = null;
		Statement stmt = null;
		ResultSet rs = null;

		Connection conn1 = null;
		try {
			// connect way #1
			String url1 = "jdbc:mysql://localhost:3306/spend";
			conn1 = DriverManager.getConnection(url1, "root", "sqlpass");
			if (conn1 != null) {
				System.out.println("Connected to the database spend");
				status=true;
				stmt = conn1.createStatement();
			//	sql = "INSERT INTO userprofile (username, fname, lname, email, phonenumber) Values ('btest1','Bob','Test','btest1@gmail.com','123456789');";
				//	sql = "INSERT INTO userprofile (username, fname, lname, email, phonenumber) Values (" + "'" + n + "', " + "'" + f + "', " + "'" + l + "', " + "'" + e + "', " + "'" + ph + "');";
				sql = "UPDATE userprofile SET fname=" + "'" + firstname + "'" + ", lname=" + "'" + lastname + "'" + ", email=" + "'" + email + "'" + ", phonenumber=" + "'" + phonenumber + "'" + " WHERE username=" + "'" + username + "';"; 
				System.out.println("sql: " + sql);
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