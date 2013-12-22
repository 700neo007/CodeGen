package com.cg.codegen.component.generator.vo;

import java.util.List;

import com.cg.codegen.model.vo.Table;

/**
 * 生成器vo基类
 * @author Neo
 *
 */
public abstract class BaseGeneratorVo {

	/**
	 * table列表
	 */
	private List<Table> tableList;
	//-------------------------------
	/**
	 * 实体包名
	 */
	private String modelPackage;
	/**
	 * 表名->实体的命名策略类名
	 */
	private String table2ModelStrategyClassName;
	/**
	 * 表名待去除的前缀
	 */
	private String tableNameLeftTrimPrefix;
	/**
	 * DB字段->实体属性的命名策略类名
	 */
	private String column2PropStrategyClassName;
	
	
	public List<Table> getTableList() {
		return tableList;
	}
	public void setTableList(List<Table> tableList) {
		this.tableList = tableList;
	}
	public String getModelPackage() {
		return modelPackage;
	}
	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}
	public String getTable2ModelStrategyClassName() {
		return table2ModelStrategyClassName;
	}
	public void setTable2ModelStrategyClassName(String table2ModelStrategyClassName) {
		this.table2ModelStrategyClassName = table2ModelStrategyClassName;
	}
	public String getTableNameLeftTrimPrefix() {
		return tableNameLeftTrimPrefix;
	}
	public void setTableNameLeftTrimPrefix(String tableNameLeftTrimPrefix) {
		this.tableNameLeftTrimPrefix = tableNameLeftTrimPrefix;
	}
	public String getColumn2PropStrategyClassName() {
		return column2PropStrategyClassName;
	}
	public void setColumn2PropStrategyClassName(String column2PropStrategyClassName) {
		this.column2PropStrategyClassName = column2PropStrategyClassName;
	}
	
}
