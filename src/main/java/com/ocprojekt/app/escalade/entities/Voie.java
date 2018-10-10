package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Voie implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nomVoie;
    private String descriptionVoie;
    private String niveauVoie;
    @ManyToOne
    @JoinColumn(name = "REF_SECT")
    private Secteur secteur;

    public Voie() {
        super();
    }

    public Voie(String nomVoie, String descriptionVoie, String niveauVoie, Secteur secteur) {
        super();
        this.nomVoie = nomVoie;
        this.descriptionVoie = descriptionVoie;
        this.niveauVoie = niveauVoie;
        this.secteur = secteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getDescriptionVoie() {
        return descriptionVoie;
    }

    public void setDescriptionVoie(String descriptionVoie) {
        this.descriptionVoie = descriptionVoie;
    }

    public String getNiveauVoie() {
        return niveauVoie;
    }

    public void setNiveauVoie(String niveauVoie) {
        this.niveauVoie = niveauVoie;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
