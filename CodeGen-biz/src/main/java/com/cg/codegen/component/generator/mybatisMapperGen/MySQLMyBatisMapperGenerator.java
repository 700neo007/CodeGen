package com.cg.codegen.component.generator.mybatisMapperGen;

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
import com.cg.codegen.model.vo.generator.mybatisMapperGen.MySQLMyBatisMapperGeneratorVo;
import com.cg.common.util.FreeMarkerUtil;
import com.cg.common.util.JsonUtil;

/**
 * MySQL MyBatis Mapper 生成器
 * @author Neo
 *
 */
public class MySQLMyBatisMapperGenerator extends MyBatisMapperGenerator  {

	/**
	 * 
	 * @param generatorVo 生成器vo
	 */
	public MySQLMyBatisMapperGenerator(GeneratorVo generatorVo) {
		setTableList(generatorVo.getTableList());
		MySQLMyBatisMapperGeneratorVo mySQLMyBatisMapperGeneratorVo = new MySQLMyBatisMapperGeneratorVo();
		try {
			PropertyUtils.copyProperties(mySQLMyBatisMapperGeneratorVo, generatorVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MySQLMyBatisMapperGenerator#-> mySQLMyBatisMapperGeneratorVo:" + JsonUtil.toJson(mySQLMyBatisMapperGeneratorVo));
		setMyBatisMapperGeneratorVo(mySQLMyBatisMapperGeneratorVo);
	}

	/**
	 * 生成MyBatis Mapper
	 */
	@Override
	public void generateMyBatisMapper() {
		List<Table> tableList = getTableList();
		MySQLMyBatisMapperGeneratorVo myBatisMapperGeneratorVo = getMyBatisMapperGeneratorVoAsSub();
		
		//mapper生成信息list
		List<FreeMarkerUtil.GenerateInfo> mapperGenerateInfoList = new ArrayList<FreeMarkerUtil.GenerateInfo>();
		//mapper xml生成信息list
		List<FreeMarkerUtil.GenerateInfo> mapperXmlGenerateInfoList = new ArrayList<FreeMarkerUtil.GenerateInfo>();
		
		FreeMarkerUtil.GenerateInfo mapperGenerateInfo = null;
		FreeMarkerUtil.GenerateInfo mapperXmlGenerateInfo = null;
		Map<String, Object> modelMap = null;
		String mapperOutputRoot = null;
		String mapperXmlOutputRoot = null;
		for (Table table : tableList) {
			//mapper生成信息
			mapperGenerateInfo = new FreeMarkerUtil.GenerateInfo();
			//mapper xml生成信息
			mapperXmlGenerateInfo = new FreeMarkerUtil.GenerateInfo();
			
			//表名->实体名命名策略
			Table2ModelStrategy table2ModelStrategy = Table2ModelStrategyFactory.createTable2ModelStrategy(
					myBatisMapperGeneratorVo.getTable2ModelStrategyClassName(), myBatisMapperGeneratorVo.getTableNameLeftTrimPrefix());
			//DB字段->实体属性命名策略
			Column2PropStrategy column2PropStrategy = Column2PropStrategyFactory.createColumn2PropStrategy(myBatisMapperGeneratorVo.getColumn2PropStrategyClassName());
			
			//数据模型
			modelMap = new HashMap<String, Object>();
			modelMap.put(MODEL_MAP_KEY_CUR_TIME, getCurTime());
			modelMap.put(MODEL_MAP_KEY_TABLE, table);
			modelMap.put(MODEL_MAP_KEY_PACKAGE, myBatisMapperGeneratorVo.getModelPackage());
			//MySQL类型、JAVA类型映射，Map
			modelMap.put(MODEL_MAP_KEY_SQL_TYPE_JAVA_TYPE_MAP, MySqlTypeHandler.SQL_TYPE_JAVA_TYPE_MAP);
			//表名->实体名命名策略
			modelMap.put(MODEL_MAP_KEY_TABLE_2_MODEL_NAME_STRATEGY, table2ModelStrategy);
			//DB字段->实体属性命名策略
			modelMap.put(MODEL_MAP_KEY_COLUMN_2_PROP_NAME_STRATEGY, column2PropStrategy);
			//generatorUtil
			modelMap.put(MODEL_MAP_KEY_GENERATOR_UTIL, GeneratorUtil.getInstance());
			//MyBatis Mapper包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_MAPPER_PACKAGE, myBatisMapperGeneratorVo.getMyBatisMapperPackage());
			//MyBatis Mapper XML包名
			modelMap.put(MODEL_MAP_KEY_MYBATIS_MAPPER_XML_PACKAGE, myBatisMapperGeneratorVo.getMyBatisMapperXmlPackage());
			//SQL类型与MyBatis JDBC类型的映射
			modelMap.put(MODEL_MAP_KEY_SQL_TPYE_MYBATIS_JDBC_TYPE_MAP, MySqlTypeHandler.SQL_TPYE_MYBATIS_JDBC_TYPE_MAP);
			
			//数据模型
			mapperGenerateInfo.setModelMap(modelMap);
			mapperXmlGenerateInfo.setModelMap(modelMap);
			
			//模板基路径
			mapperGenerateInfo.setFtlRoot(myBatisMapperGeneratorVo.getMyBatisMapperRoot());
			mapperXmlGenerateInfo.setFtlRoot(myBatisMapperGeneratorVo.getMyBatisMapperRoot());
			
			//模板文件
			mapperGenerateInfo.setFtlFile(myBatisMapperGeneratorVo.getMyBatisMapperFtlFile());
			mapperXmlGenerateInfo.setFtlFile(myBatisMapperGeneratorVo.getMyBatisMapperXmlFtlFile());
			
			//输出文件基路径
			mapperOutputRoot = myBatisMapperGeneratorVo.getMyBatisMapperOutputRoot() + File.separator +
					GeneratorUtil.getPathByPackage(myBatisMapperGeneratorVo.getMyBatisMapperPackage());
			mapperXmlOutputRoot = myBatisMapperGeneratorVo.getMyBatisMapperOutputRoot() + File.separator +
					GeneratorUtil.getPathByPackage(myBatisMapperGeneratorVo.getMyBatisMapperXmlPackage());
			mapperGenerateInfo.setTargetRoot(mapperOutputRoot);
			mapperXmlGenerateInfo.setTargetRoot(mapperXmlOutputRoot);
			try {
				FileUtils.forceMkdir(new File(mapperOutputRoot));
				FileUtils.forceMkdir(new File(mapperXmlOutputRoot));
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			
			//输出文件
			mapperGenerateInfo.setTargetFile(table2ModelStrategy.getModelName(table.getName()) + "Mapper.java");
			mapperXmlGenerateInfo.setTargetFile(table2ModelStrategy.getModelName(table.getName()) + "Mapper.xml");
			
			mapperGenerateInfoList.add(mapperGenerateInfo);
			mapperXmlGenerateInfoList.add(mapperXmlGenerateInfo);
		}
		//生成mapper
		FreeMarkerUtil.generateFiles(mapperGenerateInfoList);
		//生成mapper xml
		FreeMarkerUtil.generateFiles(mapperXmlGenerateInfoList);
	}
	
}
