package be.odisee.ti2.se4.jaegher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Wanneer je de link http://localhost:8080/home ingeeft wordt je geredirect naar de view in locatie src/main/resources/templates/home.html
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
