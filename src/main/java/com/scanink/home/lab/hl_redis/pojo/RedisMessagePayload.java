package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

@Data
public class RedisMessagePayload {

    private RedisMessageHeader header;
    private RedisMessageBody body;

}
