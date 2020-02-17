package com.sum.my.shop.web.controller;

import com.sum.my.shop.common.utils.SpringContext;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    SpringContext springContext = new SpringContext();
    UserService userService = (UserService) springContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.login(email, password);

//        登录成功
        if (user != null) {
            resp.sendRedirect("/main.jsp");
        }
//        登录失败
        else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
