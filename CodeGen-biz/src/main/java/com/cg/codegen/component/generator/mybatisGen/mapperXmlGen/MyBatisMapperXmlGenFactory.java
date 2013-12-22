package com.cg.codegen.component.generator.mybatisGen.mapperXmlGen;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.cg.codegen.component.generator.vo.GeneratorInput;

/**
 * MyBatis Mapper XML 生成器工厂
 * @author Neo
 *
 */
public class MyBatisMapperXmlGenFactory {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisMapperXmlGenFactory.class);
	
	/**
	 * 创建MyBatis Mapper XML 生成器
	 * @param generatorInput 
	 * @return
	 */
	public static MyBatisMapperXmlGen createMyBatisMapperXmlGenerator(GeneratorInput generatorInput) {
		MyBatisMapperXmlGen gen = null;
		try {
			@SuppressWarnings("unchecked")
			Class<? extends MyBatisMapperXmlGen> genClz = (Class<? extends MyBatisMapperXmlGen>) 
					Class.forName(generatorInput.getMyBatisMapperXmlGeneratorClassName());
			Constructor<? extends MyBatisMapperXmlGen> genConstructor = 
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
		generatorInput.setMyBatisMapperXmlGeneratorClassName("com.cg.codegen.component.generator.mybatisGen.mapperXmlGen.MyBatisMapperXmlGen");
		MyBatisMapperXmlGen myBatisMapperXmlGen = MyBatisMapperXmlGenFactory.createMyBatisMapperXmlGenerator(generatorInput);
		System.out.println("myBatisMapperXmlGen:" + myBatisMapperXmlGen.getClass());
	}
	
}
