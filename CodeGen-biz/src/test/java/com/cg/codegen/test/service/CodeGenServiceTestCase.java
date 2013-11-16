package com.cg.codegen.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorVo;
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
		
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setTableList(tableList);
		generatorVo.setModelPackage("com.cg.model");
		generatorVo.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorVo.setModelFtlFile("BasicModel.ftl");
		generatorVo.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		generatorVo.setModelGeneratorClassName("com.cg.codegen.component.generator.modelGen.BasicModelGenerator");
		generatorVo.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.TblUnderlineTable2ModelStrategy");
		generatorVo.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		codeGenService.generateModel(generatorVo);
	}
	
	/**
	 * 生成MyBatis Mapper
	 * @throws Exception
	 */
	@Test
	public void testGenerateMyBatisMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
//		tableNameList.add("tbl_dms_commodity_style");
//		tableNameList.add("tbl_dms_commodity_product");
		tableNameList.add("tbl_dms_auth_line_commodity_ref");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setTableList(tableList);
		generatorVo.setModelPackage("com.cg.model");
		generatorVo.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.TblUnderlineTable2ModelStrategy");
		generatorVo.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		generatorVo.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		generatorVo.setMyBatisMapperPackage("com.cg.dao");
		generatorVo.setMyBatisMapperXmlPackage("com.cg.dao.mapper");
		generatorVo.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorVo.setMyBatisMapperFtlFile("mapper.ftl");
		generatorVo.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorVo.setMyBatisMapperOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		
		codeGenService.generateMyBatisMapper(generatorVo);
	}
	
}
