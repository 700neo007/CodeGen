package com.cg.codegen.component.generator.modelGen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.component.typeHandler.TypeHandler;
import com.cg.codegen.model.vo.Column;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.modelGen.ModelGeneratorVo;

/**
 * 实体生成器
 * @author Neo
 *
 */
public abstract class ModelGenerator extends CodeGenerator {
	
	/**
	 * 生成实体
	 */
	public abstract void generateModel();
	
	/**
	 * 获取模板模型map
	 * @return 返回Map<表名, Map<key, value>>
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		ModelGeneratorVo modelGeneratorVo = getGeneratorVoAsSub();
		List<Table> tableList = modelGeneratorVo.getTableList();
		
		for (Table table : tableList) {
			Map<String, Object> modelMap = modelMaps.get(table.getName());
			Assert.notNull(modelMap, String.format("tableName(%s) could not be null", table.getName()));
			
			//获取import列表
			modelMap.put(MODEL_MAP_KEY_IMPORT_LIST, getImportList(table, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP));
			//version id
			modelMap.put(MODEL_MAP_KEY_VERSION_ID, getModelVersionId());
		}
		
		return modelMaps;
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
	
}
