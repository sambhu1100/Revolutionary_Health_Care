/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "mPayment", urlPatterns = {"/mPayment"})
public class mPayment extends HttpServlet {

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
            out.println("<title>Servlet mPayment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mPayment at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            String fee=request.getParameter("tb_fee");
            String transaction=request.getParameter("tb_transaction");
            out.println(email+" "+fee+" "+transaction);
            /*
            MyConnection db=new MyConnection();
            String query;
            Connection con;
            Statement stmt;
            try{
                con=db.getCon();
                if(con!=null){
                    query="update patient_medical_card set fee='"+fee+"', transaction_id='"+transaction+"', RegisteredON=now() where pemail='"+email+"' limit 1";
                    stmt=con.createStatement();
                    int i=stmt.executeUpdate(query);
                    if(i>=1){
                        Message msg=new Message();
                        msg.setMsg("Payment details submitted successfully..");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("WelcomePatient.jsp").forward(request, response);
                    }
                    else{
                        Message msg=new Message();
                        msg.setMsg("Invalid credential");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("WelcomePat.jsp").forward(request, response);
                    }
                }
            }catch(IOException | SQLException | ServletException ex){
                
            }
            */
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
