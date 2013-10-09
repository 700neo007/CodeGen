package com.cg.codegen.component.generator.modelGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorSubmitVo;
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
	 * @param tableList table列表
	 * @param submitVo 生成文件提交vo
	 */
	public BasicModelGenerator(List<Table> tableList, 
			GeneratorSubmitVo submitVo) {
		setTableList(tableList);
		setSubmitVo(submitVo);
		BasicModelGeneratorVo basicModelGeneratorVo = new BasicModelGeneratorVo();
		try {
			PropertyUtils.copyProperties(basicModelGeneratorVo, submitVo);
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
			
			//数据模型
			modelMap = new HashMap<String, Object>();
			modelMap.put(MODEL_MAP_KEY_TABLE, table);
			modelMap.put(MODEL_MAP_KEY_PACKAGE, modelGeneratorVo.getModelPackage());
			
			generateInfo.setModelMap(modelMap);
			generateInfo.setFtlRoot(modelGeneratorVo.getFtlRoot());
			generateInfo.setFtlFile(modelGeneratorVo.getFtlFile());
			generateInfo.setTargetRoot(modelGeneratorVo.getTargetRoot());
			generateInfo.setTargetFile(table.getName() + ".java");
			
			generateInfoList.add(generateInfo);
		}
		FreeMarkerUtil.generateFiles(generateInfoList);
	}
	
	

}
