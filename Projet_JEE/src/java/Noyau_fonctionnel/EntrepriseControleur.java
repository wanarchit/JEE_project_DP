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
@Named(value = "entrepriseControleur")
@ViewScoped
public class EntrepriseControleur implements Serializable{

    @EJB
    private EntrepriseDAO dao;
    private Entreprise selectedEnt;
    /**
     * Creates a new instance of EntrepriseControleur
     */
    public EntrepriseControleur() {
    }
    
    public List<Entreprise> getEntreprises() {
        return dao.getAll();
    }
    
    public void addEnt(Entreprise ent){
        dao.saveEntreprise(ent);
    }
    
    public void removeEnt(int i){
        dao.remove(i);
    }
    
    public Entreprise getSelectedEnt() {
        return selectedEnt;
    }

    public void setSelectedEnt(Entreprise selectedEnt) {
        this.selectedEnt = selectedEnt;
    }
    
    public void updateEnt(Entreprise ent){
        dao.updateEnt(ent);
    }
    
}
