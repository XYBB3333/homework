package com.xybb.service;

import com.xybb.entity.Single;

import java.util.List;

public interface SingleService {


//    List<Single> querySinglePaper(String paper);

    List<Single> queryByPaper(String paper);

    List<String> getSubjectList();

    List<String> querAnswerBypaper(String paper);
}
