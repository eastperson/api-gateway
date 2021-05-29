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
public class OrderBuy {
    private String uuid;
    private ZonedDateTime createdAt;
    private String buyer;
    private Integer price;
    private String productName;
}
