package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Commentaire;
import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Voie;
import com.ocprojekt.app.escalade.repository.CommentaireRepository;
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
public class GrimpeController {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Autowired
    private VoieRepository voieRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;


    @RequestMapping(value="/ListeSites")
    public String Grimpe(Model model,
                         @RequestParam(name="motclef", defaultValue ="")String mc){
        List<Site> lSites = siteRepository.chercherSite("%"+mc+"%");
        model.addAttribute("listSite" , lSites );
        model.addAttribute("motclef", mc );
        return "ListeSites";
    }

    @RequestMapping(value="/Site")
    public String AfficherSite(Model model,
                               @RequestParam(name="SiteID", defaultValue ="")Integer sid){
        model.addAttribute("SiteID", sid);
        Site site = siteRepository.getOne(sid);
        model.addAttribute("site" , site );
        List<Secteur> secteurs = secteurRepository.findSecteursBySiteIdSite(sid);
        model.addAttribute("secteur" , secteurs );
        List<Voie> voies = voieRepository.findVoiesBySecteur_Site_IdSite(sid);
        model.addAttribute("voie", voies);
        List<Commentaire> commentaires = commentaireRepository.findCommentairesBySite_IdSite(sid);
        model.addAttribute("commentaires", commentaires);

        model.addAttribute("commentaire", new Commentaire());

        return "Site";
    }

    @RequestMapping(value="/saveCom", method = RequestMethod.POST)
    public String saveCom(Model model, @RequestParam(name="SiteID", defaultValue ="")Integer sid,
                          @Valid Commentaire commentaire, BindingResult bindingResult){
        model.addAttribute("SiteID", sid);
        Site site = siteRepository.getOne(sid);
        commentaire.setSite(site);
        if(bindingResult.hasErrors())
            return "Site";
        commentaireRepository.save(commentaire);
        model.addAttribute("commentaire", commentaire);
        return "ConfirmMess";
    }

}
