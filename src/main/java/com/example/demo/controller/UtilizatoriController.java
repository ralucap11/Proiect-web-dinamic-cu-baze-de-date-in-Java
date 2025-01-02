package com.example.demo.controller;

import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilizatoriController {

    @Autowired
    private UtilizatoriRepository repository;

    @GetMapping("/utilizatori")
    public String loadUtilizatori(Model model) {
        model.addAttribute("loggedName", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("str", "Utilizatori");
        model.addAttribute("utilizatori", repository.findAll());
        return "utilizatori";
    }
}