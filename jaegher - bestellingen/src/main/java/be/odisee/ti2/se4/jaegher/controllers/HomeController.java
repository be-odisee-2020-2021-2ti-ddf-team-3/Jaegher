package be.odisee.ti2.se4.jaegher.controllers;

import be.odisee.ti2.se4.jaegher.service.JaegherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    JaegherServiceImpl jaegherServiceImpl;

    //Wanneer je de link http://localhost:8080/home ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/home.html
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("fullname", jaegherServiceImpl.getAuthenticatedFullname());
        model.addAttribute("role", jaegherServiceImpl.getAuthenticatedRole());
        return "home";
    }

    @GetMapping("/login-error")
    public String loginerror(Model model) {
        model.addAttribute("error", true);
        return "login";
    }
}
