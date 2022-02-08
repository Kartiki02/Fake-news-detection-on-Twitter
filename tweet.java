
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
import javax.servlet.http.HttpSession;


public class tweet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String s1=req.getParameter("tweet");
		//String s2=req.getParameter("pass");

     try
     {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root","system");
        PreparedStatement ps = cn.prepareStatement("insert into user where tweet=?");

                ps.setString(1,s1);
               // ps.setString(2,s2);
                
                ResultSet rs=ps.executeQuery();
                int i=0;
                while (rs.next())
                {
                 i++;
                }
            if(i>0)
            {
             HttpSession session = req.getSession();
             session.setAttribute("user",s1);
             RequestDispatcher rd =  req.getRequestDispatcher("tweets.jsp");
             rd.include(req, res);
            }
            else
            {
                pw.println("<script type=\"text/javascript\">");  
                pw.println("alert('Please enter correct username and password..');");
                pw.println("</script>");
                RequestDispatcher rd =  req.getRequestDispatcher("Home.jsp");
                rd.include(req, res);
            }
     }
     catch (Exception e)
      {
            pw.println("<html><body>"+ e +"</body></html>");
      }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
