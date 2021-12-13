package com.lgd;

import com.lgd.mapper.UseraMapper;
import com.lgd.pojo.Usera;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Autowired
    UseraMapper useraMapper;

    @Test
    void contextLoads() {
        Usera usera = useraMapper.selectByName("dgg");
        System.out.println(usera);
    }
}
