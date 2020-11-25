package com.xybb.service.impl;

import com.xybb.dao.UserDao;
import com.xybb.dao.impl.UserDaoImpl;
import com.xybb.entity.User;
import com.xybb.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    @Override
    public User queryByUserName(String username) {
        return userDao.queryByUserName(username);
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }
}
