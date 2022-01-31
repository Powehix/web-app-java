package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.repo.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
