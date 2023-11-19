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
@WebServlet(name = "patientDetailsforAdmin2", urlPatterns = {"/patientDetailsforAdmin2"})
public class patientDetailsforAdmin2 extends HttpServlet {

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
            out.println("<title>Servlet patientDetailsforAdmin2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet patientDetailsforAdmin2 at " + request.getContextPath() + "</h1>");
            
            
            String email=request.getParameter("id");
            out.print(email);
            
            ArrayList<PatientModel> patientList=new ArrayList<PatientModel>();
            ArrayList<MedicalCard> cardList=new ArrayList<MedicalCard>();
            ArrayList<Patient_and_MedicalCard> card=new ArrayList<Patient_and_MedicalCard>();
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
                    query="select a.email,a.name, a.dob,a.i_mark,a.bloodgroup,b.illness,b.firstOccur,b.medicine,b.registerOn,b.fee,b.transaction_id from patientmaster a cross join patientmedicalcard b where a.email='"+email+"' and b.pemail='"+email+"' limit 1";
                    stmt=con.createStatement();
                    rs=stmt.executeQuery(query);
                    if(rs.next()==false){
                        Message msg=new Message();
                        msg.setMsg("Empty Patient List...");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("WelcomeAdmin.jsp").forward(request, response);
                    }else{
                        do{
                            Patient_and_MedicalCard p=new Patient_and_MedicalCard();
                            p.setEmail(rs.getString("email"));
                            p.setName(rs.getString("name"));
                            p.setDob(rs.getString("dob"));
                            p.setI_mark(rs.getString("i_mark"));
                            p.setBloodgroup(rs.getString("bloodgroup"));
                            p.setIllness(rs.getString("illness"));
                            p.setFirstOccurrence(rs.getString("firstOccur"));
                            p.setMedicine(rs.getString("medicine"));
                            p.setRegisteredOn(rs.getString("registerOn"));
                            p.setFee(rs.getString("fee"));
                            p.setTransactionId(rs.getString("transaction_id"));
                            card.add(p);
                      
                        }while(rs.next());
                        request.setAttribute("patientList", card);
                        request.getRequestDispatcher("PatientConsultationforAdmin.jsp").forward(request, response);
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
