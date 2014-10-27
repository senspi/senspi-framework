package com.spiderframework.log.jfinal;

public class JdkLoggerFactory implements ILoggerFactory {
	
	public Logger getLogger(Class<?> clazz) {
		return new JdkLogger(clazz);
	}
	
	public Logger getLogger(String name) {
		return new JdkLogger(name);
	}
}
