package com.example._002springboottest.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoreService {
    @Async("scorePoolTaskExecutor2")
    public void addScore(){
        try {
            Thread.sleep(5000);
            log.info("----积分发送-------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Async("scorePoolTaskExecutor")
    public void addScore2(){
        try {
            Thread.sleep(5000);
            log.info("----积分发送-------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
