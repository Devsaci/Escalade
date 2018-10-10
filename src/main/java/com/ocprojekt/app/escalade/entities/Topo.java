package com.ocprojekt.app.escalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Topo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nomTopo;
    private String descriptionTopo;
    private String statutTopo;
    private Utilisateur utilisateur;

    public Topo() {
        super();
    }

    public Topo(String nomTopo, String descriptionTopo, String statutTopo, Utilisateur utilisateur) {
        super();
        this.nomTopo = nomTopo;
        this.descriptionTopo = descriptionTopo;
        this.statutTopo = statutTopo;
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

    public String getStatutTopo() {
        return statutTopo;
    }

    public void setStatutTopo(String statutTopo) {
        this.statutTopo = statutTopo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
