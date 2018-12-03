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
public class ProfilController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TopoRepository topoRepository;
    @Autowired
    private PretRepository pretRepository;

    @RequestMapping(value="/Profil")
    public String Profil(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(username);
        model.addAttribute("user" , user );
        List<Topo> listopo = topoRepository.findToposByUser_Username(username);
        model.addAttribute("listopo" , listopo );
        model.addAttribute("topo", new Topo());
        List<Pret> lpe = pretRepository.findAllByEmprunteur(username);
        model.addAttribute("listPretEmprunteur", lpe);
        List<Pret> lpp = pretRepository.findAllByProprietaire(username);
        model.addAttribute("listPretProprio", lpp);
        List<Pret> listnopret=pretRepository.findPretsByProprietaireAndStatutIsNotAndStatutIsNot(username,
                "refuse","termine");
        model.addAttribute("listNoPret", listnopret);
        List<Pret> listnoemprunt=pretRepository.findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(username,
                "refuse","termine");
        model.addAttribute("listNoEmprunt", listnoemprunt);
        return "Profil";
    }

    @RequestMapping(value="/saveTopo", method = RequestMethod.POST)
    public String saveTopo(@Valid Topo topo,
                           BindingResult bindingResult,
                           Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Topo> listopo = topoRepository.findToposByUser_Username(username);
        model.addAttribute("listopo" , listopo );
        User user = userRepository.findUserByUsername(username);
        model.addAttribute("user" , user );
        List<Pret> lpe = pretRepository.findAllByEmprunteur(username);
        model.addAttribute("listPretEmprunteur", lpe);
        List<Pret> lpp = pretRepository.findAllByProprietaire(username);
        model.addAttribute("listPretProprio", lpp);
        List<Pret> listnopret=pretRepository.findPretsByProprietaireAndStatutIsNotAndStatutIsNot(username,
                "refuse","termine");
        model.addAttribute("listNoPret", listnopret);
        List<Pret> listnoemprunt=pretRepository.findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(username,
                "refuse","termine");
        model.addAttribute("listNoEmprunt", listnoemprunt);

        topo.setNomProprietaire(username);
        topo.setLoan(false);
        topo.setUser(user);
        if(bindingResult.hasErrors())
            return "Profil";
        topoRepository.save(topo);
        model.addAttribute("topo", topo);
        return "ConfirmTopo";
    }

    @RequestMapping(value="/choice", method = RequestMethod.POST, params="accept")
    public String acceptPret(@RequestParam(name="idPret", defaultValue ="")int idPret,
                             Model model) {
     Pret pret = pretRepository.getOne(idPret);
     pret.setStatut("accepte");
     pretRepository.save(pret);
        return "redirect:/Profil";
    }

    @RequestMapping(value="/choice", method = RequestMethod.POST, params="refus")
    public String refusPret(@RequestParam(name="idPret", defaultValue ="")int idPret,
                             Model model) {
        Pret pret = pretRepository.getOne(idPret);
        pret.setStatut("refuse");
        pretRepository.save(pret);
        return "redirect:/Profil";
    }

    @RequestMapping(value="/envoiTopo", method = RequestMethod.POST)
    public String envoiTopo(@RequestParam(name="idPret", defaultValue ="")int idPret,
                            @RequestParam(name="nomDuTopoPret", defaultValue ="")String ndTopoPret,
                             Model model) {
        Pret pret = pretRepository.getOne(idPret);
        pret.setStatut("en cours");
        pretRepository.save(pret);
        Topo topo = topoRepository.findTopoByNomTopo(ndTopoPret);
        topo.setLoan(true);
        topoRepository.save(topo);
        return "redirect:/Profil";
    }

    @RequestMapping(value="/renvoiTopo", method = RequestMethod.POST)
    public String renvoiTopo(@RequestParam(name="idPret", defaultValue ="")int idPret,
                             @RequestParam(name="nomDuTopoPret", defaultValue ="")String ndTopoPret,
                             Model model) {
        Pret pret = pretRepository.getOne(idPret);
        pret.setStatut("termine");
        pretRepository.save(pret);
        Topo topo = topoRepository.findTopoByNomTopo(ndTopoPret);
        topo.setLoan(false);
        topoRepository.save(topo);
        return "redirect:/Profil";
    }
}
