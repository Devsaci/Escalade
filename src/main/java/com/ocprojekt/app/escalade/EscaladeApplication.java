package com.ocprojekt.app.escalade;

//import com.ocprojekt.app.escalade.entities.Secteur;
//import com.ocprojekt.app.escalade.entities.Site;
//import com.ocprojekt.app.escalade.entities.Voie;
//import com.ocprojekt.app.escalade.repository.SecteurRepository;
//import com.ocprojekt.app.escalade.repository.SiteRepository;
//import com.ocprojekt.app.escalade.repository.VoieRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscaladeApplication implements CommandLineRunner {

//	@Autowired
//	private SiteRepository siteRepository;
//	@Autowired
//	private SecteurRepository secteurRepository;
//	@Autowired
//	private VoieRepository voieRepository;

	public static void main(String[] args) {
	SpringApplication.run(EscaladeApplication.class, args);

    }

	@Override
	public void run(String... args) throws Exception {

// Peuplement des tables Spring Data
//		Site s1 = siteRepository.save(new Site("Le Mont Boom",
//				"Attention aux explosifs tous les six mètres."));
//		Site s2 = siteRepository.save(new Site("Les Alpes Froides",
//				"On ne compte plus les grimpeurs qui y ont laissé leurs pieds."));
//		Site s3 = siteRepository.save(new Site("Dragon Pic",
//				"Un dragon veille sur ce tas de rochers comme si c'était sa maison."));
//
//		Secteur sct11= secteurRepository.save(new Secteur("Le versant Clic",
//                "Rien ne sert de vous boucher les oreilles si le clic vient de sous vos pieds",s1));
//        Secteur sct12= secteurRepository.save(new Secteur("Le versant Pointu",
//                "Les petits bonhommes verts ont des hallebardes et elles piquent.",s1));
//
//        Secteur sct21= secteurRepository.save(new Secteur("Le versant Glaçon",
//                "Ou l'on se rends compte que le plus important dans un verre n'est pas le glaçon.",
//                s2));
//        Secteur sct22= secteurRepository.save(new Secteur("Le versant Bleu",
//                "Plus on grimpe, plus la température baisse.",s2));
//
//        Secteur sct31= secteurRepository.save(new Secteur("Le versant Os",
//                "Tous ces squellettes n'étaient pas au courant des horaires de siestes du maitre des" +
//                        "lieux.",s3));
//        Secteur sct32= secteurRepository.save(new Secteur("Le versant Feu",
//                "Ne demandez jamais à un dragon de vous prêter du feu.",s3));
//
//        Voie voie11 = voieRepository.save(new Voie("Boom","Quelle mine!","Mortel",
//                sct11));
//        Voie voie12 = voieRepository.save(new Voie("Oups","Une Grenade!","Epique",
//                sct11));
//        Voie voie21 = voieRepository.save(new Voie("Feroces","Ces petits hommes verts!",
//                "Epique",sct12));
//        Voie voie22 = voieRepository.save(new Voie("Cruels","C'est des gobelins!",
//                "Mortel",sct12));
//        Voie voie31 = voieRepository.save(new Voie("Bourbon","Avec glaçons.",
//                "Epique",sct21));
//        Voie voie32 = voieRepository.save(new Voie("Whysky","Avec glaçons.",
//                "Impossible",sct21));
//        Voie voie41 = voieRepository.save(new Voie("-112","Mets ton écharpe!",
//                "Mortel",sct22));
//        Voie voie42 = voieRepository.save(new Voie("-212","Sans crème solaire.",
//                "Mortel",sct22));
//        Voie voie51 = voieRepository.save(new Voie("14H","C'est bon il dort.",
//                "Impossible",sct31));
//        Voie voie52 = voieRepository.save(new Voie("17H","Il risque de vous manger",
//                "Epique",sct31));
//        Voie voie61 = voieRepository.save(new Voie("Une aile","Mais pas de poulet.",
//                "Mortel",sct32));
//        Voie voie62 = voieRepository.save(new Voie("Brulant","Quand il souffle.",
//                "Mortel",sct32));

	}
}
