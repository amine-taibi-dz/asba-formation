/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dz.acs.hr.client.ws.rh;

import dz.acs.rh.ws.client.Employee;
import dz.acs.rh.ws.client.EmployeeWebService;
import dz.acs.rh.ws.client.EmployeeWebServiceService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author ataibi
 */
@WebServlet(name = "TestWS", urlPatterns = {"/call-ws"})
public class TestWS extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/EmployeeWebServiceService/EmployeeWebService.wsdl")
    private EmployeeWebServiceService service;
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
             //out.println(service.getEmployeeWebServicePort().employeeCreate(new Employee()));
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestWS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestWS at " + request.getContextPath() + "</h1>");
            try { // Call Web Service Operation
                EmployeeWebService port = service.getEmployeeWebServicePort();
                // TODO initialize WS operation arguments here
                Employee emp = new Employee();
                emp.setFirstName("Djallel");
                emp.setLastName("Maamir");
                emp.setEnterYear(2008L);
                emp.setMatricule(305L);
                
                Employee result = port.employeeCreate(emp);
                out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
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
