
/* Author:  Hannah Latouf
   loginmysql - class that calls MySql via JDBC to test username and pasasword - returns true or false
   More Comments to come:
*/

package spend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class loginmysql {  
public static boolean validate(String name,String pass){  

	boolean status=false;  

	Connection conn1 = null;
	try {
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/spend";
		System.out.println("name:" + name + "\n");
		System.out.println("pass:" + pass + "\n");
		conn1 = DriverManager.getConnection(url1, name, pass);
		if (conn1 != null) {
			System.out.println("Connected to the database spend");
			status=true;
		}
	}catch (SQLException ex) {
		System.out.println("An error occurred. Maybe user/password is invalid");
		ex.printStackTrace();
	}

	return status;  

	}  

}  