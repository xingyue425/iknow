/**
 * <br>项目名: issue-monitor
 * <br>文件名: LogUtil.java
 * <br>Copyright 2013 北京壹平台科技有限公司
 */
package com.zk.knowaop.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 *
 * <br>类 名: LogUtil
 * <br>描 述: 日志工具类
 * <br>作 者: zk
 * <br>创 建： 2014-01-06
 * <br>版 本：v1.0.0
 * <br>
 * <br>历 史: (版本) 作者 时间 注释
 */
public class LogUtil {

	public static String LOGGER_CONTEXT_KEY="loggerName";

	/**
	 *
	 * <br>描 述：得到logger
	 * <br>作 者：zk
	 * <br>历 史: (版本) 作者 时间 注释
	 * @param className 类
	 * @return logger
	 */
	public static Logger getLogger(Class<?> className) {
		return LoggerFactory.getLogger(className);
	}

	/**
	 *
	 * <br>描 述：输出类的日志信息
	 * <br>作 者：zk
	 * <br>历 史: (版本) 作者 时间 注释
	 * @param classinf 类
	 * @return 输出此类的日志信息
	 */
	public static String getLog4jInfo(Class<?> classinf) {
		String logInfo = "";
		StackTraceElement[] stack = (new Throwable()).getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement ste = stack[i];
			if(classinf.getName().equals(ste.getClassName())){
				logInfo = "\n ->"+ste.getClassName() + "." + ste.getMethodName()+"("+ste.getFileName()+":"+ste.getLineNumber()+")  ";
				return logInfo;
			}
		}
		if(logInfo.length()==0){
			logInfo = "\n ->"+classinf.toString();
		}
		return logInfo;
	}
	public static Logger Logger(LogFileName desc) {
		return LoggerFactory.getLogger(desc.getLogFileName());
	}
	public static Logger Logger() {

		String loggerName= MDC.get(LogUtil.LOGGER_CONTEXT_KEY);
		if(StringUtils.isEmpty(loggerName)){
			loggerName=LogFileName.OTHER.getLogFileName();
		}
		return LoggerFactory.getLogger(loggerName);
	}
	public static void setLoggerName(String loggerName){
		MDC.put(LogUtil.LOGGER_CONTEXT_KEY, loggerName);
	}
	public static String getLoggerName(){
		return MDC.get(LogUtil.LOGGER_CONTEXT_KEY);
	}
	public static void clearLoggerName(){
		MDC.remove(LogUtil.LOGGER_CONTEXT_KEY);
	}
	public static Logger Logger(String loggerFileName) {
		return LoggerFactory.getLogger(loggerFileName);
	}
	public static <T> Logger Logger(Class<T> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

}