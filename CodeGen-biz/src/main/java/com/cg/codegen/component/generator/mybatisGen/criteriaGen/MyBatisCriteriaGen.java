package com.cg.codegen.component.generator.mybatisGen.criteriaGen;

import org.apache.commons.beanutils.PropertyUtils;

import com.cg.codegen.component.generator.CodeGenerator;
import com.cg.codegen.component.generator.vo.GeneratorInput;
import com.cg.codegen.component.generator.vo.mybatisGen.criteriaGen.MyBatisCriteriaGenVo;
import com.cg.common.util.JsonUtil;

/**
 * MyBatis Criteria 生成器
 * @author Neo
 *
 */
public class MyBatisCriteriaGen extends CodeGenerator {

	public MyBatisCriteriaGen(GeneratorInput generatorInput) {
		MyBatisCriteriaGenVo myBatisCriteriaGenVo = new MyBatisCriteriaGenVo();
		try {
			PropertyUtils.copyProperties(myBatisCriteriaGenVo, generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("MyBatisCriteriaGen#-> myBatisCriteriaGenVo:" + JsonUtil.toJson(myBatisCriteriaGenVo));
		setGeneratorVo(myBatisCriteriaGenVo);
	}
	
	

	/**
	 * 建造模板根路径
	 */
	@Override
	public void buildFtlRoot() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 建造模板文件名称
	 */
	@Override
	public void buildFtlFile() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 建造生成的文件的基路径
	 */
	@Override
	public void buildTargetRoot() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 建造生成的文件的名称
	 */
	@Override
	public void buildTargetFile() {
		// TODO Auto-generated method stub
		
	}

}
