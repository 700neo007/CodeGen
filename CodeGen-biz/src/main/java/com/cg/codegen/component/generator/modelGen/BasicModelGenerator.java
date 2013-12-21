package com.cg.codegen.component.generator.modelGen;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.model.vo.generator.modelGen.BasicModelGeneratorVo;
import com.cg.common.util.FreeMarkerUtil;
import com.cg.common.util.JsonUtil;


/**
 * 基本实体生成器
 * @author Administrator
 *
 */
public class BasicModelGenerator extends ModelGenerator {

	/**
	 * 
	 * @param generatorInput 生成器输入参数
	 */
	public BasicModelGenerator(GeneratorInput generatorInput) {
		BasicModelGeneratorVo basicModelGeneratorVo = new BasicModelGeneratorVo();
		try {
			PropertyUtils.copyProperties(basicModelGeneratorVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("BasicModelGenerator#-> basicModelGeneratorVo:" + JsonUtil.toJson(basicModelGeneratorVo));
		setGeneratorVo(basicModelGeneratorVo);
	}
	
	/**
	 * 生成实体
	 */
	@Override
	public void generateModel() {
		BasicModelGeneratorVo modelGeneratorVo = getGeneratorVoAsSub();
		List<Table> tableList = modelGeneratorVo.getTableList();
		
		//文件生成信息list
		List<FreeMarkerUtil.GenerateInfo> generateInfoList = new ArrayList<FreeMarkerUtil.GenerateInfo>();
		for (Table table : tableList) {
			FreeMarkerUtil.GenerateInfo generateInfo = new FreeMarkerUtil.GenerateInfo();
			generateInfo.setModelMap(getTemplateModelMaps().get(table.getName()));
			
			generateInfoList.add(generateInfo);
		}
		logger.info("generateInfoList:{}", JsonUtil.toJson(generateInfoList));
	}
	
	

}
