package com.cg.codegen.test.run.origin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorInput;
import com.cg.codegen.service.CodeGenService;
import com.cg.codegen.test.BaseTestCase;

public class O2OCommodityDBRunner extends BaseTestCase {

	@Autowired
	private CodeGenService codeGenService;
	
	@Test
	public void genModelAndMapper() throws Exception {
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("t_commodity_brand");
//		tableNameList.add("t_commodity_desc");
		tableNameList.add("t_commodity_item");
		tableNameList.add("t_commodity_item_cat");
		tableNameList.add("t_commodity_item_delivery_time");
		tableNameList.add("t_commodity_item_desc_module");
		tableNameList.add("t_commodity_item_img");
		tableNameList.add("t_commodity_item_location");
		tableNameList.add("t_commodity_item_prop");
		tableNameList.add("t_commodity_item_prop_img");
		tableNameList.add("t_commodity_item_video");
		tableNameList.add("t_commodity_locality_life");
		tableNameList.add("t_commodity_mall");
		tableNameList.add("t_commodity_mall_item");
		tableNameList.add("t_commodity_prop_group");
		tableNameList.add("t_commodity_prop_value");
		tableNameList.add("t_commodity_sku");
		tableNameList.add("t_commodity_spu");
		tableNameList.add("t_commodity_spu_ext_info");
		tableNameList.add("t_commodity_spu_img");
		tableNameList.add("t_commodity_spu_prop_img");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setTableList(tableList);
		generatorInput.setModelPackage("com.o2o.commodity");
		generatorInput.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorInput.setModelFtlFile("BasicModel.ftl");
		generatorInput.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		//generatorInput.setModelGeneratorClassName("com.cg.codegen.component.generator.modelGen.BasicModelGenerator");
		//generatorInput.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.UnderlineTable2ModelStrategy");
		generatorInput.setTableNameLeftTrimPrefix("t_commodity_");
		//generatorInput.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		//generatorInput.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		generatorInput.setMyBatisMapperPackage(generatorInput.getModelPackage() + ".dao");
		generatorInput.setMyBatisMapperXmlPackage(generatorInput.getMyBatisMapperPackage() + ".mapper");
		generatorInput.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorInput.setMyBatisMapperFtlFile("mapper.ftl");
		generatorInput.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorInput.setMyBatisMapperOutputRoot(generatorInput.getModelOutputRoot());
		
		codeGenService.generateModel(generatorInput);
		codeGenService.generateMyBatisMapper(generatorInput);
	}
	
}
