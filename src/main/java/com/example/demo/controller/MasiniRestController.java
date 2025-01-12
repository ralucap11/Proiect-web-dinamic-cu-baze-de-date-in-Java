package com.example.demo.controller;

import com.example.demo.entity.Masini;
import com.example.demo.entity.Utilizatori;
import com.example.demo.repository.MasiniRepository;
import com.example.demo.repository.UtilizatoriRepository;
import com.example.demo.service.UtilizatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MasiniRestController {
    @Autowired
    private MasiniRepository repository;

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    @PostMapping("/editor")
    public String handleEditorActions(@RequestParam String action,
                                      @RequestParam(required = false) String nrInmatriculare,
                                      @RequestParam(required = false) String marca,
                                      @RequestParam(required = false) String modelul,
                                      @RequestParam(required = false) String culoarea,
                                      @RequestParam(required = false, defaultValue = "0") int an,
                                      @RequestParam(required = false, defaultValue = "0") int capacitate_cilindrica,
                                      @RequestParam(required = false) String combustibil,
                                      @RequestParam(required = false, defaultValue = "0") int putere,
                                      @RequestParam(required = false, defaultValue = "0") int cuplu,
                                      @RequestParam(required = false, defaultValue = "0") int volum,
                                      @RequestParam(required = false, defaultValue = "0") int pret,
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //
        String username = authentication.getName(); //extrage username ul care este logat
        System.out.println("username "+username);
        Utilizatori loggedIn = utilizatoriRepository.findByUtilizator(username);
        switch (action) {
            case "add":
                Masini masinaNoua = new Masini();
                int id = loggedIn.getId_utilizator();
                System.out.println("id "+id);
                masinaNoua.setNrInmatriculare(nrInmatriculare);
                masinaNoua.setId_utilizator(id);
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
                return "redirect:/utilizatori";


            case "edit":
                Masini existingMasina = repository.findById(nrInmatriculare)
                        .orElseThrow(() -> new IllegalArgumentException("Masina nu exista: " + nrInmatriculare));
                existingMasina.setMarca(marca);
                repository.save(existingMasina);
                return "redirect:/utilizatori";
            case "delete":
                repository.deleteById(nrInmatriculare);
                return "redirect:/utilizatori";
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
    public String deleteMasini(@RequestParam String nrInmatriculare) {
        if (repository.existsById(nrInmatriculare)) {
            repository.deleteById(nrInmatriculare);
        } else {
            throw new IllegalArgumentException("Mașina cu numarul de inmatriculare " + nrInmatriculare + " nu exista!");
        }
        return "redirect:/utilizatori";
    }


//    public int getUtilizatoriById_utilizator() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            User loggedUser = (User) authentication.getPrincipal();
//            int id_utilizator = Integer.parseInt(loggedUser.getUsername()); // Se presupune că username-ul este ID-ul utilizatorului
//            return id_utilizator;
//        }
//        return -1;
//    }
}