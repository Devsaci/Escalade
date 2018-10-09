package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Voie;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
import com.ocprojekt.app.escalade.repository.VoieRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class EscaladeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EscaladeApplication.class, args);
		SiteRepository siterepository = ctx.getBean(SiteRepository.class);
        SecteurRepository secteurepository = ctx.getBean(SecteurRepository.class);
        VoieRepository voierepository = ctx.getBean(VoieRepository.class);

		List<Site> site = siterepository.findAll();
		site.forEach(e->System.out.println(e.getNomSite()));

		List<Site> dsite = siterepository.findAllDescriptionSite();
        for (Iterator iter = dsite.iterator(); iter.hasNext();)
        { String  dsi;
			dsi = (String)iter.next();
			System.out.println(dsi);}

        List<Secteur> secteur = secteurepository.findAll();
        secteur.forEach(e->System.out.println(e.getNomSecteur()));

        List<Secteur> dsecteur = secteurepository.findAllDescriptionSecteur();
        for (Iterator iter = dsecteur.iterator(); iter.hasNext();)
        { String  dse;
            dse = (String)iter.next();
            System.out.println(dse);}

        Page<Secteur> psecteur = secteurepository.findAll(PageRequest.of(0,5)) ;
        psecteur.forEach(e->System.out.println(e.getNomSecteur()));

        List<Voie> voie =voierepository.findAll();
        voie.forEach(e->System.out.println(e.getNomVoie()));

        List<Voie> dvoie = voierepository.findAllDescriptionVoie();
        for (Iterator iter = dvoie.iterator(); iter.hasNext();)
        { String  dvo;
            dvo = (String)iter.next();
            System.out.println(dvo);}

        List<Site> lisbn = siterepository.findByNomSite("Dragon Pic");
        lisbn.forEach(e->System.out.println(e.getNomSite()));

        Page<Secteur> sectos = secteurepository.chercheSecteur("%m%",PageRequest.of(0,5));
        sectos.forEach(e->System.out.println(e.getNomSecteur()));
    }
}
