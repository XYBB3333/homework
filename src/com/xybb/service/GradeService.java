package com.xybb.service;

import com.xybb.entity.Grade;

import java.util.List;

public interface GradeService {

    void insertGrade(Grade grade);

    List<Grade> queryByUserId(Integer user_id);
}
