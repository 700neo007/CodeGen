package com.cg.codegen.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorSubmitVo;
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
	
	@Test
	public void testGenerateModel() throws Exception {
		GeneratorSubmitVo submitVo = new GeneratorSubmitVo();
		submitVo.setModelPackage("com.cg.model");
		submitVo.setFtlRoot("D:\\SoftDev\\WorkPlaces\\space43\\CodeGen\\generate\\ftl\\model\\basic");
		submitVo.setFtlFile("BasicModel.ftl");
		submitVo.setTargetRoot("D:\\DeskTmp\\FreemarkerTest\\src");
		
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add("tbl_dms_commodity_style");
//		tableNameList.add("tbl_dms_commodity_product");
//		tableNameList.add("tbl_dms_auth_line_commodity_ref");
		
		List<Table> tableList = codeGenService.getTablesByTableNames(tableNameList.toArray(new String[tableNameList.size()]));
		
		codeGenService.generateModel(tableList, submitVo);
	}
	
}
