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
@WebServlet(name = "updatePatient", urlPatterns = {"/updatePatient"})
public class updatePatient extends HttpServlet {

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
            out.println("<title>Servlet updatePatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatePatient at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            String mark=request.getParameter("tb_mark");
            String blood=request.getParameter("tb_bloodgroup");
            String f_or_hub=request.getParameter("tb_forhub");
            String address=request.getParameter("tb_address");
            out.println(email);
            String query;
            Connection con;
            ResultSet rs;
            Statement stmt;
            
            MyConnection db=new MyConnection();
            try{
                con=db.getCon();
                query="update patientmaster set i_mark='"+mark+"',bloodgroup='"+blood+"',f_or_hubName='"+f_or_hub+"',address='"+address+"' where email='"+email+"' limit 1";
                stmt=con.createStatement();
                int i=stmt.executeUpdate(query);
                if(i>=1){
                    Message msg=new Message();
                       msg.setMsg("Data updated successfully");
                       request.setAttribute("message", msg);
                       request.getRequestDispatcher("patient_Login.jsp").forward(request, response);
                }
            }catch(IOException | SQLException | ServletException ex){
                
            }
            
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
