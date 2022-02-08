
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
import util.DbUtil;


public class UpdatePass extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String valemail = "", valmobno = "";
        Boolean flag = false;

        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        System.out.println(" Email : " + email + " Pass: " + pass);
        Connection cn = DbUtil.getConnection();
        try 
        {
            PreparedStatement ps = cn.prepareStatement("update  user set pass=? where email=?");
            ps.setString(1, pass);
            ps.setString(2, email);

            ps.execute();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Password Updated Successfully.......!!');");
            pw.println("</script>");

            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.include(request, response);

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
