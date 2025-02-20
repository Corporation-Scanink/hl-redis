package com.scanink.home.lab.hl_redis.services.pojo;

import com.scanink.home.lab.hl_redis.pojo.InventoryDevice;
import lombok.Data;

@Data
public class RedisInventoryDevice {

    private String name;
    private String description;
    private String os;
    private String environment;
    private String installation_type;
    private int territory;
    private int subTerritory;
    private int sequential_number;
    private String tier;
    private String increment;

    public static RedisInventoryDevice build(InventoryDevice invDevice) {

        RedisInventoryDevice device = new RedisInventoryDevice();
        device.setName(invDevice.getName());
        device.setDescription(invDevice.getDescription());
        device.setOs(invDevice.getOs());
        device.setEnvironment(invDevice.getEnvironnement());
        device.setInstallation_type(invDevice.getInstallation_type());
        device.setTerritory(invDevice.getTerritory());
        device.setSubTerritory(invDevice.getSubTerritory());
        device.setSequential_number(invDevice.getSequential_number());
        device.setTier(invDevice.getTier());
        device.setIncrement(invDevice.getIncrement());

        return device;
    }
}
