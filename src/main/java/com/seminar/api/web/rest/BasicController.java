package com.seminar.api.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seminar.api.model.CustomMessage;
import com.seminar.api.model.OrderBuy;
import com.seminar.api.model.OrderBuyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/order")
    public OrderBuy buy(@RequestBody OrderBuyRequest orderBuyRequest){
        return orderBuyRequest.convertToOrderBuy();
    }

}
