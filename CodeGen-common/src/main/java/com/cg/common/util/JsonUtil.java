package com.cg.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * json 工具
 * @author Neo
 *
 */
public class JsonUtil {
	
	private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Gson gson = new GsonBuilder()
			.serializeNulls()
			.setDateFormat(DEFAULT_DATETIME_FORMAT)
			.create();
	
	/**
	 * 转换成json 字符串
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		return gson.toJson(object);
	}
	
}
