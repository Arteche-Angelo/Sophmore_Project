package spend;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

/* Author:  Angelo Arteche
*/



@WebServlet("/transactionservlet")
public class transactionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  


	          
	    String category=request.getParameter("Category");  
	    String vendor=request.getParameter("Vendor");  
	    String amount=request.getParameter("Amount");  
	    String date=request.getParameter("date"); 
	    String uname = ;
	  
	    
	          
	    if(Transactionsmysql.trans(category, vendor,amount,date,uname)){  
	    	System.out.println("connected to database");
	    }else {
	    	System.out.println("error connecting to database");
	    }
	
	
	
}
}