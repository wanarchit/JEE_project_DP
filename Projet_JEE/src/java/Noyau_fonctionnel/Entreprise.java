/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "entreprise")
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e")
    , @NamedQuery(name = "Entreprise.findByIDent", query = "SELECT e FROM Entreprise e WHERE e.iDent = :iDent")
    , @NamedQuery(name = "Entreprise.findByNomEnt", query = "SELECT e FROM Entreprise e WHERE e.nomEnt = :nomEnt")
    , @NamedQuery(name = "Entreprise.findByAdresseEnt", query = "SELECT e FROM Entreprise e WHERE e.adresseEnt = :adresseEnt")
    , @NamedQuery(name = "Entreprise.findByLogo", query = "SELECT e FROM Entreprise e WHERE e.logo = :logo")})
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ent")
    private Integer iDent;
    @Size(max = 50)
    @Column(name = "nom_ent")
    private String nomEnt;
    @Size(max = 100)
    @Column(name = "adresse_ent")
    private String adresseEnt;
    @Size(max = 200)
    @Column(name = "logo")
    private String logo;
    @OneToMany(mappedBy = "iDent")
    private List<Employe> employeList;

    public Entreprise() {
    }

    public Entreprise(Integer iDent) {
        this.iDent = iDent;
    }

    public Integer getIDent() {
        return iDent;
    }

    public void setIDent(Integer iDent) {
        this.iDent = iDent;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public void setNomEnt(String nomEnt) {
        this.nomEnt = nomEnt;
    }

    public String getAdresseEnt() {
        return adresseEnt;
    }

    public void setAdresseEnt(String adresseEnt) {
        this.adresseEnt = adresseEnt;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDent != null ? iDent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.iDent == null && other.iDent != null) || (this.iDent != null && !this.iDent.equals(other.iDent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Entreprise[ iDent=" + iDent + " ]";
    }
    
}
