package com.xybb.service;

import com.xybb.entity.Single;

import java.util.List;

public interface SingleService {

    List<Single> queryByPaper(String paper);

    List<String> getSubjectList();

    List<String> querAnswerBypaper(String paper);
}
