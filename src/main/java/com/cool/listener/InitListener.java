package com.cool.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.cool.util.Val;

@WebListener
public class InitListener implements ServletContextListener{


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		ServletContext application = evt.getServletContext();
		Val.CONTEXT_PATH = application.getContextPath();
		Val.REAL_PATH = application.getRealPath("/");
		application.setAttribute("rt", Val.CONTEXT_PATH);
		System.out.println("======contextPath=====" + Val.CONTEXT_PATH);
		System.out.println("======rootPath=====" + Val.REAL_PATH);
	}

}
