package com.cg.codegen.model.vo.generator;

/**
 * 生成器提交vo
 * @author Neo
 *
 */
public class GeneratorSubmitVo {

	/**
	 * table列表复选框
	 */
	private String[] tableCheckboxes = new String[0];
	/**
	 * 实体包名
	 */
	private String modelPackage;
	/**
	 * 模板基路径
	 */
	private String ftlRoot; 
	/**
	 * 模板文件路径
	 */
	private String ftlFile; 
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

	public String getFtlFile() {
		return ftlFile;
	}

	public void setFtlFile(String ftlFile) {
		this.ftlFile = ftlFile;
	}

	public String getTargetRoot() {
		return targetRoot;
	}

	public void setTargetRoot(String targetRoot) {
		this.targetRoot = targetRoot;
	}
	
}
