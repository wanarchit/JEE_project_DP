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
public class EntrepriseDAO {

    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Entreprise> getAll(){
        Query query = em.createNamedQuery("Entreprise.findAll");
        return query.getResultList();
    }
    
    public Entreprise getOneEntreprise(int id){
        Query query = em.createNamedQuery("Entreprise.findById").setParameter("iDent", id);
        try{
            return (Entreprise) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas d'entreprise avec cet id");
            return null;
        }
    }
    
    public void saveEntreprise(Entreprise entreprise) {
        em.persist(entreprise);
        em.flush();
    }
    
    public void remove(int e){
        em.remove(getOneEntreprise(e));
        em.flush();
    }
    
    public void updateEnt(Entreprise e){
        em.merge(e);
        em.flush();
    }
}
