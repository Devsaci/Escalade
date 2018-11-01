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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NewSpotController {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Autowired
    private VoieRepository voieRepository;

    @RequestMapping(value="/NewSpot",method = RequestMethod.GET)
    public String NewSpot(Model model){
        List<Site> lSites = siteRepository.findAll();
        model.addAttribute("listSite" , lSites );
        List<Secteur> lSecteurs = secteurRepository.findAll();
        model.addAttribute("listSecteur" , lSecteurs );

        model.addAttribute("site", new Site());
        model.addAttribute("secteur", new Secteur());
        model.addAttribute("voie", new Voie());
        return "NewSpot";
    }

    @RequestMapping(value="/saveSite",method = RequestMethod.POST)
    public String saveSite(Model model, @Valid Site site, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "NewSpot";
        siteRepository.save(site);
        model.addAttribute("site", site);
        return "ConfirmSite";
    }

    @RequestMapping(value="/saveSecteur",method = RequestMethod.POST)
    public String saveSecteur(Model model, @Valid Secteur secteur, BindingResult bindingResult,
    @RequestParam(name = "SiteSecteur", defaultValue ="")Integer sis){
        Site site = siteRepository.getOne(sis);
        secteur.setSite(site);
        if(bindingResult.hasErrors())
            return "NewSpot";
        secteurRepository.save(secteur);
        model.addAttribute("secteur", secteur);
        return "ConfirmSecteur";
    }

    @RequestMapping(value="/saveVoie",method = RequestMethod.POST)
    public String saveVoie(Model model, @Valid Voie voie, BindingResult bindingResult,
                           @RequestParam(name = "SecteurVoie", defaultValue ="")Integer siv){
        Secteur secteur = secteurRepository.getOne(siv);
        voie.setSecteur(secteur);
        if(bindingResult.hasErrors())
            return "NewSpot";
        voieRepository.save(voie);
        model.addAttribute("voie", voie);
        return "ConfirmVoie";
    }
}
