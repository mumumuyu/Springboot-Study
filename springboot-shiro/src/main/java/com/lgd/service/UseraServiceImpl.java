package com.lgd.service;

import com.lgd.mapper.UseraMapper;
import com.lgd.pojo.Usera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseraServiceImpl implements UseraService {

    @Autowired
    UseraMapper useraMapper;

    @Override
    public Usera queryByName(String name) {
        return useraMapper.selectByName(name);
    }
}
