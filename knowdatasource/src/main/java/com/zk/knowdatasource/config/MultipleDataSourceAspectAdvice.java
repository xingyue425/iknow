package com.zk.knowdatasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MultipleDataSourceAspectAdvice implements Ordered {

    @Before("execution(* com..mapper..*.*(..))")
    public void changeDataSource(JoinPoint point) throws Throwable {
        String environmentCode = SessionUtil.getSessionAttr(SessionUtil.ENVIRONMENT_CODE,"dev").toString();
        logger.info("Use DataSource : "+ environmentCode+"-"+ point.getSignature());
        DynamicDataSourceContextHolder.setDataSourceType(environmentCode);
    }

    @After("execution(* com..service..*.*(..))")
    public void clearDataSource2(JoinPoint point) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
    @After("execution(* com..mapper..*.*(..))")
    public void clearDataSource(JoinPoint point) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
    @Before("execution(* com..service..*.*(..))")
    public void switchDataSource(JoinPoint point) throws Throwable {
        String environmentCode = SessionUtil.getSessionAttr(SessionUtil.ENVIRONMENT_CODE,"dev").toString();
        logger.info("Use DataSource : "+ environmentCode+"-"+ point.getSignature());
        DynamicDataSourceContextHolder.setDataSourceType(environmentCode);
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
