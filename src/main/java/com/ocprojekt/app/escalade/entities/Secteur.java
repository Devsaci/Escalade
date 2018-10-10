package com.ocprojekt.app.escalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Secteur implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nomSecteur;
    private String descriptionSecteur;
    private int idSite;

    public Secteur (){
        super();
    }

    public Secteur(String nomSecteur, String descriptionSecteur){
        super();
        this.nomSecteur=nomSecteur;
        this.descriptionSecteur=descriptionSecteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public String getDescriptionSecteur() {
        return descriptionSecteur;
    }

    public void setDescriptionSecteur(String descriptionSecteur) {
        this.descriptionSecteur = descriptionSecteur;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

}
