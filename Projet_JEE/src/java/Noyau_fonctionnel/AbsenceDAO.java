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
public class AbsenceDAO {
    
    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Absence> getAll(){
        Query query = em.createNamedQuery("Absence.findAll");
        return query.getResultList();
    }
    
    public Absence getOneAbsence(int id){
        Query query = em.createNamedQuery("Absence.findById").setParameter("iDabsence", id);
        try{
            return (Absence) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas d'absence avec cet id");
            return null;
        }
    }
    
    public void saveAbsence(Absence absence) {
        em.persist(absence);
        em.flush();
    }
    
    public void remove(int a){
        em.remove(getOneAbsence(a));
        em.flush();
    }
    
    public void updateAbs(Absence a){
        em.merge(a);
        em.flush();
    }
}
