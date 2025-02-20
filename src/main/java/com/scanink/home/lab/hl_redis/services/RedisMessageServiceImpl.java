package com.scanink.home.lab.hl_redis.services;

import com.google.gson.Gson;
import com.scanink.home.lab.hl_redis.pojo.InventoryField;
import com.scanink.home.lab.hl_redis.pojo.InventoryMessage;
import com.scanink.home.lab.hl_redis.services.pojo.RedisInventoryDetail;
import com.scanink.home.lab.hl_redis.services.pojo.RedisInventoryDevice;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.UnifiedJedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RedisMessageServiceImpl implements RedisMessageService, RedisKeyGenerator{

    private final UnifiedJedis client;

    private final Gson gson = new Gson();
    @Override
    public void addJson(InventoryMessage message) {

        try {

            String inventoryDeviceKey = this.generateInventoryDeviceKey(message);
            if (client.jsonGet(inventoryDeviceKey) == null ) {
                log.info("Creating new device with key: {}" , inventoryDeviceKey);
                client.jsonSet(inventoryDeviceKey, gson.toJson(RedisInventoryDevice.build(message.getEvent().getTier())));
            } else {
                log.info("Key: {}, already present in Redis database." , inventoryDeviceKey);
            }

            String inventoryDetailKey = this.generateInventoryDetailKey(message);
            if (client.jsonGet(inventoryDetailKey) == null) {
                log.info("Creating new device detail with key: {}" , inventoryDetailKey);
                client.jsonSet(inventoryDetailKey, gson.toJson(RedisInventoryDetail.build(message.getEvent().getTier().getInventaire())));
            } else {
                log.info("Key: {}, already present in Redis database." , inventoryDetailKey);
            }

            String inventoryContentKey = this.generateInventoryContentKey(message);
            if (client.jsonGet(inventoryContentKey) == null) {
                log.info("Creating new inventory content with key: {}" , inventoryContentKey);
                message.getEvent().getTier().getInventaire().getContent().forEach(
                        line -> client.sadd(inventoryContentKey, gson.toJson(line))
                );
                client.sadd(generateAllKey(), inventoryContentKey);
            } else {
                log.info("Key: {}, already present in Redis database." , inventoryContentKey);
            }

        } catch (Throwable tex) {
            log.error("Something wrong as happened: {}", tex.getLocalizedMessage());
        }

    }

    @Override
    public List<List<InventoryField>> getAll() {
        List<List<InventoryField>> lines = new ArrayList<>();
        client.smembers(this.generateAllKey()).forEach(key -> {
            for (String line : client.smembers(key)) {
                lines.add(Arrays.asList(gson.fromJson(line, InventoryField[].class)));
            }
        });

        return lines;
    }

}
