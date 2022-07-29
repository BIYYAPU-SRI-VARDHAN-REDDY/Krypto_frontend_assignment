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
 * Servlet implementation class Bill
 */
@WebServlet("/Bill")
public class Bill extends HttpServlet {
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
        out.println("<body style=\"background-color:violet;\">");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String email=request.getParameter("emailid");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/database2?useTimezone=true&serverTimeZone=UTC","root","");
            out.println("<h1>Bill</h1>");
            out.println("<hr>");
            out.println("<br>");
            out.println("<table class='table'>");
            out.println("<tr>");
            out.println("<th>Item</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Total</th>");
            out.println("</tr>");
            float shirt_price;
            float pant_price;
            float coat_price;
            float tshirt_price;
            float total=0;
            Statement stmt;
            ResultSet resultSet;
            stmt=con.createStatement();
            resultSet=stmt.executeQuery("select * from wardrobe where id=1");
            if(resultSet.next())
            {
              shirt_price=resultSet.getFloat("price");
              int shirt_qty=Integer.parseInt(request.getParameter("price1"));
              float p1=shirt_qty*shirt_price;
              total+=p1;
              out.println("<tr>");
              out.println("<td>Shirts</td>");
              out.println("<td>"+shirt_price+"</td>");
              out.println("<td>"+shirt_qty+"</td>");
              out.println("<td>"+p1+"</td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=2");
            if(resultSet.next())
            {
              pant_price=resultSet.getFloat("price");
              int pant_qty=Integer.parseInt(request.getParameter("price2"));
              float p2=pant_qty*pant_price;
              total+=p2;
              out.println("<tr>");
              out.println("<td>Pants</td>");
              out.println("<td>"+pant_price+"</td>");
              out.println("<td>"+pant_qty+"</td>");
              out.println("<td>"+p2+"</td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=3");
            if(resultSet.next())
            {
              coat_price=resultSet.getFloat("price");
              int coat_qty=Integer.parseInt(request.getParameter("price3"));
              float p3=coat_qty*coat_price;
              total+=p3;
              out.println("<tr>");
              out.println("<td>Coats</td>");
              out.println("<td>"+coat_price+"</td>");
              out.println("<td>"+coat_qty+"</td>");
              out.println("<td>"+p3+"</td>");
              out.println("</tr>");
            }

            resultSet=stmt.executeQuery("select * from wardrobe where id=4");
            if(resultSet.next())
            {
              tshirt_price=resultSet.getFloat("price");
              int tshirt_qty=Integer.parseInt(request.getParameter("price4"));
              float p3=tshirt_qty*tshirt_price;
              total+=p3;
              out.println("<tr>");
              out.println("<td>T-Shirts</td>");
              out.println("<td>"+tshirt_price+"</td>");
              out.println("<td>"+tshirt_qty+"</td>");
              out.println("<td>"+p3+"</td>");
              out.println("</tr>");
            }
            out.println("</table>");
            out.println("<h1>Total Bill="+total);
            stmt.executeUpdate("insert into bill values("+total+")");
        }
        catch(Exception e) {
            out.println(e);
        }

        out.println("</body>");

      }

}
