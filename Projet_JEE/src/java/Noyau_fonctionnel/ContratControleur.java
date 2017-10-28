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
@Named(value = "contratControleur")
@ViewScoped
public class ContratControleur implements Serializable{
    
    @EJB
    private ContratDAO dao;
    private Contrat selectedCt;

    /**
     * Creates a new instance of ContratControleur
     */
    public ContratControleur() {
    }
    
    public List<Contrat> getContrats() {
        return dao.getAll();
    }
    
    public void addCt(Contrat ct){
        dao.saveContrat(ct);
    }
    
    public void removeCt(int i){
        dao.remove(i);
    }
    
    public Contrat getSelectedCt() {
        return selectedCt;
    }

    public void setSelectedCt(Contrat selectedCt) {
        this.selectedCt = selectedCt;
    }
    
    public void updateCt(Contrat ct){
        dao.updateCt(ct);
    }
    
}
