package com.zk.knowaop.log;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface LoggerName {

    LogFileName value() default LogFileName.OTHER;
}
