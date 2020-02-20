package com.sum.my.shop.web.controller;

import com.sum.my.shop.common.constant.ControllerConstant;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends HttpServlet {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = {"","/login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email,
                        @RequestParam(required = true) String password,
                        HttpSession session){
        User user = userService.login(email, password);

        if (user != null) {
//            登录成功
            session.setAttribute(ControllerConstant.SESSION_USER,user);
            return "redirect:/main";
        }

        else{
//            登录失败
            return login();
        }

    }
}
