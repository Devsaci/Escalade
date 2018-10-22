package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Voie;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
import com.ocprojekt.app.escalade.repository.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GrimpeController {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Autowired
    private VoieRepository voieRepository;


    @RequestMapping(value="/Sites")
    public String Grimpe(Model model){
        List<Site> listSites = siteRepository.findAll();
        model.addAttribute("site" , listSites );
        return "Sites";
    }

    @RequestMapping(value="/Secteurs")
    public String Secteurs(Model model){
        List<Secteur> listSecteurs = secteurRepository.findAll();
        model.addAttribute("secteur" , listSecteurs );
        return "Secteurs";
    }

    @RequestMapping(value="/Voies")
    public String Voies (Model model){
        List<Voie> listVoies = voieRepository.findAll();
        model.addAttribute("voie" , listVoies );
        return "Voies";
    }

}
