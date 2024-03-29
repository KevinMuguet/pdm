/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import classBdd.Utilisateur;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;


@WebService(serviceName = "Utilisateur")
public class UtilisateurService {
    
    @Resource
    UserTransaction utx2;
    
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AmazonProjectPU");
    
    @PersistenceContext
    EntityManager emUtilisateur = entityManagerFactory.createEntityManager();

    
    @WebMethod(operationName = "connexionUser")
    public boolean connexionUser(@WebParam(name = "email") String email, @WebParam(name = "pwd") String pwd ){
        
        try{
           Utilisateur user = (Utilisateur) emUtilisateur.createNamedQuery("Utilisateur.connexion").setParameter("email", email).setParameter("pwd", pwd).getSingleResult();
           return true;
        }catch(NoResultException e){
       
            return false;
        }
    }
    
    
   
    
}
