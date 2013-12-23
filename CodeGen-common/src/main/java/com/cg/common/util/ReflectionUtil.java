package com.cg.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类
 * @author Neo
 *
 */
public class ReflectionUtil {

	private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);
	
	/**
	 * 获取父类的泛型Class
	 * @param clz 当前子类的Class
	 * @param index 泛型参数索引
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperGenericClass(Class clz, int index) {
		Type type = clz.getGenericSuperclass();
		if (!(type instanceof ParameterizedType)) {
			logger.error(clz.getSimpleName() + "'s superclass is not ParameterizedType");
			return Object.class;
		}
		Type[] params = ((ParameterizedType) type).getActualTypeArguments();
		
		if (index >= params.length || index < 0) {
			logger.error("params.length: " + params.length + ", index is illegal");
			return Object.class;
		}
		
		if (!(params[index] instanceof Class)) {
			logger.error(clz.getSimpleName() + "has not set the actual class to superclass generic parameter");
			return Object.class;
		}
		return (Class) params[index];
	}
	
	/**
	 * 
	 * @param object 当前object
	 * @param methodName 方法名
	 * @param parameterTypes 参数类型
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static Method getDeclareMethod(Object object, String methodName, 
			Class<?> ... parameterTypes) throws NoSuchMethodException {
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
				method.setAccessible(true);
				return method;
			} catch (Exception e) {
				logger.info(methodName + " in " + clazz.getName() + " is not exist");
			}
		}
		throw new NoSuchMethodException("this method: methodName is not exist");
	}
	
}
