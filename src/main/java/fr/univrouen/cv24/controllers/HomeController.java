package fr.univrouen.cv24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("projectName", "Service REST CV24");
        model.addAttribute("version", "1.0");
        model.addAttribute("teamMembers", List.of("Karim KASSA", "Samy BOUAMAR"));
        return "home";
    }
}
