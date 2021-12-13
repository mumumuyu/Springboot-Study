package com.lgd.mapper;

import com.lgd.pojo.Usera;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UseraMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usera record);

    int insertSelective(Usera record);

    Usera selectByName(String name);

    int updateByPrimaryKeySelective(Usera record);

    int updateByPrimaryKey(Usera record);
}