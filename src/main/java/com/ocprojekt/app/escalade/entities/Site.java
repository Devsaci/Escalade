package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Site implements Serializable {
@Id
@GeneratedValue
    private int idSite;
    @NotNull
    @Size(min = 4, max = 50)
    private String nomSite;
    @NotNull
    @Size(min = 4, max = 500)
    private String descriptionSite;
    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private Collection<Secteur> secteurs;

    public Site() {
        super();
    }

    public Site(String nomSite, String descriptionSite) {
        super();
        this.nomSite = nomSite;
        this.descriptionSite = descriptionSite;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
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
