package com.cg.codegen.model.vo.generator.mybatisMapperGen;

import com.cg.codegen.model.vo.generator.BaseGeneratorVo;

/**
 * MyBatis Mapper 生成器vo
 * @author Neo
 *
 */
public abstract class MyBatisMapperGeneratorVo extends BaseGeneratorVo {

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
