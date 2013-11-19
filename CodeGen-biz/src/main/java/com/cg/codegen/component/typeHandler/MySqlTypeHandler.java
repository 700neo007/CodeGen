package com.cg.codegen.component.typeHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * MySql类型处理器
 * 
 * @author Neo
 * 
 */
public class MySqlTypeHandler extends TypeHandler {

	// ----------mysql类型
	public static final String VARCHAR = "varchar";

	public static final String CHAR = "char";

	public static final String DATETIME = "datetime";

	public static final String SMALLINT = "smallint";

	public static final String DECIMAL = "decimal";

	public static final String DOUBLE = "double";

	public static final String INT = "int";
	
	public static final String BIGINT = "bigint";

	public static final String DATE = "date";
	
	public static final String TIME = "time";
	
	public static final String TIMESTAMP = "timestamp";
	
	// -----------mysql类型正则表达式
	public static final Pattern PATTERN_VARCHAR = Pattern.compile("varchar\\(\\d+\\)");

	public static final Pattern PATTERN_CHAR = Pattern.compile("char\\(\\d+\\)");;

	public static final Pattern PATTERN_DATETIME = Pattern.compile("datetime");

	public static final Pattern PATTERN_SMALLINT = Pattern.compile("smallint\\(\\d+\\)");

	public static final Pattern PATTERN_DECIMAL = Pattern.compile("decimal\\(\\d+,\\d+\\)");

	public static final Pattern PATTERN_DOUBLE = Pattern.compile("double\\(\\d+,\\d+\\)");
	
	public static final Pattern PATTERN_DOUBLE_NO_LEN = Pattern.compile("double");

	public static final Pattern PATTERN_INT = Pattern.compile("int\\(\\d+\\)");
	
	public static final Pattern PATTERN_BIGINT = Pattern.compile("bigint\\(\\d+\\)");
	
	public static final Pattern PATTERN_DATE = Pattern.compile("date");
	
	public static final Pattern PATTERN_TIME = Pattern.compile("time");
	
	public static final Pattern PATTERN_TIMESTAMP = Pattern.compile("timestamp");

	/**
	 * 模式类型map
	 */
	public static final Map<Pattern, String> PATTERN_TYPE_MAP = new HashMap<Pattern, String>();
	static {
		PATTERN_TYPE_MAP.put(PATTERN_VARCHAR, VARCHAR);
		PATTERN_TYPE_MAP.put(PATTERN_CHAR, CHAR);
		PATTERN_TYPE_MAP.put(PATTERN_DATETIME, DATETIME);
		PATTERN_TYPE_MAP.put(PATTERN_SMALLINT, SMALLINT);
		PATTERN_TYPE_MAP.put(PATTERN_DECIMAL, DECIMAL);
		PATTERN_TYPE_MAP.put(PATTERN_DOUBLE, DOUBLE);
		PATTERN_TYPE_MAP.put(PATTERN_DOUBLE_NO_LEN, DOUBLE);
		PATTERN_TYPE_MAP.put(PATTERN_INT, INT);
		PATTERN_TYPE_MAP.put(PATTERN_BIGINT, BIGINT);
		PATTERN_TYPE_MAP.put(PATTERN_DATE, DATE);
		PATTERN_TYPE_MAP.put(PATTERN_TIME, TIME);
		PATTERN_TYPE_MAP.put(PATTERN_TIMESTAMP, TIMESTAMP);
	}
	//------------------------------------
	
