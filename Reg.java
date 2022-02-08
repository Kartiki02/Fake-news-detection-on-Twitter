
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


public class Reg extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String valemail = "", valmobno = "";
        Boolean flag = false;

        PrintWriter pw = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String mob = request.getParameter("mob");
        String tid = request.getParameter("tid");
        String uname = request.getParameter("username");
        String pass = request.getParameter("pass");
        
        Connection cn = DbUtil.getConnection();
        try
        {
            PreparedStatement preparedStatement = cn.prepareStatement("select email from user where UPPER(email)=UPPER(?)");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                valemail = rs.getString("email");
                System.out.println("email: " + valemail);
            }
            if (email != null || !email.equalsIgnoreCase(""))
            {
                if (valemail.equalsIgnoreCase(email))
                {
                    flag = true;
                }
            }
            if (flag)
            {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Email  already exist....Please register with different email ');");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.include(request, response);
            }
            else
            {
                PreparedStatement ps = cn.prepareStatement("insert into user(fname, lname, tid, email, mob, uname, pass) values(?,?,?,?,?,?,?)");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, tid);
                ps.setString(4, email);
                ps.setString(5, mob);
                ps.setString(6, uname);
                ps.setString(7, pass);

                ps.execute();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Registration Successfull.......!!');");
                pw.println("</script>");

                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                rd.include(request, response);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
