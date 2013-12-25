package com.cg.codegen.component.generator.mybatisGen.criteriaGen;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.component.generator.GeneratorUtil;
import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.component.generator.vo.mybatisGen.criteriaGen.MyBatisCriteriaGenVo;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;
import com.cg.common.util.JsonUtil;

/**
 * MyBatis Criteria 生成器
 * @author Neo
 *
 */
public class MyBatisCriteriaGen extends CodeGenerator {

	public MyBatisCriteriaGen(GeneratorInput generatorInput) {
		MyBatisCriteriaGenVo myBatisCriteriaGenVo = new MyBatisCriteriaGenVo();
		try {
			PropertyUtils.copyProperties(myBatisCriteriaGenVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MyBatisCriteriaGen#-> myBatisCriteriaGenVo:" + JsonUtil.toJson(myBatisCriteriaGenVo));
		setGeneratorVo(myBatisCriteriaGenVo);
	}
	
	/**
	 * 获取模板模型map
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		MyBatisCriteriaGenVo myBatisCriteriaGenVo = getGeneratorVoAsSub();
		List<Table> tableList = myBatisCriteriaGenVo.getTableList();
		
		for (Table table : tableList) {
			Map<String, Object> modelMap = modelMaps.get(table.getName());
			Assert.notNull(modelMap, String.format("tableName(%s) could not be null", table.getName()));
			
			//获取import列表
			modelMap.put(MODEL_MAP_KEY_IMPORT_LIST, getImportList(table, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP));
			//MyBatis Criteria基类的包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_BASE_CRITERIA_PACKAGE, myBatisCriteriaGenVo.getMyBatisBaseCriteriaPackage());
			//MyBatis Criteria基类的名称
			modelMap.put(MODEL_MAP_KEY_MYBATIS_BASE_CRITERIA_NAME, myBatisCriteriaGenVo.getMyBatisBaseCriteriaName());
			//MyBatis Criteria包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_CRITERIA_PACKAGE, myBatisCriteriaGenVo.getMyBatisCriteriaPackage());
		}
		
		return modelMaps;
	}
	
	/**
	 * 建造模板根路径
	 */
	@Override
	public void buildFtlRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisCriteriaGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisCriteriaGenVo generatorVo) {
				generateInfo.setFtlRoot(generatorVo.getMyBatisCriteriaRoot());
			}
		});
	}

	/**
	 * 建造模板文件名称
	 */
	@Override
	public void buildFtlFile() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisCriteriaGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisCriteriaGenVo generatorVo) {
				generateInfo.setFtlFile(generatorVo.getMyBatisCriteriaFtlFile());
			}
		});
	}

	/**
	 * 建造生成的文件的基路径
	 */
	@Override
	public void buildTargetRoot() {
		MyBatisCriteriaGenVo myBatisCriteriaGenVo = getGeneratorVoAsSub();
		String targetRoot = String.format("%s%s%s", 
				myBatisCriteriaGenVo.getMyBatisCriteriaOutputRoot(), File.separator,
				GeneratorUtil.getPathByPackage(myBatisCriteriaGenVo.getMyBatisCriteriaPackage()));
		setAndCreateTargetRoot(targetRoot);
	}

	/**
	 * 建造生成的文件的名称
	 */
	@Override
	public void buildTargetFile() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisCriteriaGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisCriteriaGenVo generatorVo) {
				String targetFile = getTable2ModelStrategy().getModelName(tableName) + "Criteria.java";
				generateInfo.setTargetFile(targetFile);
			}
		});
	}

}
