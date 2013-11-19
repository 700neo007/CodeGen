package com.cg.codegen.component.typeHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 类型处理器
 * @author Neo
 *
 */
public abstract class TypeHandler {
	
	// ----------JAVA类型
	public static final String JAVA_TYPE_STRING = "String";
	
	public static final String JAVA_TYPE_UTILDATE = "Date";
	
	public static final String JAVA_TYPE_SQLDATE = "Date";
	
	public static final String JAVA_TYPE_TIME = "Time";
	
	public static final String JAVA_TYPE_TIMESTAMP = "Timestamp";
	
	public static final String JAVA_TYPE_SHORT = "Short";
	
	public static final String JAVA_TYPE_BIGDECIMAL = "BigDecimal";
	
	public static final String JAVA_TYPE_DOUBLE = "Double";
	
	public static final String JAVA_TYPE_INTEGER = "Integer";
	
	public static final String JAVA_TYPE_LONG = "Long";
	//--------------------------------
	/**
	 * java类型、包名map
	 */
	public static final Map<String, String> JAVA_TYPE_PACKAGE_MAP = new HashMap<String, String>();
	static {
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_STRING, "");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_UTILDATE, "java.util.Date");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_SQLDATE, "java.sql.Date");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_TIME, "java.sql.Time");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_TIMESTAMP, "java.sql.Timestamp");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_SHORT, "");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_BIGDECIMAL, "java.math.BigDecimal");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_DOUBLE, "");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_INTEGER, "");
		JAVA_TYPE_PACKAGE_MAP.put(JAVA_TYPE_LONG, "");
	}
	//-------------MyBatis的JDBC 类型-------------------
	
	public static final String MYBATIS_JDBC_TYPE_VARCHAR = "VARCHAR";
	
	public static final String MYBATIS_JDBC_TYPE_CHAR = "CHAR";

	public static final String MYBATIS_JDBC_TYPE_INTEGER = "INTEGER";
	
	public static final String MYBATIS_JDBC_TYPE_DOUBLE = "DOUBLE";
		
	public static final String MYBATIS_JDBC_TYPE_BIGINT = "BIGINT";	
	
	public static final String MYBATIS_JDBC_TYPE_TIMESTAMP = "TIMESTAMP";	
	
	public static final String MYBATIS_JDBC_TYPE_DATE = "DATE";	
	
	public static final String MYBATIS_JDBC_TYPE_TIME = "TIME";	
	//--------------------------------
	
	/**
	 * 类型信息
	 * @author Neo
	 *
	 */
	public static class TypeInfo {
		
		/**
		 * 类型描述
		 */
		private String typeDesc;
		/**
		 * 类型
		 */
		private String type;
		/**
		 * 长度
		 */
		private Integer length;
		/**
		 * 精度
		 */
		private Integer precision;
		
		
		public String getTypeDesc() {
			return typeDesc;
		}
		public void setTypeDesc(String typeDesc) {
			this.typeDesc = typeDesc;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Integer getPrecision() {
			return precision;
		}
		public void setPrecision(Integer precision) {
			this.precision = precision;
		}
		
		
	}
	
}
