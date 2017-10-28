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
@Named(value = "employeControleur")
@ViewScoped
public class EmployeControleur implements Serializable{

    @EJB
    private EmployeDAO dao;
    private Employe selectedEmp;
    /**
     * Creates a new instance of EmployeControleur
     */
    public EmployeControleur() {
    }
    
    public List<Employe> getEmployes() {
        return dao.getAll();
    }
    
    public void addEmp(Employe emp){
        dao.saveEmploye(emp);
    }
    
    public void removeEmp(String idE){
        dao.remove(idE);
    }
    
    public Employe getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(Employe selectedEmp) {
        this.selectedEmp = selectedEmp;
    }
    
    public void updateEmp(Employe emp){
        dao.updateEmp(emp);
    }
    
}
