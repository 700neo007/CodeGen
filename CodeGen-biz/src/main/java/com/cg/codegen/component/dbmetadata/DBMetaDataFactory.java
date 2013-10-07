package com.cg.codegen.component.dbmetadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.constant.AppProperties;

/**
 * DB 元数据上下文
 * @author Administrator
 *
 */
public class DBMetaDataFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(DBMetaDataFactory.class);
	
	/**
	 * 创建db元数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static DBMetaData createDBMetaData() {
		String metaDataClassName = AppProperties.getDbMetaDataClassName();
		String schema = AppProperties.getDbSchema();
		DBMetaData dbMetaData = null;
		try {
			Class<? extends DBMetaData> clz = (Class<? extends DBMetaData>) Class.forName(DBMetaDataFactory.class.getPackage().getName() + "." + metaDataClassName);
			dbMetaData = clz.newInstance();
			dbMetaData.setSchema(schema);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(dbMetaData, "dbMetaData is null");
		return dbMetaData;
	}
	

}
