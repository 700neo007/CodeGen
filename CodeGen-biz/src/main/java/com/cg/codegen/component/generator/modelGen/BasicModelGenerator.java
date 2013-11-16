package com.cg.codegen.component.generator.modelGen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;

import com.cg.codegen.component.generator.GeneratorUtil;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategy;
import com.cg.codegen.component.generator.nameStrategy.column2Prop.Column2PropStrategyFactory;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategy;
import com.cg.codegen.component.generator.nameStrategy.table2Model.Table2ModelStrategyFactory;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorVo;
import com.cg.codegen.model.vo.generator.modelGen.BasicModelGeneratorVo;
import com.cg.common.util.FreeMarkerUtil;


/**
 * 基本实体生成器
 * @author Administrator
 *
 */
public class BasicModelGenerator extends ModelGenerator {

	/**
	 * 
	 * @param generatorVo 
	 */
	public BasicModelGenerator(GeneratorVo generatorVo) {
		setTableList(generatorVo.getTableList());
		BasicModelGeneratorVo basicModelGeneratorVo = new BasicModelGeneratorVo();
		try {
			PropertyUtils.copyProperties(basicModelGeneratorVo, generatorVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		setModelGeneratorVo(basicModelGeneratorVo);
	}
	
	/**
	 * 生成实体
	 */
	@Override
	public void generateModel() {
		List<Table> tableList = getTableList();
		BasicModelGeneratorVo modelGeneratorVo = getModelGeneratorVoAsSub();
		
		//文件生成信息list
		List<FreeMarkerUtil.GenerateInfo> generateInfoList = new ArrayList<FreeMarkerUtil.GenerateInfo>();
		Map<String, Object> modelMap = null;
		FreeMarkerUtil.GenerateInfo generateInfo = null;
		for (Table table : tableList) {
			generateInfo = new FreeMarkerUtil.GenerateInfo();
			
			//表名->实体名命名策略
			Table2ModelStrategy table2ModelStrategy = Table2ModelStrategyFactory.createTable2ModelStrategy(modelGeneratorVo.getTable2ModelStrategyClassName());
			//DB字段->实体属性命名策略
			Column2PropStrategy column2PropStrategy = Column2PropStrategyFactory.createColumn2PropStrategy(modelGeneratorVo.getColumn2PropStrategyClassName());
			
			//数据模型
			modelMap = new HashMap<String, Object>();
			modelMap.put(MODEL_MAP_KEY_TABLE, table);
			modelMap.put(MODEL_MAP_KEY_PACKAGE, modelGeneratorVo.getModelPackage());
			//MySQL类型、JAVA类型映射，Map
			modelMap.put(MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP);
			//表名->实体名命名策略
			modelMap.put(MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY, table2ModelStrategy);
			//DB字段->实体属性命名策略
			modelMap.put(MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY, column2PropStrategy);
			//generatorUtil
			modelMap.put(MODEL_MAP_KEY_GENERATOR_UTIL, GeneratorUtil.getInstance());
			//获取import列表
			modelMap.put(MODEL_MAP_KEY_IMPORT_LIST, getImportList(table, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP));
			//version id
			modelMap.put(MODEL_MAP_KEY_VERSION_ID, getModelVersionId());
			
			
			generateInfo.setModelMap(modelMap);
			generateInfo.setFtlRoot(modelGeneratorVo.getModelFtlRoot());
			generateInfo.setFtlFile(modelGeneratorVo.getModelFtlFile());
			
			String targetRoot = modelGeneratorVo.getModelOutputRoot() + File.separator +
					GeneratorUtil.getPathByPackage(modelGeneratorVo.getModelPackage());
			generateInfo.setTargetRoot(targetRoot);
			try {
				FileUtils.forceMkdir(new File(targetRoot));
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			
			generateInfo.setTargetFile(table2ModelStrategy.getModelName(table.getName()) + ".java");
			
			generateInfoList.add(generateInfo);
		}
		FreeMarkerUtil.generateFiles(generateInfoList);
	}
	
	

}
