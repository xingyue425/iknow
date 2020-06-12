package com.zk.knowregisterdb.config3;

public class DynamicDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

    /**
     * 动态更新自定义数据源
     * @param defaultDataSource
     * @param customDataSources
     */
    public void updateTargetDataSource(Map<String,DataSource> customDataSources){
        Map<Object,Object> customDS=new HashMap<Object, Object>();
        customDS.putAll(customDataSources);
        setTargetDataSources(customDS);
        afterPropertiesSet();
    }
}
