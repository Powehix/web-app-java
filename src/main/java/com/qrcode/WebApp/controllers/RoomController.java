package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Person;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.PersonRepository;
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

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        Iterable<Room> rooms = roomRepository.findAll();
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("rooms", rooms);
        model.addAttribute("persons", persons);
        return "rooms";
    }

    @PostMapping("/rooms")
    public String roomAdd(@RequestParam String roomLocation, @RequestParam Integer roomNumberOfObjects, @RequestParam Long roomPerson, Model model) {
        Person person = personRepository.findById(roomPerson).orElse(null);
        Room room = new Room(roomLocation, roomNumberOfObjects, person);
        roomRepository.save(room);
        return "redirect:/rooms";
    }
}
