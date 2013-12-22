package com.cg.codegen.component.generator.vo.mybatisGen.mapperGen;

import com.cg.codegen.component.generator.vo.BaseGeneratorVo;

/**
 * MyBatis Mapper 生成器vo
 * @author Neo
 *
 */
public class MyBatisMapperGenVo extends BaseGeneratorVo {

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
	
	
	
}
