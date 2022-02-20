package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.ObjectRepository;
import com.qrcode.WebApp.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        long count = objectRepository.count();
        model.addAttribute("objects", objects);
        model.addAttribute("rooms", rooms);
        model.addAttribute("count", count);
        return "objects";
    }

    @PostMapping(value = "/objects/add", params = "objectAdd")
    public String objectAdd(@RequestParam String objectDescription, @RequestParam Long objectRoom, @RequestParam BigDecimal objectPrice, @RequestParam Date objectDate) {
        Room room = roomRepository.findById(objectRoom).orElse(null);
        Object object = new Object(objectDescription, room, objectPrice, objectDate);
        objectRepository.save(object);
        return "redirect:/objects";
    }

    @PostMapping(value = "/objects/{id_object}/edit", params = "objectEdit")
    public String objectEdit(@PathVariable(value = "id_object") long id_object, @RequestParam String objectDescription, @RequestParam Long objectRoom, @RequestParam BigDecimal objectPrice, @RequestParam Date objectDate) {
        Object object = objectRepository.findById(id_object).orElse(null);
        object.setDescription(objectDescription);
        Room room = roomRepository.findById(objectRoom).orElse(null);
        object.setRoom(room);
        object.setPrice(objectPrice);
        object.setDate(objectDate);
        objectRepository.save(object);
        return "redirect:/objects";
    }

    @PostMapping(value = "/objects/{id_object}/delete", params = "objectDelete")
    public String objectDelete(@PathVariable(value = "id_object") long id_object) {
        Object object = objectRepository.findById(id_object).orElse(null);
        objectRepository.delete(object);
        return "redirect:/objects";
    }
}
