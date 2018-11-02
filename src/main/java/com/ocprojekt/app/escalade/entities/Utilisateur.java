package com.ocprojekt.app.escalade.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue
    private int idUtilisateur;
    @NotNull
    @Size(min = 4, max = 50)
    private String pseudo;
    @NotNull
    @Size(min = 4, max = 50)
    private String password;
    @OneToMany(mappedBy = "utilisateur",fetch = FetchType.LAZY)
    private Collection<Topo> topos;

    public Utilisateur() {
        super();
    }

    public Utilisateur(String pseudo, String password) {
        super();
        this.pseudo = pseudo;
        this.password = password;
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

    public Collection<Topo> getTopos() {
        return topos;
    }

    public void setTopos(Collection<Topo> topos) {
        this.topos = topos;
    }
}
