/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.setContentType("text/html");
                 PrintWriter out= new PrintWriter(response.getWriter());
                      
                      String u,p;
                      u=request.getParameter("username");
                      p=request.getParameter("userpassword");
                      try{
                          Class.forName("com.mysql.cj.jdbc.Driver");
                          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
                          PreparedStatement ps=con.prepareStatement("select * from login where unm=? and pwd=?" );
                          ps.setString(1,u);
                          ps.setString(2,p);
                          ResultSet rs=ps.executeQuery();
                          boolean status= rs.next();
                          if(status=true)
                          {
                              String user;
                              user = rs.getString("unm");
                              String pwd;
                              pwd = rs.getString("pwd");
                              if(u.equals(user) && p.equals(pwd))
                              {
                                  response.sendRedirect("WelcomeServlet");
                              }
                              else
                              {
                                  RequestDispatcher requestDispatcher= request.getRequestDispatcher("/index.html");
                                  requestDispatcher.include(request,response);
                                  
                              }
                          }
                      }
                      catch( Exception e){
                      }
                      
                      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
