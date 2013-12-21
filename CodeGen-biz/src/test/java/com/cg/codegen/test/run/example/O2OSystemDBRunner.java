package com.cg.codegen.test.run.example;

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
	public void genUserModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_system_user");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.o2o.system.user.model");
		generatorInput.setModelFtlRoot(GenConf.modelFtlRoot);
		generatorInput.setModelFtlFile(GenConf.modelFtlFile);
		generatorInput.setModelOutputRoot(GenConf.modelOutputRoot);
		generatorInput.setTableNameLeftTrimPrefix(GenConf.tableNameLeftTrimPrefix);
		
		//---------------------------------------------------------------------------
		
		generatorInput.setMyBatisMapperGeneratorClassName(GenConf.myBatisMapperGeneratorClassName);
		generatorInput.setMyBatisMapperPackage(generatorInput.getModelPackage().replace("model", "") + "dao");
		generatorInput.setMyBatisMapperXmlPackage(generatorInput.getMyBatisMapperPackage() + ".mapper");
		generatorInput.setMyBatisMapperRoot(GenConf.myBatisMapperRoot);
		generatorInput.setMyBatisMapperFtlFile(GenConf.myBatisMapperFtlFile);
		generatorInput.setMyBatisMapperXmlFtlFile(GenConf.myBatisMapperXmlFtlFile);
		generatorInput.setMyBatisMapperOutputRoot(generatorInput.getModelOutputRoot());
		
		//-------------------------
		
		generatorInput.setMyBatisExampleBaseMapperPackage(GenConf.myBatisExampleBaseMapperPackage);
		generatorInput.setMyBatisExampleBaseMapperName(GenConf.myBatisExampleBaseMapperName);
		generatorInput.setMyBatisExampleBaseCriteriaPackage(GenConf.myBatisExampleBaseCriteriaPackage);
		generatorInput.setMyBatisExampleBaseCriteriaName(GenConf.myBatisExampleBaseCriteriaName);
		generatorInput.setMyBatisExampleCriteriaPackage(generatorInput.getMyBatisMapperPackage() + ".criteria");
		generatorInput.setMyBatisExampleCriteriaFtlFile(GenConf.myBatisExampleCriteriaFtlFile);
		
		//---------------------------------------------------------------------------
		
		codeGenService.generateModel(generatorInput);
		codeGenService.generateMyBatisMapper(generatorInput);
	}
	
}
