package com.ocprojekt.app.escalade.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Pret implements Serializable {

    @Id
    @GeneratedValue
    private Integer pretId;
    private String emprunteur;
    private String proprietaire;
    private String nomDuTopo;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date debutPret;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date finPret;
    private String statut;
    @ManyToOne
    @JoinColumn(name = "topoPret")
    private Topo topo;

    public Pret(){
        super();
    }

    public Pret(String emprunteur, String proprietaire, String nomDuTopo, Date debutPret,
                Date finPret, String statut, Topo topo) {
        this.emprunteur = emprunteur;
        this.proprietaire = proprietaire;
        this.nomDuTopo = nomDuTopo;
        this.debutPret = debutPret;
        this.finPret = finPret;
        this.statut = statut;
        this.topo= topo;
    }

    public Integer getPretId() {
        return pretId;
    }

    public void setPretId(Integer pretId) {
        this.pretId = pretId;
    }

    public String getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(String emprunteur) {
        this.emprunteur = emprunteur;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNomDuTopo() {
        return nomDuTopo;
    }

    public void setNomDuTopo(String nomDuTopo) {
        this.nomDuTopo = nomDuTopo;
    }

    public Date getDebutPret() {
        return debutPret;
    }

    public void setDebutPret(Date debutPret) {
        this.debutPret = debutPret;
    }

    public Date getFinPret() {
        return finPret;
    }

    public void setFinPret(Date finPret) {
        this.finPret = finPret;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
