package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Site implements Serializable {
@Id
@GeneratedValue
    private int id;
    private String nomSite;
    private String descriptionSite;
    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private Collection<Secteur>secteurs;

    public Site() {
        super();
    }

    public Site(String nomSite, String descriptionSite) {
        super();
        this.nomSite = nomSite;
        this.descriptionSite = descriptionSite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public String getDescriptionSite() {
        return descriptionSite;
    }

    public void setDescriptionSite(String descriptionSite) {
        this.descriptionSite = descriptionSite;
    }

    public Collection<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(Collection<Secteur> secteurs) {
        this.secteurs = secteurs;
    }
}
