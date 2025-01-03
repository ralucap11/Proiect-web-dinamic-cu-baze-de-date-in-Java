package com.example.demo.controller;

import com.example.demo.repository.MasiniRepository;
import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilizatoriController {

    @Autowired
    private UtilizatoriRepository repository;
    @Autowired
  private MasiniRepository masiniRepository;

  //pentru a afisa numele utilizatorului logat
    @GetMapping("/utilizatori")
public String welcomePage(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    loadUtilizatori(model);
    model.addAttribute("welcomeMessage", "Bine ai venit, " + username + "!");
    return "utilizatori";
}

    private String  loadUtilizatori(Model model) {

        model.addAttribute("str", "Utilizatori");
        model.addAttribute("masini", masiniRepository.findAll());
        return "utilizatori";
    }


}