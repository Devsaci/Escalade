package com.ocprojekt.app.escalade.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Site implements Serializable {
@Id
@GeneratedValue
    private int id;
    private String nomSite;
    private String descriptionSite;

    public Site (){
        super();
    }

    public Site(int id, String nomSite, String descriptionSite){
        super();
        this.id=id;
        this.nomSite=nomSite;
        this.descriptionSite=descriptionSite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionSite() {
        return descriptionSite;
    }

    public void setDescriptionSite(String descriptionSite) {
        this.descriptionSite = descriptionSite;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }
}
