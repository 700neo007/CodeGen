package com.cg.codegen.test.run.example;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.model.vo.Table;
import com.cg.codegen.service.CodeGenService;
import com.cg.codegen.test.BaseTestCase;

public class O2OSystemDBRunner extends BaseTestCase {

	@Autowired
	private CodeGenService codeGenService;
	
	@Test
	public void gen() throws Exception {
		ExampleGenConf conf = new ExampleGenConf();
		
		Map<String, List<String>> packageTableListMap = conf.getPackageTableListMap();
		
		for (Entry<String, List<String>> entry : packageTableListMap.entrySet()) {
			String packageName = entry.getKey();
			List<String> tableNameList = entry.getValue(); 
			
			List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
			
			GeneratorInput generatorInput = new GeneratorInput();
			generatorInput.setTableList(tableList);
			generatorInput.setModelPackage(packageName + ".model");
			generatorInput.setModelFtlRoot(conf.getModelFtlRoot());
			generatorInput.setModelFtlFile(conf.getModelFtlFile());
			generatorInput.setModelOutputRoot(conf.getModelOutputRoot());
			generatorInput.setTableNameLeftTrimPrefix(conf.getTableNameLeftTrimPrefix());
			
//			generatorInput.setMyBatisMapperGeneratorClassName(conf.getMyBatisMapperGeneratorClassName());
			generatorInput.setMyBatisMapperPackage(generatorInput.getModelPackage().replace("model", "") + "dao");
			generatorInput.setMyBatisMapperRoot(conf.getMyBatisMapperRoot());
			generatorInput.setMyBatisMapperFtlFile(conf.getMyBatisMapperFtlFile());
			generatorInput.setMyBatisMapperOutputRoot(generatorInput.getModelOutputRoot());
			
			generatorInput.setMyBatisMapperXmlPackage(generatorInput.getMyBatisMapperPackage() + ".mapper");
			generatorInput.setMyBatisMapperXmlRoot(generatorInput.getMyBatisMapperRoot());
			generatorInput.setMyBatisMapperXmlFtlFile(conf.getMyBatisMapperXmlFtlFile());
			generatorInput.setMyBatisMapperXmlOutputRoot(generatorInput.getModelOutputRoot());
			
			codeGenService.genModel(generatorInput);
			codeGenService.genMyBatisMapper(generatorInput);
			codeGenService.genMyBatisMapperXml(generatorInput);
		}
		
		
	}
	
}
