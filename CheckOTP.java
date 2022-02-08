
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckOTP extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {  
        PrintWriter pw = response.getWriter();
        
        String otp = request.getParameter("otp");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            PreparedStatement ps = cn.prepareStatement(" select * from otpdoc where otp =?" );

            ps.setString(1, otp);

            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next())
            {
                i++;
            }
            if (i > 0)
            {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('OTP Submit Successful');");
                pw.println("</script>");

                RequestDispatcher rd = request.getRequestDispatcher("UpdatePassword.jsp");
                rd.include(request, response);
            }
            else
            {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Invalid OTP');");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.include(request, response);
            }
        }
        catch (Exception e)
        {
            pw.println("<html><body>" + e + "</body></html>");
        }    
     
    } 

}
