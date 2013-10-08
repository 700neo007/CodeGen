package com.cg.codegen.component.generator.modelGen;

import java.util.List;

import com.cg.codegen.model.vo.Table;
import com.cg.common.util.FreeMarkerUtil.GeneratePathInfo;

/**
 * 基本实体生成器
 * @author Administrator
 *
 */
public class BasicModelGenerator extends ModelGenerator {
	
	/**
	 * 生成实体
	 * @param tableList table列表
	 */
	@Override
	public void generateModel(List<Table> tableList, List<GeneratePathInfo> generatePathInfoList) {
		for (Table table : tableList) {
			
		}
	}

}
