/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joker
 */
public class getCsvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         GenerateCsv.GenerateCsv wsTools = new GenerateCsv.GenerateCsv();
        wsTools.createCsvClient();
        
        RequestDispatcher rd = request.getRequestDispatcher("/redirectionHomePage.jsp") ;
            rd.forward(request, response) ;
        
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
        
        GenerateCsv.GenerateCsv wsTools = new GenerateCsv.GenerateCsv();
        wsTools.createCsvClient();
        
        
    }

}
