package com.example.demo.service;

import com.example.demo.entity.Utilizatori;

import com.example.demo.repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateUser(String nume, String parola) {

        Utilizatori user = utilizatoriRepository.findUtilizatoriByNume(nume);


        if (user != null) {
            return passwordEncoder.matches(parola, user.getParola());
        }

        return false;
    }
}

