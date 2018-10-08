package com.ocprojekt.app.escalade;

import com.ocprojekt.app.escalade.repository.SiteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EscaladeApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EscaladeApplication.class, args);
		SiteRepository siterepository = ctx.getBean(SiteRepository.class);
	}
}
