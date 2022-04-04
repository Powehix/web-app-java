package com.qrcode.WebApp;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.repo.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DatabaseController {

    @Autowired
    private ObjectRepository objectRepository;

    @GetMapping("/sqlrequest")
    public String SqlRequest(@RequestParam(name="name", required=false, defaultValue="World") String request, Model model) {
        //вызывать функцию, которая обращается к базе данных и возвращает значение
        //result=handlesqlrequest(name)
        Iterable<Object> response = objectRepository.findAll();
        model.addAttribute("name", response);
        return "response";
    }
}


