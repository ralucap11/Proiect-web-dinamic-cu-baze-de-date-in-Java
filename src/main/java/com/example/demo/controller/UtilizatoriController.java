package com.example.demo.controller;

import com.example.demo.entity.Utilizatori;
import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilizatoriController {

    @Autowired
    private UtilizatoriRepository repository;

    @GetMapping("/utilizatori")
    public List<Utilizatori> getAllUtilizatori() {

        return repository.findAll();
    }

       @PostMapping("/utilizatori")
    public String operatii(Model model, int id, String nume, String parola) {
    System.out.println("ID: " + id);
    System.out.println("Nume: " + nume);
    System.out.println("Parola: " + parola);
    model.addAttribute("lista", repository.findAll());
    return "utilizatori";

    }
}
