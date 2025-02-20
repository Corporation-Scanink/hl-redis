package com.scanink.home.lab.hl_redis.pojo;

import lombok.Data;

@Data
public class InventoryDevice {
    private String name;
    private String description;
    private String os;
    private String environnement;
    private String installation_type;
    private int territory;
    private int subTerritory;
    private int sequential_number;
    private String tier;
    private String increment;
    private InventoryDetail inventaire;
}
