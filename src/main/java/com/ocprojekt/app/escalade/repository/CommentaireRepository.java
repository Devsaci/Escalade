package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {

    List<Commentaire> findCommentairesBySite_IdSite(Integer id);
}
