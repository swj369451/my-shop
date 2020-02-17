package com.sum.my.shop.dao.impl;

import com.sum.my.shop.dao.UserDao;
import com.sum.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {

    Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        LOG.debug("调用getUser().参数email:{},password:{}", email, password);
//        方法就像填空题，需要返回什么就先new一个什么，然后返回他，中间就可以开始填空
        User user = null;

        if ("admin@qq.com".equals(email)) {
            if ("123".equals(password)) {
                user = new User();
                user.setEmail("1@qq.com");
                user.setUsername("admin");
                LOG.info("成功获取\"{}\"账户", user.getUsername());
            }
        } else {
            LOG.warn("获取\"{}\"账户失败", email);
        }

        return user;
    }
}
