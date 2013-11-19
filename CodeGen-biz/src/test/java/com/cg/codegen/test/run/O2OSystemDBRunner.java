package com.cg.codegen.test.run;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorVo;
import com.cg.codegen.service.CodeGenService;
import com.cg.codegen.test.BaseTestCase;

public class O2OSystemDBRunner extends BaseTestCase {

	@Autowired
	private CodeGenService codeGenService;
	
	@Test
	public void genModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_system_ip_info");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setTableList(tableList);
		generatorVo.setModelPackage("com.o2o.system.conf.model");
		generatorVo.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorVo.setModelFtlFile("BasicModel.ftl");
		generatorVo.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		generatorVo.setTableNameLeftTrimPrefix("t_system_");
		
		generatorVo.setMyBatisMapperPackage(generatorVo.getModelPackage().replace("model", "") + "dao");
		generatorVo.setMyBatisMapperXmlPackage(generatorVo.getMyBatisMapperPackage() + ".mapper");
		generatorVo.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorVo.setMyBatisMapperFtlFile("mapper.ftl");
		generatorVo.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorVo.setMyBatisMapperOutputRoot(generatorVo.getModelOutputRoot());
		
		codeGenService.generateModel(generatorVo);
		codeGenService.generateMyBatisMapper(generatorVo);
	}
	
}
