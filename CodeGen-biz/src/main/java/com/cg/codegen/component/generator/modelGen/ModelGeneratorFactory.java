package com.cg.codegen.component.generator.modelGen;

import java.util.List;

import com.cg.codegen.model.vo.Table;
import com.cg.codegen.model.vo.generator.GeneratorSubmitVo;

/**
 * 实体生成器工厂
 * @author Neo
 *
 */
public class ModelGeneratorFactory {

	/**
	 * 创建实体生成器
	 * @param tableList table列表
	 * @param submitVo 生成文件提交vo
	 * @return
	 */
	public static ModelGenerator createModelGenerator(
			List<Table> tableList, GeneratorSubmitVo submitVo) {
		ModelGenerator modelGenerator = new BasicModelGenerator(
				tableList, submitVo);
		return modelGenerator;
	}
	
}
