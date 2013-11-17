package com.cg.codegen.model.vo.generator;

import java.util.List;

import com.cg.codegen.model.vo.Table;

/**
 * 生成器vo
 * @author Neo
 *
 */
public class GeneratorVo {

	/**
	 * 表list
	 */
	private List<Table> tableList;
	
	//--------------------- 生成model(Start) ---------------------------
	/**
	 * 实体包名
	 */
	private String modelPackage;
	/**
	 * 实体模板基路径
	 */
	private String modelFtlRoot;
	/**
	 * 实体模板路径
	 */
	private String modelFtlFile;
	/**
	 * 实体输出根路径
	 */
	private String modelOutputRoot;
	/**
	 * 实体生成器类名，默认BasicModelGenerator
	 */
	private String modelGeneratorClassName = "com.cg.codegen.component.generator.modelGen.BasicModelGenerator";
	/**
	 * 表名->实体的命名策略类名
	 */
	private String table2ModelStrategyClassName = "com.cg.codegen.component.generator.nameStrategy.table2Model.UnderlineTable2ModelStrategy";
	/**
	 * 表名待去除的前缀
	 */
	private String tableNameLeftTrimPrefix = "";
	/**
	 * DB字段->实体属性的命名策略类名
	 */
	private String column2PropStrategyClassName = "com.cg.codegen.component.generator.nameStrategy.column2Prop.UnderlineColumn2PropStrategy";
	//--------------------- 生成model(End) ---------------------------

	//--------------------- 生成MyBatis Mapper(Start) ---------------------------
	/**
	 * MyBatis Mapper 生成器类名，默认生成MySQL 的 Mapper
	 */
	private String myBatisMapperGeneratorClassName = "com.cg.codegen.component.generator.mybatisMapperGen.MySQLMyBatisMapperGenerator";
	/**
	 * MyBatis Mapper包名
	 */
	private String myBatisMapperPackage;
	/**
	 * MyBatis Mapper XML包名
	 */
	private String myBatisMapperXmlPackage;
	/**
	 * MyBatis Mapper 模板基路径
	 */
	private String myBatisMapperRoot;
	/**
	 * MyBatis Mapper 模板
	 */
	private String myBatisMapperFtlFile;
	/**
	 * MyBatis Mapper XML 模板
	 */
	private String myBatisMapperXmlFtlFile;
	/**
	 * MyBatis Mapper输出基路径
	 */
	private String myBatisMapperOutputRoot;
	//--------------------- 生成MyBatis Mapper(End) ---------------------------
	
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
	public String getModelFtlRoot() {
		return modelFtlRoot;
	}
	public void setModelFtlRoot(String modelFtlRoot) {
		this.modelFtlRoot = modelFtlRoot;
	}
	public String getModelFtlFile() {
		return modelFtlFile;
	}
	public void setModelFtlFile(String modelFtlFile) {
		this.modelFtlFile = modelFtlFile;
	}
	public String getModelOutputRoot() {
		return modelOutputRoot;
	}
	public void setModelOutputRoot(String modelOutputRoot) {
		this.modelOutputRoot = modelOutputRoot;
	}
	public String getModelGeneratorClassName() {
		return modelGeneratorClassName;
	}
	public void setModelGeneratorClassName(String modelGeneratorClassName) {
		this.modelGeneratorClassName = modelGeneratorClassName;
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
	public String getMyBatisMapperGeneratorClassName() {
		return myBatisMapperGeneratorClassName;
	}
	public void setMyBatisMapperGeneratorClassName(String myBatisMapperGeneratorClassName) {
		this.myBatisMapperGeneratorClassName = myBatisMapperGeneratorClassName;
	}
	public String getMyBatisMapperPackage() {
		return myBatisMapperPackage;
	}
	public void setMyBatisMapperPackage(String myBatisMapperPackage) {
		this.myBatisMapperPackage = myBatisMapperPackage;
	}
	public String getMyBatisMapperXmlPackage() {
		return myBatisMapperXmlPackage;
	}
	public void setMyBatisMapperXmlPackage(String myBatisMapperXmlPackage) {
		this.myBatisMapperXmlPackage = myBatisMapperXmlPackage;
	}
	public String getMyBatisMapperRoot() {
		return myBatisMapperRoot;
	}
	public void setMyBatisMapperRoot(String myBatisMapperRoot) {
		this.myBatisMapperRoot = myBatisMapperRoot;
	}
	public String getMyBatisMapperFtlFile() {
		return myBatisMapperFtlFile;
	}
	public void setMyBatisMapperFtlFile(String myBatisMapperFtlFile) {
		this.myBatisMapperFtlFile = myBatisMapperFtlFile;
	}
	public String getMyBatisMapperXmlFtlFile() {
		return myBatisMapperXmlFtlFile;
	}
	public void setMyBatisMapperXmlFtlFile(String myBatisMapperXmlFtlFile) {
		this.myBatisMapperXmlFtlFile = myBatisMapperXmlFtlFile;
	}
	public String getMyBatisMapperOutputRoot() {
		return myBatisMapperOutputRoot;
	}
	public void setMyBatisMapperOutputRoot(String myBatisMapperOutputRoot) {
		this.myBatisMapperOutputRoot = myBatisMapperOutputRoot;
	}
	
	
	
}
