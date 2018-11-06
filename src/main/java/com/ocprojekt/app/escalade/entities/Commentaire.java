package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue
    private int comId;
    @NotNull
    @Size(min = 3, max = 50)
    private String titre;
    @NotNull
    @Size(min = 3, max = 250)
    private String message;
    @NotNull
    @Size(min = 3, max = 50)
    private String auteur;
    @ManyToOne
    @JoinColumn(name = "refSite")
    private Site site;

    public Commentaire() { super();}

    public Commentaire(@NotNull @Size(min = 3, max = 50) String titre,
                       @NotNull @Size(min = 3, max = 250) String message,
                       @NotNull @Size(min = 3, max = 50) String auteur,
                       Site site) {
        this.titre = titre;
        this.message = message;
        this.auteur = auteur;
        this.site = site;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
