
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SendOTP extends HttpServlet
{

    int otp = 0;
    String email = "";
    String mobno = " ";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        int max = 13579;
        int min = 24684;

        email = request.getParameter("email");
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            Statement st = cn1.createStatement();
            
            ResultSet rs1 = st.executeQuery("select * from user where email='" + email + "'");
            while (rs1.next())
            {
                mobno = rs1.getString("mob");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        Random randomNum = new Random();
        otp = min + randomNum.nextInt(max);
        System.out.println("Random No::" + otp);
        System.out.println("Monile Number::" + mobno);
//        try {
//
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "root");
//            PreparedStatement ps1 = cn1.prepareStatement("select * from user where mob=?");
//            ps1.setString(1, mobno);
//            //PreparedStatement ps = cn.prepareStatement("select * from val1 order by id desc LIMIT 36");
//            ResultSet rs1 = ps1.executeQuery();
//            while (rs1.next()) {
//                email = rs1.getString("email");
//                System.out.println("Email id::" + email);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection cn11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalization", "root", "root");
//            PreparedStatement ps11 = cn11.prepareStatement("update email set email=? where id=?");
//
//            //System.out.println(s2);
//            ps11.setString(1, email);
//            ps11.setString(2, "1");
//            ps11.execute();
//
//            //cn.close();
//        } catch (Exception e) {
//            pw.println("<html><body>" + e + "</body></html>");
//        }
        try {
            HttpSession session = request.getSession();

            //String mobile = (String) session.getAttribute("mobile");     //"8805559131";
            //tring area = (String) session.getAttribute("location");
            System.out.println("Mobile No::" + mobno);
            System.out.println("OTP::" + otp);
            String msg = "Your%20OTP%20Is:" + otp;
            String url = "http://www.smszone.in/sendsms.asp?page=SendSmsBulk&username=919028158107&password=68ca&number=" + mobno + "&message=" + msg;
            URL yahoo = new URL(url);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            System.out.println("message send");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
            PreparedStatement ps = cn.prepareStatement("update otpdoc set otp=? where id=?");

            //System.out.println(s2);
            ps.setInt(1, otp);
            ps.setInt(2, 1);

            if (ps.execute()) {
                pw.println("<html><body>Please try again..!</body></html>");
                //RequestDispatcher rd =  req.getRequestDispatcher("changeAdminPass.jsp");
                //rd.include(req, res);

            } else {
                //pw.println("<html><body>Password Changed..!</body></html>");
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('OTP Send Successfull.....');");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("CheckOTP.jsp");
                rd.include(request, response);

            }
            cn.close();
        } catch (Exception e) {
            pw.println("<html><body>" + e + "</body></html>");
        }
    }
 
}// </editor-fold>

