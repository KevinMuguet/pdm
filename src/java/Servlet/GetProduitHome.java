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
public class GetProduitHome extends HttpServlet {

    WebService.ProduitService wsProduit = new WebService.ProduitService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
            int size = wsProduit.getAllProduit().size();
            
            RequestDispatcher rd = request.getRequestDispatcher("/home.jsp") ;
       
            request.setAttribute("produitMobile",wsProduit.getAllProduitByCat(5));
            request.setAttribute("produitMachine",wsProduit.getAllProduitByCat(7));
            request.setAttribute("produitElectro",wsProduit.getAllProduitByCat(6));
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
