package com.sum.my.shop.dao;

import com.sum.my.shop.entity.User;

public interface UserDao {

    /**
     * 根据邮箱和密码查询用户
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    User getUser(String email, String password);
}
