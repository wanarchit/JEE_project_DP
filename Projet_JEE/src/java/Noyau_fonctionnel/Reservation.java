/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "reservation")
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findByIDresa", query = "SELECT r FROM Reservation r WHERE r.iDresa = :iDresa")
    , @NamedQuery(name = "Reservation.findByDateD", query = "SELECT r FROM Reservation r WHERE r.dateD = :dateD")
    , @NamedQuery(name = "Reservation.findByDateF", query = "SELECT r FROM Reservation r WHERE r.dateF = :dateF")
    , @NamedQuery(name = "Reservation.findByEtat", query = "SELECT r FROM Reservation r WHERE r.etat = :etat")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_resa")
    private Integer iDresa;
    @Column(name = "dateD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateD;
    @Column(name = "dateF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateF;
    @Size(max = 50)
    @Column(name = "etat")
    private String etat;
    @JoinColumn(name = "plaque", referencedColumnName = "plaque")
    @ManyToOne
    private Voiture plaque;
    @JoinColumn(name = "num_SS", referencedColumnName = "num_SS")
    @ManyToOne
    private Employe numSS;

    public Reservation() {
    }

    public Reservation(Integer iDresa) {
        this.iDresa = iDresa;
    }

    public Integer getIDresa() {
        return iDresa;
    }

    public void setIDresa(Integer iDresa) {
        this.iDresa = iDresa;
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }
    
    public String displayDateD(Date dateD){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateD);
        return dateDisplaying;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }
    
    public String displayDateF(Date dateF){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateF);
        return dateDisplaying;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Voiture getPlaque() {
        return plaque;
    }

    public void setPlaque(Voiture plaque) {
        this.plaque = plaque;
    }

    public Employe getNumSS() {
        return numSS;
    }

    public void setNumSS(Employe numSS) {
        this.numSS = numSS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDresa != null ? iDresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.iDresa == null && other.iDresa != null) || (this.iDresa != null && !this.iDresa.equals(other.iDresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Reservation[ iDresa=" + iDresa + " ]";
    }
    
}
