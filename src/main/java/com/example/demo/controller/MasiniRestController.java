package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MasiniRestController {
@Autowired
    private MasiniRepository repository;

 //adaugare masina
    @PostMapping("/editor/add")
    public String showForm(Model model){
    model.addAttribute("masina",new Masini());
    return "operatii";
    }

    //modificare masina
    @PostMapping("/editor/edit")
    public String editForm(@PathVariable String nr_inmatriculare, Model model){
     Masini masini = repository.findById(nr_inmatriculare)
        .orElseThrow(()-> new IllegalArgumentException("Masina nu exista: " + nr_inmatriculare));
        model.addAttribute("masina",masini);
        return "operatii";
    }


    //stergere masina
    @PostMapping("/editor/delete")
    public String deleteMasini(@RequestParam String nr_inmatriculare){
       repository.deleteById(nr_inmatriculare);
       return "redirect:/utilizatori";
    }

}
