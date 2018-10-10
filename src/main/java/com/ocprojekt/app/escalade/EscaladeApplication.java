package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.Secteur;
import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.entities.Voie;
import com.ocprojekt.app.escalade.repository.SecteurRepository;
import com.ocprojekt.app.escalade.repository.SiteRepository;
import com.ocprojekt.app.escalade.repository.TopoRepository;
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
        TopoRepository toporepository = ctx.getBean(TopoRepository.class);

        List<Site> site = siterepository.findAll();
        site.forEach(e->System.out.println(e.getNomSite()));

		List<Site> dsite = siterepository.findAllDescriptionSite();
        for (Iterator iter = dsite.iterator(); iter.hasNext();)
        { String  dsi;
			dsi = (String)iter.next();
			System.out.println(dsi);}

        List<Topo> topo = toporepository.findAll();
        topo.forEach(e->System.out.println(e.getNomTopo()));

        List<Topo> dtopo = toporepository.findAllDescriptionTopo();
        for (Iterator iter = dtopo.iterator(); iter.hasNext();)
        { String  dtp;
            dtp = (String)iter.next();
            System.out.println(dtp);}

    }
}
