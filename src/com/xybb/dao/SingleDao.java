package com.xybb.dao;

import com.xybb.entity.Single;

import java.util.List;

public interface SingleDao {

    public List<Single> queryByPaper(String paper);

    List<String> getSubjectList();

    List<String> querAnswerBypaper(String paper);
}
