package spend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displaytransactions

 */
//author:angleo arteche
@WebServlet("/displaytransactions")
public class displaytransactions extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
         response.setContentType("text/html");
         out.println("<html><body>");
         try 
         {  
        	 String url1 = "jdbc:mysql://localhost:3306/spend";
     		conn1 = DriverManager.getConnection(url1, "root", "Koda2244");
     		if(conn1 != null) {
     		stmnt = conn1.createStatement();
			sql="select date, vendor, category, amount from  transactions where userprofile_username like '%"+loginservlet.username+"%' order by date ;" ;
			ResultSet rs= stmnt.executeQuery(sql);
			 out.println("<table border=1 style=color:white; >");
             out.println("<tr ><th>Date</th><th>Vendor</th><th>Category</th><th>Amount</th></tr>");
             while(rs.next()) {
            	 String date =rs.getString("date");
            	 String vendor = rs.getString("vendor");
            	 String category = rs.getString("category");
            	 String amount = rs.getString("amount");
            	 out.println("<tr ><td>" + date + "</td><td>" + vendor + "</td><td>" + category + "</td><td>" + amount + "</td></tr>");
            	 
             }
             out.println("</table>");  
             out.println("</html></body>");
     		}
         }
     		catch (Exception e) {
     			out.println("error");
     		}
	

}
}
