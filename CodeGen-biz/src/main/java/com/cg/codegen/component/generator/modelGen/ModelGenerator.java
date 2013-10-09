package com.cg.codegen.component.generator.modelGen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.codegen.component.typeHandler.TypeHandler;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorSubmitVo;
import com.cg.codegen.model.vo.generator.modelGen.ModelGeneratorVo;

/**
 * 实体生成器
 * @author Neo
 *
 */
public abstract class ModelGenerator {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	//----------------数据模型key
	
	public static final String MODEL_MAP_KEY_TABLE = "table";
	
	public static final String MODEL_MAP_KEY_PACKAGE = "package";
	
	public static final String MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP = "SQL_TYPE_JAVA_TYPE_MAP";
	
	public static final String MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY = "table2ModelStrategy";
	
	public static final String MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY = "column2PropStrategy";
	
	public static final String MODEL_MAP_KEY_GENERATOR_UTIL = "generatorUtil";

	public static final String MODEL_MAP_KEY_IMPORT_LIST = "importList";
	
	public static final String MODEL_MAP_KEY_VERSION_ID = "versionId";

	//-----------------------------------------
	
	/**
	 * table列表
	 */
	private List<Table> tableList;
	/**
	 * 生成文件提交vo
	 */
	private GeneratorSubmitVo submitVo;
	/**
	 * 实体生成vo
	 */
	private ModelGeneratorVo modelGeneratorVo;
	
	/**
	 * 生成实体
	 * @param tableList 
	 * @param submitVo 
	 */
	public abstract void generateModel();
	
	/**
	 * 实体生成器vo，并转化为子类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends ModelGeneratorVo> T getModelGeneratorVoAsSub() {
		return (T) modelGeneratorVo;
	}
	
	/**
	 * 获取import列表
	 * @param sqlTypeJavaTypeMap
	 * @return
	 */
	public List<String> getImportList(Table table, Map<String, String> sqlTypeJavaTypeMap) {
		Set<String> pkgSet = new HashSet<String>();
		List<Column> columnList = table.getColumnList();
		String sqlType = null;
		String javaType = null;
		String packageName = null;
		for (Column column : columnList) {
			sqlType = column.getType();
			javaType = sqlTypeJavaTypeMap.get(sqlType);
			packageName = TypeHandler.JAVA_TYPE_PACKAGE_MAP.get(javaType);
			if (StringUtils.isNotEmpty(packageName)) {
				pkgSet.add(packageName);
			}
		}
		List<String> pkgList = new ArrayList<String>();
		pkgList.addAll(pkgSet);
		return pkgList;
	}
	
	/**
	 * 获取实体version id
	 * @return
	 */
	public String getModelVersionId() {
		return String.format("%s%s%s%s%s%s", 
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000)
				);
	}

	public List<Table> getTableList() {
		return tableList;
	}

	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}

	public GeneratorSubmitVo getSubmitVo() {
		return submitVo;
	}

	public void setSubmitVo(GeneratorSubmitVo submitVo) {
		this.submitVo = submitVo;
	}

	public ModelGeneratorVo getModelGeneratorVo() {
		return modelGeneratorVo;
	}

	public void setModelGeneratorVo(ModelGeneratorVo modelGeneratorVo) {
		this.modelGeneratorVo = modelGeneratorVo;
	}
	
	
}
