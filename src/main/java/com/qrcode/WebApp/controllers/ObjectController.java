package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.repo.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;

@Controller
public class ObjectController {

    @Autowired
    private ObjectRepository objectRepository;

    @GetMapping("/objects")
    public String objects(Model model) {
        Iterable<Object> objects = objectRepository.findAll();
        model.addAttribute("objects", objects);
        return "objects";
    }

    @PostMapping("/objects")
    public String objectAdd(@RequestParam String objectDescription, @RequestParam BigDecimal objectPrice, @RequestParam Date objectDate, Model model) {
        Object object = new Object(objectDescription, objectPrice, objectDate);
        objectRepository.save(object);
        return "redirect:/objects";
    }
}
