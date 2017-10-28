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
@Named(value = "voitureControleur")
@ViewScoped
public class VoitureControleur implements Serializable{

    @EJB
    private VoitureDAO dao;
    private Voiture selectedVoi;
    
    /**
     * Creates a new instance of VoitureControleur
     */
    public VoitureControleur() {
    }
    
    public List<Voiture> getVoitures() {
        return dao.getAll();
    }
    
    public void addVoi(Voiture voi){
        dao.saveVoiture(voi);
    }
    
    public void removeVoi(int i){
        dao.remove(i);
    }
    
    public Voiture getSelectedVoi() {
        return selectedVoi;
    }

    public void setSelectedVoi(Voiture selectedVoi) {
        this.selectedVoi = selectedVoi;
    }
    
    public void updateVoi(Voiture voi){
        dao.updateVoi(voi);
    }
}
