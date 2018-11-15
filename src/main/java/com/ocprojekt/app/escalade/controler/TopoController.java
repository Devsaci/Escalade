package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Pret;
import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.entities.User;
import com.ocprojekt.app.escalade.repository.PretRepository;
import com.ocprojekt.app.escalade.repository.TopoRepository;
import com.ocprojekt.app.escalade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TopoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopoRepository topoRepository;

    @Autowired
    private PretRepository pretRepository;

    @RequestMapping(value="/Topo")
    public String Topo( Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Topo> listopo = topoRepository.findAllByNomProprietaireIsNot(username);
        model.addAttribute("topo" , listopo );
        return "Topo";
    }

    @RequestMapping(value="/topoPret")
    public String affPretTopo(@RequestParam(name = "idTopo", defaultValue ="")Integer idt, Model model){
        model.addAttribute("idTopo", idt);
        Topo topo = topoRepository.findToposByIdTopoIs(idt);
        model.addAttribute("topo" , topo );
        model.addAttribute("pret", new Pret());
        return "topoPret";
    }

    @RequestMapping(value="/savePret",method = RequestMethod.POST)
    public String savePret(@RequestParam(name = "idTopo", defaultValue ="")Integer idt,
                           @Valid Pret pret,
                           BindingResult bindingResult,
                           Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Topo topo = topoRepository.findToposByIdTopoIs(idt);
        model.addAttribute("topo", topo);
        pret.setEmprunteur(username);
        pret.setProprietaire(topo.getNomProprietaire());
        pret.setNomDuTopo(topo.getNomTopo());
        pret.setStatut("en attente");
        pret.setTopo(topo);
        if(bindingResult.hasErrors())
            return "topoPret";
        pretRepository.save(pret);
        model.addAttribute("pret", pret);
        return "ConfirmPret";
    }


}

