package com.example._002springboottest.web.mapper;

import com.example._002springboottest.web.entity.Boke;

public interface BokeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Boke record);

    int insertSelective(Boke record);

    Boke selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Boke record);

    int updateByPrimaryKeyWithBLOBs(Boke record);

    int updateByPrimaryKey(Boke record);
}