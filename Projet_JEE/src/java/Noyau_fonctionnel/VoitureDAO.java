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
public class VoitureDAO {

    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Voiture> getAll(){
        Query query = em.createNamedQuery("Voiture.findAll");
        return query.getResultList();
    }
    
    public Voiture getOneVoiture(int id){
        Query query = em.createNamedQuery("Voiture.findById").setParameter("plaque", id);
        try{
            return (Voiture) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas de voiture de paye avec cet id");
            return null;
        }
    }
    
    public void saveVoiture(Voiture voiture) {
        em.persist(voiture);
        em.flush();
    }
    
    public void remove(int voi){
        em.remove(getOneVoiture(voi));
        em.flush();
    }
    
    public void updateVoi(Voiture voi){
        em.merge(voi);
        em.flush();
    }
}
