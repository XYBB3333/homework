package com.xybb.dao.impl;

import com.xybb.dao.SingleDao;
import com.xybb.entity.Single;
import com.xybb.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SingleDaoImpl implements SingleDao {
    //创建jdbc的链接
    //对每个方法来说：1.写sql语句 2.jdbctemplete进sql操作，并将返回集返回
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Single> queryByPaper(String paper) {
        String sql="SELECT * from single where paper= ? ";
        //template.query(sql语句,如果结果集不是基本类型就使用BeanPropertyRowMapper转换结果集为指定对象，
        // ? 表示占位符，即将我们的参数传递入？中)
        return template.query(sql,new BeanPropertyRowMapper<>(Single.class),paper);
    }

    @Override
    public List<String> getSubjectList() {
        //声明SqL语句
        String sql="SELECT DISTINCT paper FROM single";
        //调用sql语句
        return template.queryForList(sql,String.class);
    }

    @Override
    public List<String> querAnswerBypaper(String paper) {
        //声明SqL语句
        String sql="SELECT answer from single where paper=?";
        //调用sql，并获取返回
        return template.queryForList(sql,String.class,paper);
    }
}
