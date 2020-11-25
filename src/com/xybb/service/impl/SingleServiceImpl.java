package com.xybb.service.impl;

import com.xybb.dao.SingleDao;
import com.xybb.dao.impl.SingleDaoImpl;
import com.xybb.entity.Single;
import com.xybb.service.SingleService;

import java.util.List;

public class SingleServiceImpl implements SingleService {

    //获取dao层实例对象
    SingleDao singleDao = new SingleDaoImpl();
    public List<Single> queryByPaper(String paper){
        //使用dao层对应方法名的方法，并返回结果集
        return singleDao.queryByPaper(paper);
    }


    public List<String> getSubjectList() {
        //使用dao层对应方法名，并返回结果集
        List<String> list=singleDao.getSubjectList();
        return list;
    }

    public List<String> querAnswerBypaper(String paper) {
        return singleDao.querAnswerBypaper(paper);
    }
}
