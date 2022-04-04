package com.qrcode.WebApp.service;

public interface QRCodeService {
    byte[] generateQRCode(String qrContent, int width, int height);
}
