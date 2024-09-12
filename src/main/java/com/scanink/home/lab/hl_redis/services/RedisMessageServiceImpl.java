package com.scanink.home.lab.hl_redis.services;

import com.google.gson.Gson;
import com.scanink.home.lab.hl_redis.pojo.RedisMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.UnifiedJedis;

import java.text.SimpleDateFormat;

@Service
@Slf4j
@AllArgsConstructor
public class RedisMessageServiceImpl implements RedisMessageService{

    private static final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
    private static final String key_suffix = "message";
    private static final String key_separator = ":";

    private final RedisTemplate<String, String> redisTemplate;

    private final UnifiedJedis client;

    @Override
    public void addJson(RedisMessage message) {

        try {

            String key = key_suffix + key_separator + message.getId() + key_separator + formater.format(message.getDate());
            client.jsonSet(key, new Gson().toJson(message));

        } catch (Throwable tex) {
            log.error("Something wrong as happened: {}", tex.getLocalizedMessage());
        }

    }
}
