package com.scanink.home.lab.hl_redis.services;

import com.scanink.home.lab.hl_redis.pojo.InventoryField;
import com.scanink.home.lab.hl_redis.pojo.InventoryMessage;

import java.util.List;

public interface RedisMessageService {
    void addJson(InventoryMessage message);
    List<List<InventoryField>> getAll();
}
