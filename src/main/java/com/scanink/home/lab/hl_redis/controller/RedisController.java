package com.scanink.home.lab.hl_redis.controller;

import com.scanink.home.lab.hl_redis.pojo.RedisMessage;
import com.scanink.home.lab.hl_redis.services.RedisMessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisMessageService service;

    @PostMapping("/json")
    public  RedisMessage addJson(@RequestBody RedisMessage message) {

        service.addJson(message);
        return message;
    }

}
