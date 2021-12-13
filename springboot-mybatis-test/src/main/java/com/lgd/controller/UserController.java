package com.lgd.controller;

import com.lgd.mapper.UserMapper;
import com.lgd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/queryUserList",produces = "application/json;charset=utf-8")
    public List<User> queryUserList(){
        List<User> userList=userMapper.queryUserList();
        System.out.println("userList:"+userList);
        return userList;
    }
}
