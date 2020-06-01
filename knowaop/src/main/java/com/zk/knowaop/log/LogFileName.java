package com.zk.knowaop.log;


import org.springframework.util.StringUtils;

public enum LogFileName {

    WEB("web"),//接收其他的服务的请求
    JOB("job"),//定时任务
    OTHER("other");//其他

    private String logFileName;

    LogFileName(String fileName) {
        this.logFileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public static LogFileName getAwardTypeEnum(String value) {
        LogFileName[] arr = values();
        for (LogFileName item : arr) {
            if (null != item && !StringUtils.isEmpty(item.logFileName)) {
                return item;
            }
        }
        return null;
    }
}
