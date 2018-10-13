package com.ocprojekt.app.escalade.service;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Voie;

import java.util.List;

public interface IServiceEscalade {
    public Site afficherSite(int id);
    public List<Secteur> afficherSecteur(Site site);
    public List<Voie> afficherVoies(Secteur secteur);
}