	/**
	 * 类型长度map
	 */
	public static final Map<String, TypeLengthGetter> TYPE_LENGTH_MAP = new HashMap<String, MySqlTypeHandler.TypeLengthGetter>();
	/**
	 * 只有长度的类型长度获取器
	 */
	public static final TypeLengthGetter ONLY_LEN_TYPE_LENGTH_GETTER = new TypeLengthGetter() {
			@Override
			public Integer getLength(String typeDesc) {
				Integer len = null;
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(typeDesc);
				if (matcher.find()) {
					len = Integer.parseInt(matcher.group(0));
				}
				return len;
			}
		};
	/**
	 * 没有长度的类型长度获取器
	 */
	public static final TypeLengthGetter NULL_LEN_TYPE_LENGTH_GETTER = new TypeLengthGetter() {
			@Override
			public Integer getLength(String typeDesc) {
				return null;
			}
		};
	static {
		TYPE_LENGTH_MAP.put(VARCHAR, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(CHAR, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(DATETIME, NULL_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(SMALLINT, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(DECIMAL, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(DOUBLE, NULL_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(INT, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(BIGINT, ONLY_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(DATE, NULL_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(TIME, NULL_LEN_TYPE_LENGTH_GETTER);
		TYPE_LENGTH_MAP.put(TIMESTAMP, NULL_LEN_TYPE_LENGTH_GETTER);
	}
	//------------------------------------
	/**
	 * 类型精度map
	 */
	public static final Map<String, TypePrecisionGetter> TYPE_PRECISION_MAP = new HashMap<String, MySqlTypeHandler.TypePrecisionGetter>();
	/**
	 * 没有精度的类型精度获取器
	 */
	public static final TypePrecisionGetter NULL_PRECISION_TYPE_PRECISION_GETTER = new TypePrecisionGetter() {
			@Override
			public Integer getPrecision(String typeDesc) {
				return null;
			}
		};
	/**
	 * 有精度的类型精度获取器
	 */
	public static final TypePrecisionGetter PRECISION_TYPE_PRECISION_GETTER = new TypePrecisionGetter() {
			@Override
			public Integer getPrecision(String typeDesc) {
				Integer precision = null;
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(typeDesc);
				if (matcher.find() && matcher.find()) {
					precision = Integer.parseInt(matcher.group(0));
				}
				return precision;
			}
		};
	static {
		TYPE_PRECISION_MAP.put(VARCHAR, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(CHAR, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(DATETIME, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(SMALLINT, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(DECIMAL, PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(DOUBLE, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(INT, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(BIGINT, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(DATE, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(TIME, NULL_PRECISION_TYPE_PRECISION_GETTER);
		TYPE_PRECISION_MAP.put(TIMESTAMP, NULL_PRECISION_TYPE_PRECISION_GETTER);
	}
	//------------------------------------
	/**
	 * MySQL类型、JAVA类型映射，Map<mysql类型, JAVA类型>
	 */
	public static final Map<String, String> SQL_TYPE_JAVA_TYPE_MAP = new HashMap<String, String>();
	static {
		SQL_TYPE_JAVA_TYPE_MAP.put(VARCHAR, JAVA_TYPE_STRING);
		SQL_TYPE_JAVA_TYPE_MAP.put(CHAR, JAVA_TYPE_STRING);
		SQL_TYPE_JAVA_TYPE_MAP.put(DATETIME, JAVA_TYPE_TIMESTAMP);
		SQL_TYPE_JAVA_TYPE_MAP.put(SMALLINT, JAVA_TYPE_SHORT);
		SQL_TYPE_JAVA_TYPE_MAP.put(DECIMAL, JAVA_TYPE_DOUBLE);
		SQL_TYPE_JAVA_TYPE_MAP.put(DOUBLE, JAVA_TYPE_DOUBLE);
		SQL_TYPE_JAVA_TYPE_MAP.put(INT, JAVA_TYPE_INTEGER);
		SQL_TYPE_JAVA_TYPE_MAP.put(BIGINT, JAVA_TYPE_LONG);
		SQL_TYPE_JAVA_TYPE_MAP.put(DATE, JAVA_TYPE_SQLDATE);
		SQL_TYPE_JAVA_TYPE_MAP.put(TIME, JAVA_TYPE_TIME);
		SQL_TYPE_JAVA_TYPE_MAP.put(TIMESTAMP, JAVA_TYPE_TIMESTAMP);
	}
	//------------------------------------
	
	/**
	 * SQL类型与MyBatis JDBC类型的映射
	 */
	public static final Map<String, String> SQL_TPYE_MYBATIS_JDBC_TYPE_MAP = new HashMap<String, String>();
	static {
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(VARCHAR, MYBATIS_JDBC_TYPE_VARCHAR);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(CHAR, MYBATIS_JDBC_TYPE_CHAR);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(DATETIME, MYBATIS_JDBC_TYPE_TIMESTAMP);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(SMALLINT, MYBATIS_JDBC_TYPE_INTEGER);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(DECIMAL, MYBATIS_JDBC_TYPE_DOUBLE);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(DOUBLE, MYBATIS_JDBC_TYPE_DOUBLE);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(INT, MYBATIS_JDBC_TYPE_INTEGER);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(BIGINT, MYBATIS_JDBC_TYPE_BIGINT);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(DATE, MYBATIS_JDBC_TYPE_DATE);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(TIME, MYBATIS_JDBC_TYPE_TIME);
		SQL_TPYE_MYBATIS_JDBC_TYPE_MAP.put(TIMESTAMP, MYBATIS_JDBC_TYPE_TIMESTAMP);
	}
	//------------------------------------
	
	/**
	 * 获取类型信息
	 * @param typeDesc 类型描述
	 * @return
	 */
	public static TypeHandler.TypeInfo getTypeInfo(String typeDesc) {
		TypeHandler.TypeInfo typeInfo = new TypeHandler.TypeInfo();
		Pattern typePattern = null; //类型模式
		String type = null; //类型
		for (Map.Entry<Pattern, String> patternTypeEntry : PATTERN_TYPE_MAP.entrySet()) {
			typePattern = patternTypeEntry.getKey();
			type = patternTypeEntry.getValue();
			if (!typePattern.matcher(typeDesc).matches()) {
				continue;
			}
			
			typeInfo.setType(type);
			typeInfo.setTypeDesc(typeDesc);
			
			TypeLengthGetter typeLengthGetter = TYPE_LENGTH_MAP.get(type);
			if (typeLengthGetter != null) {
				typeInfo.setLength(typeLengthGetter.getLength(typeDesc));
			}
			
			TypePrecisionGetter typePrecisionGetter = TYPE_PRECISION_MAP.get(type);
			if (typePrecisionGetter != null) {
				typeInfo.setPrecision(typePrecisionGetter.getPrecision(typeDesc));
			}
		}
		if (StringUtils.isEmpty(typeInfo.getType())) {
			throw new IllegalStateException("not any type match");
		}
		return typeInfo;
	}
	
	/**
	 * 类型长度获取器
	 * @author Neo
	 *
	 */
	public static interface TypeLengthGetter {
		
		/**
		 * 获取类型长度
		 * @param typeDesc 类型描述
		 * @return
		 */
		public Integer getLength(String typeDesc);
		
	}
	
	/**
	 * 类型精度获取器
	 * @author Neo
	 *
	 */
	public static interface TypePrecisionGetter {
		/**
		 * 获取类型精度
		 * @param typeDesc 类型描述
		 * @return
		 */
		public Integer getPrecision(String typeDesc);
	}

	public static void main(String[] args) {
		System.out.println("PATTERN_VARCHAR.matcher(varchar(20)):" + PATTERN_VARCHAR.matcher("varchar(20)").matches());
		
		Pattern lenPattern = Pattern.compile("\\D");
		System.out.println("varchar(20) len:" + lenPattern.matcher("varchar(20)").replaceAll(""));
		
		Pattern precisionPattern = Pattern.compile("[a-zA-Z\\(\\)]");
		String decimalLenPrecision = precisionPattern.matcher("decimal(12,5)").replaceAll("");
		System.out.println("decimal(12,5) len,precision:" + decimalLenPrecision);
		System.out.println("decimal(12,5) len:" + decimalLenPrecision.split(",")[0]);
		System.out.println("decimal(12,5) precision:" + decimalLenPrecision.split(",")[1]);
		
		Pattern numPattern = Pattern.compile("\\d+");
		Matcher numMatcher = numPattern.matcher("varchar(20)");
		System.out.println("numMatcher.find():" + numMatcher.find());
		System.out.println("numMatcher.start():" + numMatcher.start());
		System.out.println("numMatcher.group(0):" + numMatcher.group(0));
		
		Pattern decimalPattern = Pattern.compile("\\d+");
		Matcher decimalMatcher = decimalPattern.matcher("decimal(12,5)");
		System.out.println("decimalMatcher.find():" + decimalMatcher.find());
		System.out.println("decimalMatcher.group(0):" + decimalMatcher.group(0));
		System.out.println("decimalMatcher.find():" + decimalMatcher.find());
		System.out.println("decimalMatcher.group(0):" + decimalMatcher.group(0));
	}

}
