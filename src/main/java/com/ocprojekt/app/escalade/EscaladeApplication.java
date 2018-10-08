package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.entities.Site;
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

		List<Site> site = siterepository.findAll();
		site.forEach(e->System.out.println(e.getNomSite()));

		List<Site> desc = siterepository.findAllDescriptionSite();
        for (Iterator iter = desc.iterator(); iter.hasNext();)
        { String  d2;
			d2 = (String)iter.next();
			System.out.println(d2);}

    }
}
