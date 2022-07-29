package chakri;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset='utf-8'>");
	        out.println("<title>JAVA_DA3_QUE2</title>");
	        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x' crossorigin='anonymous'>");
	        out.println("<body style=\"background-color:aqua;\">");
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String email=request.getParameter("emailid");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
	            PreparedStatement ps=con.prepareStatement("select * from admins where emailid=?");
	            ps.setString(1, email);
	            ResultSet rs =ps.executeQuery();
	            rs.next();
	            out.println("<h1>Welcome "+rs.getString("FirstName")+" "+rs.getString("LastName")+"</h1>");
	            out.println("<hr>");

	            out.println("<h2>Update Form</h2>");
	            out.println("<form class='form-control' action='UpdatePrice' method='POST'>");
	            out.println("Enter Item ID:<input type='text' name='itemId' id='itemId'>");
	            out.println("Enter Updated Price:<input type='text' name='updatedPrice' id='updatedPrice'>");

	            out.println("<input type='submit' value='Update' class='btn btn-warning'>");
	            out.println("</form>");

	            out.println("<hr>");

	            out.println("<h2>Delete Form</h2>");
	            out.println("<form class='form-control' action='DeleteItem' method='POST'>");
	            out.println("Enter Item ID:<input type='text' name='itemId' id='itemId'>");
	            out.println("<input type='submit' value='Delete' class='btn btn-danger'>");
	            out.println("</form>");

	        }
	        catch(Exception e) {
	            out.println(e);
	        }

	        out.println("</body>");

	      }

}
