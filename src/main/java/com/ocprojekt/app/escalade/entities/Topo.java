package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Topo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nomTopo;
    private String descriptionTopo;
    private Boolean isLoan =false;
    @ManyToOne
    @JoinColumn(name = "REF_UTIL")
    private Utilisateur utilisateur;

    public Topo() {
        super();
    }

    public Topo(String nomTopo, String descriptionTopo, Boolean isLoan, Utilisateur utilisateur) {
        this.nomTopo = nomTopo;
        this.descriptionTopo = descriptionTopo;
        this.isLoan = isLoan;
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTopo() {
        return nomTopo;
    }

    public void setNomTopo(String nomTopo) {
        this.nomTopo = nomTopo;
    }

    public String getDescriptionTopo() {
        return descriptionTopo;
    }

    public void setDescriptionTopo(String descriptionTopo) {
        this.descriptionTopo = descriptionTopo;
    }

    public Boolean getLoan() {
        return isLoan;
    }

    public void setLoan(Boolean loan) {
        isLoan = loan;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
