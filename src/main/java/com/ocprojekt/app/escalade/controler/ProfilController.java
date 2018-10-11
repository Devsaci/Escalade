package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Utilisateur;
import com.ocprojekt.app.escalade.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProfilController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @RequestMapping(value="/Profil")
    public String Profil(Model model2){
        List<Utilisateur> lutil = utilisateurRepository.findAll();
        model2.addAttribute("utilisateur" , lutil );
        return "Profil";
    }

}
