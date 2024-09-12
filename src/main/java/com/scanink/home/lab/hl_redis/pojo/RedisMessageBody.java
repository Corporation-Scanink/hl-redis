package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RedisMessageBody {

    private String message;
    private List<String> errors;
}
