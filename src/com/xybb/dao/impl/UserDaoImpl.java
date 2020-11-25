package com.xybb.dao.impl;

import com.xybb.dao.UserDao;
import com.xybb.entity.User;
import com.xybb.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User queryByUserName(String username) {
        String sql = "SELECT * FROM user where username = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),username);
    }

    @Override
    public void insert(User user) {
        String sql = "insert into user(username,password,name,telephone,sex,age,role) values(?,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getTelephone(),
                user.getSex(),user.getAge(),user.getRole());
    }
}
