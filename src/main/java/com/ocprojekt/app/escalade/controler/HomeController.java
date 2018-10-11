package com.ocprojekt.app.escalade.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/Home")
    public String Home(Model model) {
        return "Home";
    }
}
