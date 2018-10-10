package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {


    public List<Utilisateur> findByPseudo (String nom);

    public Page<Utilisateur> findByPseudo(String nom, Pageable pageable);

    @Query("SELECT e FROM Utilisateur e WHERE e.pseudo LIKE :x")
    public Page<Utilisateur> chercheUtilisateurs(@Param("x")String nom, Pageable pageable);

}
