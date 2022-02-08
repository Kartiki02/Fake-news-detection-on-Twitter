package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLogin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String s1 = req.getParameter("uname");
        String s2 = req.getParameter("pass");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            PreparedStatement ps = cn.prepareStatement("select * from user where uname=? and pass=?");

            ps.setString(1, s1);
            ps.setString(2, s2);

            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                i = 1;
            }
            if (i == 1) {
                i = 0;
                HttpSession session = req.getSession();
                session.setAttribute("uname", s2);
                RequestDispatcher rd = req.getRequestDispatcher("UserHome.jsp");
                rd.include(req, res);
            } else {
                pw.println("<html><body>Login failed...!!</body></html>");
            }
        } catch (Exception e) {
            pw.println("<html><body>" + e + "</body></html>");
        }
    }
}
