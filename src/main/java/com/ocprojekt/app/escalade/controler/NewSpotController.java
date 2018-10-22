package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
import com.ocprojekt.app.escalade.repository.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        model.addAttribute("site", new Site());
        return "NewSpot";
    }

    @RequestMapping(value="/saveSite",method = RequestMethod.POST)
    public String saveSite(Model model, @Valid Site site, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "Newspot";
        siteRepository.save(site);
        model.addAttribute("site", site);
        return "ConfirmSite";
    }
}
