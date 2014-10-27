package com.spiderframework.log.jfinal;

public abstract class Logger {
	
	private static ILoggerFactory factory;
	
	static {
		init();
	}
	
	public static void setLoggerFactory(ILoggerFactory loggerFactory) {
		if (loggerFactory != null)
			Logger.factory = loggerFactory;
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return factory.getLogger(clazz);
	}
	
	public static Logger getLogger(String name) {
		return factory.getLogger(name);
	}
	
	public static void init() {
		if (factory != null)
			return ;
		try {
			Class.forName("org.apache.log4j.Logger");
			Class<?> log4jLoggerFactoryClass = Class.forName("com.spiderframework.log.jfinal.Log4jLoggerFactory");
			factory = (ILoggerFactory)log4jLoggerFactoryClass.newInstance();	// return new Log4jLoggerFactory();
		} catch (Exception e) {
			factory = new JdkLoggerFactory();
		}
	}
	
	public abstract void var(String key, Object value);
	
	public abstract void debug(String message);
	
	public abstract void debug(String message, Throwable t);
	
	public abstract void info(String message);
	
	public abstract void info(String message, Throwable t);
	
	public abstract void warn(String message);
	
	public abstract void warn(String message, Throwable t);
	
	public abstract void error(String message);
	
	public abstract void error(String message, Throwable t);
	
	public abstract void fatal(String message);
	
	public abstract void fatal(String message, Throwable t);
	
	public abstract boolean isDebugEnabled();

	public abstract boolean isInfoEnabled();

	public abstract boolean isWarnEnabled();

	public abstract boolean isErrorEnabled();
	
	public abstract boolean isFatalEnabled();
}
