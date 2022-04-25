package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Inventory;
import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repositories.InventoryRepository;
import com.qrcode.WebApp.repositories.ObjectRepository;
import com.qrcode.WebApp.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class MainController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping(value={ "/", "/home"})
    public String inventories(Model model) {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        Iterable<Object> objects = objectRepository.findAll();
        Iterable<Room> rooms = roomRepository.findAll();
        long count = inventoryRepository.count();
        model.addAttribute("inventories", inventories);
        model.addAttribute("objects", objects);
        model.addAttribute("rooms", rooms);
        model.addAttribute("count", count);
        return "home";
    }

    @PostMapping(value = "/home/add", params = "inventoryAdd")
    public String inventoryAdd(@RequestParam Long inventoryRoom, @RequestParam String inventoryResult, @RequestParam Date inventoryDate, Model model) {
        Room room = roomRepository.findById(inventoryRoom).orElse(null);
        Inventory inventory = new Inventory(room, inventoryResult, inventoryDate);
        inventoryRepository.save(inventory);
        return "redirect:/home";
    }

    @PostMapping(value = "/home/{id_inventory}/edit", params = "inventoryEdit")
    public String inventoryEdit(@PathVariable(value = "id_inventory") long id_inventory, @RequestParam Long inventoryRoom, @RequestParam String inventoryResult, @RequestParam Date inventoryDate) {
        Inventory inventory = inventoryRepository.findById(id_inventory).orElse(null);
        Room room = roomRepository.findById(inventoryRoom).orElse(null);
        inventory.setRoom(room);
        inventory.setResult(inventoryResult);
        inventory.setDate(inventoryDate);
        inventoryRepository.save(inventory);
        return "redirect:/home";
    }

    @PostMapping(value = "/home/{id_inventory}/delete", params = "inventoryDelete")
    public String inventoryDelete(@PathVariable(value = "id_inventory") long id_inventory) {
        Inventory inventory = inventoryRepository.findById(id_inventory).orElse(null);
        inventoryRepository.delete(inventory);
        return "redirect:/home";
    }
}
