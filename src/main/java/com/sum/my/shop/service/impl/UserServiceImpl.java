package com.sum.my.shop.service.impl;

import com.sum.my.shop.common.utils.SpringContext;
import com.sum.my.shop.dao.UserDao;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;

public class UserServiceImpl implements UserService {

//    如果将这俩句放在属性的位置会报错误
//    SpringContext springContext = new SpringContext();
//    UserDao userDao = (UserDao) springContext.getBean("userDao");

    public User login(String email, String password) {
        SpringContext springContext = new SpringContext();
        UserDao userDao = (UserDao) springContext.getBean("userDao");
        return userDao.getUser(email, password);
    }
}
