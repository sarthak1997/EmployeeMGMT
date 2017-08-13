/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EmployeeDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;

/**
 *
 * @author SarthakJ
 */
public class UpdateEmp extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmp</title>");            
            out.println("</head>");
            out.println("<body>");
            int eid=Integer.parseInt(request.getParameter("eid"));
            EmployeeDao ad=new EmployeeDao();
            Employee a=ad.searchEmployee(eid);
            if(a==null)
                out.println("<center><h1>INVALID ID</h1></center>");
            else{
            out.println("<br><br><br><br><br><br><br><br>");
            out.println("<form method=post action=UpdateServlet");
            out.println("<center><table border=1><tr><th>Employee Name</th><td><input type=text name=upname value="+a.getEname()+ "></td></tr>");
            out.println("<tr><th>Employee ID</th><td><input type=text name=eid readonly value="+a.getEid()+ "></td></tr>");
            out.println("<tr><th>Employee Department</th><td><input type=text name=updept value="+a.getEdept()+ "></td></tr>");
            out.println("<tr><th>Employee Salary</th><td><input type=text name=upsal value="+a.getEsalary()+ "></td></tr></table><table><tr><td></td><input type=Submit value=Update></tr></table></center></form>");
            out.println("</body>");
            out.println("</html>");}
        }
        catch(Exception e)
        {
        out.println(e);
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
