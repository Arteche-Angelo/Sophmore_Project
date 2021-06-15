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
//author:Angleo Arteche, Michal Huk
@WebServlet("/displaybudgets")
public class displaybudgets extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String sql= null;
	Statement stmnt = null;
	Connection conn1 = null;
	Statement stmnt2 = null;
	static float EntertainmentAct = 0;
	static float FoodAct = 0;
	static float HomeAct = 0;
	static float MedicalAct = 0;
	static float TravelAct = 0;
	static float UtilitiesAct = 0;
	static float OtherAct = 0;
	static float BudgetsTotal=0;
	static float ActualTotal=0;
	static float DiffrenceTotal=0;
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
			sql="select category, limit_budgets from  budgets where userprofile_username like '%"+loginservlet.username+"%';" ;
			ResultSet rs= stmnt.executeQuery(sql);
			sql="select category,amount from transactions where userprofile_username like '%"+loginservlet.username+"%';";
			ResultSet rt=stmnt2.executeQuery(sql);
			while(rt.next()) {
				String cat =rt.getString("category");
				String amount =rt.getString("amount");
				switch(cat) {
				case "Entertainment":
					EntertainmentAct += Float.parseFloat(amount);
					break;
				case "Food":
					FoodAct += Float.parseFloat(amount);
					break;
				case "Home":
					HomeAct += Float.parseFloat(amount);
					break;
				case "Medical":
					MedicalAct += Float.parseFloat(amount);
					break;
				case "Travel":
					TravelAct += Float.parseFloat(amount);
					break;
				case "Utilities":
					UtilitiesAct += Float.parseFloat(amount);
					break;
				case "Other":
					OtherAct += Float.parseFloat(amount);
					break;
					
				}
				
				ActualTotal+= Float.parseFloat(amount);
			}
			
			 out.println("<table border=1 style=color:white; >");
			out.println("<tr ><th>Category</th><th>Budget</th><th>Actual</th><th>Diffrence</th></tr>");
             while(rs.next()) {
            	 float dif =0;
            	 
            	 String category =rs.getString("category");
            	 String limit_budgets = rs.getString("limit_budgets");
            	 switch (category) {     	 
            	 case "Entertainment":
            		  dif = Float.parseFloat(limit_budgets) - EntertainmentAct;
            		  out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + EntertainmentAct+ "</td><td>" + dif + "</td></tr>");
            		  break;
 				case "Food":
 					 dif =Float.parseFloat(limit_budgets) - FoodAct;
 					 out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + FoodAct + "</td><td>"+ dif + "</td></tr>");
 					 break;
 				case "Home":
 					  dif =Float.parseFloat(limit_budgets) - HomeAct;
 					  out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + HomeAct + "</td><td>"+ dif + "</td></tr>");
 					break;
 				case "Medical":
 					 dif =Float.parseFloat(limit_budgets) - MedicalAct;
 					 out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + MedicalAct + "</td><td>"+ dif + "</td></tr>");
 					 break;
 				case "Travel":
 					 dif =Float.parseFloat(limit_budgets) - TravelAct;
 					 out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + TravelAct + "</td><td>"+ dif + "</td></tr>");
 					 break;
 				case "Utilities":
 					 dif =Float.parseFloat(limit_budgets) - UtilitiesAct;
 					 out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + UtilitiesAct + "</td><td>"+ dif + "</td></tr>");
 					 break;
 				case "Other":
 					 dif =Float.parseFloat(limit_budgets) - OtherAct;
 					 out.println("<tr ><td>" + category + "</td><td>" + limit_budgets + "</td><td>" + OtherAct + "</td><td>"+ dif + "</td></tr>");
 					 break;

            	 }
            	 DiffrenceTotal += dif;
            	 BudgetsTotal += Float.parseFloat(limit_budgets);
            	 
             }
             out.println("<tr><td>Total</td><td>"+BudgetsTotal+"</td><td>"+ActualTotal+"</td><td>"+DiffrenceTotal+"</td></tr>");
             out.println("</table>");  
             out.println("</html></body>");
     		}
         }
     		catch (Exception e) {
     			out.println("error");
     		}
	
	}
}

