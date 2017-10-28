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
import javax.validation.constraints.Size;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "contrat")
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c")
    , @NamedQuery(name = "Contrat.findByIDcontrat", query = "SELECT c FROM Contrat c WHERE c.iDcontrat = :iDcontrat")
    , @NamedQuery(name = "Contrat.findByService", query = "SELECT c FROM Contrat c WHERE c.service = :service")
    , @NamedQuery(name = "Contrat.findByPoste", query = "SELECT c FROM Contrat c WHERE c.poste = :poste")
    , @NamedQuery(name = "Contrat.findByDateDcontrat", query = "SELECT c FROM Contrat c WHERE c.dateDcontrat = :dateDcontrat")
    , @NamedQuery(name = "Contrat.findByDateFcontrat", query = "SELECT c FROM Contrat c WHERE c.dateFcontrat = :dateFcontrat")
    , @NamedQuery(name = "Contrat.findBySalaireBrut", query = "SELECT c FROM Contrat c WHERE c.salaireBrut = :salaireBrut")
    , @NamedQuery(name = "Contrat.findByHeuresMens", query = "SELECT c FROM Contrat c WHERE c.heuresMens = :heuresMens")
    , @NamedQuery(name = "Contrat.findByCongesAnn", query = "SELECT c FROM Contrat c WHERE c.congesAnn = :congesAnn")
    , @NamedQuery(name = "Contrat.findByContratValidee", query = "SELECT c FROM Contrat c WHERE c.contratValidee = :contratValidee")})
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_contrat")
    private Integer iDcontrat;
    @Size(max = 50)
    @Column(name = "service")
    private String service;
    @Size(max = 50)
    @Column(name = "poste")
    private String poste;
    @Column(name = "dateD_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateDcontrat;
    @Column(name = "dateF_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateFcontrat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salaire_brut")
    private BigDecimal salaireBrut;
    @Column(name = "heures_mens")
    private Integer heuresMens;
    @Column(name = "conges_ann")
    private Integer congesAnn;
    @Column(name = "contrat_validee")
    private Boolean contratValidee;
    @JoinColumn(name = "num_SS", referencedColumnName = "num_SS")
    @ManyToOne
    private Employe numSS;

    public Contrat() {
    }

    public Contrat(Integer iDcontrat) {
        this.iDcontrat = iDcontrat;
    }

    public Integer getIDcontrat() {
        return iDcontrat;
    }

    public void setIDcontrat(Integer iDcontrat) {
        this.iDcontrat = iDcontrat;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Date getDateDcontrat() {
        return dateDcontrat;
    }

    public void setDateDcontrat(Date dateDcontrat) {
        this.dateDcontrat = dateDcontrat;
    }
    
    public String displayDateD(Date dateDcontrat){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateDcontrat);
        return dateDisplaying;
    }

    public Date getDateFcontrat() {
        return dateFcontrat;
    }

    public void setDateFcontrat(Date dateFcontrat) {
        this.dateFcontrat = dateFcontrat;
    }
    
    public String displayDateF(Date dateFcontrat){
        if(dateFcontrat == null){
            return "/";
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateDisplaying = formatter.format(dateFcontrat);
            return dateDisplaying;
        }
        
    }
    
    public BigDecimal getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(BigDecimal salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public Integer getHeuresMens() {
        return heuresMens;
    }

    public void setHeuresMens(Integer heuresMens) {
        this.heuresMens = heuresMens;
    }

    public Integer getCongesAnn() {
        return congesAnn;
    }

    public void setCongesAnn(Integer congesAnn) {
        this.congesAnn = congesAnn;
    }

    public Boolean getContratValidee() {
        return contratValidee;
    }

    public void setContratValidee(Boolean contratValidee) {
        this.contratValidee = contratValidee;
    }
    
    public String displayCtVal(Boolean contratValidee){
        if(contratValidee){
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
        hash += (iDcontrat != null ? iDcontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.iDcontrat == null && other.iDcontrat != null) || (this.iDcontrat != null && !this.iDcontrat.equals(other.iDcontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Contrat[ iDcontrat=" + iDcontrat + " ]";
    }
    
}
