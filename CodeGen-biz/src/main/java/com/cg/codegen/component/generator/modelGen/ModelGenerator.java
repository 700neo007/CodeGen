package com.cg.codegen.component.generator.modelGen;

import java.util.List;

import com.cg.codegen.model.vo.Table;
import com.cg.common.util.FreeMarkerUtil.GeneratePathInfo;

/**
 * 实体生成器
 * @author Neo
 *
 */
public abstract class ModelGenerator {

	/**
	 * 生成实体
	 * @param tableList table列表
	 * @param generatePathInfoList 生成文件的路径信息
	 */
	public abstract void generateModel(List<Table> tableList, 
			List<GeneratePathInfo> generatePathInfoList);
	
}
