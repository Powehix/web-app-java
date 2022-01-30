package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        Iterable<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }
}
