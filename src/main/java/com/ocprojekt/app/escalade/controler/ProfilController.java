package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.entities.User;
import com.ocprojekt.app.escalade.repository.TopoRepository;
import com.ocprojekt.app.escalade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value="/Profil")
    public String Profil(Model model, @RequestParam(name="rmUser", defaultValue ="")String username){
        model.addAttribute("rmUser", username);
        User user = userRepository.findUserByUsername(username);
        model.addAttribute("user" , user );
        List<Topo> listopo = topoRepository.findToposByUser_Username(username);
        model.addAttribute("listopo" , listopo );
        model.addAttribute("topo", new Topo());
        return "Profil";
    }

    @RequestMapping(value="/saveTopo", method = RequestMethod.POST)
    public String saveTopo(@RequestParam(name="nomUser", defaultValue ="")String username,
                           @Valid Topo topo,
                           BindingResult bindingResult,
                           Model model){
        model.addAttribute("nomUser", username);
        User user = userRepository.findUserByUsername(username);
        model.addAttribute("user" , user );
        topo.setLoan(false);
        topo.setUser(user);
        if(bindingResult.hasErrors())
            return "Profil";
        topoRepository.save(topo);
        model.addAttribute("topo", topo);
        return "ConfirmTopo";
    }
}
