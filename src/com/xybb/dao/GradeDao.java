package com.xybb.dao;

import com.xybb.entity.Grade;

import java.util.List;

public interface GradeDao {

    void insertGrade(Grade grade);

    List<Grade> queryByUserId(Integer user_id);
}
