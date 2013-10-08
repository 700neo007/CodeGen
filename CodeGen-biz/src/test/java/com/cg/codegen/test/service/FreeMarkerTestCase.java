package com.cg.codegen.test.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cg.codegen.test.BaseTestCase;
import com.cg.common.util.FreeMarkerUtil;
import com.cg.common.util.FreeMarkerUtil.GenerateInfo;

public class FreeMarkerTestCase extends BaseTestCase {

	@Test
	public void test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "HelloWorld");
		String ftlRoot = "D:\\DeskTmp\\FreemarkerTest\\ftl";
		String ftlFile = "test.ftl";
		String targetRoot = "D:\\DeskTmp\\FreemarkerTest\\target";
		String targetFile = "test.html";
		
		GenerateInfo generateInfo = new GenerateInfo();
		generateInfo.setModelMap(map);
		generateInfo.getPathInfo().setFtlRoot(ftlRoot);
		generateInfo.getPathInfo().setFtlFile(ftlFile);
		generateInfo.getPathInfo().setTargetRoot(targetRoot);
		generateInfo.getPathInfo().setTargetFile(targetFile);
		FreeMarkerUtil.generateFile(generateInfo);
		
	}
	
}
