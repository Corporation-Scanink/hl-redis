package com.scanink.home.lab.hl_redis.services.pojo;

import com.scanink.home.lab.hl_redis.pojo.InventoryDetail;
import lombok.Data;

@Data
public class RedisInventoryDetail {

    private Float created;
    private String  description;
    private String  data_type;

    public static RedisInventoryDetail build(InventoryDetail invDetail) {

        RedisInventoryDetail detail = new RedisInventoryDetail();
        detail.setCreated(invDetail.getCreated());
        detail.setDescription(invDetail.getDescription());
        detail.setData_type(invDetail.getData_type());

        return detail;
    }
}
