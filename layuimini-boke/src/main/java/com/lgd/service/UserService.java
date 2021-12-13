package com.lgd.service;

import com.lgd.dao.UserDao;
import com.lgd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(String code) {
        return userDao.getUser(code);
    }

    public int updatePass(Integer id, String newPsw) {
        return userDao.updatePass(id,newPsw);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public int getCount() {
        return userDao.getCount();
    }

    public List<User> findAllUsers(int page, int limit) {
        return userDao.findAllUsers(page,limit);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int delUser(int id) {
        return userDao.delUser(id);
    }

    public int getCount(String role) {
        return userDao.getCount(role);
    }

    public List<User> findUser(int page, int limit, String role) {
        return userDao.findUser(page,limit,role);
    }

    public void resetPass(int id) {
        userDao.resetPass(id);
    }
}
