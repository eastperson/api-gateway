package com.seminar.api.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seminar.api.model.CustomMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final ObjectMapper objectMapper;

    @GetMapping("/hello")
    public String hello() throws JsonProcessingException {
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("hello");
        return objectMapper.writeValueAsString(customMessage);
    }

}
