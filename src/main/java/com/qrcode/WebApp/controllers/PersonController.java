package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Person;
import com.qrcode.WebApp.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/persons")
    public String personAdd(@RequestParam String personName, @RequestParam String personSurname, @RequestParam String personPersonalCode, @RequestParam String personEmail, @RequestParam String personPhone, Model model) {
        Person person = new Person(personName, personSurname, personPersonalCode, personEmail, personPhone);
        personRepository.save(person);
        return "redirect:/persons";
    }
}
