package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;


@Data
public class InventoryMessage {

    private String numeroPoste;
    private InventoryEvent event;

}
