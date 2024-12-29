package com.example.demo;

import com.example.demo.entity.Utilizatori;
import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilizatoriController {

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    @GetMapping("/utilizatori")
    public List<Utilizatori> getAllUtilizatori() {

        return utilizatoriRepository.findAll();
    }
}
