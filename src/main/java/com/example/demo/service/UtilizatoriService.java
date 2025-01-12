package com.example.demo.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UtilizatoriService {
public int getUtilizatoriById_utilizator() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   if(authentication != null && authentication.isAuthenticated()) {
       User loggedUser = (User) authentication.getPrincipal();
       int id_utilizator = Integer.parseInt(loggedUser.getUsername());
       return id_utilizator;
   }
   return -1;
}
}
