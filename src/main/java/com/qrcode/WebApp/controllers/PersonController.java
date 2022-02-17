package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Person;
import com.qrcode.WebApp.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping(value = "/persons/add", params = "personAdd")
    public String personAdd(@RequestParam String personName, @RequestParam String personSurname, @RequestParam String personPersonalCode, @RequestParam String personEmail, @RequestParam String personPhone) {
        Person person = new Person(personName, personSurname, personPersonalCode, personEmail, personPhone);
        personRepository.save(person);
        return "redirect:/persons";
    }

    @PostMapping(value = "/persons/{id_person}/edit", params = "personEdit")
    public String personEdit(@PathVariable(value = "id_person") long id_person, @RequestParam String personName, @RequestParam String personSurname, @RequestParam String personPersonalCode, @RequestParam String personEmail, @RequestParam String personPhone) {
        Person person = personRepository.findById(id_person).orElse(null);
        person.setName(personName);
        person.setSurname(personSurname);
        person.setPersonal_code(personPersonalCode);
        person.setEmail(personEmail);
        person.setPhone(personPhone);
        personRepository.save(person);
        return "redirect:/persons";
    }

    @PostMapping(value = "/persons/{id_person}/delete", params = "personDelete")
    public String personDelete(@PathVariable(value = "id_person") long id_person) {
        Person person = personRepository.findById(id_person).orElse(null);
        personRepository.delete(person);
        return "redirect:/persons";
    }
}
