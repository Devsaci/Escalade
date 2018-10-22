package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Integer> {

    @Query ("SELECT s FROM Site s WHERE s.nomSite LIKE :x")
    List<Site> chercherSite(@Param("x")String mc);

    @Override
    Site getOne(Integer integer);

}
