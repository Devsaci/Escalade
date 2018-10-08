package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
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

		List<Site> site = siterepository.findAll();
		site.forEach(e->System.out.println(e.getNomSite()));

		List<Site> dsite = siterepository.findAllDescriptionSite();
        for (Iterator iter = dsite.iterator(); iter.hasNext();)
        { String  dsi;
			dsi = (String)iter.next();
			System.out.println(dsi);}

        List<Secteur> secteur =secteurepository.findAll();
        secteur.forEach(e->System.out.println(e.getNomSecteur()));

        List<Secteur> dsecteur = secteurepository.findAllDescriptionSecteur();
        for (Iterator iter = dsecteur.iterator(); iter.hasNext();)
        { String  dse;
            dse = (String)iter.next();
            System.out.println(dse);}

    }
}
