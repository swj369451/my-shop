package com.sum.my.shop.web.controller;

import com.sum.my.shop.common.utils.SpringContext;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;
import com.sum.my.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    UserService userService = SpringContext.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User user = userService.login(email, password);

//        登录成功
        if (user != null) {
            if("remember".equals(remember)){
                req.getSession().setAttribute("email",email);
                req.getSession().setAttribute("password",password);
            }
            resp.sendRedirect("/main.jsp");
        }
//        登录失败
        else {
            req.setAttribute("message","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
