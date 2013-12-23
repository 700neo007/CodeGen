package com.cg.codegen.component.generator.mybatisGen.mapperGen;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.component.generator.GeneratorUtil;
import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.component.generator.vo.mybatisGen.mapperGen.MyBatisMapperGenVo;
import com.cg.codegen.model.vo.Table;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;
import com.cg.common.util.JsonUtil;

/**
 * MyBatis Mapper 生成器
 * @author Neo
 *
 */
public class MyBatisMapperGen extends CodeGenerator {
	
	protected MyBatisMapperGen() {}
	
	public MyBatisMapperGen(GeneratorInput generatorInput) {
		MyBatisMapperGenVo myBatisMapperGenVo = new MyBatisMapperGenVo();
		try {
			PropertyUtils.copyProperties(myBatisMapperGenVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MyBatisMapperGen#-> myBatisMapperGenVo:" + JsonUtil.toJson(myBatisMapperGenVo));
		setGeneratorVo(myBatisMapperGenVo);
	}
	
	/**
	 * 获取模板模型map
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		MyBatisMapperGenVo myBatisMapperGenVo = getGeneratorVoAsSub();
		List<Table> tableList = myBatisMapperGenVo.getTableList();
		
		for (Table table : tableList) {
			Map<String, Object> modelMap = modelMaps.get(table.getName());
			Assert.notNull(modelMap, String.format("tableName(%s) could not be null", table.getName()));
			
			//MyBatis Mapper包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_MAPPER_PACKAGE, myBatisMapperGenVo.getMyBatisMapperPackage());
		}
		
		return modelMaps;
	}

	/**
	 * 建造模板根路径
	 */
	@Override
	public void buildFtlRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperGenVo generatorVo) {
				generateInfo.setFtlRoot(generatorVo.getMyBatisMapperRoot());
			}
		});
	}

	/**
	 * 建造模板文件名称
	 */
	@Override
	public void buildFtlFile() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperGenVo generatorVo) {
				generateInfo.setFtlFile(generatorVo.getMyBatisMapperFtlFile());
			}
		});
	}

	/**
	 * 建造生成的文件的基路径
	 */
	@Override
	public void buildTargetRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperGenVo generatorVo) {
				String targetRoot = String.format("%s%s%s", 
						generatorVo.getMyBatisMapperOutputRoot(), File.separator,
						GeneratorUtil.getPathByPackage(generatorVo.getMyBatisMapperPackage()));
				generateInfo.setTargetRoot(targetRoot);
				try {
					FileUtils.forceMkdir(new File(targetRoot));
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		});
	}

	/**
	 * 建造生成的文件的名称
	 */
	@Override
	public void buildTargetFile() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperGenVo generatorVo) {
				String targetFile = getTable2ModelStrategy().getModelName(tableName) + "Mapper.java";
				generateInfo.setTargetFile(targetFile);
			}
		});
	}
	
}
