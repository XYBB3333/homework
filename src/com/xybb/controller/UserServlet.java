package com.xybb.controller;

import com.xybb.entity.User;
import com.xybb.service.UserService;
import com.xybb.service.impl.UserServiceImpl;
import com.xybb.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//指定url为/user
@WebServlet(name = "UserController",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //登录
    public String login(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.queryByUserName(username);
        if (password.equals(user.getPassword())){
            req.getSession().setAttribute("user",user);
            req.setAttribute("username",username);
            return "WEB-INF/Exam/studentIndex.jsp";
        }
        return "index.jsp";
    }

    //注册
    public String register(HttpServletRequest req, HttpServletResponse resp){
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setTelephone(req.getParameter("telephone"));
        user.setSex(req.getParameter("sex"));
        user.setAge(Integer.valueOf(req.getParameter("age")));
        user.setRole(req.getParameter("role"));
        userService.register(user);
        return "index.jsp";
    }
}
