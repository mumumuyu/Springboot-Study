package com.lgd.controller;

import com.lgd.mapper.UseraMapper;
import com.lgd.pojo.Usera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UseraController {

    @Autowired
    UseraMapper useraMapper;

    @GetMapping("/allList")
    public List<Usera> queryAll(){
        List<Usera> useras = useraMapper.queryAll();
        return  useras;
    }

    @GetMapping("/insert/{id}")
    public String insert(@PathVariable("id")Integer id){
        int num = useraMapper.insert(new Usera(id,"lgd","123456"));
        return "成功插入" + num;
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")Integer id){
        int num = useraMapper.updateByPrimaryKey(new Usera(id,"lgd","123456"));
        return "成功改变" + num;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        int num = useraMapper.deleteByPrimaryKey(id);
        return "成功删除" + num;
    }
}
