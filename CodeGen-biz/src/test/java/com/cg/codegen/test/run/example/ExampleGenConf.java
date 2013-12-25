package com.cg.codegen.test.run.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Example方式的生成器配置类
 * @author Neo
 *
 */
public class ExampleGenConf {

	/**
	 * Map<包名, 表名List>
	 */
	private Map<String, List<String>> packageTableListMap;
	
	//--------------------------------------------------------------
	
	/**
	 * 实体模板基路径
	 */
	private String modelFtlRoot = "D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\";
	/**
	 * 实体模板路径
	 */
	private String modelFtlFile = "BasicModel.ftl";
	/**
	 * 实体输出根路径
	 */
	private String modelOutputRoot = "D:\\DeskTmp\\FreemarkerTest\\src";
	/**
	 * 表名待去除的前缀
	 */
	private String tableNameLeftTrimPrefix = "t_system_";
	
	//--------------------------------------------------------------
	
	/**
	 * MyBatis Mapper 生成器类名
	 */
	private String myBatisMapperGeneratorClassName = "com.cg.codegen.component.generator.mybatisGen.mapperGen.MyBatisMapperGenExtendBase";
	/**
	 * MyBatis Mapper 模板基路径
	 */
	private String myBatisMapperRoot = "D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql\\example";
	/**
	 * MyBatis Mapper 模板
	 */
	private String myBatisMapperFtlFile = "mapper.ftl";
	/**
	 * MyBatis Mapper XML 模板
	 */
	private String myBatisMapperXmlFtlFile = "mapperXml.ftl";
	
	//--------------------------------------------------------------
	
	/**
	 * MyBatis Base Mapper包名
	 */
	private String myBatisBaseMapperPackage = "com.o2o.common.mybatis";
	/**
	 * MyBatis Base Mapper类名
	 */
	private String myBatisBaseMapperName = "BaseMapper";
	
	//--------------------------------------------------------------
	
	/**
	 * MyBatis Criteria基类的包名
	 */
	private String myBatisBaseCriteriaPackage = "com.o2o.common.mybatis";
	/**
	 * MyBatis Criteria基类的名称
	 */
	private String myBatisBaseCriteriaName = "BaseCriteria";
	/**
	 * MyBatis Criteria模板
	 */
	private String myBatisCriteriaFtlFile = "criteria.ftl";
	//--------------------------------------------------------------
	
	public ExampleGenConf() {
		initPackageTableListMap();
	}
	
	private void initPackageTableListMap() {
		packageTableListMap = new HashMap<String, List<String>>();
		
		List<String> userPkgTblList = new ArrayList<String>();
		userPkgTblList.add("t_system_user");
		userPkgTblList.add("t_system_role");
		packageTableListMap.put("com.o2o.system.user", userPkgTblList);
		
//		List<String> menuPkgTblList = new ArrayList<String>();
//		menuPkgTblList.add("t_system_resource");
//		packageTableListMap.put("com.o2o.system.res", menuPkgTblList);
//		
//		List<String> confPkgTblList = new ArrayList<String>();
//		confPkgTblList.add("t_system_config");
//		confPkgTblList.add("t_system_ip_info");
//		packageTableListMap.put("com.o2o.system.conf", confPkgTblList);
	}

	public Map<String, List<String>> getPackageTableListMap() {
		return packageTableListMap;
	}

	public String getModelFtlRoot() {
		return modelFtlRoot;
	}

	public String getModelFtlFile() {
		return modelFtlFile;
	}

	public String getModelOutputRoot() {
		return modelOutputRoot;
	}

	public String getTableNameLeftTrimPrefix() {
		return tableNameLeftTrimPrefix;
	}

	public String getMyBatisMapperGeneratorClassName() {
		return myBatisMapperGeneratorClassName;
	}

	public String getMyBatisMapperRoot() {
		return myBatisMapperRoot;
	}

	public String getMyBatisMapperFtlFile() {
		return myBatisMapperFtlFile;
	}

	public String getMyBatisMapperXmlFtlFile() {
		return myBatisMapperXmlFtlFile;
	}

	public String getMyBatisBaseMapperPackage() {
		return myBatisBaseMapperPackage;
	}

	public String getMyBatisBaseMapperName() {
		return myBatisBaseMapperName;
	}

	public String getMyBatisBaseCriteriaPackage() {
		return myBatisBaseCriteriaPackage;
	}

	public String getMyBatisBaseCriteriaName() {
		return myBatisBaseCriteriaName;
	}

	public String getMyBatisCriteriaFtlFile() {
		return myBatisCriteriaFtlFile;
	}

}
