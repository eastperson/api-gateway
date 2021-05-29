package com.seminar.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    private OrderBuy orderBuy;
    private String receiver;
    private String address;
    private String uuid;
    private ZonedDateTime createdAt;

}
