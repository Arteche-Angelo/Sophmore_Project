
/* Author:  Angelo Arteche, Michal Huk

*/

package spend;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Budgetsmysql {  
public static boolean trans(String category,String limit,String uname){  

	boolean status=false;  
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	try {
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/spend";
		conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
		
		System.out.println("category:" + category + "\n");
		System.out.println("limit:" + limit + "\n");
		System.out.println("username: "+ uname + "\n");
		
		if (conn1 != null) {
			System.out.println("Connected to the database spend");
			status=true;
			stmnt = conn1.createStatement();
			sql="insert into transactions (category, limit, userprofile_username) values(" +"'" + category +"', '"+limit+"', '"+ uname + "');" ;
			stmnt.execute(sql);
		
		}
		}catch (SQLException ex) {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;  
	}
}
	
