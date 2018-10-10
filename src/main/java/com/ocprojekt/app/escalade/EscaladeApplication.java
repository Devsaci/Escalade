package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.*;
import com.ocprojekt.app.escalade.repository.*;

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
        UtilisateurRepository utilisateurepository = ctx.getBean(UtilisateurRepository.class);

        List<Site> site = siterepository.findAll();
        site.forEach(e->System.out.println(e.getNomSite()));

		List<Site> dsite = siterepository.findAllDescriptionSite();
        for (Iterator iter = dsite.iterator(); iter.hasNext();)
        { String  dsi;
			dsi = (String)iter.next();
			System.out.println(dsi);}

        List<Topo> topo = toporepository.findAll();
        topo.forEach(e->System.out.println(e.getNomTopo()));

        List<Utilisateur> util = utilisateurepository.findAll();
        util.forEach(e->System.out.println(e.getPseudo()));

        List<Utilisateur> statut = utilisateurepository.findByStatut("user");
        statut.forEach(e->System.out.println(e.getPseudo()));

    }
}
