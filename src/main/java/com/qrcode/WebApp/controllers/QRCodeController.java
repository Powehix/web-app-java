package com.qrcode.WebApp.controllers;

import com.qrcode.WebApp.models.Object;
import com.qrcode.WebApp.repo.ObjectRepository;
import com.qrcode.WebApp.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private ObjectRepository objectRepository;

    @PostMapping("/qrGenerate")
    public String showQRCode(String qrContent, Model model) {
        model.addAttribute("qrCodeContent", "/generateQRCode?qrContent=" + qrContent);
        Iterable<Object> objects = objectRepository.findAll();
        model.addAttribute("objects", objects);
        return "home";
    }

    @GetMapping("/generateQRCode")
    public void generateQRCode(String qrContent, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        byte[] qrCode = qrCodeService.generateQRCode(qrContent, 150, 150);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(qrCode);
    }
}
