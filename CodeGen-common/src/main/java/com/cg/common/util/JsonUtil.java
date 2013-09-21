package com.cg.common.util;

import com.google.gson.Gson;

/**
 * json 工具
 * @author Neo
 *
 */
public class JsonUtil {

	public static Gson gson = new Gson();
	
	/**
	 * 转换成json 字符串
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		return gson.toJson(object);
	}
	
}
