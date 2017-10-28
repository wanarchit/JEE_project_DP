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
@Named(value = "fichePayeControleur")
@ViewScoped
public class FichePayeControleur implements Serializable{

    @EJB
    private FichePayeDAO dao;
    private FichePaye selectedFP;
    
    /**
     * Creates a new instance of FichePayeControleur
     */
    public FichePayeControleur() {
    }
    
    public List<FichePaye> getFichePayes() {
        return dao.getAll();
    }
    
    public void addFP(FichePaye fp){
        dao.saveFichePaye(fp);
    }
    
    public void removeFP(int i){
        dao.remove(i);
    }
    
    public FichePaye getSelectedFP() {
        return selectedFP;
    }

    public void setSelectedFP(FichePaye selectedFP) {
        this.selectedFP = selectedFP;
    }
    
    public void updateFP(FichePaye fp){
        dao.updateFP(fp);
    }
    
}
