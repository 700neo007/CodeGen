package com.cg.codegen.component.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代码生成器
 * 
 * @author Neo
 * 
 */
public abstract class CodeGenerator {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// ----------------数据模型key

	public static final String MODEL_MAP_KEY_TABLE = "table";

	public static final String MODEL_MAP_KEY_PACKAGE = "package";

	public static final String MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP = "SQL_TYPE_JAVA_TYPE_MAP";

	public static final String MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY = "table2ModelStrategy";

	public static final String MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY = "column2PropStrategy";

	public static final String MODEL_MAP_KEY_GENERATOR_UTIL = "generatorUtil";

	public static final String MODEL_MAP_KEY_IMPORT_LIST = "importList";

	public static final String MODEL_MAP_KEY_VERSION_ID = "versionId";

	// -----------------------------------------

}
