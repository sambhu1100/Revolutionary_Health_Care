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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "PatientRegistration", urlPatterns = {"/PatientRegistration"})
public class PatientRegistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PatientRegistration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PatientRegistration at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            String password=request.getParameter("tb_password");
            String name=request.getParameter("tb_name");
            String gender=request.getParameter("gender");
            String dob=request.getParameter("tb_dob");
            String address=request.getParameter("tb_address");
            String f_or_h=request.getParameter("tb_guardian");
            String occupation=request.getParameter("tb_occupation");
            String identification_mark=request.getParameter("tb_mark");
            String bloodgroup=request.getParameter("blood_group");
            String aadhar=request.getParameter("tb_aadhar");
         
            Connection con;
            Statement stmt;
            ResultSet rs;
            String query,checkEmail;
            MyConnection db=new MyConnection();
            try{
                con=db.getCon();
                if(con!=null){
                    query="insert into patientmaster(email,password,name,gender,dob,address,f_or_hubName,occupation,i_mark,bloodgroup,aadhar) values('"+email+"','"+password+"','"+name+"','"+gender+"','"+dob+"','"+address+"','"+f_or_h+"','"+occupation+"','"+identification_mark+"','"+bloodgroup+"','"+aadhar+"');";
                    checkEmail="select * from patientMaster where binary email='"+email+"'";
                    stmt=con.createStatement();
                    rs=stmt.executeQuery(checkEmail);
                    if(rs.next()){
                        Message msg=new Message();
                        msg.setMsg("This email has alredy been registered.");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("patient_Registration.jsp").forward(request, response);
                    }
                        stmt=con.createStatement();
                        int result=stmt.executeUpdate(query);
                        if(result>=1){
                            Message msg=new Message();
                            msg.setMsg("Successfully Registered.");
                            request.setAttribute("message", msg);
                            request.getRequestDispatcher("patient_Registration.jsp").forward(request, response);
                        }
                                  
                }else{
                    Message msg=new Message();
                    msg.setMsg("Server error!!! Please try after some time");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("patient_Registration.jsp").forward(request, response);
                }
            }catch(IOException | ServletException ex){
                
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PatientRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PatientRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
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
