package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Integer> {

    public List<Site> findByNomSite(String nom);

    public Page<Site> findByNomSite(String nom, Pageable pageable);

    @Query ("SELECT e FROM Site e WHERE e.nomSite LIKE :x")
    public Page<Site> chercheSites(@Param("x")String nom, Pageable pageable);

    @Query ("SELECT e.descriptionSite FROM Site e" )
    public List<Site> findAllDescriptionSite();
}
