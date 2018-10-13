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
        List<Secteur> listSecteurs = secteurRepository.findAll();
        model.addAttribute("secteur", listSecteurs);
        List<Voie> listVoies = voieRepository.findAll();
        model.addAttribute("voie", listVoies);

//        List<Secteur> secteurBySite = secteurRepository.findBySiteId(10);
//        secteurBySite.forEach(e->System.out.println(e.getNomSecteur()));
//        secteurBySite.forEach(e->System.out.println(e.getDescriptionSecteur()));
//
//        List<Voie> voieBySecteur =  voieRepository.findBySecteurId(13);
//        voieBySecteur.forEach(e->System.out.println(e.getNomVoie()));
//        voieBySecteur.forEach(e->System.out.println(e.getDescriptionVoie()));
//
//        List<Voie> voieBySecteur2 =  voieRepository.findBySecteurId(14);
//        voieBySecteur2.forEach(e->System.out.println(e.getNomVoie()));
//        voieBySecteur2.forEach(e->System.out.println(e.getDescriptionVoie()));
        return "Grimpe";
    }


}
