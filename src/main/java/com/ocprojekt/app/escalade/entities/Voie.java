package com.ocprojekt.app.escalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Voie implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nomVoie;
    private String descriptionVoie;
    private String niveauVoie;
    private int idSecteur;

    public Voie(){
        super();
    }

    public Voie(String nomVoie, String descriptionVoie, String niveauVoie){
        super();
        this.nomVoie=nomVoie;
        this.descriptionVoie=descriptionVoie;
        this.niveauVoie=niveauVoie;
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

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

}
