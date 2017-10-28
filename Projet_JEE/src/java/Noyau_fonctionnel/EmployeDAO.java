/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Paul
 */
@Stateless
public class EmployeDAO {

    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Employe> getAll(){
        Query query = em.createNamedQuery("Employe.findAll");
        return query.getResultList();
    }
    
    public Employe getOneEmploye(String id){
        Query query = em.createNamedQuery("Employe.findById").setParameter("numSS", id);
        try{
            return (Employe) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas d'employé avec cet id");
            return null;
        }
    }
    
    public void saveEmploye(Employe employe) {
        em.persist(employe);
        em.flush();
    }
    
    public void remove(String idE){
        em.remove(getOneEmploye(idE));
        em.flush();
    }
    
    public void updateEmp(Employe e){
        em.merge(e);
        em.flush();
    }
}
