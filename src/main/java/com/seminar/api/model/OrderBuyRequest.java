package com.seminar.api.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class OrderBuyRequest {

    private String buyer;
    private Integer price;
    private String productName;

    public OrderBuy convertToOrderBuy() {
        return OrderBuy.builder()
                .buyer(buyer)
                .price(price)
                .productName(productName)
                .uuid(UUID.randomUUID().toString())
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
