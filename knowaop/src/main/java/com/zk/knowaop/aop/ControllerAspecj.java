package com.zk.knowaop.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspecj {

    @Pointcut("execution(public * com.zk.knowaop.controller.*.*(..)))")
//    @Pointcut("@annotation(com.zk.knowaop.annotation.Log)")
    public void logPointCut(){}


    @Before("logPointCut()")
    public void doBeforeGame(){
        System.out.println("记录日志前");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("logPointCut()")
    public void doAfterGame(){
        System.out.println("记录日志后");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("logPointCut()")
    public void doAfterReturningGame(){
        System.out.println("方法执行结束前");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("logPointCut()")
    public void doAfterThrowingGame(){
        System.out.println("异常记录");
    }
}
