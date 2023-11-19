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
@WebServlet(name = "patientAllData", urlPatterns = {"/patientAllData"})
public class patientAllData extends HttpServlet {

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
            out.println("<title>Servlet patientAllData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet patientAllData at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            Connection con;
            ResultSet rs;
            Statement stmt;
            String query;
            MyConnection db=new MyConnection();
            try{
                ArrayList<PatientModel> patientDetails=new ArrayList<PatientModel>();
                ArrayList<MedicalCard> card=new ArrayList<MedicalCard>();
                con=db.getCon();
                if(con==null){
                    out.println("Fail");
                }
                else{
                    query="insert into patientmedicalcard(pemail,illness,firstOccur,medicine,registerOn) values('"+email+"','fever','2 days before','calpol',curdate())";
                    stmt=con.createStatement();
                    rs=stmt.executeQuery(query);
                    if(rs.next()==false){
                        /*invalid credential*/
                        Message msg=new Message();
                        msg.setMsg("Error in data fetching...");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("doctor_Login.jsp").forward(request, response);
                    }else{
                        do{
                        PatientModel pt=new PatientModel();
                        pt.setPid(rs.getInt("pid"));
                        pt.setEmail(rs.getString("email"));
                        pt.setPassword(rs.getString("password"));
                        pt.setName(rs.getString("name"));
                        pt.setGender(rs.getString("gender"));
                        pt.setDob(rs.getString("dob"));
                        pt.setAddress(rs.getString("address"));
                        pt.setF_or_hubName(rs.getString("f_or_hubName"));
                        pt.setOccupation(rs.getString("occupation"));
                        pt.setI_mark(rs.getString("i_mark"));
                        pt.setBloodgroup(rs.getString("bloodgroup"));
                        pt.setAadhar(rs.getString("aadhar"));
                        patientDetails.add(pt);
                    }while(rs.next());
                        
                        
                        
                    request.setAttribute("patientData", patientDetails);
                    request.getRequestDispatcher("Prescribe.jsp").forward(request, response);
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
