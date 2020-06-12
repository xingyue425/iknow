package com.zk.knowregisterdb.config3;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvironmentUtils implements EnvironmentAware {

    private static Environment environment ;
    @Override
    public void setEnvironment(Environment environment) {
        EnvironmentUtils.environment=environment;
    }
    public static Environment getEnvironment(){
        return EnvironmentUtils.environment;
    }
}
