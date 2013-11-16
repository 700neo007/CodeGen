package com.cg.codegen.model.vo.generator.modelGen;

/**
 * 基本实体生成vo
 * @author Neo
 *
 */
public class BasicModelGeneratorVo extends ModelGeneratorVo {

	/**
	 * 模板文件路径
	 */
	private String modelFtlFile;

	public String getModelFtlFile() {
		return modelFtlFile;
	}

	public void setModelFtlFile(String modelFtlFile) {
		this.modelFtlFile = modelFtlFile;
	}

}
