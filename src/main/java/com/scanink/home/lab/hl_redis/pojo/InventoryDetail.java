package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class InventoryDetail {

    private Float created;
    private String  description;
    private String  data_type;
    private List<List<InventoryField>> content;
}
