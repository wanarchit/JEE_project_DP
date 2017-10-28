/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "voiture")
@NamedQueries({
    @NamedQuery(name = "Voiture.findAll", query = "SELECT v FROM Voiture v")
    , @NamedQuery(name = "Voiture.findByPlaque", query = "SELECT v FROM Voiture v WHERE v.plaque = :plaque")
    , @NamedQuery(name = "Voiture.findByMarque", query = "SELECT v FROM Voiture v WHERE v.marque = :marque")
    , @NamedQuery(name = "Voiture.findByModele", query = "SELECT v FROM Voiture v WHERE v.modele = :modele")
    , @NamedQuery(name = "Voiture.findByKilometrage", query = "SELECT v FROM Voiture v WHERE v.kilometrage = :kilometrage")
    , @NamedQuery(name = "Voiture.findByDateProchRevision", query = "SELECT v FROM Voiture v WHERE v.dateProchRevision = :dateProchRevision")
    , @NamedQuery(name = "Voiture.findByDisponibilite", query = "SELECT v FROM Voiture v WHERE v.disponibilite = :disponibilite")})
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "plaque")
    private String plaque;
    @Size(max = 50)
    @Column(name = "marque")
    private String marque;
    @Size(max = 50)
    @Column(name = "modele")
    private String modele;
    @Column(name = "kilometrage")
    private Integer kilometrage;
    @Column(name = "date_proch_revision")
    @Temporal(TemporalType.DATE)
    private Date dateProchRevision;
    @Column(name = "disponibilite")
    private Boolean disponibilite;
    @OneToMany(mappedBy = "plaque")
    private List<Reservation> reservationList;

    public Voiture() {
    }

    public Voiture(String plaque) {
        this.plaque = plaque;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Date getDateProchRevision() {
        return dateProchRevision;
    }

    public void setDateProchRevision(Date dateProchRevision) {
        this.dateProchRevision = dateProchRevision;
    }
    
    public String displayDateRevision(Date dateProchRevision){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateProchRevision);
        return dateDisplaying;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    public String displayDispoVal(Boolean disponibilite){
        if(disponibilite){
            return "Disponible";
        }else{
            return "Non disponible";
        }
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaque != null ? plaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voiture)) {
            return false;
        }
        Voiture other = (Voiture) object;
        if ((this.plaque == null && other.plaque != null) || (this.plaque != null && !this.plaque.equals(other.plaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Voiture[ plaque=" + plaque + " ]";
    }
    
}
