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
@Named(value = "absenceControleur")
@ViewScoped
public class AbsenceControleur implements Serializable{

    @EJB
    private AbsenceDAO dao;
    private Absence selectedAbs;
    
    /**
     * Creates a new instance of AbsenceControleur
     */
    public AbsenceControleur() {
    }
    
    public List<Absence> getAbsences() {
        return dao.getAll();
    }
    
    public void addAbs(Absence abs){
        dao.saveAbsence(abs);
    }
    
    public void removeAbs(int i){
        dao.remove(i);
    }
    
    public Absence getSelectedAbs() {
        return selectedAbs;
    }

    public void setSelectedAbs(Absence selectedAbs) {
        this.selectedAbs = selectedAbs;
    }
    
    public void updateAbs(Absence abs){
        dao.updateAbs(abs);
    }
}
