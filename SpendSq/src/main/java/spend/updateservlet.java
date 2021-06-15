package spend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/* Author:  Hannah Latouf 
*/


@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
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
	  
	    upmysql upm = new upmysql(n, p, f, l, e, ph);
	          
	    if(upm.up()){  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
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
	
	
	
