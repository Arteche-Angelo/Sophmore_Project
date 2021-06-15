/* Author:  Hannah Latouf
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
import javax.servlet.http.HttpSession;  



@WebServlet("/readprofileservlet")
public class readprofileservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
	
		 	HttpSession session = request.getSession();
		 	user u = (user) session.getAttribute("user");
            String username = u.username;
            System.out.println("username = " + username);
            
            rpmysql rp =  new rpmysql();
            rp.read(username);
            String firstname = rp.fname;
            String lastname = rp.lname;
            String email = rp.email;
            String phonenumber = rp.phonenumber;
            
            System.out.println("firstname = " + firstname);
            System.out.println("lastname = " + lastname);
            System.out.println("email = " + email);
            System.out.println("phonenumber = " + phonenumber);
            
		
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		           
		    out.print("<html>  \n"
		    		+ "\n"
		    		+ "    <head>\n"
		    		+ "    <link rel=\"stylesheet\" href=\"style.css\">\n"
		    		+ "    \n"
		    		+ "    <title>\n"
		    		+ "           Profile Update Page\n"
		    		+ "    </title>\n"
		    		+ "        \n"
		    		+ "    </head>\n"
		    		+ "    \n"
		    		+ "<body>\n"
		    		+ "\n"
		    		+ "<form action=\"http://localhost:8080/SpendSq/updateservlet\" method=\"post\">\n"
		    		+ "  <div class=\"container\">\n"
		    		+ "    <h1>Update Your Profile</h1>\n"
		    		+ "  \n"
		    		+ "    <hr>\n"
		    		+ "\n"
		    		+ "    <label for=\"username\"><b>Username</b></label>\n"
		    		+ "    <input type=\"text\" placeholder=" + username + " name=username id=\"username\" required >\n"
		    		+ "       \n"
		    		+ " <label for=\"fname\"><b>First Name</b></label>\n"
		    		+ "    <input type=\"text\" placeholder=" + firstname + " name=\"firstname\" id=\"firstname\" required >\n"
		    		+ "      \n"
		    		+ "     <label for=\"lname\"><b>Last Name</b></label>\n"
		    		+ "    <input type=\"text\" placeholder=" + lastname + " name=\"lastname\" id=\"lastname\" required > "
		    		+ "      <label for=\"email\"><b>Email</b></label>\n"
		    		+ "    <input type=\"text\" placeholder=" + email + " name=\"email\" id=\"email\" required>\n"
		    		+ "      \n"
		    		+ "       <label for=\"phonenumber\"><b>Phone Number</b></label>\n"
		    		+ "    <input type=\"text\" placeholder=" + phonenumber + " name=\"phonenumber\" id=\"phonenumber\" required>\n"
		    		+ "\n"
		    		+ "    <label for=\"psw\"><b>Password</b></label>\n"
		    		+ "    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" id=\"psw\" required>\n"
		    		+ "\n"
		    		+ "    <label for=\"psw-repeat\"><b>Repeat Password</b></label>\n"
		    		+ "    <input type=\"password\" placeholder=\"Repeat Password\" name=\"psw-repeat\" id=\"psw-repeat\" required>\n"
		    		+ "    <hr>\n"
		    		+ "\n"
		    		+ "\n"
		    		+ "    <button type=\"submit\" class=\"registerbtn\">Update Profile</button>\n"
		    		+ "  </div>\n"
		    		+ "\n"
		    		+ "  <div class=\"container signin\">\n"
		    		+ "\n"
		    		+ "  </div>\n"
		    		+ "</form> \n"
		    		+ "    \n"
		    		+ "</body>\n"
		    		+ "    \n"
		    		+ "</html>");  
	
		          
		    out.close();  
		    }    
	  
}