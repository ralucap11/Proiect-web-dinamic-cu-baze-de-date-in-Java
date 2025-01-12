package com.example.demo.controller;

import com.example.demo.entity.Utilizatori;
import com.example.demo.repository.MasiniRepository;
import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Utilizatori utilizator = repository.findByUtilizator(username);
        String welcomeMessage = "Bine ai venit, " + utilizator.getNume() + "!";
      loadUtilizatori(model);
    model.addAttribute("welcomeMessage", welcomeMessage);
    return "utilizatori";
}

    private String  loadUtilizatori(Model model) {
        model.addAttribute("str", "Utilizatori");
        model.addAttribute("masini", masiniRepository.findAll());
        return "utilizatori";
    }

       @GetMapping("/logout")
       public String logout(RedirectAttributes redirectAttributes){
       redirectAttributes.addFlashAttribute("logoutMessage" + "You have been logged out.");
       return "redirect:/login";

       }



}