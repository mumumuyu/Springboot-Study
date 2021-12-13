package com.lgd.mapper;

import com.lgd.pojo.Usera;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository
public interface UseraMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usera record);

    int insertSelective(Usera record);

    Usera selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usera record);

    int updateByPrimaryKey(Usera record);

    List<Usera> queryAll();
}