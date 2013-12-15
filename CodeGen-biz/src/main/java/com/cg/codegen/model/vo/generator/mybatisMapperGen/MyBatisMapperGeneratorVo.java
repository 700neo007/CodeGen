package com.cg.codegen.model.vo.generator.mybatisMapperGen;

/**
 * MyBatis Mapper 生成器vo
 * @author Neo
 *
 */
public abstract class MyBatisMapperGeneratorVo {

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
	//-------------------
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
	//----
	/**
	 * MyBatis Example BaseMapper的包名
	 */
	private String myBatisExampleBaseMapperPackage;
	/**
	 * MyBatis Example BaseMapper的名称
	 */
	private String myBatisExampleBaseMapperName;
	//----
	
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
	public String getMyBatisExampleBaseMapperPackage() {
		return myBatisExampleBaseMapperPackage;
	}
	public void setMyBatisExampleBaseMapperPackage(String myBatisExampleBaseMapperPackage) {
		this.myBatisExampleBaseMapperPackage = myBatisExampleBaseMapperPackage;
	}
	public String getMyBatisExampleBaseMapperName() {
		return myBatisExampleBaseMapperName;
	}
	public void setMyBatisExampleBaseMapperName(String myBatisExampleBaseMapperName) {
		this.myBatisExampleBaseMapperName = myBatisExampleBaseMapperName;
	}
	
}
