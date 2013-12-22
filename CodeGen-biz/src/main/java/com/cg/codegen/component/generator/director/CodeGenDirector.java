package com.cg.codegen.component.generator.director;

import com.cg.codegen.component.generator.CodeGenerator;

/**
 * 代码生成指挥官
 * @author Neo
 *
 */
public class CodeGenDirector {

	/**
	 * 代码生成器
	 */
	private CodeGenerator codeGenerator;

	public CodeGenDirector(CodeGenerator codeGenerator) {
		super();
		this.codeGenerator = codeGenerator;
	}
	
	/**
	 * 创建生成器信息
	 */
	public void createGeneratorInfo() {
		codeGenerator.initGeneratorInfoMap();
		codeGenerator.buildModelMap();
		codeGenerator.buildFtlRoot();
		codeGenerator.buildFtlFile();
		codeGenerator.buildTargetRoot();
		codeGenerator.buildTargetFile();
	}
	
}
