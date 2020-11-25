package com.xybb.dao;

import com.xybb.entity.User;

public interface UserDao {

    User queryByUserName(String username);

    void insert(User user);
}
