package com.cg.codegen.component.generator;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.common.constant.CommonConstant;

/**
 * 代码生成器
 * 
 * @author Neo
 * 
 */
public abstract class CodeGenerator {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// ----------------数据模型key

	public static final String MODEL_MAP_KEY_CUR_TIME = "time";
	
	public static final String MODEL_MAP_KEY_TABLE = "table";

	public static final String MODEL_MAP_KEY_PACKAGE = "package";

	public static final String MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP = "SQL_TYPE_JAVA_TYPE_MAP";

	public static final String MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY = "table2ModelStrategy";

	public static final String MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY = "column2PropStrategy";

	public static final String MODEL_MAP_KEY_GENERATOR_UTIL = "generatorUtil";

	public static final String MODEL_MAP_KEY_IMPORT_LIST = "importList";

	public static final String MODEL_MAP_KEY_VERSION_ID = "versionId";
	
	public static final String MODEL_MAP_KEY_MYBATIS_MAPPER_PACKAGE = "myBatisMapperPackage";
	
	public static final String MODEL_MAP_KEY_MYBATIS_MAPPER_XML_PACKAGE = "myBatisMapperXmlPackage";

	public static final String MODEL_MAP_KEY_SQL_TPYE_MYBATIS_JDBC_TYPE_MAP = "SQL_TPYE_MYBATIS_JDBC_TYPE_MAP";
	// -----------------------------------------
	
	/**
	 * 获取当前时间
	 * @return
	 */
	protected String getCurTime() {
		Date date = new Date();
		return DateFormatUtils.format(date, CommonConstant.DATE_TIME_FORMAT);
	}

}
