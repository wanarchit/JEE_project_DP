/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noyau_fonctionnel;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "fiche_paye")
@NamedQueries({
    @NamedQuery(name = "FichePaye.findAll", query = "SELECT f FROM FichePaye f")
    , @NamedQuery(name = "FichePaye.findByIDfiche", query = "SELECT f FROM FichePaye f WHERE f.iDfiche = :iDfiche")
    , @NamedQuery(name = "FichePaye.findByDateBs", query = "SELECT f FROM FichePaye f WHERE f.dateBs = :dateBs")
    , @NamedQuery(name = "FichePaye.findByPrime", query = "SELECT f FROM FichePaye f WHERE f.prime = :prime")
    , @NamedQuery(name = "FichePaye.findByFicheValidee", query = "SELECT f FROM FichePaye f WHERE f.ficheValidee = :ficheValidee")})
public class FichePaye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_fiche")
    private Integer iDfiche;
    @Column(name = "date_bs")
    @Temporal(TemporalType.DATE)
    private Date dateBs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prime")
    private BigDecimal prime;
    @Column(name = "fiche_validee")
    private Boolean ficheValidee;
    @JoinColumn(name = "num_SS", referencedColumnName = "num_SS")
    @ManyToOne
    private Employe numSS;

    public FichePaye() {
    }

    public FichePaye(Integer iDfiche) {
        this.iDfiche = iDfiche;
    }

    public Integer getIDfiche() {
        return iDfiche;
    }

    public void setIDfiche(Integer iDfiche) {
        this.iDfiche = iDfiche;
    }

    public Date getDateBs() {
        return dateBs;
    }

    public void setDateBs(Date dateBs) {
        this.dateBs = dateBs;
    }
    
    public String displayDateFP(Date dateBs){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        String dateDisplaying = formatter.format(dateBs);
        return dateDisplaying;
    }

    public BigDecimal getPrime() {
        return prime;
    }

    public void setPrime(BigDecimal prime) {
        this.prime = prime;
    }

    public Boolean getFicheValidee() {
        return ficheValidee;
    }

    public void setFicheValidee(Boolean ficheValidee) {
        this.ficheValidee = ficheValidee;
    }
    
    public String displayFPVal(Boolean ficheValidee){
        if(ficheValidee){
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
        hash += (iDfiche != null ? iDfiche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichePaye)) {
            return false;
        }
        FichePaye other = (FichePaye) object;
        if ((this.iDfiche == null && other.iDfiche != null) || (this.iDfiche != null && !this.iDfiche.equals(other.iDfiche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.FichePaye[ iDfiche=" + iDfiche + " ]";
    }
    
}
