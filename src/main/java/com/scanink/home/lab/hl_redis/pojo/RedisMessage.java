package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Data
public class RedisMessage {

    private Date date = GregorianCalendar.getInstance().getTime();
    private String id = UUID.randomUUID().toString();
    private RedisMessagePayload payload;
}
