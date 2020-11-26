package com.xybb.controller;

import com.xybb.entity.Grade;
import com.xybb.entity.Single;
import com.xybb.entity.User;
import com.xybb.service.GradeService;
import com.xybb.service.SingleService;
import com.xybb.service.impl.GradeServiceImpl;
import com.xybb.service.impl.SingleServiceImpl;
import com.xybb.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//指定url为/single
@WebServlet(name = "SingleController1",urlPatterns = "/single")
public class SingleServlet extends BaseServlet{
    //获取SingleService的实例
    SingleService singleService=new SingleServiceImpl();
    //获取GradeService的实例，实现成绩录入
    GradeService gradeService = new GradeServiceImpl();

    public String getList(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        //1.获取Paper内容 2.调用Service对应的方法 3.将结果返回给jsp 4.跳转页面
        String paper=request.getParameter("subject");
        List<Single> list=singleService.queryByPaper(paper);
        //返回给jsp
        request.setAttribute("list",list);
        //返回科目.
        
        request.setAttribute("paper",paper);
        return "WEB-INF/Exam/paper.jsp";
    }


    //getSubjectList方法实现
    public String getSubjectList(HttpServletRequest request,HttpServletResponse response){
        //调用Service方法,并接受返回值
        List<String> list=singleService.getSubjectList();
        //传递值给前端jsp
        request.setAttribute("subjectList",list);
        return "WEB-INF/Exam/subjectList.jsp";
    }


    public String checkTest(HttpServletRequest request,HttpServletResponse httpServletResponse){
        //获取科目名
        String paper=request.getParameter("paper");
        //第一种：1.通过科目名获取正确答案，然后在获取用户的答案，最后核对，输出成绩
        //第二种：1.，获取正确答案，核对，输出成绩
        /*
         一、获取用户答案：1.获取参数名
         二、获取正确答案
         */
        Enumeration<String>   parameterList =request.getParameterNames();
        //获取正确答案
        List<String>  answerList=singleService.querAnswerBypaper(paper);
        //存放用户正确答案
        List<String>  userAnswerList=new ArrayList<>();
        //存放用户正确数
        int count=0;
        while(parameterList.hasMoreElements()){
            //获取当前循环参数名
            String number=parameterList.nextElement();
            try{
                //筛查非数字字符串,即讲题号转换为int
                int index=Integer.parseInt(number);
                //获取参数名对应的值,即当前用户的一个答案
                String userAnswer=request.getParameter(number);
                //核对
                if(userAnswer.equals(answerList.get(index))) count++;
                //将用户答案存入集合
                userAnswerList.add(userAnswer);
            }catch (NumberFormatException e){
                continue;
            }
        }
        //计算分数
        int score=count*(100/answerList.size());
        //从session域中获取user对象
        User user = (User) request.getSession().getAttribute("user");
        /*
        * 成绩记录
        * 1.声明成绩对象
        * 2.将用户id，分数存入该对象中
        * 3.调用成绩服务*/
        Grade grade = new Grade();
        grade.setUser_id(user.getUser_id());
        grade.setPaper(paper);
        grade.setScore(score);
        gradeService.insertGrade(grade);
        //数据装载
        /*
        1.分数   2.用户答案  3.正确答案
         */
        request.setAttribute("score",score);
        request.setAttribute("userAnswerList",userAnswerList);
        request.setAttribute("answerList",answerList);
        return "WEB-INF/Exam/result.jsp";
    }
}
