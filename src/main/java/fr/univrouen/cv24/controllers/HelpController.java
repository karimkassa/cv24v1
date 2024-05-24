package fr.univrouen.cv24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelpController {

    @GetMapping("/help")
    public String help(Model model) {
        return "help";
    }
}
