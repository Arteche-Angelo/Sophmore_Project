package spend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/* Author:  Hannah Latouf v1
*/
/* regservlet */


@WebServlet("/regservlet")
public class regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("psw");  
	    String f=request.getParameter("firstname");  
	    String l=request.getParameter("lastname"); 
	    String e=request.getParameter("email");  
	    String ph=request.getParameter("phonenumber"); 
	  
	    
	          
	    if(regmysql.reg(n, p,f,l,e,ph)){  
	        RequestDispatcher rd=request.getRequestDispatcher("regcustomer");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("loginpage.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	
	
	
}