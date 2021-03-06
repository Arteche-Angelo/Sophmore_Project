/* Author:  Hannah Latouf
   welcomecustomer- servlet that redirects to customer landing page after successful authentication
   More Comments to come:
*/

package spend;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/**
 * Servlet implementation class welcomecustomer
 */
/* welcome customer */

@WebServlet("/welcomecustomer")
public class welcomecustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		     String n=request.getParameter("uname");
		     if (n != loginservlet.username) {
		    out.print("Welcome "+loginservlet.username);  
		     }else {
		    	 out.print("welcome "+ n );
		     }
		    
		    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
		          
		    out.close();  
		    }

	}
	  

