package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Voie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoieRepository extends JpaRepository<Voie,Integer> {

    @Query ("SELECT e FROM Voie e WHERE e.nomVoie LIKE :x" )
    List<Voie> chercheVoie(@Param("x")String nom);

    List<Voie> findVoiesBySecteur_Site_IdSite(Integer id);
}
