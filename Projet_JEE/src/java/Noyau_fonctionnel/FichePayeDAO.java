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
public class FichePayeDAO {

    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<FichePaye> getAll(){
        Query query = em.createNamedQuery("FichePaye.findAll");
        return query.getResultList();
    }
    
    public FichePaye getOneFichePaye(int id){
        Query query = em.createNamedQuery("FichePaye.findById").setParameter("iDfiche", id);
        try{
            return (FichePaye) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas de fiche de paye avec cet id");
            return null;
        }
    }
    
    public void saveFichePaye(FichePaye fichePaye) {
        em.persist(fichePaye);
        em.flush();
    }
    
    public void remove(int fp){
        em.remove(getOneFichePaye(fp));
        em.flush();
    }
    
    public void updateFP(FichePaye fp){
        em.merge(fp);
        em.flush();
    }
}
