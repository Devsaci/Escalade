package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Secteur implements Serializable {

    @Id
    @GeneratedValue
    private int idSecteur;
    @NotNull
    @Size(min = 4, max = 50)
    private String nomSecteur;
    @NotNull
    @Size(min = 4, max = 250)
    private String descriptionSecteur;
    @ManyToOne
    @JoinColumn(name = "idSite")
    private Site site;
    @OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
    private Collection<Voie> voies;

    public Secteur() {
        super();
    }

    public Secteur(String nomSecteur, String descriptionSecteur, Site site) {
        super();
        this.nomSecteur = nomSecteur;
        this.descriptionSecteur = descriptionSecteur;
        this.site = site;
    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Collection<Voie> getVoies() {
        return voies;
    }

    public void setVoies(Collection<Voie> voies) {
        this.voies = voies;
    }
}
