package com.zk.knowdatasource.config;

import com.zk.knowdatasource.service.DataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Configuration
@Order(2)
public class DataSourceConfig {

    private static Logger log= LoggerFactory.getLogger(DataSourceConfig.class);

    public static List<Map> datasourceMap;

    @Autowired
    private DataSourceService dataSourceService;

    @PostConstruct
    public void initDatabasePropertySourceUsage() {
        log.debug("获取数据源配置信息！");
        datasourceMap=dataSourceService.getDataSourceMap();
    }

}
