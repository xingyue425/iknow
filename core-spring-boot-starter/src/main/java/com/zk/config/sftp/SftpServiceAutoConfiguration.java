package com.zk.config.sftp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SftpConfigProperties.class)
@ConditionalOnClass(SftpService.class)
@ConditionalOnProperty(prefix = "sftp", value = "enabled", matchIfMissing = true)
public class SftpServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(SftpService.class)
    public SftpService sftpService(SftpPool pool){
        SftpService sftpService=new SftpService(pool);
        return sftpService;
    }

    @Bean
    public SftpFactory sftpFactory(SftpConfigProperties properties) {
        return new SftpFactory(properties);
    }

    // 连接池
    @Bean
    public SftpPool sftpPool(SftpFactory sftpFactory) {
        return new SftpPool(sftpFactory);
    }
}
