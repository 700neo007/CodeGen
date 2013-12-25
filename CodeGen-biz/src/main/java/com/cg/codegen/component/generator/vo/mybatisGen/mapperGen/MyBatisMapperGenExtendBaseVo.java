package com.cg.codegen.component.generator.vo.mybatisGen.mapperGen;

/**
 * MyBatis Mapper 生成器(继承基类)Vo
 * @author Neo
 *
 */
public class MyBatisMapperGenExtendBaseVo extends MyBatisMapperGenVo {

	/**
	 * MyBatis Base Mapper包名
	 */
	private String myBatisBaseMapperPackage;
	/**
	 * MyBatis Base Mapper类名
	 */
	private String myBatisBaseMapperName;
	//--------------------------------------------
	/**
	 * MyBatis Criteria包名
	 */
	private String myBatisCriteriaPackage;
	
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
	public String getMyBatisCriteriaPackage() {
		return myBatisCriteriaPackage;
	}
	public void setMyBatisCriteriaPackage(String myBatisCriteriaPackage) {
		this.myBatisCriteriaPackage = myBatisCriteriaPackage;
	}
	
	
	
}
