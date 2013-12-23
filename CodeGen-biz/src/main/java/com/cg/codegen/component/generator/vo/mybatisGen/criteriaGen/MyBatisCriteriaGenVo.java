package com.cg.codegen.component.generator.vo.mybatisGen.criteriaGen;

import com.cg.codegen.component.generator.vo.BaseGeneratorVo;

/**
 * MyBatis Criteria 生成器Vo
 * @author Neo
 *
 */
public class MyBatisCriteriaGenVo extends BaseGeneratorVo {

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
