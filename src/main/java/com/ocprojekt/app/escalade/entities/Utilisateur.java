package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    private int idUtilisateur;
    private String pseudo;
    private String password;
    private boolean isAdmin=false;
    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private Collection<Topo> topos;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String pseudo, String password, boolean isAdmin) {
        super();
        this.pseudo = pseudo;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisteur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Collection<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }
}
