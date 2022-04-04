package com.qrcode.WebApp.services;

public interface QRCodeService {
    byte[] generateQRCode(String qrContent, int width, int height);
}
