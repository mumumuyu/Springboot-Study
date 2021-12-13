package com.example._002springboottest.web.service;

import com.example._002springboottest.web.entity.Boke;
import com.example._002springboottest.web.mapper.BokeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BokeService {

    @Autowired
    private BokeMapper bokeMapper;

    public void createBoke(Boke obj){
        bokeMapper.insertSelective(obj);
    }
    public void findExample(){
        log.info("----查询id=1----");
        Boke boke=this.bokeMapper.selectByPrimaryKey(1);
    }
}
