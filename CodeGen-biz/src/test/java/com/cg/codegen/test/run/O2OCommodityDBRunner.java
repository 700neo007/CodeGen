package com.cg.codegen.test.run;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorVo;
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
		
		GeneratorVo generatorVo = new GeneratorVo();
		generatorVo.setTableList(tableList);
		generatorVo.setModelPackage("com.o2o.commodity");
		generatorVo.setModelFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic\\");
		generatorVo.setModelFtlFile("BasicModel.ftl");
		generatorVo.setModelOutputRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		//generatorVo.setModelGeneratorClassName("com.cg.codegen.component.generator.modelGen.BasicModelGenerator");
		//generatorVo.setTable2ModelStrategyClassName("com.cg.codegen.component.generator.nameStrategy.table2Model.UnderlineTable2ModelStrategy");
		generatorVo.setTableNameLeftTrimPrefix("t_commodity_");
		//generatorVo.setColumn2PropStrategyClassName("com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy");
		
		//generatorVo.setMyBatisMapperGeneratorClassName("com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator");
		generatorVo.setMyBatisMapperPackage(generatorVo.getModelPackage() + ".dao");
		generatorVo.setMyBatisMapperXmlPackage(generatorVo.getMyBatisMapperPackage() + ".mapper");
		generatorVo.setMyBatisMapperRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\myBatisMapper\\mysql");
		generatorVo.setMyBatisMapperFtlFile("mapper.ftl");
		generatorVo.setMyBatisMapperXmlFtlFile("mapperXml.ftl");
		generatorVo.setMyBatisMapperOutputRoot(generatorVo.getModelOutputRoot());
		
		codeGenService.generateModel(generatorVo);
		codeGenService.generateMyBatisMapper(generatorVo);
	}
	
}
