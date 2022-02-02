package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/rooms")
    public String roomAdd(@RequestParam String roomLocation, @RequestParam Integer roomNumberOfObjects, Model model) {
        Room room = new Room(roomLocation, roomNumberOfObjects);
        roomRepository.save(room);
        return "redirect:/rooms";
    }
}
