package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Integer> {

    public List<Site> findByNomSite(String lns);

    public Page<Site>  findByNomSite(String pns, Pageable pageable);

    @Query ("Select e From Site where e.nomSite like :x" )
    public Page<Site>  chercheSites(@Param("x")String pns, Pageable pageable);
}
