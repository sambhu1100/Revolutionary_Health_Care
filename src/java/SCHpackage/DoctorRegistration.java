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
@WebServlet(name = "DoctorRegistration", urlPatterns = {"/DoctorRegistration"})
public class DoctorRegistration extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoctorRegistration</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoctorRegistration at " + request.getContextPath() + "</h1>");
            
            String email=request.getParameter("tb_email");
            String password=request.getParameter("tb_password");
            String name=request.getParameter("tb_name");
            String gender=request.getParameter("gender");
            String contact=request.getParameter("tb_contact");
            String address=request.getParameter("tb_address");
            String specialization=request.getParameter("specialization");
            Connection con;
            ResultSet rs;
            Statement stmt;
            String query,checkEmail;
            MyConnection db=new MyConnection();
            try{
                con=db.getCon();
                if(con!=null){
                    query="insert into doctormaster(email,password,name,gender,contact,address,specialization) values('"+email+"','"+password+"','"+name+"','"+gender+"','"+contact+"','"+address+"','"+specialization+"')";
                    checkEmail="select * from doctormaster where binary email='"+email+"'";
                    stmt=con.createStatement();
                    rs=stmt.executeQuery(checkEmail);
                    if(rs.next()){
                        Message msg=new Message();
                        msg.setMsg("This email has alredy been registered.");
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("doctorRegistration.jsp").forward(request, response);
                    }
                        stmt=con.createStatement();
                        int result=stmt.executeUpdate(query);
                        if(result>=1){
                            Message msg=new Message();
                            msg.setMsg("Successfully Registered.");
                            request.setAttribute("message", msg);
                            request.getRequestDispatcher("doctorRegistration.jsp").forward(request, response);
                        }
                                
                }else{
                    Message msg=new Message();
                    msg.setMsg("Server error!!! Please try after some time");
                    request.setAttribute("message", msg);
                    request.getRequestDispatcher("doctorRegistration.jsp").forward(request, response);
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
            Logger.getLogger(DoctorRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DoctorRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
