package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Utilisateur;
import com.ocprojekt.app.escalade.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AccueilController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @RequestMapping(value="/Accueil")
    public String Accueil(Model model5){
        List<Utilisateur> lutil2 = utilisateurRepository.findAll();
        model5.addAttribute("utilisateur" , lutil2 );
        return "Accueil";
    }

}
