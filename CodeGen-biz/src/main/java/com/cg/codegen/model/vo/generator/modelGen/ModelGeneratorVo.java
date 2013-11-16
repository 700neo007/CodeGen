package com.cg.codegen.model.vo.generator.modelGen;

/**
 * 实体生成vo
 * @author Neo
 *
 */
public abstract class ModelGeneratorVo {

	/**
	 * 实体包名
	 */
	private String modelPackage;
	/**
	 * 模板基路径
	 */
	private String modelFtlRoot; 
	/**
	 * 生成的文件基路径
	 */
	private String modelOutputRoot;
	
	/**
	 * 表名->实体的命名策略类名
	 */
	private String table2ModelStrategyClassName;
	/**
	 * DB字段->实体属性的命名策略类名
	 */
	private String column2PropStrategyClassName;
	
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
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
	public String getTable2ModelStrategyClassName() {
		return table2ModelStrategyClassName;
	}
	public void setTable2ModelStrategyClassName(String table2ModelStrategyClassName) {
		this.table2ModelStrategyClassName = table2ModelStrategyClassName;
	}
	public String getColumn2PropStrategyClassName() {
		return column2PropStrategyClassName;
	}
	public void setColumn2PropStrategyClassName(String column2PropStrategyClassName) {
		this.column2PropStrategyClassName = column2PropStrategyClassName;
	}
	
	
}
