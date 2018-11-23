package com.ocprojekt.app.escalade.repository;

import com.ocprojekt.app.escalade.entities.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PretRepository extends JpaRepository<Pret,Integer> {

    List<Pret> findAllByEmprunteur(String username);

    List<Pret> findAllByProprietaire(String username);

    List<Pret> findPretsByProprietaireAndStatutIsNotAndStatutIsNot(String username, String statut1,
                                                                                 String statut2);

    List<Pret> findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(String username, String statut1,
                                                                   String statut2);

}
