package com.ocprojekt.app.escalade.controler;

import com.ocprojekt.app.escalade.entities.Topo;
import com.ocprojekt.app.escalade.repository.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TopoController {

    @Autowired
    private TopoRepository topoRepository;

    @RequestMapping(value="/Topo")
    public String Topo(Model model1){
        List<Topo> ltopo = topoRepository.findAll();
        model1.addAttribute("topo" , ltopo );
        return "Topo";
    }


}

