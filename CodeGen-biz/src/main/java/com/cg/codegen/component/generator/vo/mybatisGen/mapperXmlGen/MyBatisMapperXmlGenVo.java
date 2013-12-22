package com.cg.codegen.component.generator.vo.mybatisGen.mapperXmlGen;

import com.cg.codegen.component.generator.vo.BaseGeneratorVo;

/**
 * MyBatis Mapper XML 生成器vo
 * @author Neo
 *
 */
public class MyBatisMapperXmlGenVo extends BaseGeneratorVo {

	/**
	 * MyBatis Mapper包名
	 */
	private String myBatisMapperPackage;
	//---------------------------------------------
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
	
	
	
}
