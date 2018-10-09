package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Voie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoieRepository extends JpaRepository<Voie,Integer> {

    public List<Voie> findByNomVoie(String nom);

    public Page<Voie>  findByNomVoie(String nom, Pageable pageable);

    @Query ("SELECT e FROM Voie e WHERE e.nomVoie LIKE :x" )
    public Page<Voie> chercheVoie(@Param("x")String nom, Pageable pageable);

    @Query ("SELECT e.descriptionVoie FROM Voie e" )
    public List<Voie> findAllDescriptionVoie();
}
