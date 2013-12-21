package com.cg.codegen.component.generator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategy;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategyFactory;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategy;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategyFactory;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.BaseGeneratorVo;
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

	public static final String MODEL_MAP_KEY_BASE_MAPPER_PACKAGE = "myBatisExampleBaseMapperPackage";

	public static final String MODEL_MAP_KEY_BASE_MAPPER_NAME = "myBatisExampleBaseMapperName";
	
	// -----------------------------------------
	
	/**
	 * 生成器vo
	 */
	private BaseGeneratorVo generatorVo;
	// -----------------------------------------
	
	/**
	 * 获取生成器vo，并转化为子类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends BaseGeneratorVo> T getGeneratorVoAsSub() {
		return (T) generatorVo;
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	protected String getCurTime() {
		Date date = new Date();
		return DateFormatUtils.format(date, CommonConstant.DATE_TIME_FORMAT);
	}
	
	/**
	 * 获取模板模型map
	 * @return 返回Map<表名, Map<key, value>>
	 */
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = new HashMap<String, Map<String,Object>>();
		
		List<Table> tableList = generatorVo.getTableList();
		Assert.notEmpty(tableList, "tableList could not be empty");
		for (Table table : tableList) {
			//数据模型
			Map<String, Object> modelMap = new HashMap<String, Object>();
			
			//表名->实体名命名策略
			Table2ModelStrategy table2ModelStrategy = Table2ModelStrategyFactory.createTable2ModelStrategy(
					generatorVo.getTable2ModelStrategyClassName(), generatorVo.getTableNameLeftTrimPrefix());
			//DB字段->实体属性命名策略
			Column2PropStrategy column2PropStrategy = Column2PropStrategyFactory.createColumn2PropStrategy(
					generatorVo.getColumn2PropStrategyClassName());
			
			modelMap.put(MODEL_MAP_KEY_CUR_TIME, getCurTime());
			modelMap.put(MODEL_MAP_KEY_TABLE, table);
			modelMap.put(MODEL_MAP_KEY_PACKAGE, generatorVo.getModelPackage());
			//MySQL类型、JAVA类型映射，Map
			modelMap.put(MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP);
			//表名->实体名命名策略
			modelMap.put(MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY, table2ModelStrategy);
			//DB字段->实体属性命名策略
			modelMap.put(MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY, column2PropStrategy);
			//generatorUtil
			modelMap.put(MODEL_MAP_KEY_GENERATOR_UTIL, GeneratorUtil.getInstance());
			
			modelMaps.put(table.getName(), modelMap);
		}
		Assert.isTrue(modelMaps.size() != 0, "modelMaps could not be empty");
		
		return modelMaps;
	}
	// -----------------------------------------
	

	public BaseGeneratorVo getGeneratorVo() {
		return generatorVo;
	}

	public void setGeneratorVo(BaseGeneratorVo generatorVo) {
		this.generatorVo = generatorVo;
	}
	
}
