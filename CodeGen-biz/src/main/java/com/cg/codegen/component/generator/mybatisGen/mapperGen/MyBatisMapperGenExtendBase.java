package com.cg.codegen.component.generator.mybatisGen.mapperGen;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.component.generator.vo.mybatisGen.mapperGen.MyBatisMapperGenExtendBaseVo;
import com.cg.codegen.model.vo.Table;
import com.cg.common.util.JsonUtil;

/**
 * MyBatis Mapper 生成器(继承基类)
 * @author Neo
 *
 */
public class MyBatisMapperGenExtendBase extends MyBatisMapperGen {

	public MyBatisMapperGenExtendBase(GeneratorInput generatorInput) {
		super();
		MyBatisMapperGenExtendBaseVo myBatisMapperGenExtendBaseVo = new MyBatisMapperGenExtendBaseVo();
		try {
			PropertyUtils.copyProperties(myBatisMapperGenExtendBaseVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MyBatisMapperGenExtendBase#-> myBatisMapperGenExtendBaseVo:" + JsonUtil.toJson(myBatisMapperGenExtendBaseVo));
		setGeneratorVo(myBatisMapperGenExtendBaseVo);
	}
	
	/**
	 * 获取模板模型map
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		MyBatisMapperGenExtendBaseVo myBatisMapperGenExtendBaseVo = getGeneratorVoAsSub();
		List<Table> tableList = myBatisMapperGenExtendBaseVo.getTableList();
		
		for (Table table : tableList) {
			Map<String, Object> modelMap = modelMaps.get(table.getName());
			Assert.notNull(modelMap, String.format("tableName(%s) could not be null", table.getName()));
			
			//MyBatis Base Mapper包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_BASE_MAPPER_PACKAGE, myBatisMapperGenExtendBaseVo.getMyBatisBaseMapperPackage());
			//MyBatis Base Mapper类名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_BASE_MAPPER_NAME, myBatisMapperGenExtendBaseVo.getMyBatisBaseMapperName());
			//MyBatis Criteria包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_CRITERIA_PACKAGE, myBatisMapperGenExtendBaseVo.getMyBatisCriteriaPackage());
		}
		
		return modelMaps;
	}

}
