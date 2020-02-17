package com.sum.my.shop.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContext {

    public Object getBean(String beanId) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        return applicationContext.getBean(beanId);
    }
}
