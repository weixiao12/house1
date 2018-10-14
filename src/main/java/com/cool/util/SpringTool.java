package com.cool.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTool {
	private static final String CONF_FILE = "applicationContext.xml";
	
	private static ApplicationContext ctx;
	
	static{
		ctx = new ClassPathXmlApplicationContext(CONF_FILE);
	}
	
	public static Object getBean(String beanId){
		return ctx.getBean(beanId);
	}
	public static <T> T getBean(Class<T> cls){
		return ctx.getBean(cls);
	}
}
