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
public class ReservationDAO {

    @PersistenceContext(unitName = "Projet_JEEPU")
    private EntityManager em;
    
    public List<Reservation> getAll(){
        Query query = em.createNamedQuery("Reservation.findAll");
        return query.getResultList();
    }
    
    public Reservation getOneReservation(int id){
        Query query = em.createNamedQuery("Reservation.findById").setParameter("iDresa", id);
        try{
            return (Reservation) query.getSingleResult();
        } catch (NoResultException e){
            System.err.println("pas de reservation de paye avec cet id");
            return null;
        }
    }
    
    public void saveReservation(Reservation reservation) {
        em.persist(reservation);
        em.flush();
    }
    
    public void remove(int resa){
        em.remove(getOneReservation(resa));
        em.flush();
    }
    
    public void updateResa(Reservation resa){
        em.merge(resa);
        em.flush();
    }
}
