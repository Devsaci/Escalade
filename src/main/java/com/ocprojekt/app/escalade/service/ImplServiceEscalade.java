package com.ocprojekt.app.escalade.service;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Voie;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
import com.ocprojekt.app.escalade.repository.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImplServiceEscalade implements IServiceEscalade{

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private SecteurRepository secteurRepository;
    @Autowired
    private VoieRepository voieRepository;

    @Override
    public Site afficherSite(int id) {
        return null;
    }

    @Override
    public List<Secteur> afficherSecteur(Site site) {
        return null;
    }

    @Override
    public List<Voie> afficherVoies(Secteur secteur) {
        return null;
    }
}
