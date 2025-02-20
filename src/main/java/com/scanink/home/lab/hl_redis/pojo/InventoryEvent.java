package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

@Data
public class InventoryEvent {

    private String date;
    private InventoryDevice tier;
}
