package com.scanink.home.lab.hl_redis.services;

import com.scanink.home.lab.hl_redis.pojo.InventoryMessage;


public interface RedisKeyGenerator {

    String key_suffix = "ogi:";
    String key_middle_fix = ":inventory:";
    String key_separator = ":";
    String key_all_inventory = "ogi:inventory:all";


    default String generateInventoryDeviceKey(InventoryMessage message) {
        return "%s%s%s%s".formatted(key_suffix, message.getNumeroPoste(), key_middle_fix, message.getEvent().getTier().getName());
    }

    default String generateInventoryDetailKey(InventoryMessage message) {
        return "%s%s%s".formatted(generateInventoryDeviceKey(message), key_separator,message.getEvent().getTier().getInventaire().getData_type());
    }

    default String generateInventoryContentKey(InventoryMessage message) {
        return "%s%s%s".formatted(generateInventoryDetailKey(message), key_separator,message.getEvent().getDate());
    }

    default String generateAllKey(){
        return key_all_inventory;
    }
}
