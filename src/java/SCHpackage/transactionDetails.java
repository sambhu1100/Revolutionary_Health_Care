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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "transactionDetails", urlPatterns = {"/transactionDetails"})
public class transactionDetails extends HttpServlet {

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
            out.println("<title>Servlet transactionDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet transactionDetails at " + request.getContextPath() + "</h1>");
            
            
           
            ArrayList<MedicalCard> mdata=new ArrayList<MedicalCard>();
            Connection con;
            ResultSet rs;
            Statement stmt;
            String query;
            MyConnection db=new MyConnection();
            try{
                con=db.getCon();
                if(con==null){
                    out.println("Fail");
                }
                else{
                    query="select pemail,transaction_id,registerOn from patientmedicalcard limit 5";
                    stmt=con.createStatement();
                    rs=stmt.executeQuery(query);
                    if(rs.next()==false){
                        Message msg=new Message();
                        msg.setMsg("Error");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("admin_login.jsp").forward(request, response);
                    }else{
                        do{
                           MedicalCard data=new MedicalCard();
                           data.setEmail(rs.getString("pemail"));
                           data.setTransactionId(rs.getString("transaction_id"));
                           data.setRegisteredOn(rs.getString("registerOn"));
                           mdata.add(data);
                        }while(rs.next());
                        //patient data
                        
                        
                        
                        
                        
                        request.setAttribute("data", mdata);
                        request.getRequestDispatcher("TransactionDetails.jsp").forward(request, response);
                    }
                    
                }
            }catch(SQLException ex){
                
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
