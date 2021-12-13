package com.lgd;

import com.lgd.mapper.UserMapper;
import com.lgd.mapper.UseraMapper;
import com.lgd.pojo.User;
import com.lgd.pojo.Usera;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UseraMapper useraMapper;
    @Test
    public void test() {
        List<User> userList = userMapper.queryUserList();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        List<Usera> userList = useraMapper.queryAll();

        for (Usera user : userList) {
            System.out.println(user);
        }
    }

}
