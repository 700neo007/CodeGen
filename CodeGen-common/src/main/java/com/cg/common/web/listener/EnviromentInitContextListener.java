package com.cg.common.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 初始化listener
 * @author Neo
 *
 */
public class EnviromentInitContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(EnviromentInitContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String prefix = "contextInitialized#-> ";
		ServletContext servletContext = sce.getServletContext();
		
		String basePath = servletContext.getContextPath();
		logger.info("{}bathPath:{}", prefix, basePath);
		
		String baseRealPath = servletContext.getRealPath("/");
		logger.info("{}baseRealPath:{}", prefix, baseRealPath);
		
		System.setProperty("BasePath", basePath);
		System.setProperty("BaseRealPath", baseRealPath);
		
		servletContext.setAttribute("BasePath", basePath);
		servletContext.setAttribute("BaseRealPath", baseRealPath);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
