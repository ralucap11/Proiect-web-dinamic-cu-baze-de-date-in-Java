package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasiniRestController {
@Autowired
    private MasiniRepository repository;

 //adaugare masina
    @PostMapping("/add")
    public String showForm(Model model){
    model.addAttribute("masina",new Masini());
    return "operatii";
    }

    //modificare masina
    @PostMapping("/edit/{nr_inmatriculare}")
    public String editForm(@PathVariable String nr_inmatriculare, Model model){
     Masini masini = repository.findById(nr_inmatriculare)
        .orElseThrow(()-> new IllegalArgumentException("Masina nu exista: " + nr_inmatriculare));
        model.addAttribute("masina",masini);
        return "operatii";
    }


    //stergere masina
    @PostMapping("/delete/{nr_inmatriculare}")
    public String deleteMasini(@PathVariable String nr_inmatriculare){
       repository.deleteById(nr_inmatriculare);
       return "redirect:/utilizatori";
    }



//      @PostMapping("/operatii")
//    public String operatii(Model model,String ISBN,String titlul, String autorul) {
//    System.out.println("ISBN: " + ISBN);
//    System.out.println("Ttilul: " + titlul);
//    System.out.println("Autorul: " + autorul);
//    String s = "Lista cartilor preluate prin repository";
//    model.addAttribute("str", s);
//    model.addAttribute("lista", repository.findAll());
//    return "carti";
//
//    }
}
