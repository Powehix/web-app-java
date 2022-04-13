package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Inventory;
import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repositories.InventoryRepository;
import com.qrcode.WebApp.repositories.ObjectRepository;
import com.qrcode.WebApp.repositories.RoomRepository;
import com.qrcode.WebApp.services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/generateQRCode")
    public void generateQRCode(String qrContent, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        byte[] qrCode = qrCodeService.generateQRCode(qrContent, 150, 150);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(qrCode);
    }

    @PostMapping("/qrGenerate")
    public String showQRCode(String qrContent, Model model) {
        model.addAttribute("qrCodeContent", "/generateQRCode?qrContent=" + qrContent);
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
}
