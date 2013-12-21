package com.cg.codegen.model.vo.generator.modelGen;

import com.cg.codegen.model.vo.generator.BaseGeneratorVo;

/**
 * 实体生成vo
 * @author Neo
 *
 */
public abstract class ModelGeneratorVo extends BaseGeneratorVo {

	/**
	 * 模板基路径
	 */
	private String modelFtlRoot; 
	/**
	 * 生成的文件基路径
	 */
	private String modelOutputRoot;
	
	public String getModelFtlRoot() {
		return modelFtlRoot;
	}
	public void setModelFtlRoot(String modelFtlRoot) {
		this.modelFtlRoot = modelFtlRoot;
	}
	public String getModelOutputRoot() {
		return modelOutputRoot;
	}
	public void setModelOutputRoot(String modelOutputRoot) {
		this.modelOutputRoot = modelOutputRoot;
	}
	
}
