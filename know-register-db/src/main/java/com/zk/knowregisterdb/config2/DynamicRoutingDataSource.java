package com.zk.knowregisterdb.config2;

import com.zk.knowregisterdb.config.DynamicDataSourceContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource{

    private static Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();
        logger.info("当前数据源是：{}", dataSourceName);
        return DynamicDataSourceContextHolder.getDataSourceRouterKey();
    }
}
