package com.cg.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class CommonUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	/**
     * 获取异常输出的堆栈信息
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
    	StringWriter stringWriter = null;
    	StringBuffer buffer = null;
		try {
			stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			t.printStackTrace(writer);
			buffer = stringWriter.getBuffer();
		} finally {
			stringWriter.flush();
			try {
				stringWriter.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		Assert.notNull(buffer, "buffer is null");
		return buffer.toString();
	}
	
}
