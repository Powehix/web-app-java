package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Person;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repositories.PersonRepository;
import com.qrcode.WebApp.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/rooms")
    public String rooms( Model model) {
        Iterable<Room> rooms = roomRepository.findAll();
        Iterable<Person> persons = personRepository.findAll();
        long count = roomRepository.count();
        model.addAttribute("rooms", rooms);
        model.addAttribute("persons", persons);
        model.addAttribute("count", count);
        return "rooms";
    }

    @PostMapping(value = "/rooms/add", params = "roomAdd")
    public String roomAdd(@RequestParam String roomLocation, @RequestParam Integer roomNumberOfObjects, @RequestParam Long roomPerson) {
        Person person = personRepository.findById(roomPerson).orElse(null);
        Room room = new Room(roomLocation, roomNumberOfObjects, person);
        roomRepository.save(room);
        return "redirect:/rooms";
    }

    @PostMapping(value = "/rooms/{id_room}/edit", params = "roomEdit")
    public String roomEdit(@PathVariable(value = "id_room") long id_room, @RequestParam String roomLocation, @RequestParam Integer roomNumberOfObjects, @RequestParam Long roomPerson) {
        Room room = roomRepository.findById(id_room).orElse(null);
        room.setLocation_of_room(roomLocation);
        room.setNumber_of_objects(roomNumberOfObjects);
        Person person = personRepository.findById(roomPerson).orElse(null);
        room.setPerson(person);
        roomRepository.save(room);
        return "redirect:/rooms";
    }

    @PostMapping(value = "/rooms/{id_room}/delete", params = "roomDelete")
    public String roomDelete(@PathVariable(value = "id_room") long id_room) {
        Room room = roomRepository.findById(id_room).orElse(null);
        roomRepository.delete(room);
        return "redirect:/rooms";
    }
}
