package com.lgd;

import com.lgd.dao.UserDao;
import com.lgd.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LayuiminiTestApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        User user = userDao.getUser("admin");
        System.out.println(user);
    }

}
