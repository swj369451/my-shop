package com.sum.my.shop.service;

import com.sum.my.shop.entity.User;

public interface UserService {
    /**
     * 登录用户
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    User login (String email,String password);
}
