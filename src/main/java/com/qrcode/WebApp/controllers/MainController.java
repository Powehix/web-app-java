package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Inventory;
import com.qrcode.WebApp.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/home")
    public String inventories(Model model) {
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        model.addAttribute("inventories", inventories);
        return "home";
    }

    @PostMapping("/home")
    public String inventoryAdd(@RequestParam String inventoryResult, @RequestParam Date inventoryDate, Model model) {
        Inventory inventory = new Inventory(inventoryResult, inventoryDate);
        inventoryRepository.save(inventory);
        return "redirect:/home";
    }
}
