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

import java.util.List;

@Controller
public class GrimpeController {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Autowired
    private VoieRepository voieRepository;


    @RequestMapping(value="/Grimpe")
    public String Grimpe(Model model){
        List<Site> listSites = siteRepository.findAll();
        model.addAttribute("site" , listSites );
        return "Grimpe";
    }

    @RequestMapping(value="/Secteurs")
    public String Secteurs(Model model){
        List<Site> listSites = siteRepository.findAll();
        model.addAttribute("site" , listSites );
        return "Secteurs";
    }

}
