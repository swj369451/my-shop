package com.sum.my.shop.service.impl;

import com.sum.my.shop.common.context.SpringContext;
import com.sum.my.shop.dao.UserDao;
import com.sum.my.shop.entity.User;
import com.sum.my.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }

}
