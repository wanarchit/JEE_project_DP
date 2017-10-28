/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Paul
 */
@Named(value = "reservationControleur")
@ViewScoped
public class ReservationControleur implements Serializable{

    @EJB
    private ReservationDAO dao;
    private Reservation selectedResa;
    
    /**
     * Creates a new instance of ReservationControleur
     */
    public ReservationControleur() {
    }
    
    public List<Reservation> getReservations() {
        return dao.getAll();
    }
    
    public void addResa(Reservation resa){
        dao.saveReservation(resa);
    }
    
    public void removeResa(int i){
        dao.remove(i);
    }
    
    public Reservation getSelectedResa() {
        return selectedResa;
    }

    public void setSelectedResa(Reservation selectedResa) {
        this.selectedResa = selectedResa;
    }
    
    public void updateResa(Reservation resa){
        dao.updateResa(resa);
    }
    
}
