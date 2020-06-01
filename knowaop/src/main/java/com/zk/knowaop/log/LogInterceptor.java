package com.zk.knowaop.log;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LoggerName name=handler.getClass().getAnnotation(LoggerName.class);
        if(name!=null){
            LogFileName loggerName=name.value();
            if(loggerName==null){
                loggerName=LogFileName.OTHER;
            }
            MDC.put(LogUtil.LOGGER_CONTEXT_KEY, loggerName.getLogFileName());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.remove(LogUtil.LOGGER_CONTEXT_KEY);
    }
}
