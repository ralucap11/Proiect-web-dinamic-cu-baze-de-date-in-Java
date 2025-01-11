package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.repository.MasiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MasiniRestController {
    @Autowired
    private MasiniRepository repository;

    @PostMapping("/editor")
    public String handleEditorActions(@RequestParam String action,
                                      @RequestParam(required = false) String nrInmatriculare,
                                      @RequestParam(required = false) String marca,
                                      @RequestParam(required = false) String modelul,
                                      @RequestParam(required = false) String culoarea,
                                      @RequestParam(required = false) int an,
                                      @RequestParam(required = false) int capacitate_cilindrica,
                                      @RequestParam(required = false) String combustibil,
                                      @RequestParam(required = false) int putere,
                                      @RequestParam(required = false) int cuplu,
                                      @RequestParam(required = false) int volum,
                                      @RequestParam(required = false) int pret,
                                      Model model) {
        System.out.println("action: " + action);
        System.out.println("nrInmatriculare: " + nrInmatriculare);
        System.out.println("marca: " + marca);
        System.out.println("modelul: " + modelul);
        System.out.println("culoarea: " + culoarea);
        System.out.println("an: " + an);
        System.out.println("capacitate_cilindrica" + capacitate_cilindrica);
        System.out.println("combustibil" + combustibil);
        System.out.println("putere" + putere);
        System.out.println("cuplu" + cuplu);
        System.out.println("volum" + volum);
        System.out.println("pret" + pret);

        switch (action) {
            case "add":
                Masini masinaNoua = new Masini();
                masinaNoua.setNrInmatriculare(nrInmatriculare);
                masinaNoua.setId_utilizator(1);
                masinaNoua.setMarca(marca);
                masinaNoua.setModelul(modelul);
                masinaNoua.setCuloarea(culoarea);
                masinaNoua.setAn(an);
                masinaNoua.setCapacitate_cilindrica(capacitate_cilindrica);
                masinaNoua.setCombustibil(combustibil);
                masinaNoua.setPutere(putere);
                masinaNoua.setCuplu(cuplu);
                masinaNoua.setVolum(volum);
                masinaNoua.setPret(pret);
                repository.save(masinaNoua);
                return "redirect:/utilizatori"; // Add operation view
            case "edit":
                Masini existingMasina = repository.findById(nrInmatriculare)
                        .orElseThrow(() -> new IllegalArgumentException("Masina nu exista: " + nrInmatriculare));
                existingMasina.setMarca(marca); // Update marca
                repository.save(existingMasina); // Save changes
                return "redirect:/utilizatori"; // Edit operation view
            case "delete":
                repository.deleteById(nrInmatriculare);
                return "redirect:/utilizatori"; // Redirect after delete
            default:
                throw new IllegalArgumentException("Actiune necunoscuta: " + action);
        }
    }

    //adaugare masina
    @PostMapping("/editor/add")
    public String showForm(Model model) {
        model.addAttribute("masina", new Masini());
        return "utilizatori";
    }

    //modificare masina
    @PostMapping("/editor/edit")
    public String editForm(@PathVariable String nr_inmatriculare, Model model) {
        Masini masini = repository.findById(nr_inmatriculare)
                .orElseThrow(() -> new IllegalArgumentException("Masina nu exista: " + nr_inmatriculare));
        model.addAttribute("masina", masini);
        return "utilizatori";
    }

    //stergere masina
    @PostMapping("/editor/delete")
    public String deleteMasini(@RequestParam String nr_inmatriculare) {
        repository.deleteById(nr_inmatriculare);
        return "utilizatori";
    }

}