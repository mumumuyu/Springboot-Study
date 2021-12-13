package com.example._002springboottest.web.controller;

import com.example._002springboottest.web.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ZhuCeController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/jifen")
    public String createUser() {
        log.info("------注册------");
        this.scoreService.addScore();
        return  "注册完成";
    }
    @RequestMapping("/jifen2")
    public String createUser2() {
        log.info("------注册------");
        this.scoreService.addScore2();
        return  "注册完成";
    }
}
