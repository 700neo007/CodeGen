package com.cg.codegen.component.generator.mybatisGen.criteriaGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.vo.GeneratorInput;

/**
 * MyBatis Criteria 生成器 工厂
 * @author Neo
 *
 */
public class MyBatisCriteriaGenFactory {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisCriteriaGenFactory.class);
	
	/**
	 * 创建MyBatis Criteria 生成器
	 * @param generatorInput
	 * @return
	 */
	public static MyBatisCriteriaGen createMyBatisCriteriaGenerator(GeneratorInput generatorInput) {
		MyBatisCriteriaGen gen = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends MyBatisCriteriaGen> genClz = (Class<? extends MyBatisCriteriaGen>) 
					Class.forName(generatorInput.getMyBatisCriteriaGeneratorClassName());
			Constructor<? extends MyBatisCriteriaGen> genConstructor = 
					genClz.getConstructor(GeneratorInput.class);
			gen = genConstructor.newInstance(generatorInput);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		Assert.notNull(gen, "MyBatisMapperXmlGen is null");
		return gen;
	}
	
	public static void main(String[] args) {
		GeneratorInput generatorInput = new GeneratorInput();
		generatorInput.setMyBatisCriteriaGeneratorClassName("com.cg.codegen.component.generator.mybatisGen.criteriaGen.MyBatisCriteriaGen");
		MyBatisCriteriaGen myBatisCriteriaGen = MyBatisCriteriaGenFactory.createMyBatisCriteriaGenerator(generatorInput);
		System.out.println("myBatisCriteriaGen:" + myBatisCriteriaGen.getClass());
	}
	
}
