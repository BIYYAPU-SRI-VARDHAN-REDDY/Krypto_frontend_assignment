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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public static boolean checkUser(String email,String pass)
	  {
	      boolean status =false;
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
	          PreparedStatement ps=con.prepareStatement("select * from users where emailid=? and password=?");
	          ps.setString(1, email);
	          ps.setString(2, pass);
	          ResultSet rs =ps.executeQuery();
	          status=rs.next();

	      }
	      catch(Exception e) {
	          e.printStackTrace();
	      }
	      return status;
	  }

	  public static boolean checkAdmin(String email,String pass)
	  {
	      boolean status =false;
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
	          PreparedStatement ps=con.prepareStatement("select * from admins where emailid=? and password=?");
	          ps.setString(1, email);
	          ps.setString(2, pass);
	          ResultSet rs =ps.executeQuery();
	          status=rs.next();

	      }
	      catch(Exception e) {
	          e.printStackTrace();
	      }
	      return status;
	  }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();

	        String email = request.getParameter("emailid");
	        String pass = request.getParameter("password");
	        String isAdmin=request.getParameter("isAdmin");
	        if(isAdmin!=null)
	        {
	          if(checkAdmin(email,pass))
	          {
	            RequestDispatcher rs=request.getRequestDispatcher("AdminHome");
	            rs.forward(request,response);
	          }
	          else
	          {
	             out.println("Username or Password incorrect");
	             RequestDispatcher rs = request.getRequestDispatcher("index.html");
	             rs.include(request, response);
	          }
	        }
	        else
	        {
	          if(checkUser(email, pass))
	          {
	              RequestDispatcher rs = request.getRequestDispatcher("Home");
	              rs.forward(request, response);
	          }
	          else
	          {
	             out.println("Username or Password incorrect");
	             RequestDispatcher rs = request.getRequestDispatcher("index.html");
	             rs.include(request, response);
	          }
	        }


	    }

}
