/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "patientDeleteForAdmin", urlPatterns = {"/patientDeleteForAdmin"})
public class patientDeleteForAdmin extends HttpServlet {

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
            out.println("<title>Servlet patientDeleteForAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet patientDeleteForAdmin at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            Connection con=null;
            Statement stmt=null;
            ResultSet rs=null;
            MyConnection db=new MyConnection();
            
            try{
                con=db.getCon();
                if(con==null){
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    String query="delete from patienmedicalcard where pemail='"+email+"'";
                    stmt=con.createStatement();
                    int x=stmt.executeUpdate(query);
                    if(x>0)
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                /*
                con=db.getCon();
                if(con==null){
                    out.println("Fail");
                }
                else{
                    String query="delete from patienmedicalcard where pemail=''null'";
                    stmt=con.createStatement();
                    int x=stmt.executeUpdate(query);
                }*/
                
            }catch(SQLException ex){
                
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
            out.println(email);
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
        processRequest(request, response);
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
