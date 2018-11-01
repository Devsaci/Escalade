package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {

//    @Autowired
//    private UtilisateurRepository utilisateurRepository;

    @RequestMapping(value="/Accueil")
    public String Accueil(){
        return "Accueil";
    }

    @RequestMapping(value="/")
    public String Home(){
        return "Redirect:/Accueil";
    }

//    @RequestMapping(value="/login")
//    public String login(){
//        return "login";
//    }

}
