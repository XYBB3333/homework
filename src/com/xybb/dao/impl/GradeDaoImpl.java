package com.xybb.dao.impl;

import com.xybb.dao.GradeDao;
import com.xybb.entity.Grade;
import com.xybb.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class GradeDaoImpl implements GradeDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void insertGrade(Grade grade) {
        String sql = "insert into grade(user_id,paper,score,time) values(?,?,?,now())";
        template.update(sql,grade.getUser_id(),grade.getPaper(),grade.getScore());
    }

    @Override
    public List<Grade> queryByUserId(Integer user_id) {
        String sql="SELECT * from grade where user_id=? order by score DESC";
        //template.query(sql语句,如果结果集不是基本类型就使用BeanPropertyRowMapper转换结果集为指定对象，
        // ? 表示占位符，即将我们的参数传递入？中)
        return template.query(sql,new BeanPropertyRowMapper<>(Grade.class),user_id);
    }
}
