package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class MasiniController {

 @Autowired
    private MasiniRepository repository;

//vizualizare lista
  @GetMapping
    public String listMasini(Model model) {
        List<Masini> masini = repository.findAll();
        model.addAttribute("masini", masini);
        return "utilizatori";
    }


}
