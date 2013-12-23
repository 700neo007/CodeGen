package com.cg.codegen.component.generator.mybatisGen.mapperXmlGen;

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
import com.cg.codegen.component.generator.vo.mybatisGen.mapperXmlGen.MyBatisMapperXmlGenVo;
import com.cg.codegen.component.typeHandler.MySqlTypeHandler;
import com.cg.codegen.model.vo.Table;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;
import com.cg.common.util.JsonUtil;

/**
 * MyBatis Mapper XML 生成器
 * @author Neo
 *
 */
public class MyBatisMapperXmlGen extends CodeGenerator {

	public MyBatisMapperXmlGen(GeneratorInput generatorInput) {
		MyBatisMapperXmlGenVo myBatisMapperXmlGenVo = new MyBatisMapperXmlGenVo();
		try {
			PropertyUtils.copyProperties(myBatisMapperXmlGenVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MyBatisMapperXmlGen#-> myBatisMapperXmlGenVo:" + JsonUtil.toJson(myBatisMapperXmlGenVo));
		setGeneratorVo(myBatisMapperXmlGenVo);
	}
	
	/**
	 * 获取模板模型map
	 */
	@Override
	protected Map<String, Map<String, Object>> getTemplateModelMaps() {
		Map<String, Map<String, Object>> modelMaps = super.getTemplateModelMaps();
		
		MyBatisMapperXmlGenVo myBatisMapperXmlGenVo = getGeneratorVoAsSub();
		List<Table> tableList = myBatisMapperXmlGenVo.getTableList();
		
		for (Table table : tableList) {
			Map<String, Object> modelMap = modelMaps.get(table.getName());
			Assert.notNull(modelMap, String.format("tableName(%s) could not be null", table.getName()));
			
			//MyBatis Mapper包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_MAPPER_PACKAGE, myBatisMapperXmlGenVo.getMyBatisMapperPackage());
			//MyBatis Mapper XML包名 
			modelMap.put(MODEL_MAP_KEY_MYBATIS_MAPPER_XML_PACKAGE, myBatisMapperXmlGenVo.getMyBatisMapperXmlPackage());
			//SQL类型与MyBatis JDBC类型的映射 
			modelMap.put(MODEL_MAP_KEY_SQL_TPYE_MYBATIS_JDBC_TYPE_MAP, MySqlTypeHandler.SQL_TPYE_MYBATIS_JDBC_TYPE_MAP);
		}
		
		return modelMaps;
	}

	/**
	 * 建造模板根路径
	 */
	@Override
	public void buildFtlRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperXmlGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperXmlGenVo generatorVo) {
				generateInfo.setFtlRoot(generatorVo.getMyBatisMapperXmlRoot());
			}
		});
	}

	/**
	 * 建造模板文件名称
	 */
	@Override
	public void buildFtlFile() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperXmlGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperXmlGenVo generatorVo) {
				generateInfo.setFtlFile(generatorVo.getMyBatisMapperXmlFtlFile());
			}
		});
	}

	/**
	 * 建造生成的文件的基路径
	 */
	@Override
	public void buildTargetRoot() {
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperXmlGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperXmlGenVo generatorVo) {
				String targetRoot = String.format("%s%s%s", 
						generatorVo.getMyBatisMapperXmlOutputRoot(), File.separator,
						GeneratorUtil.getPathByPackage(generatorVo.getMyBatisMapperXmlPackage()));
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
		iterateBuildPart(new IterateBuildPartCallBack<MyBatisMapperXmlGenVo>() {
			@Override
			public void buildSinglePart(String tableName, GenerateInfo generateInfo, MyBatisMapperXmlGenVo generatorVo) {
				String targetFile = getTable2ModelStrategy().getModelName(tableName) + "Mapper.xml";
				generateInfo.setTargetFile(targetFile);
			}
		});
	}

	
	
}
