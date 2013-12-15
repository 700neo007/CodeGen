package com.cg.codegen.test.run.example;

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
	public void genUserModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_system_user");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setTableList(tableList);
		generatorVo.setModelPackage("com.o2o.system.user.model");
		generatorVo.setModelFtlRoot(GenConf.modelFtlRoot);
		generatorVo.setModelFtlFile(GenConf.modelFtlFile);
		generatorVo.setModelOutputRoot(GenConf.modelOutputRoot);
		generatorVo.setTableNameLeftTrimPrefix(GenConf.tableNameLeftTrimPrefix);
		
		generatorVo.setMyBatisMapperPackage(generatorVo.getModelPackage().replace("model", "") + "dao");
		generatorVo.setMyBatisMapperXmlPackage(generatorVo.getMyBatisMapperPackage() + ".mapper");
		generatorVo.setMyBatisMapperRoot(GenConf.myBatisMapperRoot);
		generatorVo.setMyBatisMapperFtlFile(GenConf.myBatisMapperFtlFile);
		generatorVo.setMyBatisMapperXmlFtlFile(GenConf.myBatisMapperXmlFtlFile);
		generatorVo.setMyBatisMapperOutputRoot(generatorVo.getModelOutputRoot());
		
		generatorVo.setMyBatisExampleBaseMapperPackage(GenConf.myBatisExampleBaseMapperPackage);
		generatorVo.setMyBatisExampleBaseMapperName(GenConf.myBatisExampleBaseMapperName);
		
		codeGenService.generateModel(generatorVo);
		codeGenService.generateMyBatisMapper(generatorVo);
	}
	
}
