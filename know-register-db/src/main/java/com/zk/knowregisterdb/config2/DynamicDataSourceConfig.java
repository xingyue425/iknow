package com.zk.knowregisterdb.config2;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsContructor
public class DynamicDataSourceConfig implements TransactionManagerConfigurer{

    private final Map<Object,Object> dataSourceMap=new HashMap<Object,Object>();
    private final DataSourceProperties dataSourceProperties;

    public DynamicDataSource dataSource(){

    }
}
