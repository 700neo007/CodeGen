package com.cg.codegen.test.run.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MyBatis Example方式的生成器配置类
 * @author Neo
 *
 */
public class ExampleGenConf {

	/**
	 * Map<包名, 表名List>
	 */
	private Map<String, List<String>> packageTableListMap;
	
	
	
	public ExampleGenConf() {
		initPackageTableListMap();
	}
	
	private void initPackageTableListMap() {
		packageTableListMap = new HashMap<String, List<String>>();
		
		List<String> userPkgTblList = new ArrayList<String>();
		userPkgTblList.add("t_system_user");
		userPkgTblList.add("t_system_role");
		packageTableListMap.put("com.o2o.system.user", userPkgTblList);
		
		List<String> menuPkgTblList = new ArrayList<String>();
		menuPkgTblList.add("t_system_menu");
		packageTableListMap.put("com.o2o.system.menu", menuPkgTblList);
		
		List<String> confPkgTblList = new ArrayList<String>();
		confPkgTblList.add("t_system_config");
		confPkgTblList.add("t_system_ip_info");
		packageTableListMap.put("com.o2o.system.conf", confPkgTblList);
	}

	public Map<String, List<String>> getPackageTableListMap() {
		return packageTableListMap;
	}
	
	
}
