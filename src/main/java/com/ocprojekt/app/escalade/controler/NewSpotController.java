package com.ocprojekt.app.escalade.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewSpotController {

    @RequestMapping(value="/NewSpot")
    public String NewSpot(){
        return "NewSpot";
    }

}
