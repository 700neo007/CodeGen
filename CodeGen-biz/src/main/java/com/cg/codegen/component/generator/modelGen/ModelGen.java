package com.cg.codegen.component.generator.modelGen;

import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.component.generator.vo.modelGen.ModelGenVo;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;

/**
 * 实体生成器
 * @author Neo
 *
 */
public abstract class ModelGen extends CodeGenerator {
	
	/**
	 * 获取模板模型map
	 * @return 返回Map<表名, Map<key, value>>
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		ModelGenVo modelGeneratorVo = getGeneratorVoAsSub();
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
