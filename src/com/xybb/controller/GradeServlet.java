package com.xybb.controller;

import com.xybb.entity.Grade;
import com.xybb.entity.User;
import com.xybb.service.GradeService;
import com.xybb.service.impl.GradeServiceImpl;
import com.xybb.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "GradeController",urlPatterns = "/grade")
public class GradeServlet extends BaseServlet {
    //获取GradeService的实例
    GradeService gradeService = new GradeServiceImpl();

    public String history(HttpServletRequest request, HttpServletResponse response){
        //1.接受请求 2.调用服务 3.跳转页面
        //从session域获取当前用户对象
        User user = (User) request.getSession().getAttribute("user");
        List<Grade> list = gradeService.queryByUserId(user.getUser_id());
        request.setAttribute("gradeList",list);
        return "WEB-INF/Exam/resultTable.jsp";
    }
}
