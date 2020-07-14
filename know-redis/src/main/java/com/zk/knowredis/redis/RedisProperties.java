package com.zk.knowredis.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//依赖注入
@Component
//该注解用于读取配置文件中的属性，其中prefix表示前缀；
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisProperties {
    private String nodes;

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

}