package spend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;      
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/* Authors:  Angelo Arteche, Michal Huk
*/



@WebServlet("/budgetservlet")
public class budgetservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		response.setContentType("text/html");  

	          
	    String category=request.getParameter("Category");  
	    String limit=request.getParameter("Limit");
	    String uname = loginservlet.username ;
	  
	    
	          
	    if(Budgetsmysql.trans(category, limit, uname)){  
	    	System.out.println("connected to database");
	    	RequestDispatcher rd=request.getRequestDispatcher("welcomecustomer");  
	        rd.forward(request,response);
	    }else {
	    	System.out.println("error connecting to database");
	    }
	
	
	
}
}