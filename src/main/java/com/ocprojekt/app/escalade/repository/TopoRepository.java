package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Topo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopoRepository extends JpaRepository <Topo,Integer> {

    public List<Topo> findByNomTopo (String nom);

    public Page<Topo> findByNomTopo(String nom, Pageable pageable);

    @Query("SELECT e FROM Topo e WHERE e.nomTopo LIKE :x")
    public Page<Topo> chercheTopos(@Param("x")String nom, Pageable pageable);

    @Query ("SELECT e.descriptionTopo FROM Topo e" )
    public List<Topo> findAllDescriptionTopo();
}
