package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLoginPage(ModelMap map) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLoginPage(ModelMap model, @RequestParam String nume, @RequestParam String parola) {
        boolean utilizatorValid = service.validateUser(nume, parola);
        if (!utilizatorValid) {
            model.put("errorMessage", "Invalid username or password.");
            return "login";
        }
        model.put("nume", nume);
        return "operatii";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
    model.clear();
        return "redirect:/login";
    }
}
