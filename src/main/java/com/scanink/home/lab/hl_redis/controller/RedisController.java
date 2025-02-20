package com.scanink.home.lab.hl_redis.controller;

import com.scanink.home.lab.hl_redis.pojo.InventoryField;
import com.scanink.home.lab.hl_redis.pojo.InventoryMessage;
import com.scanink.home.lab.hl_redis.services.RedisMessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisMessageService service;

    @PostMapping("/message")
    public InventoryMessage addJson(@RequestBody InventoryMessage message) {

        service.addJson(message);
        return message;
    }

    @GetMapping("/messages")
    public List<List<InventoryField>> getAll() {

        return service.getAll();
    }

}
