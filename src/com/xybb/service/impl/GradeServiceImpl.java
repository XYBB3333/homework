package com.xybb.service.impl;

import com.xybb.dao.GradeDao;
import com.xybb.dao.impl.GradeDaoImpl;
import com.xybb.entity.Grade;
import com.xybb.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao = new GradeDaoImpl();
    @Override
    public void insertGrade(Grade grade) {
        gradeDao.insertGrade(grade);
    }

    @Override
    public List<Grade> queryByUserId(Integer user_id) {
        return gradeDao.queryByUserId(user_id);
    }
}
