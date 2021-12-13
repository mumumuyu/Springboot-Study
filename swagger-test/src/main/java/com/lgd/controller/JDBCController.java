package com.lgd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/getlist")
    public List<Map<String,Object>> getList(){
        String sql ="select * from user";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/adduser")
    public String addUser(){
        String sql = "insert into user(id, name, pwd) values (?,?,?)";

        Object[] objects = new Object[3];
        objects[0] = 10;
        objects[1] = "lgd";
        objects[2] = "123456";
        jdbcTemplate.update(sql,objects);
        return "insert succeed!";
    }

    @GetMapping("/updateuser/{id}")
    public String updateUser(@PathVariable Integer id){
        String sql = "update user set name = ?,pwd=? where id = "+id;

        Object[] objects = new Object[2];
        objects[0] = "lgd";
        objects[1] = "123456";
        jdbcTemplate.update(sql,objects);
        return "update succeed!";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        String sql = "delete from user where id ="+id;
        jdbcTemplate.update(sql);
        return "delete succeed";
    }
}
