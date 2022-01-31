package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Person;
import com.qrcode.WebApp.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String persons(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "persons";
    }
}
