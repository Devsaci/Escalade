package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Secteur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecteurRepository extends JpaRepository<Secteur,Integer> {

    public List<Secteur> findByNomSecteur(String nom);

    public Page<Secteur>  findByNomSecteur(String nom, Pageable pageable);

    @Query ("SELECT e FROM Secteur e WHERE e.nomSecteur LIKE :x" )
    public Page<Secteur> chercheSecteur(@Param("x")String nom, Pageable pageable);

    @Query ("SELECT e.descriptionSecteur FROM Secteur e" )
    public List<Secteur> findAllDescriptionSecteur();
}
