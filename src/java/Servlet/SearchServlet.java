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
public class SearchServlet extends HttpServlet {

    
 WebService.ProduitService wsProduit = new WebService.ProduitService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
             
            String search = request.getParameter("searchProduit") ;
       
            request.setAttribute("result",wsProduit.getProduitByName(search));
            RequestDispatcher rd = request.getRequestDispatcher("/produitRecherche.jsp") ;
            rd.forward(request, response) ;        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
  
}
