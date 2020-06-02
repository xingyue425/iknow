package com.zk.knowprop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:property/system.properties")
public class SystemConfig {

    @Value("${zk.user}")
    private String user;

    public String getUser() {
        return user;
    }
}
