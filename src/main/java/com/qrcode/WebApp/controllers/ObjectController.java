package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.ObjectRepository;
import com.qrcode.WebApp.repo.RoomRepository;
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

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/objects")
    public String objects(Model model) {
        Iterable<Object> objects = objectRepository.findAll();
        Iterable<Room> rooms = roomRepository.findAll();
        model.addAttribute("objects", objects);
        model.addAttribute("rooms", rooms);
        return "objects";
    }

    @PostMapping("/objects")
    public String objectAdd(@RequestParam String objectDescription, @RequestParam Long objectRoom, @RequestParam BigDecimal objectPrice, @RequestParam Date objectDate, Model model) {
        Room room = roomRepository.findById(objectRoom).orElse(null);
        Object object = new Object(objectDescription, room, objectPrice, objectDate);
        objectRepository.save(object);
        return "redirect:/objects";
    }
}
