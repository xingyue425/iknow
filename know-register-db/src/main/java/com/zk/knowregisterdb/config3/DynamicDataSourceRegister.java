package com.zk.knowregisterdb.config3;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class DynamicDataSourceRegister implements EnvironmentAware {

    /**
     * 加载多数据源配置
     */
    @Override
    public void setEnvironment(Environment env) {
        DynamicDataSourceRegisterUtil.initAndRegisterDataSource(env);
    }

}
