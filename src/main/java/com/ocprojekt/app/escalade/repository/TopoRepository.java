package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopoRepository extends JpaRepository <Topo,Integer> {

    List<Topo> findToposByUser_Username(String username);
}
