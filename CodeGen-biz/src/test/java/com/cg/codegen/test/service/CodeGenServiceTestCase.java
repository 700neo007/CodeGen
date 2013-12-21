package com.cg.codegen.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.service.CodeGenService;
import com.cg.codegen.test.BaseTestCase;
import com.cg.common.util.JsonUtil;

public class CodeGenServiceTestCase extends BaseTestCase {

	@Autowired
	private CodeGenService codeGenService;
	
	@Test
	public void testGetTableByTableName() {
		Table table = codeGenService.getTableByTableName("tbl_dms_commodity_style");
		System.out.println("@@--" + JsonUtil.toJson(table));
	}
	
	/**
	 * 生成实体
	 * @throws Exception
	 */
	@Test
	public void testGenerateModel() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("tbl_dms_commodity_style");
		tableNameList.add("tbl_dms_commodity_product");
		tableNameList.add("tbl_dms_auth_line_commodity_ref");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.cg.model");
		generatorInput.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorInput.setModelFtlFile("BasicModel.ftl");
		generatorInput.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		generatorInput.setModelGeneratorClassName("com.cg.codegen.component.generator.modelGen.BasicModelGenerator");
		generatorInput.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.UnderlineTable2ModelStrategy");
		generatorInput.setTableNameLeftTrimPrefix("tbl_dms_");
		generatorInput.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		codeGenService.generateModel(generatorInput);
	}
	
	/**
	 * 生成MyBatis Mapper
	 * @throws Exception
	 */
	@Test
	public void testGenerateMyBatisMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("tbl_dms_commodity_style");
		tableNameList.add("tbl_dms_commodity_product");
		tableNameList.add("tbl_dms_auth_line_commodity_ref");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		System.out.println("@@--#-> tableList:" + JsonUtil.toJson(tableList));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.cg.model");
		generatorInput.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.UnderlineTable2ModelStrategy");
		generatorInput.setTableNameLeftTrimPrefix("tbl_dms_");
		generatorInput.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		generatorInput.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		generatorInput.setMyBatisMapperPackage("com.cg.dao");
		generatorInput.setMyBatisMapperXmlPackage("com.cg.dao.mapper");
		generatorInput.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorInput.setMyBatisMapperFtlFile("mapper.ftl");
		generatorInput.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorInput.setMyBatisMapperOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		
		codeGenService.generateMyBatisMapper(generatorInput);
	}
	
}
