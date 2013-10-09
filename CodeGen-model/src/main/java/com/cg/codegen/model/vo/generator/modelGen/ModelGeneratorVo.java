package com.cg.codegen.model.vo.generator.modelGen;

/**
 * 实体生成vo
 * @author Neo
 *
 */
public abstract class ModelGeneratorVo {

	/**
	 * table列表复选框
	 */
	private String[] tableCheckboxes;
	/**
	 * 实体包名
	 */
	private String modelPackage;
	/**
	 * 模板基路径
	 */
	private String ftlRoot; 
	/**
	 * 生成的文件基路径
	 */
	private String targetRoot;
	
	public String[] getTableCheckboxes() {
		return tableCheckboxes;
	}
	public void setTableCheckboxes(String[] tableCheckboxes) {
		this.tableCheckboxes = tableCheckboxes;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getFtlRoot() {
		return ftlRoot;
	}
	public void setFtlRoot(String ftlRoot) {
		this.ftlRoot = ftlRoot;
	}
	public String getTargetRoot() {
		return targetRoot;
	}
	public void setTargetRoot(String targetRoot) {
		this.targetRoot = targetRoot;
	}
	
	
	
}
