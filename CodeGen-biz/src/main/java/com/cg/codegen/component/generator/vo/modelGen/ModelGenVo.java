package com.cg.codegen.component.generator.vo.modelGen;

import com.cg.codegen.component.generator.vo.BaseGeneratorVo;

/**
 * 实体生成vo
 * @author Neo
 *
 */
public abstract class ModelGenVo extends BaseGeneratorVo {

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
