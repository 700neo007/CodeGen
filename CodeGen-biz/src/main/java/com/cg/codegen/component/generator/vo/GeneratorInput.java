package com.cg.codegen.component.generator.vo;

import java.util.List;

import com.cg.codegen.model.vo.Table;

/**
 * 生成器输入参数
 * @author Neo
 *
 */
public class GeneratorInput {

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
	private String modelGeneratorClassName = "com.cg.codegen.component.generator.modelGen.BasicModelGen";
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
	 * MyBatis Mapper 生成器类名
	 */
	private String myBatisMapperGeneratorClassName = "com.cg.codegen.component.generator.mybatisGen.mapperGen.MyBatisMapperGen";
	/**
	 * MyBatis Mapper包名
	 */
	private String myBatisMapperPackage;
	/**
	 * MyBatis Mapper 模板基路径
	 */
	private String myBatisMapperRoot;
	/**
	 * MyBatis Mapper 模板
	 */
	private String myBatisMapperFtlFile;
	/**
	 * MyBatis Mapper输出基路径
	 */
	private String myBatisMapperOutputRoot;
	
	//--------------------- 生成MyBatis Mapper(End) ---------------------------
	
	//--------------------- 生成MyBatis Mapper XML(Start) ---------------------------
	/**
	 * MyBatis Mapper XML 生成器类名
	 */
	private String myBatisMapperXmlGeneratorClassName = "com.cg.codegen.component.generator.mybatisGen.mapperXmlGen.MyBatisMapperXmlGen";
	/**
	 * MyBatis Mapper XML包名
	 */
	private String myBatisMapperXmlPackage;
	/**
	 * MyBatis Mapper XML模板基路径
	 */
	private String myBatisMapperXmlRoot;
	/**
	 * MyBatis Mapper XML 模板
	 */
	private String myBatisMapperXmlFtlFile;
	/**
	 * MyBatis Mapper XML输出基路径
	 */
	private String myBatisMapperXmlOutputRoot;
	//--------------------- 生成MyBatis Mapper XML(Start) ---------------------------

	//--------------------- BaseMapper(Start) ---------------------------
	/**
	 * MyBatis Base Mapper包名
	 */
	private String myBatisBaseMapperPackage;
	/**
	 * MyBatis Base Mapper类名
	 */
	private String myBatisBaseMapperName;
	//--------------------- BaseMapper(End) ---------------------------
	
