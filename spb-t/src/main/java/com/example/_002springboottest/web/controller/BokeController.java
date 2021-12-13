package com.example._002springboottest.web.controller;

import com.example._002springboottest.web.service.BokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BokeController {
    @Autowired
    private BokeService bokeService;

    @RequestMapping(value = "/c", method = RequestMethod.GET)
    public void create() {
//        for (int i = 10; i < 1000; i++) {
//            Boke boke = new Boke();
//            String temp = "boke" + i;
//            boke.setId(i);
//            boke.setTitle(temp);
//            BokeService.createBoke(boke);
        }
        @RequestMapping(value="/f",method = RequestMethod.GET)
        public void find(){
        this.bokeService.findExample();
    }
}
