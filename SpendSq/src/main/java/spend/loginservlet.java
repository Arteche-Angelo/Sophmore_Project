package spend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

/**
 * Servlet implementation class loginservlet
 * 
 */
/* Author:  Hannah Latouf
loginservlet - servlet to take username and pasasword from form and test against MySql
More Comments to come: 
*/
/* loginservlet */

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("uname");  
	    String p=request.getParameter("psw");  
	        
	    
	    if(loginmysql.validate(n, p)){  
	    	user u = new user(n);
	    	HttpSession session = request.getSession();
            session.setAttribute("user", u);
            user tu = (user) session.getAttribute("user");
            String puser = tu.username;
            System.out.println("username = " + puser);
	    	RequestDispatcher rd=request.getRequestDispatcher("welcomecustomer");  
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