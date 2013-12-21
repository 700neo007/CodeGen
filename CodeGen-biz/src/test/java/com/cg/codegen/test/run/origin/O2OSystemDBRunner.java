package com.cg.codegen.test.run.origin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.service.CodeGenService;
import com.cg.codegen.test.BaseTestCase;

public class O2OSystemDBRunner extends BaseTestCase {

	@Autowired
	private CodeGenService codeGenService;
	
	@Test
	public void genConfModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_system_ip_info");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.o2o.system.conf.model");
		generatorInput.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorInput.setModelFtlFile("BasicModel.ftl");
		generatorInput.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		generatorInput.setTableNameLeftTrimPrefix("t_system_");
		
		generatorInput.setMyBatisMapperPackage(generatorInput.getModelPackage().replace("model", "") + "dao");
		generatorInput.setMyBatisMapperXmlPackage(generatorInput.getMyBatisMapperPackage() + ".mapper");
		generatorInput.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorInput.setMyBatisMapperFtlFile("mapper.ftl");
		generatorInput.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorInput.setMyBatisMapperOutputRoot(generatorInput.getModelOutputRoot());
		
		codeGenService.generateModel(generatorInput);
		codeGenService.generateMyBatisMapper(generatorInput);
	}
	
	@Test
	public void genUserModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_system_user");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.o2o.system.user.model");
		generatorInput.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorInput.setModelFtlFile("BasicModel.ftl");
		generatorInput.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		generatorInput.setTableNameLeftTrimPrefix("t_system_");
		
		generatorInput.setMyBatisMapperPackage(generatorInput.getModelPackage().replace("model", "") + "dao");
		generatorInput.setMyBatisMapperXmlPackage(generatorInput.getMyBatisMapperPackage() + ".mapper");
		generatorInput.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorInput.setMyBatisMapperFtlFile("mapper.ftl");
		generatorInput.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorInput.setMyBatisMapperOutputRoot(generatorInput.getModelOutputRoot());
		
		codeGenService.generateModel(generatorInput);
		codeGenService.generateMyBatisMapper(generatorInput);
	}
	
}
