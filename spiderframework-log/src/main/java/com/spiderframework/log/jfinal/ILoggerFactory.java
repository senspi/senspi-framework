package com.spiderframework.log.jfinal;

public interface ILoggerFactory {

	Logger getLogger(Class<?> clazz);

	Logger getLogger(String name);
}
