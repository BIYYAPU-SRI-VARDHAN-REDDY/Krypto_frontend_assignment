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
 * Servlet implementation class RegisterInsert
 */
@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
        out.println("<body style=\"background-color:red;\">");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
            Statement stmt=con.createStatement();
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String email=request.getParameter("emailid");
            String password=request.getParameter("password");

            stmt.executeUpdate("insert into users values('"+firstName+"','"+lastName+"','"+email+"','"+password+"')");
            out.println("<h1>Succesfully Registered</h1>");
        }
        catch(Exception e) {
            out.println(e);
        }

        out.println("</body>");

      }


}
