package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Inventory;
import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repo.InventoryRepository;
import com.qrcode.WebApp.repo.ObjectRepository;
import com.qrcode.WebApp.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class MainController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private RoomRepository roomRepository;

   /* @Query("SELECT COUNT(*) FROM Room");
    public string roomCount*/

    @GetMapping("/home")
    public String inventories(Model model) {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        Iterable<Object> objects = objectRepository.findAll();
        Iterable<Room> rooms = roomRepository.findAll();
        model.addAttribute("inventories", inventories);
        model.addAttribute("objects", objects);
        model.addAttribute("rooms", rooms);
        return "home";
    }

    @PostMapping("/home")
    public String inventoryAdd(@RequestParam Long inventoryRoom, @RequestParam String inventoryResult, @RequestParam Date inventoryDate, Model model) {
        Room room = roomRepository.findById(inventoryRoom).orElse(null);
        Inventory inventory = new Inventory(room, inventoryResult, inventoryDate);
        inventoryRepository.save(inventory);
        return "redirect:/home";
    }
}
