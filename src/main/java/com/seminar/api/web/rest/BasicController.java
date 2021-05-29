package com.seminar.api.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seminar.api.model.CustomMessage;
import com.seminar.api.model.OrderBuy;
import com.seminar.api.model.Shipment;
import com.seminar.api.model.ShipmentReqeust;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final ObjectMapper objectMapper;

    @GetMapping("/hello")
    public CustomMessage hello() throws JsonProcessingException {
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("hello");
        return customMessage;
    }

    @PostMapping("/ship")
    public Shipment ship(@RequestBody ShipmentReqeust shipmentReqeust) {
        return Shipment.builder()
                .orderBuy(OrderBuy.builder()
                        .createdAt(shipmentReqeust.getCreatedAt())
                        .uuid(shipmentReqeust.getUuid())
                        .price(shipmentReqeust.getPrice())
                        .buyer(shipmentReqeust.getBuyer())
                        .productName(shipmentReqeust.getProductName())
                        .build()
                )
                .receiver(shipmentReqeust.getBuyer())
                .address(shipmentReqeust.getAddress())
                .uuid(UUID.randomUUID().toString())
                .createdAt(ZonedDateTime.now())
                .build();
    }
}
