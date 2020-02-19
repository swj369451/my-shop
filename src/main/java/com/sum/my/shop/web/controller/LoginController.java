package com.sum.my.shop.web.controller;

import com.sum.my.shop.common.context.SpringContext;
import com.sum.my.shop.common.utils.CookieUtils;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;
import com.sum.my.shop.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private static final String COOKIE_NAME_USER_INFO ="userInfo";
    private UserService userService = SpringContext.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req, COOKIE_NAME_USER_INFO);

        if(StringUtils.isNoneBlank(userInfo)){
            String[] userInfoArray = userInfo.split(":");
            req.setAttribute("email",userInfoArray[0]);
            req.setAttribute("password",userInfoArray[1]);
            req.setAttribute("isRemember",true);
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Boolean isRemember = req.getParameter("isRemember") == null ? false : true;
        User user = userService.login(email, password);

//        用户选择不记住密码
        if(!isRemember){
            CookieUtils.deleteCookie(req,resp,COOKIE_NAME_USER_INFO);
        }

//        登录成功
        if (user != null) {
            if (isRemember) {
//               如果记住密码保存一周
                CookieUtils.setCookie(req, resp, COOKIE_NAME_USER_INFO, String.format("%s:%s", email, password), 7 * 24 * 60 * 60);
            }
            resp.sendRedirect("/main.jsp");
        }
//        登录失败
        else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
