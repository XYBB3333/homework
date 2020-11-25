package com.xybb.service;

import com.xybb.entity.User;

public interface UserService {


    User queryByUserName(String username);

    void register(User user);
}
