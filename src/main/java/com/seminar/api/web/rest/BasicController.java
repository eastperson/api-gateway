package com.seminar.api.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seminar.api.model.CustomMessage;
import com.seminar.api.model.Search;
import com.seminar.api.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BasicController {

    private final ObjectMapper objectMapper;
    private final AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        return "장원";
    }

    @GetMapping("/async")
    public String goAsync() {
        int cnt = 0;
        List<Future<String>> list = new ArrayList<>();
        int size = 50;
        for(int i = 0; i < size; i++){
          Future<String> future = asyncService.test(cnt);
          list.add(future);
        }

        while (true){
            if(list.stream().allMatch(future -> future.isDone())){
                break;
            }
        }

        list.forEach(item -> {
            try {
                log.info("str : {}",item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        String str = "Hello Spring Boot Async : " + list.size();
        log.info(str);
        log.info("==================================");
        return str;
    }



}
