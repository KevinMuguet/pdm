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
public class InscriptionServlet extends HttpServlet {

     WebService.UtilisateurService addUser = new WebService.UtilisateurService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // permet de décoder les paramètres en UTF-8
        request.setCharacterEncoding("UTF-8") ;

        String Nom = "tester";
        String Email = "test@test.fr";
        String Password = "Test";
        String typeUser = "tester";
        
        boolean connexionSuccess = addUser.insertUser();
        
        if(connexionSuccess){
            RequestDispatcher rd = request.getRequestDispatcher("/connexion.jsp") ;
            rd.forward(request, response) ;
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/inscription.jsp") ;
            rd.forward(request, response) ;
        }

    }
    
}
