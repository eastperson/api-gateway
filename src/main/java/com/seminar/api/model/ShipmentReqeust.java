package com.seminar.api.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ShipmentReqeust {
    private String uuid;
    private ZonedDateTime createdAt;
    private String buyer;
    private Integer price;
    private String productName;
    private String address;
}
