package com.seminar.api.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async
    public Future<String> test(int cnt){
        try {
            long time = (long) ((int) (Math.random() * 10)) * 1000;
            log.info(Thread.currentThread() + " : " + time);
            Thread.sleep(time);
            cnt++;
            return new AsyncResult<>("result : "+Thread.currentThread().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
