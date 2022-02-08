package com;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DbUtil;

public class del extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String s1 = req.getParameter("id");
        Connection cn = (Connection) DbUtil.getConnection();
        try
        {
            Statement st1 = cn.createStatement();
            st1.execute("delete from user where id ='" + s1 + "'");

        
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Recored Deleted..');");
            pw.println("</script>");

            RequestDispatcher rd = req.getRequestDispatcher("AdminViewUser.jsp");
            rd.include(req, res);

        }
        catch (Exception e)
        {
            pw.println("<html><body>" + e + "</body></html>");
        }
    }
}
