package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    @RequestMapping(path = "/search", method = RequestMethod.GET)
public String search(
        Model model,
        @RequestParam(value = "marca", required = false) String marca,
        @RequestParam(value = "culoarea", required = false) String culoarea,
        @RequestParam(value = "combustibil", required = false) String combustibil) {

    List<Masini> masini = repository.findByMarcaContainingIgnoreCaseAndCuloareaContainingIgnoreCaseAndCombustibilContainingIgnoreCase(
            marca != null ? marca : "",
            culoarea != null ? culoarea : "",
            combustibil != null ? combustibil : ""
    );

    model.addAttribute("masini", masini);
    return "utilizatori";
}



}
