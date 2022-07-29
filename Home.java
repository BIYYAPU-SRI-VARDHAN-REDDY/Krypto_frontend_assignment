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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
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
        out.println("<body style=\"background-color:palegreen;\">");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String email=request.getParameter("emailid");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
            PreparedStatement ps=con.prepareStatement("select * from users where emailid=?");
            ps.setString(1, email);
            ResultSet rs =ps.executeQuery();
            rs.next();
            out.println("<h1>Welcome "+rs.getString("FirstName")+" "+rs.getString("LastName")+"</h1>");
            out.println("<hr>");
            out.println("<h3>Enter the number of needed wardrobe items in the corresponding box(0 if not needed):</h3>");
            out.println("<br>");
            out.println("<form action='Bill' method='POST'>");
            out.println("<table class='table'>");
            out.println("<tr>");
            out.println("<th>Item</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("</tr>");
            float short_price;
            float shirt_price;
            float pant_price;
            float tshirt_price;
            Statement stmt;
            ResultSet resultSet;
            stmt=con.createStatement();
            resultSet=stmt.executeQuery("select * from wardrobe where id=1");
            if(resultSet.next())
            {
              short_price=resultSet.getFloat("price");
              out.println("<tr>");
              out.println("<td>Shorts</td>");
              out.println("<td>"+short_price+"</td>");
              out.println("<td><input type='text' name='price1' id='price1' value=0></td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=2");
            if(resultSet.next())
            {
              shirt_price=resultSet.getFloat("price");
              out.println("<tr>");
              out.println("<td>shirts</td>");
              out.println("<td>"+shirt_price+"</td>");
              out.println("<td><input type='text' name='price2' id='price2' value=0></td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=3");
            if(resultSet.next())
            {
              pant_price=resultSet.getFloat("price");
              out.println("<tr>");
              out.println("<td>pants</td>");
              out.println("<td>"+pant_price+"</td>");
              out.println("<td><input type='text' name='price3' id='price3' value=0></td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=4");
            if(resultSet.next())
            {
              tshirt_price=resultSet.getFloat("price");
              out.println("<tr>");
              out.println("<td>T-Shirts</td>");
              out.println("<td>"+tshirt_price+"</td>");
              out.println("<td><input type='text' name='price4' id='price4' value=0></td>");
              out.println("</tr>");
            }
            out.println("</table>");
            out.println("<input type='submit' class='btn btn-primary' value='Submit'>");
            out.println("</form>");
        }
        catch(Exception e) {
            out.println(e);
        }

        out.println("</body>");

      }

}
