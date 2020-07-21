package com.zk.knowprop.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
@PropertySource("classpath:property/redis.properties")
@Data
@Component
public class RedisProperty {

    private String nodes;
}
