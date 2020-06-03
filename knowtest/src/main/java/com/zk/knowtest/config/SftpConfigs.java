package com.zk.knowtest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:property/sftp.properties")
public class SftpConfigs {
}
