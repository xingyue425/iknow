package com.zk.knowobjectpool.config.sftp;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SftpProperties.class)
@PropertySource(value={"classpath:property/sftp.properties"},encoding="utf-8")
public class SftpConfig {

    // 工厂
    @Bean
    public SftpFactory sftpFactory(SftpProperties properties) {
        return new SftpFactory(properties);
    }

    // 连接池
    @Bean
    public SftpPool sftpPool(SftpFactory sftpFactory) {
        return new SftpPool(sftpFactory);
    }

    // 辅助类
    @Bean
    public SftpHelper sftpHelper(SftpPool sftpPool) {
        return new SftpHelper(sftpPool);
    }

}
