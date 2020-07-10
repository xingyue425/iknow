package com.zk.knowdatasource.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static Logger log= LoggerFactory.getLogger(ApplicationContextUtil.class);

    public static ApplicationContext applicationContext;//获取上下文

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("初始化系统上下文");
        this.applicationContext=applicationContext;
    }
}
