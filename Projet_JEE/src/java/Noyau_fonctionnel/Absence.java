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
@Table(name = "absence")
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a")
    , @NamedQuery(name = "Absence.findByIDabsence", query = "SELECT a FROM Absence a WHERE a.iDabsence = :iDabsence")
    , @NamedQuery(name = "Absence.findByDateDabs", query = "SELECT a FROM Absence a WHERE a.dateDabs = :dateDabs")
    , @NamedQuery(name = "Absence.findByDateFabs", query = "SELECT a FROM Absence a WHERE a.dateFabs = :dateFabs")
    , @NamedQuery(name = "Absence.findByMotif", query = "SELECT a FROM Absence a WHERE a.motif = :motif")
    , @NamedQuery(name = "Absence.findByAbsValidee", query = "SELECT a FROM Absence a WHERE a.absValidee = :absValidee")})
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_absence")
    private Integer iDabsence;
    @Column(name = "dateD_abs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDabs;
    @Column(name = "dateF_abs")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFabs;
    @Size(max = 50)
    @Column(name = "motif")
    private String motif;
    @Column(name = "abs_validee")
    private Boolean absValidee;
    @JoinColumn(name = "num_SS", referencedColumnName = "num_SS")
    @ManyToOne
    private Employe numSS;

    public Absence() {
    }

    public Absence(Integer iDabsence) {
        this.iDabsence = iDabsence;
    }

    public Integer getIDabsence() {
        return iDabsence;
    }

    public void setIDabsence(Integer iDabsence) {
        this.iDabsence = iDabsence;
    }

    public Date getDateDabs() {
        return dateDabs;
    }

    public void setDateDabs(Date dateDabs) {
        this.dateDabs = dateDabs;
    }
    
    public String displayDateD(Date dateDabs){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateDabs);
        return dateDisplaying;
    }

    public Date getDateFabs() {
        return dateFabs;
    }

    public void setDateFabs(Date dateFabs) {
        this.dateFabs = dateFabs;
    }
    
    public String displayDateF(Date dateFabs){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm - dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateFabs);
        return dateDisplaying;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Boolean getAbsValidee() {
        return absValidee;
    }

    public void setAbsValidee(Boolean absValidee) {
        this.absValidee = absValidee;
    }
    
    public String displayAbsVal(Boolean absValidee){
        if(absValidee){
            return "Validée";
        }else{
            return "Non validée";
        }
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
        hash += (iDabsence != null ? iDabsence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.iDabsence == null && other.iDabsence != null) || (this.iDabsence != null && !this.iDabsence.equals(other.iDabsence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Absence[ iDabsence=" + iDabsence + " ]";
    }
    
}
