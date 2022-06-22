/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author bryan
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String crearJSON(String usuario) {
        StringBuilder json = new StringBuilder();
        
        json.append("[");
        json.append("{");
        json.append(usuario);
        json.append("}");
        json.append("]");
        return json.toString();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("application/json");
            try (PrintWriter out = response.getWriter()) {
                // Initialize the database
                Connection con = BaseDeDatos.initializeDatabase("proyecto");

                final String queryCheck = "SELECT * from usuarios WHERE nombre = ? AND contrasenia = ?";
                final PreparedStatement ps = con.prepareStatement(queryCheck);
                System.out.println(request.getParameter("user"));
                System.out.println(request.getParameter("pass"));
                ps.setString(1, request.getParameter("user"));
                ps.setString(2, request.getParameter("pass"));
                final ResultSet resultSet = ps.executeQuery();
                if(resultSet.next()) {
                    System.out.println("1");
                    out.write(crearJSON(request.getParameter("user")));
                } else {
                    System.out.println("2");
                    out.write("NULL");
                }
                // Close all the connections
                ps.close();
                con.close();
            }
        } catch(Exception e){
            e.printStackTrace(); 
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