package com.cg.codegen.constant;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * app.properties的值
 * @author Neo
 *
 */
@Lazy(value = false)
@Component
public class AppProperties {

	@Value("${db.metaDataClassName}")
	private String dbMetaDataClassNameProp;
	private static String dbMetaDataClassName;
	
	@Value("${db.schema}")
	private String dbSchemaProp;
	private static String dbSchema;
	
	
	@PostConstruct
	public void init() {
		dbMetaDataClassName = dbMetaDataClassNameProp;
		dbSchema = dbSchemaProp;
	}
	
	public static String getDbMetaDataClassName() {
		return dbMetaDataClassName;
	}
	public static void setDbMetaDataClassName(String dbMetaDataClassName) {
		AppProperties.dbMetaDataClassName = dbMetaDataClassName;
	}

	public static String getDbSchema() {
		return dbSchema;
	}

	public static void setDbSchema(String dbSchema) {
		AppProperties.dbSchema = dbSchema;
	}
	
	
	
}
