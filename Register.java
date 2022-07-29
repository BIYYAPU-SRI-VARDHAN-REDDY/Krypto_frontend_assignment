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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>JAVA_DA3_QUE22</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x' crossorigin='anonymous'>");
        out.println("<body style=\"background-color:yellow;\">");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
            out.println("<h1>Men Wardrobe Shopping Cart Registration Form</h1>");
            out.println("<hr>");
            out.println("<form class='form-control' action='RegisterInsert' method='POST'>");
            out.println("<h1>Register Here</h1>");
            out.println("First Name:<input class='form-control' type='text' name='firstName' required><br>");
            out.println("Last Name:<input class='form-control' type='text' name='lastName' required><br>");
            out.println("Email ID:<input class='form-control' type='email' name='emailid' required><br>");
            out.println("Password:<input class='form-control' type='password' name='password' required><br>");
            out.println("<input class='btn btn-primary' type='submit' name='Register'>");
            out.println("</form>");
        }
        catch(Exception e) {
            out.println(e);
        }

        out.println("</body>");

      }

}