	//--------------------- 生成MyBatis Criteria(Start) ---------------------------
	/**
	 * MyBatis Criteria 生成器类名
	 */
	private String myBatisCriteriaGeneratorClassName = "com.cg.codegen.component.generator.mybatisGen.criteriaGen.MyBatisCriteriaGen";
	/**
	 * MyBatis Criteria基类的包名
	 */
	private String myBatisBaseCriteriaPackage;
	/**
	 * MyBatis Criteria基类的名称
	 */
	private String myBatisBaseCriteriaName;
	/**
	 * MyBatis Criteria包名
	 */
	private String myBatisCriteriaPackage;
	/**
	 * MyBatis Criteria模板基路径
	 */
	private String myBatisCriteriaRoot;
	/**
	 * MyBatis Criteria模板
	 */
	private String myBatisCriteriaFtlFile;
	/**
	 * MyBatis Criteria输出基路径
	 */
	private String myBatisCriteriaOutputRoot;
	//--------------------- 生成MyBatis Criteria(End) ---------------------------
	
	
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
	public String getMyBatisMapperOutputRoot() {
		return myBatisMapperOutputRoot;
	}
	public void setMyBatisMapperOutputRoot(String myBatisMapperOutputRoot) {
		this.myBatisMapperOutputRoot = myBatisMapperOutputRoot;
	}
	public String getMyBatisMapperXmlGeneratorClassName() {
		return myBatisMapperXmlGeneratorClassName;
	}
	public void setMyBatisMapperXmlGeneratorClassName(String myBatisMapperXmlGeneratorClassName) {
		this.myBatisMapperXmlGeneratorClassName = myBatisMapperXmlGeneratorClassName;
	}
	public String getMyBatisMapperXmlPackage() {
		return myBatisMapperXmlPackage;
	}
	public void setMyBatisMapperXmlPackage(String myBatisMapperXmlPackage) {
		this.myBatisMapperXmlPackage = myBatisMapperXmlPackage;
	}
	public String getMyBatisMapperXmlRoot() {
		return myBatisMapperXmlRoot;
	}
	public void setMyBatisMapperXmlRoot(String myBatisMapperXmlRoot) {
		this.myBatisMapperXmlRoot = myBatisMapperXmlRoot;
	}
	public String getMyBatisMapperXmlFtlFile() {
		return myBatisMapperXmlFtlFile;
	}
	public void setMyBatisMapperXmlFtlFile(String myBatisMapperXmlFtlFile) {
		this.myBatisMapperXmlFtlFile = myBatisMapperXmlFtlFile;
	}
	public String getMyBatisMapperXmlOutputRoot() {
		return myBatisMapperXmlOutputRoot;
	}
	public void setMyBatisMapperXmlOutputRoot(String myBatisMapperXmlOutputRoot) {
		this.myBatisMapperXmlOutputRoot = myBatisMapperXmlOutputRoot;
	}
	public String getMyBatisBaseMapperPackage() {
		return myBatisBaseMapperPackage;
	}
	public void setMyBatisBaseMapperPackage(String myBatisBaseMapperPackage) {
		this.myBatisBaseMapperPackage = myBatisBaseMapperPackage;
	}
	public String getMyBatisBaseMapperName() {
		return myBatisBaseMapperName;
	}
	public void setMyBatisBaseMapperName(String myBatisBaseMapperName) {
		this.myBatisBaseMapperName = myBatisBaseMapperName;
	}
	public String getMyBatisCriteriaGeneratorClassName() {
		return myBatisCriteriaGeneratorClassName;
	}
	public void setMyBatisCriteriaGeneratorClassName(String myBatisCriteriaGeneratorClassName) {
		this.myBatisCriteriaGeneratorClassName = myBatisCriteriaGeneratorClassName;
	}
	public String getMyBatisBaseCriteriaPackage() {
		return myBatisBaseCriteriaPackage;
	}
	public void setMyBatisBaseCriteriaPackage(String myBatisBaseCriteriaPackage) {
		this.myBatisBaseCriteriaPackage = myBatisBaseCriteriaPackage;
	}
	public String getMyBatisBaseCriteriaName() {
		return myBatisBaseCriteriaName;
	}
	public void setMyBatisBaseCriteriaName(String myBatisBaseCriteriaName) {
		this.myBatisBaseCriteriaName = myBatisBaseCriteriaName;
	}
	public String getMyBatisCriteriaPackage() {
		return myBatisCriteriaPackage;
	}
	public void setMyBatisCriteriaPackage(String myBatisCriteriaPackage) {
		this.myBatisCriteriaPackage = myBatisCriteriaPackage;
	}
	public String getMyBatisCriteriaRoot() {
		return myBatisCriteriaRoot;
	}
	public void setMyBatisCriteriaRoot(String myBatisCriteriaRoot) {
		this.myBatisCriteriaRoot = myBatisCriteriaRoot;
	}
	public String getMyBatisCriteriaFtlFile() {
		return myBatisCriteriaFtlFile;
	}
	public void setMyBatisCriteriaFtlFile(String myBatisCriteriaFtlFile) {
		this.myBatisCriteriaFtlFile = myBatisCriteriaFtlFile;
	}
	public String getMyBatisCriteriaOutputRoot() {
		return myBatisCriteriaOutputRoot;
	}
	public void setMyBatisCriteriaOutputRoot(String myBatisCriteriaOutputRoot) {
		this.myBatisCriteriaOutputRoot = myBatisCriteriaOutputRoot;
	}
	
	
	
	
	
}
