package com.cg.codegen.component.generator.mybatisMapperGen;

import com.cg.codegen.component.generator.CodeGenerator;

/**
 * MyBatis Mapper 生成器
 * @author Neo
 *
 */
public abstract class MyBatisMapperGenerator extends CodeGenerator {
	
	/**
	 * 生成MyBatis Mapper
	 */
	public abstract void generateMyBatisMapper();
	
}
