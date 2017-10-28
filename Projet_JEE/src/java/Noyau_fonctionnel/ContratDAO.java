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
public class ContratDAO {
    
    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Contrat> getAll(){
        Query query = em.createNamedQuery("Contrat.findAll");
        return query.getResultList();
    }
    
    public Contrat getOneContrat(int id){
        Query query = em.createNamedQuery("Contrat.findById").setParameter("iDcontrat", id);
        try{
            return (Contrat) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas de contrat avec cet id");
            return null;
        }
    }
    
    public void saveContrat(Contrat contrat) {
        em.persist(contrat);
        em.flush();
    }
    
    public void remove(int c){
        em.remove(getOneContrat(c));
        em.flush();
    }
    
    public void updateCt(Contrat c){
        em.merge(c);
        em.flush();
    }
}
