package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Site;
import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.entities.Utilisateur;
import com.ocprojekt.app.escalade.repository.TopoRepository;
import com.ocprojekt.app.escalade.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfilController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private TopoRepository topoRepository;

    @RequestMapping(value="/Profil")
    public String Profil(Model model, Integer idUt){
        idUt=1;
        Utilisateur util = utilisateurRepository.getOne(idUt);
        model.addAttribute("utilisateur" , util );
        List<Topo> listopo = topoRepository.findToposByUtilisateurIdUtilisateur(idUt);
        model.addAttribute("listopo" , listopo );
        model.addAttribute("topo", new Topo());
        return "Profil";
    }

    @RequestMapping(value="/saveTopo",method = RequestMethod.POST)
    public String saveTopo(Model model, @Valid Topo topo, BindingResult bindingResult){
        Utilisateur utilisateur= utilisateurRepository.getOne(1);
        model.addAttribute("utilisateur" , utilisateur );
        topo.setLoan(true);
        topo.setUtilisateur(utilisateur);
        if(bindingResult.hasErrors())
            return "Profil";
        topoRepository.save(topo);
        model.addAttribute("topo", topo);
        return "ConfirmTopo";
    }
}
