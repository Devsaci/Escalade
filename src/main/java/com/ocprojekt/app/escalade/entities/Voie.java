package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Voie implements Serializable {
    @Id
    @GeneratedValue
    private int idVoie;
    @NotNull
    @Size(min = 4, max = 50)
    private String nomVoie;
    @NotNull
    @Size(min = 4, max = 500)
    private String descriptionVoie;
    @NotNull
    @Size(min = 4, max = 50)
    private String niveauVoie;
    @ManyToOne
    @JoinColumn(name = "idSecteur")
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

    public int getIdVoie() {
        return idVoie;
    }

    public void setIdVoie(int idVoie) {
        this.idVoie = idVoie;
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
