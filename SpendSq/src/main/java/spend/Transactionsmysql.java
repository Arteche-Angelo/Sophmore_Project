
/* Author:  Angelo arteche

*/

package spend;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactionsmysql {  
public static boolean trans(String category,String vendor,String amount,String date,String uname){  

	boolean status=false;  
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	try {
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/spend";
		conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
		
		System.out.println("category:" + category + "\n");
		System.out.println("vendor:" + vendor + "\n");
		System.out.println("amount:" + amount + "\n");
		System.out.println("date:" + date + "\n");
		System.out.println("username: "+ uname + "\n");
		
		if (conn1 != null) {
			System.out.println("Connected to the database spend");
			status=true;
			stmnt = conn1.createStatement();
			sql="insert into transactions (category,vendor,amount,date, userprofile_username) values(" +"'" + category +"', '"+vendor+"', '"+ amount+"', '"+date+"', '"+ uname + "');" ;
			stmnt.execute(sql);
		
		}
		}catch (SQLException ex) {
		System.out.println("An error occurred. ");
		ex.printStackTrace();
		}
	  
		return status;  
	}
}
	
