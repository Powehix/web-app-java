package com.qrcode.WebApp;

import com.qrcode.WebApp.models.Room;
import com.qrcode.WebApp.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ResourceController {
    @Autowired
    private RoomRepository roomRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sql/get_number_of_objects")
    public Integer NumberOjObjects(@RequestParam(value = "sql") String name) {
//        return new Object(counter.incrementAndGet(), String.format(template, name));
        //нужно получить строку (name поменять на что-то, на request), запрос с телефона будет выглядеть
        //http://localhost:8080/greeting?sql={"token":token,"request":}
        Room room = roomRepository.findById(Long.parseLong(name)).orElse(null);
        return room.getNumber_of_objects();
    }
}
