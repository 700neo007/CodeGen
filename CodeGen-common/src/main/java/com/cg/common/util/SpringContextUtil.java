package com.cg.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取bean工具
 * @author Neo
 *
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getaApplicationContext() {
		checkContext();
		return applicationContext;
	}
	
	private static void checkContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("ApplicationContext并未注入");
		}
	}

	/**
	 * 获取bean
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkContext();
		return (T)applicationContext.getBean(name);
	}

	/**
	 * 获取bean
	 * @param beanClz
	 * @return
	 */
	public static <T> T getBean(Class<T> beanClz) {
		checkContext();
		return applicationContext.getBean(beanClz);
	}

}
