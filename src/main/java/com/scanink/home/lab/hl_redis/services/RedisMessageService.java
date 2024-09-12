package com.scanink.home.lab.hl_redis.services;

import com.scanink.home.lab.hl_redis.pojo.RedisMessage;

public interface RedisMessageService {
    void addJson(RedisMessage message);
}
