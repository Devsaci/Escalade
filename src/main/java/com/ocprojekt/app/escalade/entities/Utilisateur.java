package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String pseudo;
    private String password;
    private String statut;
    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private Collection<Topo> topos;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String pseudo, String password, String statut) {
        super();
        this.pseudo = pseudo;
        this.password = password;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Collection<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }
}
