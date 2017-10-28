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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "employe")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e")
    , @NamedQuery(name = "Employe.findByNumSS", query = "SELECT e FROM Employe e WHERE e.numSS = :numSS")
    , @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom")
    , @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Employe.findByDateNaissance", query = "SELECT e FROM Employe e WHERE e.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Employe.findBySexe", query = "SELECT e FROM Employe e WHERE e.sexe = :sexe")
    , @NamedQuery(name = "Employe.findByAdresse", query = "SELECT e FROM Employe e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Employe.findByPhoto", query = "SELECT e FROM Employe e WHERE e.photo = :photo")
    , @NamedQuery(name = "Employe.findByLogin", query = "SELECT e FROM Employe e WHERE e.login = :login")
    , @NamedQuery(name = "Employe.findByMdp", query = "SELECT e FROM Employe e WHERE e.mdp = :mdp")
    , @NamedQuery(name = "Employe.findByMail", query = "SELECT e FROM Employe e WHERE e.mail = :mail")})
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_SS")
    private String numSS;
    @Size(max = 50)
    @Column(name = "nom")
    private String nom;
    @Size(max = 50)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "sexe")
    private Boolean sexe;
    @Size(max = 100)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 200)
    @Column(name = "photo")
    private String photo;
    @Size(max = 50)
    @Column(name = "login")
    private String login;
    @Size(max = 50)
    @Column(name = "mdp")
    private String mdp;
    @Size(max = 50)
    @Column(name = "mail")
    private String mail;
    @OneToMany(mappedBy = "numSS")
    private List<Contrat> contratList;
    @JoinColumn(name = "ID_ent", referencedColumnName = "ID_ent")
    @ManyToOne
    private Entreprise iDent;
    @OneToMany(mappedBy = "numSS")
    private List<Absence> absenceList;
    @OneToMany(mappedBy = "numSS")
    private List<FichePaye> fichePayeList;
    @OneToMany(mappedBy = "numSS")
    private List<Reservation> reservationList;

    public Employe() {
    }

    public Employe(String numSS) {
        this.numSS = numSS;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public String displayDate(Date dateNaissance){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateDisplaying = formatter.format(dateNaissance);
        return dateDisplaying;
    }

    public Boolean getSexe() {
        return sexe;
    }

    public void setSexe(Boolean sexe) {
        this.sexe = sexe;
    }
    
    public String displaySexe(Boolean sexe){
        if(sexe){
            return "Homme";
        }else{
            return "Femme";
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    public Entreprise getIDent() {
        return iDent;
    }

    public void setIDent(Entreprise iDent) {
        this.iDent = iDent;
    }

    public List<Absence> getAbsenceList() {
        return absenceList;
    }

    public void setAbsenceList(List<Absence> absenceList) {
        this.absenceList = absenceList;
    }

    public List<FichePaye> getFichePayeList() {
        return fichePayeList;
    }

    public void setFichePayeList(List<FichePaye> fichePayeList) {
        this.fichePayeList = fichePayeList;
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
        hash += (numSS != null ? numSS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.numSS == null && other.numSS != null) || (this.numSS != null && !this.numSS.equals(other.numSS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Noyau_fonctionnel.Employe[ numSS=" + numSS + " ]";
    }
    
}
